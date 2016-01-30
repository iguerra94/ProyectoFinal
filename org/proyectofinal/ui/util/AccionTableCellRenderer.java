package org.proyectofinal.ui.util;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.proyectofinal.ui.PanelAccion;

public class AccionTableCellRenderer implements TableCellRenderer {

	private PanelAccion test;
	
	public AccionTableCellRenderer() {
		test = new PanelAccion();
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		test.setTabla(table);
		
		return test;
	}

}
