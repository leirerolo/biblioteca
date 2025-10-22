package proyecto.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import proyecto.domain.*;
import proyecto.gui.JFramePrincipal;

public class Main {

	public static void main(String[] args) {
		List<Libro> libros = cargarLibrosCSV("libros.csv");
		SwingUtilities.invokeLater(() -> {
            JFramePrincipal ventana = new JFramePrincipal(libros);
            ventana.setVisible(true);
        });
	}

	private static List<Libro> cargarLibrosCSV(String fichero) {
		File f = new File(fichero);
		List<Libro> listaLibros = new ArrayList<>();
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				System.out.println(linea);
				
				String[] campos = linea.split(";");
				ImageIcon portada = null; // cuando tengamos las fotos cargadas será: new ImageIcon("images/"+campos[2]);
				Libro libro = new Libro(campos[0], campos[1], portada, Double.parseDouble(campos[3]));
				listaLibros.add(libro);
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error" + e.getMessage());
		}
		return listaLibros;
	}
	
	
}
