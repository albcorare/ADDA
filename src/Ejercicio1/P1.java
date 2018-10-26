package Ejercicio1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1 {
	/*
	 * Dada una lista de String buscar la cadena que tiene un mayor número de
	 * caracteres en minúscula.
	 */

	public static Integer cuentaMinusculas(String n) {
		Integer i = 0; // Contador letras
		Integer num = 0; // Contador letra guarda
		Integer nu = 0; // Contador letra Guarda
		while (i < n.length()) {
			if (!(Character.isUpperCase(n.charAt(i)))) {
				num++;
				if ((n.length()) == i) {
					if (num > nu) {
						nu = num;
					}
					i = 0;
					num = 0;
				}
			}
			i++;
		}
		return num;

	}

	public static String mayorMinusculas(List<String> ls) {
		Integer i = 0; // Contador letras
		String f = null; // Contador String
		while (i < (ls.size() - 1)) {
			if ((cuentaMinusculas(ls.get(i)) > cuentaMinusculas(ls.get(i + 1))) && i < ls.size() - 1) {
				f = ls.get(i);
			} else {
				f = ls.get(i + 1);
			}
			i++;
		}
		return f;

	}

	public static String mayorMinusculas2(List<String> ls) {
		Integer i = 0; // Contador letras
		String f = null; // Contador String
		while (i < (ls.size() - 1)) {
			if ((cuentaMinusculas(ls.get(i)) < cuentaMinusculas(ls.get(i + 1)))) {
				f = ls.get(i + 1);
			}
			i++;
		}
		return f;

	}

//--------------------------------------P1--------------------------------------------------------------
	public static String Ej1While(List<String> ls) {
		Integer i = 0; // Contador letras
		String f = null; // Contador String
		while (i < (ls.size() - 1)) {
			if (cuentaMinusculas(ls.get(i)) < cuentaMinusculas(ls.get(i + 1))) {
				f = ls.get(i + 1);
			}
			i++;
		}
		return f;

	}

	/*
	 * public static String EjJava10(List<String> ls) { return
	 * IntStream.rangeClosed(0,ls.size()-1) .boxed() .filter(x->
	 * String.valueOf(cuentaMinusculas(ls.get(x)))) .collect(Collectors.joining());
	 * }
	 */

	/*
	 * public static String ejemploY(List<String> ls){ return ls.stream()
	 * .max(Comparator.comparing(Ejemplos::ejemploX)) .get(); }
	 */
	/*
	 * public static Integer cuentaMinRec(String n) { Integer a = 0; Integer i = 0;
	 * if (n.length() == i) { return a; } else if
	 * (!(Character.isUpperCase(n.charAt(i)))) { a = a + 1; i = i + 1; return
	 * cuentaMinRec(n); } else { i = i + 1; return cuentaMinRec(n); } }
	 */
	public static Integer cuentaMinRec(String n, Integer a, Integer i) {
		if (n.length() == i) {
			return a;
		}else if (!(Character.isUpperCase(n.charAt(i)))) {
			return cuentaMinRec(n, a + 1, i + 1);
		} else {
			return cuentaMinRec(n, a, i + 1);
		}
	}
	

	public static String Ej1RecFinal(List<String> ls, String g, Integer i) {
		if (ls.size() == 1) {
			return ls.get(i);
		}else if(ls.size()-1 == i) {
			return g;
		}else if (cuentaMinRec(ls.get(i), 0, 0) < cuentaMinRec(ls.get(i + 1), 0, 0)) {
			if(cuentaMinRec(ls.get(i+1), 0, 0) > cuentaMinRec(g, 0, 0)) {
				return Ej1RecFinal(ls, ls.get(i+1), i+1);
			}
			return Ej1RecFinal(ls, g, i + 1);
		} else {
			return Ej1RecFinal(ls,ls.get(i), i + 1);
		}
	}

//List<String> lineas = Files.lines(Paths.get("...\..\....txt")).collect(Collectors.toList());	
	// cada linea forma partr de una parte de la lista

	// List<String> lineas =
	// Files.lines(Paths.get("PPI/src/Ejercicio1/fechas.txt")).collect(Collectors.toList());
	// -----------------------------------------------------------------------------------------------------
	/*
	 * public static String Ej1RecNoFinal(List<String> ls) { String n = null;
	 * Integer i = 0; return ls.forEach(p->cuentaMinusculas(ls.get(i))) return n;
	 * 
	 * }
	 */
	// CREAR UN METODO QUE DETERMINE QUEIN ES MAYOR EN UNA LISTA DE STRING

	// filter mayor numero de mayusculas

	public static void main(String[] args) {
		List<String> b = new ArrayList<String>();
		b.add("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS");
		b.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		b.add("As");
		b.add("aaaaaaaaaaaaaaaaaaa");
		b.add("");
		b.add("assssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		// System.out.println(Ej1While(b));
		System.out.println(Ej1RecFinal(b,"", 0));
		// System.out.println(EjJava10(b));
		// System.out.println(mayorMinusculas2(b));
		//System.out.println(cuentaMinRec("AlddddGGGGffffb",0,0));
	}

	/*
	 * public static String Ej1While2(List<String> ls) { Integer i = 0; // Contador
	 * letras Integer num = 0; // Contador letra guarda Integer nu = 0; // Contador
	 * letra Guarda Integer c = 0; // Contador Lista String f = null; // Contador
	 * String while (c < ls.size()) { if
	 * (!(Character.isUpperCase(ls.get(c).charAt(i)))) { num++; if
	 * ((ls.get(c).length() - 1) == i) { if (num > nu) { nu = num; f = ls.get(c); }
	 * c++; i = -1; num = 0; } } i++; } return f;
	 * 
	 * }
	 */

}
