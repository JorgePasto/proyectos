package com.pastorino.fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Fibonacci {
	
	Map<Double, Double> result; 

	/*
	 * Constructor que toma los valores base 
	 * F(0)=0 - F(1)=1
	 * el resto los va calculando
	 */
	public Fibonacci (){
		double uno=1;
		double cero=0;
		result =  new HashMap<Double, Double>();
		this.result.put(cero, cero);
		this.result.put(uno, uno);		
	}
		
	/*
	 * Método Recursivo evolutivo que va guardando los valores calculados
	 * y se fija en los valores existentes
	 */
	public double getFuncion (double n){
		// Verifico si esta el valor para la clave, si no es asi lo calculo
		if (! this.result.containsKey(n)){
			this.result.put(n,getFuncion(n-2) + getFuncion(n-1));
		}
		return this.result.get(n);		
	}
	/*
	 * Método que utiliza una estructura repetitiva. 
	 */
	public double getValor (double n){
	double fibo1=1, fibo2=1, fibonacci=1;
	if(n == 1 || n == 2){
        return 1;
    }
	if (n == 0){
        return 0;
    }
    
    for(int i= 3; i<= n; i++){
        fibonacci = fibo1 + fibo2;
        fibo1 = fibo2;
        fibo2 = fibonacci;

    }
    return fibonacci;
	}
	/*
	 * Imprime el Diccionario generado
	 */
	public void printD (){
	for(Entry<Double, Double> entry : this.result.entrySet()) {
		  System.out.print(entry.getKey());
		  System.out.print(" - ");
		   System.out.println(entry.getValue());
		
	}
		
	}
	 
}