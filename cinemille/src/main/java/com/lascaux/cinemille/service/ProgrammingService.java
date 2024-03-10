package com.lascaux.cinemille.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.ProgrammingDetail;
import com.lascaux.cinemille.entities.repo.ProgrammingDetailRepo;
import com.lascaux.cinemille.entities.repo.ProgrammingRepo;
import com.lascaux.cinemille.enums.State;

@Service
public class ProgrammingService {

	@Autowired
	private ProgrammingRepo programmingRepo;
	
	@Autowired
	private ProgrammingDetailRepo detailRepo;
	
	public List<Film> getProgrammingFilmBetweenDates(Date startDate, Date endDate) {
		try {
		LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if (endDate == null) {
			LocalDate localEndDate = localStartDate.plusWeeks(1);
			endDate = Date.from(localEndDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
		return programmingRepo.findFilmBetweenDates(startDate, endDate);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Film> getActiveFilm() {
		try {
		return programmingRepo.findActiveFilm(State.ACTIVE);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<ProgrammingDetail> getFilmDetail(Long filmId) {
		try {
		return detailRepo.getFilmDetail(filmId);
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
