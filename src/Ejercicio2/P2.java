package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class P2 {

	// Dado un fichero de texto con una fecha escrita en cada línea, genere otro
	// fichero con
	// las fechas ordenadas y que estén entre dos fechas dadas.

	public static List<LocalDate> listFechas(LocalDate fechamenor, LocalDate fechamayor){
		Integer i = 0;

		List<String> f = getLines("ficheros/fechas");// lista de fechas
		List<LocalDate> lista = new ArrayList<>();
		
		while (i < f.size()) {
			LocalDate localDate1 = LocalDate.parse(f.get(i), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			if(localDate1.isAfter(fechamenor) && localDate1.isBefore(fechamayor)) {
				lista.add(localDate1);
			}
			i++;	
		}
		Collections.sort(lista);
		return lista;
		
	}
	
	public static void While(LocalDate fechamenor, LocalDate fechamayor){
		Integer i = 0;
		while(i < listFechas(fechamenor, fechamayor).size()) {
			String fecha = listFechas(fechamenor, fechamayor).toString();
			toFile(fecha, "ficheros/fechasIterativo");
			i++;
		}
	}
	public static void listFechasRec(LocalDate fechamenor, LocalDate fechamayor,Integer i
			,List<LocalDate> lista ){
		List<String> f = getLines("ficheros/fechas");
		LocalDate date = LocalDate.parse(f.get(i), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if(i == f.size()-1) {
			if((date.isAfter(fechamenor) && date.isBefore(fechamayor))) {
				lista.add(date);
				Collections.sort(lista);
				toFile(lista.toString(), "ficheros/fechasRecursivo");
			}
		}else if(!(date.isAfter(fechamenor) && date.isBefore(fechamayor))){
			 listFechasRec(fechamenor, fechamayor, i+1, lista);
		}else {
			lista.add(date);
			 listFechasRec(fechamenor, fechamayor, i+1,lista);
		}
	}
	public static void listFechasRec2(LocalDate fechamenor, LocalDate fechamayor) {
		List<LocalDate> lista = new ArrayList<>();
		if(fechamenor.isAfter(fechamayor)) {
			System.out.println("La fecha menor debe ser anterior a la fecha mayor");
		}else {
			listFechasRec(fechamenor, fechamayor, 0, lista);
		}

	}
	
	public static List<LocalDate> fechasJava10(LocalDate fechamenor, LocalDate fechamayor,Integer i
			,List<LocalDate> lista ) {
		List<String> f = getLines("ficheros/fechas");
		
		return IntStream.rangeClosed(0, f.size()-1)
				.boxed()
				.map(x-> LocalDate.parse(f.get(x), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.collect(Collectors.toList());
	}
	
	public static void fechasJava10(LocalDate fechamenor, LocalDate fechamayor){
		List<LocalDate> lista = new ArrayList<LocalDate>();
		 toFile( fechasJava10(fechamenor, fechamayor, 0, lista).stream()
				 .filter(x-> x.isAfter(fechamenor) && x.isBefore(fechamayor))
				 .collect(Collectors.toList()).toString(), "ficheros/fechasJava10");
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
//----------------------------------------------------------------------------------------	
	public static void toFile(Stream<String> s, String file) {
		try {
			final PrintWriter f = 
					new PrintWriter(new BufferedWriter(
							new FileWriter(file)));
			s.forEach(x->f.println(x));
			f.close();
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"No se ha podido crear el fichero " + file);
		}
	}
	
	public static PrintWriter getWriter(String f) {
		PrintWriter fout = null;
		try {
			fout = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		} catch (IOException e) {
			System.err.println(e.toString());
		}
		return fout;
	}
	public static void toFile(String s, String file) {
		try {
			final PrintWriter f = 
					new PrintWriter(new BufferedWriter(
							new FileWriter(file)));
			f.println(s);
			f.close();
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"No se ha podido crear el fichero " + file);
		}
	}
	
	public static List<String> getLines(String f) {
		List<String> lineas = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
			lineas = bufferedReader.lines().collect(Collectors.toList());
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return lineas;
	}

	public static void main(String[] args) throws IOException {
		List<LocalDate> lista = new ArrayList<LocalDate>();
		LocalDate menor = LocalDate.of(1996, 4, 10);
		
		
		While(menor, LocalDate.now());
		//listFechasRec(menor, LocalDate.now(), 0,lista);
		//System.out.println(fechasJava10(menor, LocalDate.now(), 0, lista));
		fechasJava10(menor, LocalDate.now());
		listFechasRec2(menor, LocalDate.now());
		//System.out.println(recursivo(menor, LocalDate.now(), 0, lista));
		
	}

}
