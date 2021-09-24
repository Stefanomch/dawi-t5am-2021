package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_categorias")
public class Categorias {
	
	@Id
	private int idcategoria;
	private String descripcion;
	
	
	@Override
	public String toString() {
		return "Categorias [idcategoria=" + idcategoria + ", descripcion=" + descripcion + "]";
	}
	public Categorias() {
		super();
	}
	public Categorias(int idcategoria, String categoria) {
		super();
		this.idcategoria = idcategoria;
		this.descripcion = categoria;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getCategoria() {
		return descripcion;
	}
	public void setCategoria(String categoria) {
		this.descripcion = categoria;
	}
	
	
}
