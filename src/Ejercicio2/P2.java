package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class P2 {

	// Dado un fichero de texto con una fecha escrita en cada línea, genere otro
	// fichero con
	// las fechas ordenadas y que estén entre dos fechas dadas.

//	public static void listaFechas() throws IOException {
//		Integer i = 0;
//		List<String> ls = new ArrayList<String>();
//		//convertir string a local
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//		BufferedReader bf2 = new BufferedReader(new FileReader("ficheros/fechas"));
//		String date2 = null;
//		//convert String to LocalDate
//		LocalDate localDate = LocalDate.parse(date2, formatter);
//		while((date2 = bf2.readLine()) != null) {
//			ls.add(date2);
//			FileWriter fichero = null;
//			try {
//
//				fichero = new FileWriter("ficheros/fichero_escriturakjhjjkh.txt");
//
//				// Escribimos linea a linea en el fichero
//				for (String linea : ls) {
//					fichero.write(linea + "\n");
//				}
//
//				fichero.close();
//
//			} catch (Exception ex) {
//				System.out.println("Mensaje de la excepción: " + ex.getMessage());
//			}
//			i++;
//		}

	// -------------------------------------------------------

	public static List<LocalDate> creaFicheros(LocalDate z) throws IOException {
		Integer i = 0;
		BufferedReader bf = new BufferedReader(new FileReader("ficheros/fechas"));

//		Stream<String> a = bf.lines();
		String fecha = bf.readLine();// lee la linea
//		String[] parts = fecha.split("/");// cortar fecha

		//Integer lineas = (int) a.count();// numero de lineas de txt
		LocalDate localDate1 = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));// pasa string a local
																									// date

		List<LocalDate> ls = new ArrayList<LocalDate>();
		// ordenas fechas
		Scanner s = new Scanner(bf);
		Boolean lineaa = s.hasNextLine();
		String linea = s.;

		// Leemos linea a linea el fichero
		
		while (true) {
			// Guardamos la linea en un String
			if(s.) {
				System.out.println(linea);
			}
			
			System.out.println(linea);      // Imprimimos la linea
		}


	}

	public static void main(String[] args) throws IOException {
		System.out.println(creaFicheros(LocalDate.now()));
	}

}
