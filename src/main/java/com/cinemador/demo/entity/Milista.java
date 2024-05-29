package com.cinemador.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_userlist")
public class Milista {

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
	private String movieImdb;
	
	@Column(nullable=true)
	private String movieRanking;

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

    public String getMovieImdb() {
        return movieImdb;
    }

    public void setMovieImdb(String movieImdb) {
        this.movieImdb = movieImdb;
    }

    public String getMovieRanking() {
        return movieRanking;
    }

    public void setMovieRanking(String movieRanking) {
        this.movieRanking = movieRanking;
    }

    
}
