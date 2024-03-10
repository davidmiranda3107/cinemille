package com.lascaux.cinemille.entities;

import java.io.Serializable;
import java.util.Date;

import com.lascaux.cinemille.enums.State;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "programming_master")
public class Programming implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	
	@ManyToOne
	@JoinColumn(name = "film_id", nullable = false)
	private Film film;
	
	@Temporal(TemporalType.DATE)	
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date end_date;
	
	@Enumerated(EnumType.ORDINAL)
	private State state;
	
	private Integer weeks;

	@Override
	public String toString() {
		return "Programming [id=" + id + ", film=" + film + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", state=" + state + ", weeks=" + weeks + "]";
	}

}
