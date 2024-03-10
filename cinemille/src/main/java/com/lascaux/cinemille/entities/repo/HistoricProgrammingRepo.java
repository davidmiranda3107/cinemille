package com.lascaux.cinemille.entities.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.HistoricProgramming;

public interface HistoricProgrammingRepo extends CrudRepository<HistoricProgramming, Long> {

	List<HistoricProgramming> findByStartDateAfterAndEndDateBefore(Date start_Date, Date end_Date);
	
	List<HistoricProgramming> findByFilm(Film film);
}
