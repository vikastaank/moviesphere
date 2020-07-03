package com.vtworks.moviesphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtworks.moviesphere.core.entity.Movie;
import com.vtworks.moviesphere.core.exception.MovieSphereException;
import com.vtworks.moviesphere.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public void delete(Long id) throws MovieSphereException {
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> find() throws MovieSphereException {
		List<Movie> list = movieRepository.findAll();
		if (list == null || list.size() < 1) {
			throw new MovieSphereException("The specified movie not found");
		}
		return list;
	}

	@Override
	public Movie findById(Long id) throws MovieSphereException {
		Movie movie = movieRepository.findById(id).orElse(null);
		if (movie == null) {
			throw new MovieSphereException("The specified movie not found");
		}
		return movie;
	}

	@Override
	public Long save(Movie movie) throws MovieSphereException {
		return movieRepository.save(movie).getId();
	}

}
