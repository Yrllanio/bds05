package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRespository extends JpaRepository<Genre, Long> {

}
