package org.proyectofinal.ui.util;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import org.proyectofinal.ui.PanelAccion;

public class CeldaAccionEditor extends AbstractCellEditor implements TableCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6623354045559442913L;
	private PanelAccion pa;
	
	public CeldaAccionEditor() {
		pa = new PanelAccion();
		pa.setCeldaEditor(this);
	}
	
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		
		pa.setTabla(table);
		return pa;
	}
	
	public void lanzarDetencionEdicion()
    {
        this.fireEditingStopped();
    }

}
