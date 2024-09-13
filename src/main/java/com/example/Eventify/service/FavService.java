package com.example.Eventify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eventify.entity.Favorites;
import com.example.Eventify.repo.FavRepo;

@Service
public class FavService {

	 @Autowired
	 
	    private FavRepo favoritesRepository;

	    public Favorites createFavorite(Favorites favorites) {
	        return favoritesRepository.save(favorites);
	    }

	    public List<Favorites> getAllFavorites() {
	        return favoritesRepository.findAll();
	    }

	    public Optional<Favorites> getFavoriteById(int favoriteId) {
	        return favoritesRepository.findById(favoriteId);
	    }

	    public Favorites updateFavorite(int favoriteId, Favorites updatedFavorites) {
	        if (favoritesRepository.existsById(favoriteId)) {
	            updatedFavorites.setFavoriteId(favoriteId);
	            return favoritesRepository.save(updatedFavorites);
	        } else {
	            throw new RuntimeException("Favorite not found with id " + favoriteId);
	        }
	    }

	    public void deleteFavorite(int favoriteId) {
	        if (favoritesRepository.existsById(favoriteId)) {
	            favoritesRepository.deleteById(favoriteId);
	        } else {
	            throw new RuntimeException("Favorite not found with id " + favoriteId);
	        }
	    }
}
