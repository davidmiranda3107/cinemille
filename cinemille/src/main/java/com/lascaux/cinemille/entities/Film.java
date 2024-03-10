package com.lascaux.cinemille.entities;

import java.io.Serializable;

import com.lascaux.cinemille.enums.State;
import com.lascaux.cinemille.enums.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "film")
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Name is required")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@NotBlank(message="Director is required")
	private String director;
	
	@Enumerated(EnumType.ORDINAL)
	private State state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", name=" + name + ", genre=" + genre + ", director=" + director + ", state=" + state
				+ "]";
	}
	
}
