package main;

import java.io.FileOutputStream;

import clases.HandlerPDF;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "C:\\Users\\Jorge\\Documents\\Archivos Jorge\\img\\DSC014";
		HandlerPDF handlerPDF = new HandlerPDF("C:\\Users\\Jorge\\Documents\\Archivos Jorge\\img\\S. Gestion");				
		System.out.print("Cargando imagenes");
		for (int i = 34; i < 52; i++) {			
			String img = s+i+".jpg" ;		
			System.out.print("---");
			handlerPDF.addImagen(img);
		}		
		System.out.println();		
		handlerPDF.cargarImagenes();	
	
		
		
	}

}
