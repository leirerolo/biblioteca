package proyecto.domain;

import java.util.Objects;

import javax.swing.ImageIcon;

public class Libro {
	private String titulo;
	private String autor;
	private ImageIcon portada;
	private double valoracion;
	
	public Libro(String titulo, String autor, ImageIcon portada, double valoracion) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.portada = portada;
		this.valoracion = valoracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ImageIcon getPortada() {
		return portada;
	}

	public void setPortada(ImageIcon portada) {
		this.portada = portada;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", portada=" + portada + ", valoracion=" + valoracion
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, portada, titulo, valoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(portada, other.portada)
				&& Objects.equals(titulo, other.titulo)
				&& Double.doubleToLongBits(valoracion) == Double.doubleToLongBits(other.valoracion);
	}
	
	
}
