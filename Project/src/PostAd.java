import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import components.FileChooserDemo;

public class PostAd {
	private SeeAds seeAds;
	private PostAd postAd;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ButtonGroup furnishedButtonGroup;
	private ButtonGroup priceButtonGroup;
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_3 = new JComboBox();
	JComboBox comboBox_4 = new JComboBox();
	JComboBox periodTypeComboBox = new JComboBox<>();
	JLabel lblChooseType = new JLabel("Choose Type");
	JLabel label = new JLabel("");
	JLabel lblNewLabel_1 = new JLabel("New label");
	JLabel lblTitle = new JLabel("Title");
	JLabel lblAdress = new JLabel("Adress");
	JComboBox comboBox_5 = new JComboBox();
	JComboBox comboBox_6 = new JComboBox();
	JComboBox comboBox_8 = new JComboBox();
	JComboBox comboBox_9 = new JComboBox();
	JLabel lblFurnished = new JLabel("Furnished");
	JRadioButton rdbtnYes = new JRadioButton("Yes");
	JRadioButton rdbtnNo = new JRadioButton("No");
	JLabel label_1 = new JLabel("");
	JLabel lblPrice = new JLabel("Price");
	JRadioButton rdbtnTl = new JRadioButton("Tl");
	JRadioButton rdbtnUsd = new JRadioButton("Usd");
	JRadioButton rdbtnEur = new JRadioButton("Eur");
	String photoPath;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PostAd window = new PostAd();
	 * window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the application.
	 */
	public PostAd() {
		postAd = this;
		initialize();
	}

	public PostAd(SeeAds seeAds) {
		this.seeAds = seeAds;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final String[] city = new String[4];
		city[0] = "City";
		city[1] = "Ankara";
		city[2] = "Ýstanbul";
		city[3] = "Ardahan";
		final String[] ankaraTown = new String[4];
		ankaraTown[0] = "Town";
		ankaraTown[1] = "Cankaya";
		ankaraTown[2] = "Polatli";
		ankaraTown[3] = "Yenimahalle";
		final String[] istanbulTown = new String[4];
		istanbulTown[0] = "Town";
		istanbulTown[1] = "Bagcilar";
		istanbulTown[2] = "Sultanbeyli";
		istanbulTown[3] = "Esenyurt";
		final String[] ardahanTown = new String[4];
		ardahanTown[0] = "Town";
		ardahanTown[1] = "Damal";
		ardahanTown[2] = "Çýldýr";
		ardahanTown[3] = "Göle";
		final String[] cankayaDistrict = { "District", "Kizilay", "Bilkent" };
		final String[] polatliDistrict = { "District", "Cumhuriyet", "Gedikli" };
		final String[] yenimahalleDistrict = { "District", "Anadolu", "Barýþ" };
		final String[] bagcilarDistrict = { "District", "100.Yýl", "Fatih" };
		final String[] sultanbeyliDistrict = { "District", "Mehmet Akif", "Orhangazi" };
		final String[] esenyurtDistrict = { "District", "Akçaburgaz", "Esenkent" };
		final String[] damalDistrict = { "District", "Mustafa Kemal", "Kalender" };
		final String[] cýldýrDistrict = { "District", "Kenardere", "Eskibeyrehatun" };
		final String[] göleDistrict = { "District", "Gülistan", "Göle" };

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 594, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 251, 556, -244);
		frame.getContentPane().add(panel);

		comboBox_1.setBounds(43, 291, 248, 20);
		comboBox_1.addItem("Office");
		comboBox_1.addItem("House");
		comboBox_1.addItem("Land");
		comboBox_1.addItem("Timeshare");
		frame.getContentPane().add(comboBox_1);

		comboBox_4.addItem("Sale");
		comboBox_4.addItem("Rent");

		comboBox_4.addActionListener(new ActionListener() {

			@Override
			//When rent chosen, long term and short term enabled to click
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				if (newSelection.equals("Sale")) {
					periodTypeComboBox.setEnabled(false);
				} else {
					periodTypeComboBox.setEnabled(true);
				}
			}
		});

		periodTypeComboBox.addItem("Short");
		periodTypeComboBox.addItem("Long");
		periodTypeComboBox.setBounds(43, 326, 248, 20);
		periodTypeComboBox.setEnabled(false);
		frame.getContentPane().add(periodTypeComboBox);

		JButton btnSignOut = new JButton("Sign Out");
		comboBox_3.setBounds(43, 344, 248, 20);
		comboBox_3.addItem("Flat");
		comboBox_3.addItem("Residence");
		comboBox_3.addItem("Villa");
		comboBox_3.addItem("Farm House");
		comboBox_3.addItem("Mansion");
		frame.getContentPane().add(comboBox_3);

		comboBox_4.setBounds(43, 308, 248, 20);
		frame.getContentPane().add(comboBox_4);

		btnSignOut.setBounds(59, 51, 89, 23);

		btnSignOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		frame.getContentPane().add(btnSignOut);

		textField = new JTextField();
		textField.setBounds(43, 180, 248, 59);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		lblChooseType.setBounds(43, 236, 137, 41);
		lblChooseType.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblChooseType);

		label.setBounds(43, 155, 1, 2);
		frame.getContentPane().add(label);

		lblNewLabel_1.setBounds(43, 183, 89, -34);
		frame.getContentPane().add(lblNewLabel_1);

		lblTitle.setBounds(43, 155, 89, 28);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblTitle);

		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdress.setBounds(43, 377, 73, 23);
		frame.getContentPane().add(lblAdress);

		comboBox_5.setBounds(43, 411, 119, 20);
		// for (int i = 0; i < city.length; i++) {
		// comboBox_5.addItem(city[i]);
		// }

		comboBox_6.setBounds(43, 441, 119, 20);
		final String townStr[] = new String[1];
		townStr[0] = "Town";
		comboBox_6.setModel(new DefaultComboBoxModel<>(townStr));
		frame.getContentPane().add(comboBox_6);
		comboBox_5.setModel(new DefaultComboBoxModel<>(city));
		comboBox_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				
				//When the city changes, town changes in adress combo boxes
				if (newSelection.equals("Ýstanbul")) {
					comboBox_6.setModel(new DefaultComboBoxModel<>(istanbulTown));
				} else if (newSelection.equals("Ankara")) {
					comboBox_6.setModel(new DefaultComboBoxModel<>(ankaraTown));
				} else if (newSelection.equals("Ardahan")) {
					comboBox_6.setModel(new DefaultComboBoxModel<>(ardahanTown));
				}
				frame.revalidate();
				frame.repaint();

			}
		});

		frame.getContentPane().add(comboBox_5);
		final String districtStr[] = new String[1];
		districtStr[0] = "District";
		comboBox_8.setModel(new DefaultComboBoxModel<>(districtStr));

		comboBox_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				
				//When the town changes, district changes in adress combo boxes
				if (newSelection.equals("Cankaya")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(cankayaDistrict));
				} else if (newSelection.equals("Polatli")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(polatliDistrict));
				} else if (newSelection.equals("Yenimahalle")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(yenimahalleDistrict));
				} else if (newSelection.equals("Bagcilar")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(bagcilarDistrict));
				} else if (newSelection.equals("Sultanbeyli")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(sultanbeyliDistrict));
				} else if (newSelection.equals("Esenyurt")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(esenyurtDistrict));
				} else if (newSelection.equals("Damal")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(damalDistrict));
				} else if (newSelection.equals("Çýldýr")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(cýldýrDistrict));
				} else if (newSelection.equals("Göle")) {
					comboBox_8.setModel(new DefaultComboBoxModel<>(göleDistrict));
				}
				frame.revalidate();
				frame.repaint();
			}
		});

		comboBox_8.setBounds(43, 472, 119, 23);
		// comboBox_8.addItem("orhan gazi");
		frame.getContentPane().add(comboBox_8);

		lblFurnished.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFurnished.setBounds(346, 180, 82, 20);
		frame.getContentPane().add(lblFurnished);

		furnishedButtonGroup = new ButtonGroup();
		rdbtnYes.setBounds(342, 198, 109, 23);
		rdbtnYes.setSelected(true);
		frame.getContentPane().add(rdbtnYes);

		rdbtnNo.setBounds(453, 198, 109, 23);
		rdbtnNo.setSelected(false);
		frame.getContentPane().add(rdbtnNo);

		furnishedButtonGroup.add(rdbtnNo);
		furnishedButtonGroup.add(rdbtnYes);

		label_1.setBounds(340, 180, -4, 7);
		frame.getContentPane().add(label_1);

		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(346, 226, 82, 14);
		frame.getContentPane().add(lblPrice);

		priceButtonGroup = new ButtonGroup();

		rdbtnTl.setBounds(346, 250, 58, 20);
		rdbtnTl.setSelected(true);
		frame.getContentPane().add(rdbtnTl);

		rdbtnUsd.setBounds(406, 249, 58, 23);
		rdbtnUsd.setSelected(false);
		frame.getContentPane().add(rdbtnUsd);

		rdbtnEur.setBounds(466, 249, 58, 23);
		rdbtnEur.setSelected(false);
		frame.getContentPane().add(rdbtnEur);

		priceButtonGroup.add(rdbtnTl);
		priceButtonGroup.add(rdbtnEur);
		priceButtonGroup.add(rdbtnUsd);

		textField_1 = new JTextField();
		textField_1.setBounds(342, 273, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblM = new JLabel("M^2");
		lblM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM.setBounds(342, 311, 64, 14);
		frame.getContentPane().add(lblM);

		textField_2 = new JTextField();
		textField_2.setBounds(342, 326, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNumberOfRoom = new JLabel("Number of Room");
		lblNumberOfRoom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberOfRoom.setBounds(342, 365, 129, 19);
		frame.getContentPane().add(lblNumberOfRoom);

		comboBox_9.setBounds(342, 395, 129, 20);
		comboBox_9.addItem("1+1");
		comboBox_9.addItem("2+1");
		comboBox_9.addItem("3+1");
		frame.getContentPane().add(comboBox_9);

		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSignOut.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure", "Sign Out", dialogButton);
				if (dialogResult == 0) {

					frame.setVisible(false); // you can't see me!
					frame.dispose(); // Destroy the JFrame object

				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		JButton btnSendAd = new JButton("Send Ad");
		btnSendAd.setBounds(202, 536, 89, 23);
		btnSendAd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					createNewState();
				} catch (FileNotFoundException e1) {
				} catch (IOException e1) {
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnSendAd);

		JFileChooser fc;
		fc = new JFileChooser();

		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(346, 536, 89, 23);
		btnUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnUpload) {
					File imageFile;
					int returnVal = fc.showOpenDialog(btnUpload);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						imageFile = fc.getSelectedFile();
						setPhotoPath(imageFile.getPath());

					}

				}

			}
		});

		frame.getContentPane().add(btnUpload);

		JLabel lblRemsys = new JLabel();
		ImageIcon logoIcon = new ImageIcon("src/logo.png");
		Image logoImage = logoIcon.getImage();
		Image newLogo = logoImage.getScaledInstance(220, 145, java.awt.Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(newLogo);
		lblRemsys.setIcon(logoIcon);

		lblRemsys.setBounds(176, 18, 228, 139);
		frame.getContentPane().add(lblRemsys);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void createNewState() throws Exception {
		//Gives id based on date of posting ad
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		String id_with_time = year + ":" + month + ":" + day;

		int realState_id = FileHandler.getMaxId() + 1;
		id_with_time += "-" + realState_id;

		// System.out.println(realState_id);
		String warning = "please specify: ";
		String title = this.textField.getText();
		//Validations for meter, title, city selection, town selection, district selection
		if (title.length() == 0) {
			warning += "Title, ";
		}
		String typeOfState = this.comboBox_1.getSelectedItem().toString();
		String whatFor = this.comboBox_4.getSelectedItem().toString();
		String propertyType = this.comboBox_3.getSelectedItem().toString();

		String city = this.comboBox_5.getSelectedItem().toString();
		if (city.equalsIgnoreCase("City")) {
			warning += "City, ";
		}
		String town = this.comboBox_6.getSelectedItem().toString();
		if (town.isEmpty() || town.length() == 0 || town.equalsIgnoreCase("Town")) {
			warning += "Town, ";
		}
		String district = this.comboBox_8.getSelectedItem().toString();
		if (district.isEmpty() || district.length() == 0 || district.equalsIgnoreCase("District")) {
			warning += "District, ";
		}

		String numberOfRooms = this.comboBox_9.getSelectedItem().toString();

		// System.out.println(title + " " + typeOfState + " " + whatFor + " " +
		// propertyType);
		// System.out.println(city + " " + town + " " + district + " " +
		// numberOfRooms);
		
		//Button selections for furnished and money
		String furniture = "";
		for (Enumeration<AbstractButton> buttons = furnishedButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				furniture = button.getText();
			}
		}

		String price = "";
		for (Enumeration<AbstractButton> buttons = priceButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				price = button.getText();
			}
		}
		//validation for price
		String priceAmount = textField_1.getText();
		for (int i = 0; i < priceAmount.length(); i++) {
			if ('0' > priceAmount.charAt(i) || priceAmount.charAt(i) > '9') {
				throw new Exception("price must be written as numbers");
			}
		}
		if (priceAmount.isEmpty() || priceAmount.length() == 0) {
			warning += "Price Amount, ";
			throw new Exception("price must be written as numbers");
		}
		//validation for metersquare
		String meters = textField_2.getText();
		for (int i = 0; i < meters.length(); i++) {
			if ('0' > meters.charAt(i) || meters.charAt(i) > '9') {
				throw new Exception("meters must be written as numbers");
			}
		}
		if (meters.isEmpty() || meters.length() == 0) {
			warning += "Meters, ";
		}

		boolean isRent;
		boolean isSale;
		if (whatFor.equals("Sale")) {
			isRent = false;
			isSale = true;
		} else {
			isRent = true;
			isSale = false;
		}
		boolean isFurnished = false;
		if (furniture.equals("Yes")) {
			isFurnished = true;
		}
		String period = "NonePeriod";
		if (isRent) {
			period = periodTypeComboBox.getSelectedItem().toString();
		}
		if (!warning.equalsIgnoreCase("please specify: ")) {
			throw new Exception(warning);
		}
		
		if (price.equals("USD"))
			priceAmount = String.valueOf(Double.parseDouble(priceAmount) * 3.4);
		if (price.equals("Eur"))
			priceAmount = String.valueOf(Double.parseDouble(priceAmount) * 3.4);

		RealEstate realEstate = new RealEstate(title, city, town, district, Double.parseDouble(priceAmount),
				typeOfState, numberOfRooms, isFurnished, isSale, isRent, getPhotoPath(), id_with_time,
				Integer.parseInt(meters), period);

		System.out.println(realEstate.toString());

		FileHandler.writeEstateToFile(realEstate);

		seeAds.frame.setVisible(true);
		seeAds.frame.setVisible(true);
		seeAds.frame.repaint();
		frame.setVisible(false); // you can't see me!
		frame.dispose(); // Destroy the JFrame object

		this.seeAds.afterPostAdd();

	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
		this.photoPath.replace("\\", "\\\\");
	}

	public String getPhotoPath() {
		return photoPath;
	}

}