package com.example.Eventify.controller;


import com.example.Eventify.entity.Favorites;
import com.example.Eventify.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorites")
public class FavController {

    @Autowired
    private FavService favoritesService;

    @PostMapping
    public ResponseEntity<Favorites> createFavorite(@RequestBody Favorites favorites) {
        Favorites createdFavorite = favoritesService.createFavorite(favorites);
        return new ResponseEntity<>(createdFavorite, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Favorites>> getAllFavorites() {
        List<Favorites> favoritesList = favoritesService.getAllFavorites();
        return new ResponseEntity<>(favoritesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorites> getFavoriteById(@PathVariable("id") int favoriteId) {
        Optional<Favorites> favorite = favoritesService.getFavoriteById(favoriteId);
        return favorite.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorites> updateFavorite(@PathVariable("id") int favoriteId, @RequestBody Favorites updatedFavorites) {
        try {
            Favorites favorite = favoritesService.updateFavorite(favoriteId, updatedFavorites);
            return new ResponseEntity<>(favorite, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable("id") int favoriteId) {
        try {
            favoritesService.deleteFavorite(favoriteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
