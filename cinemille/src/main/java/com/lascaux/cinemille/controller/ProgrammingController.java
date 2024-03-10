package com.lascaux.cinemille.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.ProgrammingDetail;
import com.lascaux.cinemille.service.ProgrammingService;

@RestController
@RequestMapping("/api/programming")
public class ProgrammingController {

	@Autowired
	private ProgrammingService programmingService;
	
	@GetMapping("/filmBetweenDates")
	public List<Film> getFilmBetweenDates(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {		
		return programmingService.getProgrammingFilmBetweenDates(startDate, endDate);
	}
	
	@GetMapping("/filmDetail")
	public List<ProgrammingDetail> getFilmDetail(@RequestParam("filmId") Long filmId) {
		return programmingService.getFilmDetail(filmId);
	}
}
