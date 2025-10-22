package proyecto.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import proyecto.domain.Libro;

public class JFramePrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<Libro> libros;
	//predefinir las fuentes
	private Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);
	private Font fuenteMenu = new Font("Comic Sans MS", Font.BOLD, 18);
	
	public JFramePrincipal(List<Libro> libros) {
		this.libros = libros;
		this.inicializarPanelSuperior();
		this.inicializarPanelCentral();
		
		this.setTitle("Biblioteca");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	private void inicializarPanelSuperior() {		
		JPanel upperPanel = new JPanel(new BorderLayout());
		// Cabecera: nombre de la biblioteca, y botón para el perfil
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(new Color(0, 160, 220));
		
		JLabel biblio = new JLabel("Biblio.O");
		biblio.setFont(fuenteTitulo);
		biblio.setForeground(Color.WHITE);
		header.add(biblio, BorderLayout.WEST);
		
		JLabel perfil = new JLabel("Mi perfil");
		perfil.setFont(fuenteTitulo);
		perfil.setForeground(Color.white);
		header.add(perfil, BorderLayout.EAST);
		upperPanel.add(header, BorderLayout.NORTH);

		// Menú de navegación: inicio, explorar, reservas
		JPanel menu = new JPanel(new GridLayout(1,3));
		menu.setBackground(Color.white);
		JLabel inicio = new JLabel("Inicio", JLabel.CENTER);
		inicio.setFont(fuenteMenu);
		menu.add(inicio);
		JLabel explorar = new JLabel("Explorar", JLabel.CENTER);
		explorar.setFont(fuenteMenu);
		menu.add(explorar);
		JLabel reservas = new JLabel("Reservas", JLabel.CENTER);
		reservas.setFont(fuenteMenu);
		menu.add(reservas);
		upperPanel.add(menu, BorderLayout.CENTER);
		upperPanel.setBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		add(upperPanel, BorderLayout.NORTH);
	}
	
	private void inicializarPanelCentral() {
	    JPanel mainPanel = new JPanel(new BorderLayout());
	    mainPanel.setBackground(Color.WHITE);

	    // --- Panel de contenido ---
	    JPanel contentPanel = new JPanel(new BorderLayout());
	    contentPanel.setBackground(Color.WHITE);

	    JLabel lblPopulares = new JLabel("Populares");
	    lblPopulares.setFont(fuenteTitulo);
	    lblPopulares.setForeground(new Color(0, 102, 204));
	    lblPopulares.setHorizontalAlignment(JLabel.LEFT);
	    lblPopulares.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    contentPanel.add(lblPopulares, BorderLayout.NORTH);

	    // --- Cuadrícula de libros ---
	    JPanel gridPanel = new JPanel(new GridLayout(2, 4, 10, 10)); // 2 filas, 4 columnas
	    gridPanel.setBackground(Color.WHITE);
	    gridPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    // Si hay libros, los mostramos
	    if (libros != null && !libros.isEmpty()) {
	        for (Libro libro : libros) {
	            JPanel libroPanel = new JPanel(new BorderLayout());
	            libroPanel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	            libroPanel.setBackground(Color.WHITE);

	            // Portada
	            JLabel portada = new JLabel("Portada", JLabel.CENTER);
	            portada.setForeground(Color.GRAY);
	            portada.setOpaque(true);
	            portada.setBackground(new Color(245, 245, 245));
	            libroPanel.add(portada, BorderLayout.CENTER);

	            // Título
	            JLabel titulo = new JLabel(libro.getTitulo(), JLabel.CENTER);
	            libroPanel.add(titulo, BorderLayout.SOUTH);

	            gridPanel.add(libroPanel);
	        }
	    } else {
	        gridPanel.add(new JLabel("No hay libros disponibles", JLabel.CENTER));
	    }

	    // Añadimos todo al contentPanel
	    JPanel scrollable = new JPanel(new BorderLayout());
	    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(gridPanel);
	    scrollPane.setBorder(null);
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);
	    scrollable.add(scrollPane, BorderLayout.CENTER);

	    contentPanel.add(scrollable, BorderLayout.CENTER);

	    mainPanel.add(contentPanel, BorderLayout.CENTER);

	    // Añadir al panel central
	    add(mainPanel, BorderLayout.CENTER);
	}


	

}
