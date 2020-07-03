package com.vtworks.moviesphere.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vtworks.moviesphere.core.entity.Movie;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
