package Process;

import java.util.ArrayList;


/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
 
 
    private static final double DESCUENTO = 0.10;


	public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double totalSinImpuestos = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            totalSinImpuestos = totalSinImpuestos + precios.get(i);
        }
        
        // Lógica de descuento (Magic Number 100 y 0.10)
        if (totalSinImpuestos > 100) {
            System.out.println("Descuento aplicado.");
            totalSinImpuestos = totalSinImpuestos - (totalSinImpuestos * DESCUENTO); 
        }
        
        double resultadoTotal = calculoIVA(totalSinImpuestos);

        resultadoTotal = calculoEnvio(resultadoTotal);

        return resultadoTotal;
    }


	private double calculoEnvio(double resultadoTotal) {
		// Gastos de envío (Magic Number 500 y 15.95)
        if (resultadoTotal < 500) {
        	resultadoTotal = resultadoTotal + 15.95;
        }
		return resultadoTotal;
	}


    // Cálculo de impuestos (Magic Number 0.21)
    private double calculoIVA(double totalSinImpuestos) {

    	double resultadoTotal = totalSinImpuestos + (totalSinImpuestos * 0.21);
    	return resultadoTotal;
    }
}