package com.lascaux.cinemille.entities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lascaux.cinemille.entities.ProgrammingDetail;

public interface ProgrammingDetailRepo extends JpaRepository<ProgrammingDetail, Long> {

	@Query("SELECT d FROM ProgrammingDetail d WHERE d.programming.film.id = :filmId and d.programming.film.state = 1")
	public List<ProgrammingDetail> getFilmDetail(@Param("filmId") Long filmId);
}
