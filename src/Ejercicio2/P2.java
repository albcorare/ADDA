package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class P2 {
	// Dado un fichero de texto con una fecha escrita en cada línea, genere otro
	// fichero con
	// las fechas ordenadas y que estén entre dos fechas dadas.

	public static void listaFechas() throws IOException {
		Integer i = 0;
		List<String> ls = new ArrayList<String>();
		//convertir string a local
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		BufferedReader bf2 = new BufferedReader(new FileReader("ficheros/fechas"));
		String date2 = null;
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date2, formatter);
		while((date2 = bf2.readLine()) != null) {
			ls.add(date2);
			FileWriter fichero = null;
			try {

				fichero = new FileWriter("ficheros/fichero_escrituraList2.txt");

				// Escribimos linea a linea en el fichero
				for (String linea : ls) {
					fichero.write(linea + "\n");
				}

				fichero.close();

			} catch (Exception ex) {
				System.out.println("Mensaje de la excepción: " + ex.getMessage());
			}
			i++;
		}
		
		//-------------------------------------------------------
		
		
		
		
		
		
		
		/*List<String> ls = new ArrayList<String>();
		List<String> ls2 = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader("ficheros/fechas"));
		String sCadena;
		String ruta = "ficheros/nuevo.txt";
		File archivo = new File(ruta);
		while ((sCadena = bf.readLine()) != null) {
			ls.add(sCadena);
			LocalDate date = LocalDate.parse("2017-02-05");
			System.out.println("Fechas= " + ls.get(i));
			i++;
			archivo.createNewFile();
			
			
		}
		
		return ls;*/
	}
	
	

	public static void main(String[] args) throws IOException {
	
		/*
		//String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };
		
		List<String> lineas = new ArrayList<String>();
		lineas.add("Alberto");
		lineas.add("a");

		/** FORMA 1 DE ESCRITURA **/
		/*FileWriter fichero = null;
		try {

			fichero = new FileWriter("ficheros/fichero_escrituraList.txt");

			// Escribimos linea a linea en el fichero
			for (String linea : lineas) {
				fichero.write(linea + "\n");
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}*/
	}

}
