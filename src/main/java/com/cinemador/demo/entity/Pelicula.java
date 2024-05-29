package com.cinemador.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_movies")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;
	
	@Column(nullable=false)
	private String movieTitle;

	@Column(nullable=false)
	private String movieGenre;
	
	@Column(nullable=false)
	private String movieDescription;
	
	@Column(nullable=true, length = 512)
	private String movieTrailer;
	
	@Column(nullable=true)
	private Float movieImdb;
	
	@Column(nullable=true)
	private Float movieRanking;
	
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieTrailer() {
		return movieTrailer;
	}

	public void setMovieTrailer(String movieTrailer) {
		this.movieTrailer = movieTrailer;
	}

	public Float getMovieImdb() {
		return movieImdb;
	}

	public void setMovieImdb(Float movieImdb) {
		this.movieImdb = movieImdb;
	}

	public Float getMovieRanking() {
		return movieRanking;
	}

	public void setMovieRanking(Float movieRanking) {
		this.movieRanking = movieRanking;
	}

}
