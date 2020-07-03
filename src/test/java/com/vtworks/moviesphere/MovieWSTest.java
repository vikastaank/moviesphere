package com.vtworks.moviesphere;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.vtworks.moviesphere.core.entity.Movie;
import com.vtworks.moviesphere.core.exception.MovieSphereException;
import com.vtworks.moviesphere.repository.MovieRepository;
import com.vtworks.moviesphere.service.MovieServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class MovieWSTest {

	@Mock
	MovieRepository movieRepository;

	@InjectMocks
	MovieServiceImpl movieServiceImpl;

	static List<Movie> moviesList = null;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeAll
	static void initBeforeAll() {
		Movie m1 = new Movie(1L, "Movie1", 3.5);
		Movie m2 = new Movie(2L, "Movie1", 4.5);
		Movie m3 = new Movie(3L, "Movie1", 2.6);
		moviesList = new ArrayList<Movie>();
		moviesList.add(m1);
		moviesList.add(m2);
		moviesList.add(m3);
	}

	@Test
	void testDelete() {
		try {
			moviesList.remove(2);
			when(movieServiceImpl.find()).thenReturn(moviesList);
			assertNull(moviesList.get(2));
		} catch (MovieSphereException e) {
			fail("Failed - Exception occurred.");
		}
	}

	@Test
	void testFind() {
		try {
			when(movieServiceImpl.find()).thenReturn(moviesList);
			assertNotEquals(0, movieServiceImpl.find().size());
		} catch (MovieSphereException e) {
			fail("Failed - Exception occurred.");
		}
	}

	@Test
	void testFindById() {
		try {
			when(movieServiceImpl.findById(1L)).thenReturn(moviesList.get(0));
			assertEquals(1L, movieServiceImpl.findById(1L).getId().longValue());
		} catch (MovieSphereException e) {
			fail("Failed - Exception occurred.");
		}
	}

	@Test
	void testSave() {
		try {
			Movie movieToSave = moviesList.get(0);
			when(movieServiceImpl.save(movieToSave)).thenReturn(1L);
			assertEquals(1L, movieServiceImpl.save(movieToSave).longValue());
		} catch (MovieSphereException e) {
			fail("Failed - Exception occurred.");
		}
	}

	@Test
	void testUpdate() {
		try {
			Movie movieToUpdate = new Movie();
			movieToUpdate.setTitle("Movie 1 - updated");
			movieToUpdate.setRank(5.0);
			Long movieId = 1L;
			when(movieServiceImpl.findById(movieId)).thenReturn(moviesList.get(0));

			Movie existingMovie = movieServiceImpl.findById(movieId);
			existingMovie.setTitle(existingMovie.getTitle());
			existingMovie.setRank(existingMovie.getRank());

			when(movieServiceImpl.save(movieToUpdate)).thenReturn(1L);
			assertEquals(1L, movieServiceImpl.save(existingMovie).longValue());
		} catch (MovieSphereException e) {
			fail("Failed - Exception occurred.");
		}
	}

}
