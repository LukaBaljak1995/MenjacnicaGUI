package klase;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ValuteTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni",
			"Naziv" };
	private List<Valute> valute;

	public ValuteTableModel(List<Valute> valute) {
		if (valute == null) {
			this.valute = new LinkedList<>();
		} else {
			this.valute = valute;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return valute.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Valute v = valute.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return v.getSifra();
		case 1:
			return v.getSkraceniNaziv();
		case 2:
			return v.getSrednji();
		case 3:
			return v.getKupovni();
		case 4:
			return v.getProdajni();
		case 5:
			return v.getNaziv();
		default:
			return "NN";
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void ucitajvalute(List<Valute> valute) {
		this.valute = valute;
		fireTableDataChanged();
	}

	public Valute getValuteByIndex(int index) {
		return valute.get(index);
	}

	public void izbrisiRed(int indeks) {
		valute.remove(indeks);
	}

}
