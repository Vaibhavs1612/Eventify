package com.example.Eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eventify.entity.Favorites;


@Repository
public interface FavRepo extends JpaRepository<Favorites, Integer>{

}
