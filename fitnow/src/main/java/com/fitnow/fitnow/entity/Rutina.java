package com.fitnow.fitnow.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutina")
public class Rutina implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rutina")
    private Integer idRutina;
    
    @Column(name = "dia")
    private String dia;
    
    @Column(name = "ejercicio")
    private String ejercicio;
    
    @JsonIgnore
    @OneToOne
    @JoinColumn(name ="id_usuario")
    private Usuario usuario;

	public Integer getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(Integer idRutina) {
		this.idRutina = idRutina;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
    
}
