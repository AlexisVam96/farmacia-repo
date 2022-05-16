package com.vampiro.springboot.backen.apirest.models.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(nullable = false, unique = true)
	private String nombre;

	private String imagen;

	@NotEmpty
	@Column(nullable = false)
	private String descripcion;

	@NotNull(message = "no puede estar vacío")
	private Double precio;

	@Column(nullable = false)
	@NotNull(message = "no puede estar vacío")
	private Integer stock;

	@NotNull(message = "no puede estar vacío")
	@ManyToOne(fetch = FetchType.LAZY) // carga peresoza
	@JoinColumn(name = "categoria_id") //Se puede omitir
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_at;
	/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id") //Se puede omitir
    @JsonIgnoreProperties({"compras","productos","hibernateLazyInitializer", "handler"})
    private Usuario usuario;
*/

	@PrePersist
	public void prePersist(){
		this.create_at = new Date(); ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
}
