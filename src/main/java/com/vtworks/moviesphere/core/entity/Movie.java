package com.vtworks.moviesphere.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated movie ID")
	private Long id;

	@Column(name = "Title")
	@ApiModelProperty(notes = "movie title")
	private String title;

	@Column(name = "Ranking")
	@ApiModelProperty(notes = "ranking of movie")
	private Double rank;

}
