package com.lascaux.cinemille.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.HistoricProgramming;
import com.lascaux.cinemille.service.HistoricProgrammingService;

@RestController
@RequestMapping("/api/historic")
public class HistoricProgrammingController {

	@Autowired
	private HistoricProgrammingService historicService;
	
	@GetMapping("/historicBetweenDates")
	public List<HistoricProgramming> getHistoricProgrammingBetweenDates(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
		return historicService.getHistoricBetweenDates(startDate, endDate);
	}
	
	@GetMapping("/historicByFilm")
	public List<HistoricProgramming> getHistoricProgrammingByFilm(@RequestParam("film") Film film) {
		return historicService.getHistoricByFilm(film);
	}
}
