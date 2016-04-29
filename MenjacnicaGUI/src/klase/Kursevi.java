package klase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class Kursevi {

	private LinkedList<Valute> valute = new LinkedList<Valute>();

	public void dodajValutu(Valute valuta) {
		valute.add(valuta);
	}

	public void obrisiValutu(Valute valuta) {
		valute.remove(valuta);
	}

	public LinkedList<Valute> vratiSveValute() {
		return valute;
	}

	public void sacuvajUFajl(String putanja) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(putanja)));

			out.writeObject(valute);

			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")

	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(putanja)));

			LinkedList<Valute> valute2 = (LinkedList<Valute>) (in.readObject());
			valute.clear();
			valute.addAll(valute2);

			in.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
