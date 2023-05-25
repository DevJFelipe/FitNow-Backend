package com.fitnow.fitnow.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "genero")
    private String genero;
    
    @NotBlank
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @NotBlank
    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "altura_cm")
    private Double alturaCm;

    @Column(name = "peso_kg")
    private Double pesoKg;

    @Column(name = "nivel_actividad")
    private String nivelActividad;
    
    @Column(name = "fecha_registro")
    @CreatedDate
    private Date fechaRegistro;
    
    @Column(name = "edad")
    private Integer edad;
    
    @Column(name = "lugar_entrenamiento")
    private String lugarEntrenamiento;
    
    @ElementCollection
    @Column(name = "objetivo")
    private List<String> objetivos;
    
    @JoinColumn(name = "id_rutina")    
    private Rutina rutina;
   
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Double getAlturaCm() {
		return alturaCm;
	}

	public void setAlturaCm(Double alturaCm) {
		this.alturaCm = alturaCm;
	}

	public Double getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(Double pesoKg) {
		this.pesoKg = pesoKg;
	}

	public String getNivelActividad() {
		return nivelActividad;
	}

	public void setNivelActividad(String nivelActividad) {
		this.nivelActividad = nivelActividad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getLugarEntrenamiento() {
		return lugarEntrenamiento;
	}

	public void setLugarEntrenamiento(String lugarEntrenamiento) {
		this.lugarEntrenamiento = lugarEntrenamiento;
	}
	
	public List<String> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<String> objetivos) {
        this.objetivos = objetivos;
    }
}

