package org.proyectofinal.ui.util;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.PropertiesManager;

import javax.swing.*;
import java.util.ResourceBundle;

import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;

public class pdfopener {    

    public void helpview() throws URISyntaxException {    	    

        String filepath = "C:/sample.pdf";

        // build a controller
        SwingController controller = new SwingController();

	    // Build a SwingViewFactory configured with the controller
        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

	    // add copy keyboard command
//        ComponentKeyBinding.install(controller, viewerComponentPanel);

        // add interactive mouse link annotation support via callback

        controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));

        // Use the factory to build a JPanel that is pre-configured with a complete, active Viewer UI.

        // Create a JFrame to display the panel in

        JFrame window = new JFrame("Metrics Wizard Help");

        window.getContentPane().add(viewerComponentPanel);

        window.pack();
       
        window.setVisible(true);

  	   	// Open a PDF document to view
           
	    controller.openDocument(filepath);

    }

}