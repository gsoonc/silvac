package com.gdsc.silvac.backend.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





@Entity //Tiene una correspondiente table en la BD.
@Table (name="clientes")
//AL SER UNA CLASE DEL TIPO ENTIDAD SE DEBE IMPLEMENTAR EL SERIALIZABLE
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//SERIALIZABLE: cada objeto al instanciarse tendrá un id unico
	
	@Id	//id atributo identificador
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	private Integer cod;
	@Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 128, message = "El nombre del cliente debe estar entre 3 y 128 caracteres")
	private String nombres;
	@Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 128, message = "Los apellidos del cliete deben estar entre 3 y 128 caracteres")
	private String apellidos;
	@Basic(optional = false)
    @NotNull
    @Size(max = 8, message = "El DNI debe tener 8 caracteres")
	private String dni;
	@Basic(optional = false)
    @NotNull
    @Size(min = 30, max = 80, message = "La direcciòn del cliente debe estar entre 30 y 80 caracteres")
	private String direccion;
	private String telefono;
	@Temporal (TemporalType.DATE)
	private Date createat;
	
//Private Cliente aval para hacer la autorealización de a uno mismo
	
	
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="cliente")
	//private List<RequestReserva> requestsreserva;
	public Cliente() {};
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getCreateat() {
		return createat;
	}
	public void setCreateat(Date createat) {
		this.createat = createat;
	}
	public Cliente(Integer cod, String nombres, String apellidos, String dni, String direccion, String telefono,
			Date createat) {
		super();
		this.cod = cod;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.createat = createat;
	}

	
	
}
