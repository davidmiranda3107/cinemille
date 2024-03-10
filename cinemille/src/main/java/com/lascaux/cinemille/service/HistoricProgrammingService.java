package com.lascaux.cinemille.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.HistoricProgramming;
import com.lascaux.cinemille.entities.repo.HistoricProgrammingRepo;

@Service
public class HistoricProgrammingService {

	@Autowired
	private HistoricProgrammingRepo historicProgrammingRepo;
	
	public List<HistoricProgramming> getHistoricByFilm(Film film) {
		try {
		return historicProgrammingRepo.findByFilm(film);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<HistoricProgramming> getHistoricBetweenDates(Date startDate, Date endDate) {
		try {
		return historicProgrammingRepo.findByStartDateAfterAndEndDateBefore(startDate, endDate);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
