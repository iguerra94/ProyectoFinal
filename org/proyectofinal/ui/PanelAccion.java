package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.ui.util.CeldaAccionEditor;

public class PanelAccion extends JPanel {

	private static final long serialVersionUID = -7994970746450494028L;

	private JTable tabla;
	@SuppressWarnings("unused")
	private CeldaAccionEditor cae;
	@SuppressWarnings("unused")
	private AbstractTableModel atm;
	private JButton btnEditar;
	private JButton btnEliminar;
	
	public PanelAccion() {
		setBackground(Color.WHITE);
		initComponents();
	}
	
	public void setCeldaEditor(CeldaAccionEditor cae)
    {
        this.cae = cae;
    }
    
    public void setTabla(JTable tabla)
    {
        this.tabla = tabla;
        atm = (AbstractTableModel) this.tabla.getModel();
    }
    
    private void initComponents(){
    	
    	setLayout(null);
		
		btnEditar = new JButton("");
		btnEditar.setBorderPainted(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setToolTipText("Editar vuelo..");
		btnEditar.setIcon(new ImageIcon(PanelAccion.class.getResource("/imagenes/editar.png")));
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEditarActionPerformed();
			}
		});
		btnEditar.setBounds(0, 1, 30, 15);
		add(btnEditar);
		
		btnEliminar = new JButton("");
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setToolTipText("Eliminar vuelo..");
		btnEliminar.setIcon(new ImageIcon(PanelAccion.class.getResource("/imagenes/eliminar.png")));
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnEliminarActionPerformed();
			}
		});
		btnEliminar.setBounds(32, 1, 30, 15);
		add(btnEliminar);
    	
    }
    
    private void btnEliminarActionPerformed(){
		int opcion = JOptionPane.showConfirmDialog(tabla,"¿Está seguro que desea eliminar el vuelo con Codigo de Viaje N° " + tabla.getValueAt(tabla.getSelectedRow(), 0) + "?", "Eliminar vuelo..", JOptionPane.YES_NO_OPTION);
		
		if (opcion == 0){
			
			ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
			Integer codigo = (Integer)tabla.getValueAt(tabla.getSelectedRow(), 0);
			
			try {
				vCDao.baja(codigo);
				
				JOptionPane.showMessageDialog(tabla, "El vuelo ha sido eliminado con exito!");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(tabla, e1.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(tabla, e1.getMessage());
			}
		}
    }
    
    private void btnEditarActionPerformed(){
		Integer codViaje = (Integer)tabla.getValueAt(tabla.getSelectedRow(), 0);
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		DialogLoadFlight dLF = new DialogLoadFlight();
		
		dLF.setTitle("Editar vuelo..");
//		dLF.setBounds(15, 260, 171, 37);
		dLF.getBtnRealizarCambios().setText("Guardar cambios");
		
		try {
			
			vCDao.conectar();
			
			ResultSet res = vCDao.consultarPorCodigoViaje(codViaje);
			
			while(res.next()){
				
				dLF.getTxtCodigoViaje().setText(dLF.getTxtCodigoViaje().getText() + res.getInt("codViaje"));
				dLF.getTxtCiudadOrigen().setText(dLF.getTxtCiudadOrigen().getText() + res.getString("ciudadOrigen"));
//				dLF.getTxtPaisOrigen().setText(dLF.getTxtPaisOrigen().getText() + res.getString("paisOrigen"));
				dLF.getTxtCiudadDestino().setText(dLF.getTxtCiudadDestino().getText() + res.getString("ciudadDestino"));
//				dLF.getTxtPaisDestino().setText(dLF.getTxtPaisDestino().getText() + res.getString("paisDestino"));
				dLF.getDateChooserFechaSalida().setDate(res.getDate("fechaSalida"));
				dLF.getTxtHoraSalida().setText(dLF.getTxtHoraSalida().getText() + res.getTime("horaSalida"));
				dLF.getDateChooserFechaLlegada().setDate(res.getDate("fechaLlegada"));
				dLF.getTxtHoraLlegada().setText(dLF.getTxtHoraLlegada().getText() + res.getTime("horaLlegada"));
				dLF.getTxtCupo().setText(dLF.getTxtCupo().getText() + res.getInt("cupo"));			

				dLF.getTxtCodigoViaje().setEnabled(false);
			}
			
			vCDao.desconectar();
			
//			dLF.validate();
//			dLF.repaint();
			
			dLF.setVisible(true);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(dLF, e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(dLF, e.getMessage());
		}
		
    }
}