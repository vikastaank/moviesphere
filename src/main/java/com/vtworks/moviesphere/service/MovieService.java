package com.vtworks.moviesphere.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vtworks.moviesphere.core.entity.Movie;
import com.vtworks.moviesphere.core.exception.MovieSphereException;

@Service
public interface MovieService {
	
	void delete(Long id) throws MovieSphereException;

	List<Movie> find() throws MovieSphereException;

	Movie findById(Long id) throws MovieSphereException;

	Long save(Movie movie) throws MovieSphereException;
}
