package br.edu.ufabc.Ticketeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sessao")
public class SessionVO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private TheaterVO theater;
	@Transient
	private MovieVO movie;
	@Column(name = "dia", unique = true, 
			nullable = false, length = 60)
	private int dia;
	@Column(name = "horario", unique = true, 
			nullable = false, length = 60)
	private int horario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MovieVO getMovie() {
		return movie;
	}
	public void setMovie(MovieVO movie) {
		this.movie = movie;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
}
