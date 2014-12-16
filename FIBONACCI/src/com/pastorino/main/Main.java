package com.pastorino.main;

import com.pastorino.fibonacci.Fibonacci;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Fibonacci fibonacci = new Fibonacci();
		Scanner sc = new Scanner(System.in);
		int valor = 0;
		double n = 0, res;
		long tIni, tFin;     
		 
		while (valor != 3){
			
			System.out.println("¿Qué desea Hacer?");
			System.out.println("1) Calcular solo un valor.");
			System.out.println("2) Calcular hasta un valor.");
			System.out.println("3) Salir.");
			valor = Integer.parseInt(sc.nextLine());
			
			switch (valor) {
			
            		case 1: 
            			System.out.print("Ingrese el valor a calcular: ");
            			n = Double.parseDouble(sc.nextLine());
            			System.out.print("La función Fibonacci de: "+n+" es: ");
            			tIni = System.currentTimeMillis();
            			res = fibonacci.getFuncion(n);
            			tFin = System.currentTimeMillis();
            			System.out.println(res);
            			System.out.println("Se tardo: "+(tFin -tIni)+" milisegundos");
            			
         			    break;
         			    
            		case 2: 
            			System.out.print("Ingrese hasta el valor a calcular: ");
            			n = Double.parseDouble(sc.nextLine());           			
            			for (int i = 0; i <= n; i++) {
            			    System.out.println("La función Fibonacci de: "+i+" es: "+fibonacci.getFuncion(i));
            			}
            			break;
            			
            		case 3: 
            			System.out.println("Chau!");
            			break;
            			
            		default:
            			System.out.println("Opción Incorrecta! ");
            			break;
			}

		}
	}
}
