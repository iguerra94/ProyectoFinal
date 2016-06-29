package org.proyectofinal.ui.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class Boleto {
	
	private FileOutputStream ficheroPdf = null;
	private String path = null;
	private List<String> ImagePaths = null;
	
	public Boleto(){
		ImagePaths = new ArrayList<String>();
	}

	public File retornarBoleto(){
		
		File archivo = new File(getPath());
		
		return archivo;
	}
	
	public void convertirAImagen(String path){
		
		try {
			
			PDDocument document = null;
			
			//se carga el documento
			document = PDDocument.load(new File(path));
			
			//se obtiene el numero de paginas del PDF
			int numero_paginas = document.getNumberOfPages();
			
			//Se capturan todas las paginas
			List pages = document.getDocumentCatalog().getAllPages();
			
			//un ciclo repetitivo para crear todas las imagenes
			for(int i = 0; i <= numero_paginas-1; i++){
				
				//se obtiene la pagina "i" de n paginas
				PDPage page = (PDPage)pages.get(i);
				
				//se convierte la hoja pdf a imagen y se coloca en memoria
				BufferedImage image = page.convertToImage();
				
				//ancho y alto de la pagina pdf
				int w = (int) document.getPageFormat(i).getWidth();
				int h = (int) document.getPageFormat(i).getHeight();
				
				//se crea una nueva imagen en memoria con el tamaño de la hoja pdf
				BufferedImage escala = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics2D = escala.createGraphics(); 
				graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
				
				//se añade la imagen
				graphics2D.drawImage(image, 0, 0, w, h, null);
				
				// se escribe a imagen en disco
				
				ImagePaths.add(path.substring(0, path.length()-4) + "-" + i + ".png");
				
				ImageIO.write(escala, "png", new File(ImagePaths.get(i)));
			}
		
			document.close();//cerramos el pdf

		} catch (IOException ex) {
			Logger.getLogger(Boleto.class.getName()).log(Level.SEVERE, null, ex);
		}  
	}
	
	public void abrirBoleto(){
		
		convertirAImagen(getPath());
        
        for (int i = 0; i < ImagePaths.size(); i++) {     	
        	JFrame ventana = new JFrame("Boleto " + (i+1));
        	ImageIcon imagen = new ImageIcon(ImagePaths.get(i));
        	JLabel etiqueta = new JLabel(imagen);
        	ventana.getContentPane().add(etiqueta);
        	ventana.setBounds(100 +(600*i), 50, 800, 800);
            ventana.setResizable(false);
            ventana.pack();
            ventana.requestFocus();
            ventana.setVisible(true);
		}
        
	}
	
	public void crearBoleto(Reservas reserva) throws IOException, DocumentException {
    	
		FontFactory.register("/usr/share/fonts/truetype/msttcorefonts/georgia.ttf");
		
		PdfContentByte cb = null;
		ColumnText ct = null;
		Image imagen = null;
		Phrase myText = null;
		
		Rectangle rect = new Rectangle(0, 0, 595, 420);
    	
    	Document document = new Document(rect, 0,0,0,0);
    	
    	Random r = new Random();
    	
    	Integer num = (Integer) r.nextInt(1000);
    	
    	path = "/home/ivang94/Escritorio/BoletoN°".concat(num.toString()) + ".pdf";
    	
    	FileOutputStream ficheroPdf = new FileOutputStream(path);
    	
		PdfWriter writer = PdfWriter.getInstance(document, ficheroPdf);
		
		document.open();
		
		for (int i = 0; i < reserva.getListReservas().size(); i++){

		    imagen = Image.getInstance("/home/ivang94/workspace/PruebaIText/src/BOLETO.gif");
	
		    document.add(imagen);
		    
			document.add(new Chunk(""));
			
			//DATOS COMPAÑIA
			
			cb = writer.getDirectContent();
			
			ct = new ColumnText(cb);
		
			//Numero de Viaje Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCodigoViaje().toString(), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 87, 345, 150, 346, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);

			//Fecha de Salida Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(8, 10) + "/" +reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(5, 7) + "/" + reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(0, 4), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 84, 317, 180, 318, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Hora de Salida Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getHoraSalida().toString().substring(0, 5), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 230, 317, 275, 318, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Origen Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCiudadOrigen() + ", " + reserva.getListReservas().get(i).getViaje().getShortPaisOrigen(), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 98, 288, 220, 289, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Destino Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCiudadDestino() + ", " + reserva.getListReservas().get(i).getViaje().getShortPaisDestino(), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 92, 260, 230, 261, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Asiento Compañia
			myText = new Phrase(reserva.getListReservas().get(i).getAsiento().toString(), FontFactory.getFont("georgia",13f, Font.BOLD, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 109, 236, 130, 237, 1, Element.ALIGN_CENTER);
			ct.go();
			
			//DATOS PASAJERO

			cb = writer.getDirectContent();
			ct = new ColumnText(cb);

			//Numero de Viaje Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCodigoViaje().toString(), FontFactory.getFont("georgia",10.5f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 480, 355, 550, 356, 1, Element.ALIGN_CENTER);
			ct.go();

			cb = writer.getDirectContent();
			ct = new ColumnText(cb);

			//Fecha y Hora de Salida Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(8, 10) + "/" +reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(5, 7) + "/" + reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(0, 4) + " - " + reserva.getListReservas().get(i).getViaje().getHoraSalida().toString().substring(0, 5), FontFactory.getFont("georgia",10f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 440, 317, 560, 318, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);

			//Origen Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCiudadOrigen() + ", " + reserva.getListReservas().get(i).getViaje().getShortPaisOrigen(), FontFactory.getFont("georgia",10f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 440, 287, 560, 288, 1, Element.ALIGN_CENTER);
			ct.go();

			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Destino Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCiudadDestino() + ", " + reserva.getListReservas().get(i).getViaje().getShortPaisDestino(), FontFactory.getFont("georgia",10f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 442, 261, 560, 262, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Apellido y Nombre Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getPasajero().getApellido() + ", " + reserva.getListReservas().get(i).getPasajero().getNombre(), FontFactory.getFont("georgia",9.5f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 442, 232, 560, 233, 1, Element.ALIGN_CENTER);
			ct.go();
			
			cb = writer.getDirectContent();
			ct = new ColumnText(cb);
			
			//Asiento Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getAsiento().toString(), FontFactory.getFont("georgia",12f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 505, 216, 530, 217, 1, Element.ALIGN_CENTER);
			ct.go();
			
			document.newPage();
		}
		
		document.close();
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}