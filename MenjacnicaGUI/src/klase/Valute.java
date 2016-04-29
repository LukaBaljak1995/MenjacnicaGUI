package klase;

import java.io.Serializable;
import java.util.LinkedList;

public class Valute implements Serializable {

	private static final long serialVersionUID = 3703480367619355688L;
	private int sifra;
	private String naziv;
	private double prodajni;
	private double srednji;
	private double kupovni;
	private String skraceniNaziv;

	public int getSifra() {
		return sifra;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getProdajni() {
		return prodajni;
	}

	public double getSrednji() {
		return srednji;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

}
