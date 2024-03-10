package com.lascaux.cinemille.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "programming_detail")
public class ProgrammingDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id", nullable = false)
	private Theatre theatre;
	
	@Temporal(TemporalType.DATE)	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "programming_id", nullable = false)
	private Programming programming;

	@Override
	public String toString() {
		return "ProgrammingDetail [id=" + id + ", theatre=" + theatre + ", date=" + date + ", programming="
				+ programming + "]";
	}
}
