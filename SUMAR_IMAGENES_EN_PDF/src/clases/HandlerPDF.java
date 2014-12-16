package clases;

import java.io.FileOutputStream;
import java.util.ArrayList;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class HandlerPDF {
	
	Document documento;
	PdfWriter writer;
	ArrayList<String> imagenes = new ArrayList<String>();
	
	
/* Constructor */	
	public HandlerPDF(String path) {
		
		try{
		this.documento = new Document(PageSize.A4);	
		this.writer = PdfWriter.getInstance(documento,new FileOutputStream(path+".pdf"));
		}
		catch(Exception e){
			 System.out.println("Se produjo un Error al Crear el Documento");
		 }
		
	}
/* Setters and Getters */	
	
	public Document getDocumento() {
		return documento;
	}
	public PdfWriter getWriter() {
		return writer;
	}
	public void setWriter(PdfWriter writer) {
		this.writer = writer;
	}
	public void setDocumento(Document documento) {
		this.documento = documento;
	}
	public ArrayList<String> getImagenes() {
		return imagenes;
	}
	public void setImagenes(ArrayList<String> imagenes) {
		this.imagenes = imagenes;
	} 
	
/* Metodos */
	
/*Crear Archivos con imagenes*/	
	public void addImagen (String imagen){
		imagenes.add(imagen);
	}
			
	public void cargarImagenes(){			
		try{
			documento.open();
			System.out.print("Agregando imagenes");
			for (String imagen: imagenes) {
				
				 Image imag = Image.getInstance(imagen);
				 imag.scaleAbsolute(PageSize.A4.getWidth(),PageSize.A4.getHeight());
				 imag.setAbsolutePosition((PageSize.A4.getWidth() - imag.getScaledWidth()) / 2,
				 						  (PageSize.A4.getHeight() - imag.getScaledHeight()) / 2);
				 writer.getDirectContent().addImage(imag);	
				 documento.newPage();
				System.out.print("---");
			}
			System.out.println();
			System.out.println("Archivo creado satisfactoriamente");
			documento.close();
		}
		catch(Exception e){
			 System.out.println("Se produjo un Error al Incertar Imagen");
		 }					
		
	}
/*Leer Archivos*/
	
	public void lector (String path, String newPath){
		try{		 	        
			PdfReader reader = new PdfReader(path);
	        int n = reader.getNumberOfPages();
	        documento.open();
	        PdfImportedPage page;

	        // Go through all pages
	        for (int i = 1; i <= n; i++) {
	            page = writer.getImportedPage(reader, i);
	            Image instance = Image.getInstance(page);
	            instance.scaleAbsolute(PageSize.A4.getWidth(),PageSize.A4.getHeight());
	            instance.setAbsolutePosition((PageSize.A4.getWidth() - instance.getScaledWidth()) / 2,
				 						   (PageSize.A4.getHeight() - instance.getScaledHeight()) / 2);
	            documento.add(instance);
	        }

	        documento.close();

        System.out.println("listo!");
		
		}
		catch(Exception e){
			 System.out.println("Se produjo un Error al leer el archivo");
		 }	
	}
	
	

}
