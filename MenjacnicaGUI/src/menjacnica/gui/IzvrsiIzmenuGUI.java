package menjacnica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class IzvrsiIzmenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField textFieldKupovniKurs;
	private JLabel label;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JCheckBox kupovinaCheckBox;
	private JTextField prodajniTextField;
	private JTextField iznosTextField;

	/**
	 * Create the frame.
	 */
	public IzvrsiIzmenuGUI() {
		setPreferredSize(new Dimension(300, 500));
		setResizable(false);
		setTitle("Izvrsite izmenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLabel());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTextFieldKupovniKurs());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getKupovinaCheckBox());

		JLabel lblTransakcija = new JLabel("Transakcija:");
		lblTransakcija.setBounds(298, 126, 106, 16);
		contentPane.add(lblTransakcija);

		JCheckBox prodajaCheckBox = new JCheckBox("Prodaja");
		prodajaCheckBox.setBounds(298, 169, 128, 23);
		contentPane.add(prodajaCheckBox);
		contentPane.add(getProdajniTextField());
		contentPane.add(getIznosTextField());

		JSlider slider = new JSlider();
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				iznosTextField.setText("" + slider.getValue());
			}
		});
		slider.setFont(new Font("Palatino", Font.BOLD, 15));
		slider.setMajorTickSpacing(10);
		slider.setPaintLabels(true);
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setVisible(true);
		slider.setMinorTickSpacing(5);
		slider.setBounds(6, 209, 438, 39);
		contentPane.add(slider);

		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getKupovinaCheckBox().isSelected()) {
					String tekst = "Transakcija kupovine -> Valuta: " + (String) comboBox.getSelectedItem()
							+ ", iznos: " + iznosTextField.getText();
					GUIKontroler.setZaEditor(GUIKontroler.getZaEditor() + tekst);
				}
				if (prodajaCheckBox.isSelected()) {
					String tekst = "Transakcija prodaje -> Valuta: " + (String) comboBox.getSelectedItem() + ", iznos: "
							+ iznosTextField.getText();
					GUIKontroler.setZaEditor(GUIKontroler.getZaEditor() + tekst);
				}
			}
		});
		btnIzvrsiZamenu.setBounds(6, 275, 175, 39);
		contentPane.add(btnIzvrsiZamenu);

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(269, 275, 175, 39);
		contentPane.add(btnOdustani);
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs:");
			lblProdajniKurs.setBounds(298, 5, 146, 47);
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs:");
			lblKupovniKurs.setBounds(6, 5, 146, 47);
		}
		return lblKupovniKurs;
	}

	private JTextField getTextFieldKupovniKurs() {
		if (textFieldKupovniKurs == null) {
			textFieldKupovniKurs = new JTextField();
			textFieldKupovniKurs.setPreferredSize(new Dimension(50, 20));
			textFieldKupovniKurs.setBounds(6, 64, 146, 39);
			textFieldKupovniKurs.setEditable(false);
			textFieldKupovniKurs.setColumns(10);
		}
		return textFieldKupovniKurs;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(152, 5, 146, 89);
		}
		return label;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(152, 44, 146, 89);
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHF");
		}
		return comboBox;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(6, 115, 146, 39);
		}
		return lblIznos;
	}

	private JCheckBox getKupovinaCheckBox() {
		if (kupovinaCheckBox == null) {
			kupovinaCheckBox = new JCheckBox("Kupovina");
			kupovinaCheckBox.setBounds(298, 145, 146, 24);
			kupovinaCheckBox.setPreferredSize(new Dimension(90, 13));
		}
		return kupovinaCheckBox;
	}

	private JTextField getProdajniTextField() {
		if (prodajniTextField == null) {
			prodajniTextField = new JTextField();
			prodajniTextField.setPreferredSize(new Dimension(50, 20));
			prodajniTextField.setEditable(false);
			prodajniTextField.setColumns(10);
			prodajniTextField.setBounds(298, 64, 146, 39);
		}
		return prodajniTextField;
	}

	private JTextField getIznosTextField() {
		if (iznosTextField == null) {
			iznosTextField = new JTextField();
			iznosTextField.setPreferredSize(new Dimension(50, 20));
			iznosTextField.setColumns(10);
			iznosTextField.setBounds(6, 153, 146, 39);
		}
		return iznosTextField;
	}
}
