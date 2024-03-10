package com.lascaux.cinemille.entities;

import java.io.Serializable;

import com.lascaux.cinemille.enums.Format;

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
@Table(name = "theatre")
public class Theatre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Format format;

	@Override
	public String toString() {
		return "Theatre [id=" + id + ", description=" + description + ", format=" + format + "]";
	}	
	
}
