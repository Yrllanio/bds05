package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review entity = new Review();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ReviewDTO(entity);
    }

    private void copyDtoToEntity(ReviewDTO dto, Review entity) {
        entity.setMovie(movieRepository.getOne(dto.getMovieId()));
        UserDTO userDTO = userService.getProfile();
        entity.setUser(new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), null));
        entity.setText(dto.getText());
    }

}

