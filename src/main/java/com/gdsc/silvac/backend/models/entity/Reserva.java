package com.gdsc.silvac.backend.models.entity;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reservas")
public class Reserva  implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codreserv;
	
	@NotNull
	private String agencia;
	
	@Temporal(TemporalType.DATE)
	private Date Inicio;
	@Temporal(TemporalType.DATE)
	private Date Fin;
	
	@NotNull
	private Cliente cliente;
	
	@NotNull
	private Auto auto;
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/*@OneToOne(cascade = CascadeType.ALL, mappedBy="usuario")
	private List<RequestReserva> autoRequest;*/
	
}
