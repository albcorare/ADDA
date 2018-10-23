package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

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

//-----------------------------------------------------------------------------------------------------
	public static String Ej1While(List<String> ls) {
		Integer i = 0; // Contador letras
		String f = null; // Contador String
		while (i < (ls.size() - 1)) {
			f = mayorMinusculas(ls);
			i++;
		}
		return f;

	}

	public static String EjJava10(List<String> ls) {
		String res = mayorMinusculas(ls);
		ls.forEach(p -> mayorMinusculas(ls));
		return res;
	}

	public static String Ej1RecNoFinal(List<String> ls, String g, Integer i) {
		if (ls.size() == 1) {
			return ls.get(i);
		} else if (i < ls.size() - 1) {
			return g;
		} else {
			return Ej1RecNoFinal(ls, null, i++);
		}
	}

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
		b.add("Alss");
		b.add("Asaaaas");
		b.add("Asaaaasaaaa");
		// System.out.println(Ej1While(b));
		// System.out.println(cuentaMinusculas("Alberto"));
		// System.out.println(Ej1RecNoFinal(b, mayorMinusculas(b), 0));
		System.out.println(EjJava10(b));
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
