package com.lascaux.cinemille.entities.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.Programming;
import com.lascaux.cinemille.enums.State;

public interface ProgrammingRepo extends JpaRepository<Programming, Long> {

	@Query("SELECT DISTINCT p.film FROM Programming p " +
           "WHERE p.start_date BETWEEN :startDate AND :endDate " +
	       "AND (p.end_date IS NULL OR p.end_date >= :startDate) " +
	       "AND p.state = 1")
	List<Film> findFilmBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("SELECT DISTINCT p.film FROM Programming p WHERE p.film.state = :state")
	List<Film> findActiveFilm(@Param("state") State state);
	
}
