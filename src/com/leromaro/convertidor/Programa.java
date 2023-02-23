package com.leromaro.convertidor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Programa {
	static boolean continuar = true;
	static boolean numero = true;
	static double valor = 0;
	static double valorDouble = 0;
	static double valorFinal = 0;
	static Object respuestaTipo;
	
	static List<String> divisas = Arrays.asList("de Dólar a ARS", " de Euro a ARS", " de Libras esterlinas  a ARS",
			"de Yen a ARS", "de Won coreano a ARS", "de ARS a Dólar", " de ARS a Euro", " de ARS a Libras esterlinas",
			"de ARS a Yen", "de ARS a Won coreano");
	static List<String> medidas = Arrays.asList("de centímetros a metros", "de centímetros kilómetros",
			"de metros a centímetros", "de metros a kilómetros", "de kilómetros a centímetos",
			"de kilómetros a metros");
	static List<String> temperaturas = Arrays.asList("de centígrados a Farenheit", " de centígrados a Kelvin",
			"de Farenheit a centígrados", "de Farenheit a Kelvin", "de Kelvin a centígrados", "de Kelvin a Farenheit");

	public static void main(String[] args) {

		while (continuar) {
			Object respuesta = JOptionPane.showInputDialog(null, "Seleccione el tipo de conversor", "Conversores",
					JOptionPane.INFORMATION_MESSAGE, null, Conversores.values(), "");
			if (respuesta == null) {
				finalizar();
			}
			String respuestaString = respuesta.toString();
			while (numero) {
				String valor = JOptionPane.showInputDialog(null, "Introduzca la cantidad a convertir : ",
						respuestaString, 3);
				System.out.println(valor);
				if (valor == null) {
					finalizar();
				}
				try {
					valorDouble = Double.parseDouble(valor);
					numero = false;
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					numero = true;
				}
			}
			numero = true;
			if (respuestaString == "Divisas") {
				respuestaTipo = JOptionPane.showInputDialog(null, "Seleccione las " + respuestaString, respuestaString,
				JOptionPane.INFORMATION_MESSAGE, null, divisas.toArray(), "");
				if (respuesta == null)finalizar();
				divisas(valorDouble);
			} else if (respuestaString == "Temperaturas") {
				respuestaTipo = JOptionPane.showInputDialog(null, "Seleccione las " + respuestaString, respuestaString,
				JOptionPane.INFORMATION_MESSAGE, null, temperaturas.toArray(), "");
				if (respuesta == null) finalizar();
				temperaturas(valorDouble);
			} else if (respuestaString == "Distancias") {
				respuestaTipo = JOptionPane.showInputDialog(null, "Seleccione las " + respuestaString, respuestaString,
				JOptionPane.INFORMATION_MESSAGE, null, medidas.toArray(), "");
				if (respuesta == null) finalizar();
				medidas(valorDouble);
			}
			JOptionPane.showMessageDialog(null, valorFinal, respuesta.toString(), JOptionPane.INFORMATION_MESSAGE);
			int fin = JOptionPane.showConfirmDialog(null, "¿Convertir otro valor?", "Conversor", JOptionPane.YES_NO_OPTION);
			if (fin==1) {
				continuar = false;
				finalizar();
			}else {
				continuar = true;
			}
			}

	}
	private static double divisas(double valor) {
		switch (respuestaTipo.toString()) {
		case "de Dólar a ARS":
			valorFinal = valor * 194.94;
			break;
		case "de Euro a ARS":
			valorFinal = valor * 207.04;
			break;
		case "de Libras esterlinas  a ARS":
			valorFinal = valor * 235.12;
			break;
		case "de Yen a ARS":
			valorFinal = valor * 1.45;
			break;
		case "de Won coreano a ARS":
			valorFinal = valor * 0.15;
			break;
		case "de ARS a Dólar":
			valorFinal = valor / 194.94;
			break;
		case "de ARS a Euro":
			valorFinal = valor / 207.04;
			break;
		case "de ARS a Libras esterlinas":
			valorFinal = valor / 235.12;
			break;
		case "de ARS a Yen":
			valorFinal = valor / 1.45;
			break;
		case "de ARS a Won coreano":
			valorFinal = valor / 0.15;
			break;
		default:
			break;
		}
		return valorFinal;
	}
	private static double temperaturas(double valor) {
		switch (respuestaTipo.toString()) {
		case "de centígrados a Farenheit":
			valorFinal = valor * 1.8 + 32;
			break;
		case "de centígrados a Kelvin":
			valorFinal = valor - 273.15;
			break;
		case "de Farenheit a centígrados":
			valorFinal = (valor - 32) / 1.8;
			break;
		case "de Farenheit a Kelvin":
			valorFinal = (5 / (9 * (valor - 32))) + 273.15;
			break;
		case "de Kelvin a centígrados":
			valorFinal = valor + 273.15;
			break;
		case "de Kelvin a Farenheit":
			valorFinal = (1.8 * (valor - 273.15)) + 32;
			break;
		default:
			break;
		}
		return valorFinal;
	}
	
	private static double medidas(double valor) {
		switch (respuestaTipo.toString()) {
		case "de centímetros a metros":
			valorFinal = valor / 100;
			break;
		case "de centímetros a kilómetros":
			valorFinal = valor / 100000;
			break;
		case "de metros a centímetros":
			valorFinal = valor * 100;
			break;
		case "de metros a kilómetros":
			valorFinal = valor / 1000;
			break;
		case "de kilómetros a centímetos":
			valorFinal = valor * 100000;
			break;
		case "de kilómetros a metros":
			valorFinal = valor * 1000;
			break;
		default:
			break;
		}
		return valorFinal;
	}
	
	private static void finalizar() {
		JOptionPane.showMessageDialog(null, "Programa Terminado", "Conversor", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
		
}
