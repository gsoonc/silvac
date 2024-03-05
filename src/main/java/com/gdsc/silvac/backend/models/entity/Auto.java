package com.gdsc.silvac.backend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity

public class Auto implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(unique=true)
	private Integer codauto;
	@Basic(optional = false)
    @NotNull
    @Size( max =7, message = "La matrícula del auto debe contener 7 caracteres")
	private String matricula;
	@Basic(optional = false)
    @NotNull
    @Size(min = 15, max = 30, message = "El modelo del auto debe contener entre 15 y 30 caracteres")
	private String modelo;
	@Basic(optional = false)
    @NotNull
    @Size( max = 28, message = "El color del auto debe tener 28 caracteres como máximo")
	private String color;
	@Basic(optional = false)
    @NotNull
    @Size(min = 15, max = 30, message = "La marca del auto debe contener entre 15 y 30 caracteres")
	private String marca;
	@Basic(optional = false)
    @NotNull
    @Size(min = 3, message = "El precio de alquiler debe ser de 3 cifras")
	private String priceAlquiler;
	private Double priceTotal;
	private String litraje;
	@Basic(optional = false)
    @NotNull
    @Size(min = 15, max = 30, message = "El Garaje debe contener entre 15 y 30 caracteres")
	private String Garaje;
	
	@NotNull
	@Column(columnDefinition = "boolean default true")
	private boolean entregado;
	
	@OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
	private List<RequestReserva>autorequests;
	
	
	public Auto() {};
	public Auto(Integer codauto, String matricula, String modelo, String color, String marca,
			String priceAlquiler, Double priceTotal, String litraje, String garaje, @NotNull boolean entregado) {
		super();
		this.codauto = codauto;
		this.matricula = matricula;
		this.modelo = modelo;
		this.color = color;
		this.marca = marca;
		this.priceAlquiler = priceAlquiler;
		this.priceTotal = priceTotal;
		this.litraje = litraje;
		Garaje = garaje;
		this.entregado = entregado;
	}
	
	public Integer getCodauto() {
		return codauto;
	}

	public void setCodauto(Integer codauto) {
		this.codauto = codauto;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPriceAlquiler() {
		return priceAlquiler;
	}

	public void setPriceAlquiler(String priceAlquiler) {
		this.priceAlquiler = priceAlquiler;
	}

	public Double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public String getLitraje() {
		return litraje;
	}

	public void setLitraje(String litraje) {
		this.litraje = litraje;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public String getGaraje() {
		return Garaje;
	}

	public void setGaraje(String garaje) {
		Garaje = garaje;
	}

	
	public List<RequestReserva>getAutorequest(){
		return this.autorequests;
	}
	
	public void setAutorequests(List<RequestReserva> autorequests) {
		this.autorequests = autorequests;
	}
	
	public RequestReserva addAutorequest(RequestReserva autorequest) {
		getAutorequest().add(autorequest);
		autorequest.setAuto(this);
		return autorequest;
	}
	
	public RequestReserva removeAutorequest(RequestReserva autorequest) {
		getAutorequest().remove(autorequest);
		autorequest.setAuto(null);
		return autorequest;
	}
	
	
	
	
	
	
}
