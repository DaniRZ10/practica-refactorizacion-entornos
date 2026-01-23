package Process;

import java.util.ArrayList;


/**
 * Código inicial para la práctica de refactorización.
 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
 */
public class ProcesadorPedidos {
 
 
    private static final int LIMITE_INFERIOR_IMPUESTOS = 100;
	private static final int LIMITE_ENVIO = 500;
	private static final double GASTOS_DE_ENVIO = 15.95;
	private static final double IVA = 0.21;
	private static final double DESCUENTO = 0.10;


	public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
        double totalSinImpuestos = 0;
        
        // Sumar precios de la lista
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + listaNombres.get(i));
            totalSinImpuestos = totalSinImpuestos + precios.get(i);
        }
        
        // Lógica de descuento (Magic Number 100 y 0.10)
        if (totalSinImpuestos > LIMITE_INFERIOR_IMPUESTOS) {
            System.out.println("Descuento aplicado.");
            totalSinImpuestos = totalSinImpuestos - (totalSinImpuestos * DESCUENTO); 
        }
        
        double resultadoTotal = calculoIVA(totalSinImpuestos);

        resultadoTotal = calculoEnvio(resultadoTotal);

        return resultadoTotal;
    }

	// Gastos de envío (Magic Number 500 y 15.95)
	private double calculoEnvio(double resultadoTotal) {
        if (resultadoTotal < LIMITE_ENVIO) {
        	resultadoTotal = resultadoTotal + GASTOS_DE_ENVIO;
        }
		return resultadoTotal;
	}


    // Cálculo de impuestos (Magic Number 0.21)
    private double calculoIVA(double totalSinImpuestos) {

    	double resultadoTotal = totalSinImpuestos + (totalSinImpuestos * IVA);
    	return resultadoTotal;
    }
}