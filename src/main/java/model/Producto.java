package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_productos")
public class Producto {
	
	@Id
	private String idprod;
	private String descripcion;
	private int stock;
	private double precio;
	@Column(name="idcategoria")
	private int categoria;
	private int estado;
	
	
	
	public Producto() {
		super();
	}

	public Producto(String idprod, String descripcion, int stock, double precio, int categoria, int estado) {
		super();
		this.idprod = idprod;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.categoria = categoria;
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Producto [idprod=" + idprod + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio
				+ ", categoria=" + categoria + ", estado=" + estado + "]";
	}
	
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
