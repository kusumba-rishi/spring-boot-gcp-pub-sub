package com.projects147.google_pub_sub.repository;

import com.projects147.google_pub_sub.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String> {
}
