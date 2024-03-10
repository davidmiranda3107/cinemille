package com.lascaux.cinemille.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "historic_programming")
public class HistoricProgramming implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "film_id", nullable = false)
	private Film film;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatre;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)	
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)	
	private Date endDate;

	@Override
	public String toString() {
		return "HistoricProgramming [id=" + id + ", film=" + film + ", theatre=" + theatre + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
}
