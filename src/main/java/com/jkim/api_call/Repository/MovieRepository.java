package com.jkim.api_call.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jkim.api_call.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
