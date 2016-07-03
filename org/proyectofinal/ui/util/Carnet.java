package org.proyectofinal.ui.util;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Carnet {
	
	private String pathPdf = null;
	private String pathImagen = null;
	
	public Carnet(){
		
	}
	
	private void convertirAImagen(String path, PersonaRegistrada pR){
		
		try {

			PDDocument document = null;
			
			//se carga el documento
			document = PDDocument.load(new File(path));
			
			//se obtiene la pagina
			PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
			
			//se convierte la hoja pdf a imagen y se coloca en memoria
			BufferedImage image = page.convertToImage();
				
			//ancho y alto de la pagina pdf
			int w = (int) document.getPageFormat(0).getWidth();
			int h = (int) document.getPageFormat(0).getHeight();
				
			//se crea una nueva imagen en memoria con el tamaño de la hoja pdf
			BufferedImage escala = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = escala.createGraphics(); 
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
				
			//se añade la imagen
			graphics2D.drawImage(image, 0, 0, w, h, null);

			pathImagen = "/home/ivang94/workspace/ProyectoFinal/src/carnets/png/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".png";
	    	
			ImageIO.write(escala, "png", new File(pathImagen));
			
		
			document.close();//cerramos el pdf
			
			String rutaImagenBIN = "/home/ivang94/workspace/ProyectoFinal/bin/carnets/png/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".png";
	    	
			copiarArchivo(pathImagen, rutaImagenBIN);

		} catch (IOException ex) {
			
		}  
	}
	
	private void crearImagenCarnet(PersonaRegistrada pR){
		convertirAImagen(getPathPdf(), pR);
	}

	public void crearCarnet(PersonaRegistrada pR) throws MalformedURLException, IOException, DocumentException {
		
		FontFactory.register("/usr/share/fonts/truetype/msttcorefonts/georgia.ttf");

		PdfContentByte cb = null;
		ColumnText ct = null;
		Image imagen = null;
		Phrase myText = null;
		
		Rectangle rect = new Rectangle(0, 0, 227, 142);
    	
    	Document document = new Document(rect, 0,0,0,0);

    	pathPdf = "/home/ivang94/workspace/ProyectoFinal/src/carnets/pdf/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".pdf";
    	
    	FileOutputStream ficheroPdf = new FileOutputStream(pathPdf);
    	
		PdfWriter writer = PdfWriter.getInstance(document, ficheroPdf);
		
		document.open();

//	    imagen = Image.getInstance("/home/ivang94/workspace/ProyectoFinal/src/imagenes/carnet.png");
		
	    imagen = Image.getInstance("/home/ivang94/workspace/ProyectoFinal/src/imagenes/carnetReal.png");

	    document.add(imagen);
	    
		document.add(new Chunk(""));
			
		//DATOS Persona
			
		cb = writer.getDirectContent();
		
		ct = new ColumnText(cb);
	
		//Apellido y Nombre
		myText = new Phrase(pR.getApellido() + ", " + pR.getNombre(), FontFactory.getFont("Arial",10f, Font.BOLD, new BaseColor(0, 20, 133)));
		ct.setSimpleColumn(myText, 14, 26, 175, 9, 1, Element.ALIGN_LEFT);
		ct.go();
		
		cb = writer.getDirectContent();
		ct = new ColumnText(cb);

		//DNI
		myText = new Phrase(pR.getDni(), FontFactory.getFont("Arial",10f, Font.BOLD, new BaseColor(0, 20, 133)));
		ct.setSimpleColumn(myText, 125, 26, 305, 9, 1, Element.ALIGN_LEFT);
		ct.go();
		
		document.close();
		
		String rutaPdfBIN = "/home/ivang94/workspace/ProyectoFinal/bin/carnets/pdf/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".pdf";
    	
		copiarArchivo(pathPdf, rutaPdfBIN);
		
		//CONVERTIR A IMAGEN
		crearImagenCarnet(pR);
    }
	
	public void copiarArchivo(String sourceFile, String destinationFile) {
//		System.out.println("Desde: " + sourceFile);
//		System.out.println("Hacia: " + destinationFile);

		try {
			File inFile = new File(sourceFile);
			File outFile = new File(destinationFile);

			FileInputStream in = new FileInputStream(inFile);
			FileOutputStream out = new FileOutputStream(outFile);

			int c;
			while( (c = in.read() ) != -1)
				out.write(c);

			in.close();
			out.close();
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!");
		}
	}

	public String getPathPdf() {
		return pathPdf;
	}

	public void setPath(String pathPdf) {
		this.pathPdf = pathPdf;
	}
	
	public String getPathImagen() {
		return pathImagen;
	}

	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

}