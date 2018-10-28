package Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class P2 {
	// Dado un fichero de texto con una fecha escrita en cada línea, genere otro
	// fichero con
	// las fechas ordenadas y que estén entre dos fechas dadas.

	public static List<String> listaFechas() throws IOException {
		Integer i = 0;
		List<String> ls = new ArrayList<String>();
		List<String> ls2 = new ArrayList<String>();
		BufferedReader bf = new BufferedReader(new FileReader("ficheros/fechas"));
		String sCadena;
		while ((sCadena = bf.readLine()) != null) {
			ls.add(sCadena);
			LocalDate date = LocalDate.parse("2017-02-05");
			System.out.println("Fechas= " + ls.get(i));
			i++;
		}
		return ls;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(listaFechas());

	}

}
