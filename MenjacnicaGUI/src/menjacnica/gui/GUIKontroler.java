package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import klase.Kursevi;
import klase.Valute;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnica;
	private static Kursevi kurs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kurs = new Kursevi();
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static String sacuvajUFajl() {
		String putanja = "";
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				putanja = (String) (file.getAbsolutePath());
				kurs.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
		return putanja;
	}

	public static String ucitajIzFajla() {
		String putanja = "";
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(menjacnica.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				kurs.ucitajIzFajla(file.getAbsolutePath());
				menjacnica.osveziTabelu();
				putanja = (String) (file.getAbsolutePath());

			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
		return putanja;
	}

	public static void unesValutu(int sifra, String skraceniNaziv, double kupovni, double prodajni, double srednji,
			String naziv) {
		try {
			Valute v = new Valute();
			v.setKupovni(kupovni);
			v.setNaziv(naziv);
			v.setProdajni(prodajni);
			v.setSifra(sifra);
			v.setSkraceniNaziv(skraceniNaziv);
			v.setSrednji(srednji);
			kurs.dodajValutu(v);

			menjacnica.osveziTabelu();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Proveri formu: " + e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static List<Valute> vratiSveValute() {
		return kurs.vratiSveValute();
	}

	public static void izbrisiValutu(Valute v) {
		kurs.obrisiValutu(v);
		menjacnica.osveziTabelu();
	}

}