package com.gdsc.silvac.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class RequestReserva implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer requestId;
	
	private long requestTime;
	
	private long responseTime;
	
	private int status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="cod")
	private Cliente cliete;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name="codauto")
	private Auto auto;

	
	public RequestReserva() {
		
	}

	public RequestReserva(Integer requestId, long requestTime, long responseTime, int status, Cliente cliete,
			Auto auto) {
		super();
		this.requestId = requestId;
		this.requestTime = requestTime;
		this.responseTime = responseTime;
		this.status = status;
		this.cliete = cliete;
		this.auto = auto;
	}


	public Integer getRequestId() {
		return requestId;
	}


	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}


	public long getRequestTime() {
		return requestTime;
	}


	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}


	public long getResponseTime() {
		return responseTime;
	}


	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Cliente getCliete() {
		return cliete;
	}


	public void setCliete(Cliente cliete) {
		this.cliete = cliete;
	}


	public Auto getAuto() {
		return auto;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	
	
}
