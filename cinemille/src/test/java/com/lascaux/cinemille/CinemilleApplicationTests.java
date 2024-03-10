package com.lascaux.cinemille;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lascaux.cinemille.entities.Film;
import com.lascaux.cinemille.entities.HistoricProgramming;
import com.lascaux.cinemille.entities.ProgrammingDetail;
import com.lascaux.cinemille.service.HistoricProgrammingService;
import com.lascaux.cinemille.service.ProgrammingService;

@SpringBootTest
class CinemilleApplicationTests {

	@Autowired
	ProgrammingService programmingService;
	
	@Autowired
	HistoricProgrammingService historicService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getProgrammingFilmBetweenDatesTest() {
		LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        Date yesterday = Date.from(yesterdayLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
		List<Film> filmList = programmingService.getProgrammingFilmBetweenDates(yesterday, null);
		for (Film f : filmList) {
			System.out.println("[FILM] ---> " + f.toString());
		}
		assertFalse(filmList.isEmpty(), "the list is empty");
		
	}
	
	@Test
	void getActiveFilmTest() {
		List<Film> activeFilmList = programmingService.getActiveFilm();
		for (Film f : activeFilmList) {
			System.out.println("[FILM] ---> " + f.toString());
		}
		assertFalse(activeFilmList.isEmpty(), "the list is empty");
	}
	
	@Test
	void getActiveFilmDetail() {
		List<ProgrammingDetail> detailList = programmingService.getFilmDetail(21L);
		for (ProgrammingDetail d : detailList) {
			System.out.println("[DETAIL] ---> " + d.toString());
		}
		assertFalse(detailList.isEmpty(), "the list is empty");
	}
	
	@Test
	void getInactiveFilmDetail() {
		List<ProgrammingDetail> detailList = programmingService.getFilmDetail(1L);
		for (ProgrammingDetail d : detailList) {
			System.out.println("[DETAIL] ---> " + d.toString());
		}
		assertTrue(detailList.isEmpty(), "the list is not empty");
	}
	
	@Test
	void getHistoricByFilm() {
		Film film = new Film();
		film.setId(1L);
		List<HistoricProgramming> historicList = historicService.getHistoricByFilm(film);
		for (HistoricProgramming h : historicList) {
			System.out.println("[HISTORY] ---> " + h.toString());
		}
		assertFalse(historicList.isEmpty(), "the list is empty");
	}

}
