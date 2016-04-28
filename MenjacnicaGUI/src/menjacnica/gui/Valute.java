package menjacnica.gui;

import javax.swing.table.AbstractTableModel;

public class Valute extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni",
			"Naziv" };

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return kolone[columnIndex];
		
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	

}
