package org.proyectofinal.ui.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

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
//	public static void main(String[] args){
//		
//		for (Iterator i = FontFactory.getRegisteredFonts().iterator(); i.hasNext();) {
//	        System.out.println(i.next());
//	     }
//		try {
//			new Boleto().crearBoleto();
//		} catch (IOException | DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public Boleto(){	
//		FontFactory.register(System.getProperty("file.separator")+"usr"+System.getProperty("file.separator")+"share"+System.getProperty("file.separator")+"fonts"+System.getProperty("file.separator")+"truetype"+System.getProperty("file.separator")+"mstcorefonts"+System.getProperty("file.separator")+"georgia.ttf", "Georgia");
	}

	public File retornarBoleto(){
		
		File archivo = new File(getPath());
		
		return archivo;
	}
	
	public void abrirBoleto(){
		
        // build a controller
        SwingController controller = new SwingController();

	    // Build a SwingViewFactory configured with the controller
        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();
        
// 		add copy keyboard command
//      ComponentKeyBinding.install(controller, viewerComponentPanel);
//
// 		add interactive mouse link annotation support via callback
//
//      controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
//		Use the factory to build a JPanel that is pre-configured with a complete, active Viewer UI.
//
// 		Create a JFrame to display the panel in

        JFrame ventana = new JFrame("Boleto");

        ventana.getContentPane().add(viewerComponentPanel);

        ventana.pack();
       
        ventana.setVisible(true);

  	   	// Open a PDF document to view
           
	    controller.openDocument(getPath());
	}
	
	public void crearBoleto(Reservas reserva) throws IOException, DocumentException {
    	
		FontFactory.register("/usr/share/fonts/truetype/msttcorefonts/georgia.ttf");
		
		PdfContentByte cb = null;
		ColumnText ct = null;
		Image imagen = null;
		Phrase myText = null;
		
		Rectangle rect = new Rectangle(0, 0, 595, 420);
    	
    	Document document = new Document(rect, 0,0,0,0);

//    	Date date = new Date();
    	
    	Random r = new Random();
    	
    	Integer num = (Integer) r.nextInt(1000);
    	
    	path = "/home/ivang94/Escritorio/BoletoN°".concat(num.toString()).concat(".pdf");
    	
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
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getCodigoViaje().toString(), FontFactory.getFont("georgia",13f, Font.NORMAL, BaseColor.BLACK));
			ct.setSimpleColumn(myText, 500, 355, 530, 356, 1, Element.ALIGN_CENTER);
			ct.go();

			cb = writer.getDirectContent();
			ct = new ColumnText(cb);

			//Fecha y Hora de Salida Pasajero
			myText = new Phrase(reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(8, 10) + "/" +reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(5, 7) + "/" + reserva.getListReservas().get(i).getViaje().getFechaSalida().toString().substring(0, 4) + " - " + reserva.getListReservas().get(i).getViaje().getHoraSalida().toString().substring(0, 5), FontFactory.getFont("georgia",10.5f, Font.NORMAL, BaseColor.BLACK));
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