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
import java.util.stream.Stream;

public class P2 {
	
	// Dado un fichero de texto con una fecha escrita en cada l�nea, genere otro
	// fichero con
	// las fechas ordenadas y que est�n entre dos fechas dadas.

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
//				System.out.println("Mensaje de la excepci�n: " + ex.getMessage());
//			}
//			i++;
//		}
		
		//-------------------------------------------------------
		
		
		public static String creaFicheros() throws IOException{
			Integer i = 0;
			BufferedReader bf = new BufferedReader(new FileReader("ficheros/fechas"));
			Stream<String> a = bf.lines();
			String fecha = bf.readLine();
			String[] parts = fecha.split("/");
			
			Integer lineas =  (int) a.count();
			String nu = "19";
			Integer numEntero = Integer.parseInt(parts[i]);
			
			while(i <= parts.length) {
				
			}
			
			while(i<= lineas) {
				if(numEntero > 1) {
					return "Lee";
				}
				i++;
			}
			return "no lee";
	    }
			
	
		
	

	public static void main(String[] args) throws IOException {
		System.out.println(creaFicheros());
	}

}
