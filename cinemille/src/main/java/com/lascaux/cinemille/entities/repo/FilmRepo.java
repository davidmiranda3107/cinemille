package com.lascaux.cinemille.entities.repo;

import org.springframework.data.repository.CrudRepository;

import com.lascaux.cinemille.entities.Film;

public interface FilmRepo extends CrudRepository<Film, Long> {

}
