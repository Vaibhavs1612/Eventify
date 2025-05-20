import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity
from flask import Flask, request, jsonify
import psycopg2  # Or use SQLAlchemy if preferred

app = Flask(__name__)

# 🔁 Step 1: Fetch events from your database
def fetch_events_from_db():
    conn = psycopg2.connect(
        host="localhost",
        database="eventify",
        user="root",
        password="1612"
    )
    query = "SELECT id, title, category, description, tags, speakers FROM events"
    df = pd.read_sql(query, conn)
    conn.close()
    return df

# Load data
events = fetch_events_from_db()

# Combine important textual info
events['combined'] = events['description'] + " " + events['category'] + " " + events['tags'] + " " + events['speakers']

# Vectorize tags
cv = CountVectorizer(max_features=5000, stop_words='english')
vectors = cv.fit_transform(events['combined'].fillna("")).toarray()

# Compute similarity
similarity = cosine_similarity(vectors)

@app.route('/recommend', methods=['GET'])
def recommend():
    title = request.args.get('title')
    if title not in events['title'].values:
        return jsonify({"error": "Event not found"}), 404
    
    index = events[events['title'] == title].index[0]
    distances = list(enumerate(similarity[index]))
    similar_events = sorted(distances, key=lambda x: x[1], reverse=True)[1:6]
    
    recommended = []
    for i in similar_events:
        event = events.iloc[i[0]]
        recommended.append({
            "title": event['title'],
            "category": event['category'],
            "description": event['description']
        })
    
    return jsonify(recommended)

if __name__ == '__main__':
    app.run(debug=True, port=5001)
