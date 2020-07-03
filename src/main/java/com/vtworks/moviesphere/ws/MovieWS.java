package com.vtworks.moviesphere.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtworks.moviesphere.core.basic.ResultVO;
import com.vtworks.moviesphere.core.entity.Movie;
import com.vtworks.moviesphere.core.exception.MovieSphereException;
import com.vtworks.moviesphere.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/movies")
@Api(value = "MovieSphere", description = "all movies collection")
public class MovieWS {

	public static final String RESPONSE_FAILURE = "FAILURE";

	@Autowired
	MovieService movieService;

	@ApiOperation(value = "Delete a particular movie.", response = ResultVO.class)
	@DeleteMapping(value = "/{movieId}")
	public void delete(@PathVariable("movieId") Long movieId) throws MovieSphereException {
		movieService.delete(movieId);
	}

	@ApiOperation(value = "View a particular movie.", response = ResultVO.class)
	@GetMapping
	public ResultVO<List<Movie>> find() throws MovieSphereException {
		return new ResultVO<List<Movie>>(movieService.find());
	}

	@ApiOperation(value = "View list of all available movies.", response = ResultVO.class)
	@GetMapping(value = "/{movieId}")
	public ResultVO<Movie> findById(@PathVariable("movieId") Long movieId) throws MovieSphereException {
		return new ResultVO<Movie>(movieService.findById(movieId));
	}

	@ApiOperation(value = "Save a new movie.", response = ResultVO.class)
	@PostMapping
	public Long save(@RequestBody Movie movie) throws MovieSphereException {
		return movieService.save(movie);
	}

	@ApiOperation(value = "Update an existing movie.", response = ResultVO.class)
	@PutMapping(value = "/{movieId}")
	public Long update(@PathVariable Long movieId, @RequestBody Movie movie) throws MovieSphereException {
		Movie movieToUpdate = movieService.findById(movieId);
		movieToUpdate.setTitle(movie.getTitle());
		movieToUpdate.setRank(movie.getRank());
		return movieService.save(movieToUpdate);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResultVO<Object> handleNotFoundException(IllegalArgumentException ex) {
		ResultVO<Object> resultVO = new ResultVO<>();
		resultVO.setStatus(RESPONSE_FAILURE);
		resultVO.setStatusCode(500);
		resultVO.setStatusMsg(ex.getMessage());
		ex.printStackTrace();
		return resultVO;
	}

}
