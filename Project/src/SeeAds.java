
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class SeeAds {
	PostAd postAd;
	SeeAds seeAds;
	private static final LayoutManager BorderLayout = null;
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JComboBox comboBox_3 = new JComboBox();
	JComboBox comboBox_2 = new JComboBox();
	JComboBox comboBox_4 = new JComboBox();
	JComboBox comboBox_5 = new JComboBox();
	JComboBox comboBox_6 = new JComboBox();
	JTextField txtMax = new JTextField();
	JTextField txtMin = new JTextField();
	boolean furnished;
	JRadioButton rdbtnYes = new JRadioButton("Yes");
	JRadioButton rdbtnNo = new JRadioButton("No");

	double metreMinRange = 0;
	double metreMaxRange = 1000000000000000.0;
	String selectedCity = "";
	String selectedTown = "";
	String selectedDistrict = "";
	String type = "";
	String usingFor = "";
	String period = "";
	String numberOfRoom = "";
	String currency = "";
	double priceMin = 0;
	double priceMax = 1000000000000000.0;
	boolean isForRent = true;
	boolean isForSale = true;
	JFrame frame;
	private final JLabel lblPeriod = new JLabel("Period");
	private final JLabel lblPriceRange = new JLabel("Price Range");
	private final JRadioButton rdbtnUsd = new JRadioButton("USD");
	private final JRadioButton rdbtnEur = new JRadioButton("EUR");
	private final JRadioButton rdbtnTl = new JRadioButton("TL");
	private final JLabel lblM = new JLabel("M^2");
	private final JTextField meterMin = new JTextField();
	private final JTextField meterMax = new JTextField();
	private final JLabel lblNumberOfRoom = new JLabel("Number of Room");
	private final JLabel lblFurnished = new JLabel("Furnished");
	private final JLabel logo = new JLabel("");
	private final JButton btnSearch = new JButton("Search");
	JPanel panel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeAds window = new SeeAds();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public SeeAds() throws FileNotFoundException, IOException {
		seeAds = this;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private void initialize() throws FileNotFoundException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				comboBox_1.removeAllItems();

				if (newSelection.equals("Ýstanbul")) {
					for (int i = 0; i < istanbulTown.length; i++) {
						comboBox_1.addItem(istanbulTown[i]);

					}

					frame.revalidate();
					frame.repaint();

				}
				if (newSelection.equals("Ankara")) {
					for (int i = 0; i < ankaraTown.length; i++) {
						comboBox_1.addItem(ankaraTown[i]);
					}

					frame.revalidate();
					frame.repaint();
				}
				if (newSelection.equals("Ardahan")) {
					for (int i = 0; i < ardahanTown.length; i++) {
						comboBox_1.addItem(ardahanTown[i]);
					}

					frame.revalidate();
					frame.repaint();

				}

			}
		});

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = comboBox_2.getSelectedItem().toString();

			}

		});
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usingFor = comboBox_4.getSelectedItem().toString();
				if (usingFor.equals("Rent")) {
					isForRent = true;
					isForSale = false;
				} else if (usingFor.equals("Sale")) {
					isForRent = false;
					isForSale = true;
				} else if (usingFor.equals("For")) {
					isForRent = true;
					isForSale = true;
				}

			}

		});
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				period = comboBox_5.getSelectedItem().toString();

			}

		});

		txtMin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtMin.setText("");

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
		txtMax.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtMax.setText("");

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

		txtMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					priceMax = Double.parseDouble(txtMax.getText());
					if (currency.equals("USD"))
						priceMax = priceMax * 3.4;
					if (currency.equals("Eur"))
						priceMax = priceMax * 3.4;
				}

				catch (NumberFormatException ex) {
					JOptionPane currencyNotSelected = new JOptionPane();
					currencyNotSelected.showMessageDialog(null, "Please Select Currency First", "Select Currency",
							currencyNotSelected.WARNING_MESSAGE);

				}

			}

		});
		txtMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					priceMin = Double.parseDouble(txtMin.getText());
					if (currency.equals("USD"))
						priceMin = priceMin * 3.6;
					if (currency.equals("Eur"))
						priceMin = priceMin * 3.6;
				} catch (NumberFormatException ex) {
					JOptionPane currencyNotSelected = new JOptionPane();
					currencyNotSelected.showMessageDialog(null, "Please Select Currency First", "Select Currency",
							currencyNotSelected.WARNING_MESSAGE);

				}

			}

		});

		rdbtnTl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUsd.setSelected(false);
				rdbtnEur.setSelected(false);
				currency = rdbtnTl.getLabel();

			}

		});
		rdbtnUsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEur.setSelected(false);
				rdbtnTl.setSelected(false);
				currency = rdbtnUsd.getLabel();

			}

		});
		rdbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
				furnished = true;

			}

		});
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnYes.setSelected(false);
				furnished = false;

			}

		});
		rdbtnEur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnUsd.setSelected(false);
				rdbtnTl.setSelected(false);
				currency = rdbtnEur.getLabel();

			}

		});

		meterMax.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				meterMax.setText("");

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
		meterMin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				meterMin.setText("");

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
		meterMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					metreMinRange = Double.parseDouble(meterMin.getText());
				} catch (NumberFormatException ex) {
					JOptionPane currencyNotSelected = new JOptionPane();
					currencyNotSelected.showMessageDialog(null, "Please Enter Min", "Enter Min",
							currencyNotSelected.WARNING_MESSAGE);
				}
			}

		});
		meterMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					metreMaxRange = Double.parseDouble(meterMax.getText());
				}

				catch (NumberFormatException ex) {
					JOptionPane currencyNotSelected = new JOptionPane();
					currencyNotSelected.showMessageDialog(null, "Please Enter Max", "Enter Max",
							currencyNotSelected.WARNING_MESSAGE);
				}
			}

		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String newSelection = (String) cb.getSelectedItem();

				comboBox_3.removeAllItems();
				if (newSelection != null) {

					if (newSelection.equals("Cankaya")) {
						for (int i = 0; i < cankayaDistrict.length; i++) {
							comboBox_3.addItem(cankayaDistrict[i]);

						}

						frame.revalidate();
						frame.repaint();
					}
					if (newSelection.equals("Polatli")) {
						for (int i = 0; i < polatliDistrict.length; i++) {
							comboBox_3.addItem(polatliDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();
					}
					if (newSelection.equals("Yenimahalle")) {
						for (int i = 0; i < yenimahalleDistrict.length; i++) {
							comboBox_3.addItem(yenimahalleDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();

					}
					if (newSelection.equals("Damal")) {
						for (int i = 0; i < damalDistrict.length; i++) {
							comboBox_3.addItem(damalDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();
					}
					if (newSelection.equals("Çýldýr")) {
						for (int i = 0; i < cýldýrDistrict.length; i++) {
							comboBox_3.addItem(cýldýrDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();

					}
					if (newSelection.equals("Göle")) {
						for (int i = 0; i < göleDistrict.length; i++) {
							comboBox_3.addItem(göleDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();
					}
					if (newSelection.equals("Esenyurt")) {
						for (int i = 0; i < esenyurtDistrict.length; i++) {
							comboBox_3.addItem(esenyurtDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();

					}
					if (newSelection.equals("Sultanbeyli")) {
						for (int i = 0; i < sultanbeyliDistrict.length; i++) {
							comboBox_3.addItem(sultanbeyliDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();
					}
					if (newSelection.equals("Bagcilar")) {
						for (int i = 0; i < bagcilarDistrict.length; i++) {
							comboBox_3.addItem(bagcilarDistrict[i]);
						}

						frame.revalidate();
						frame.repaint();

					}

				}

			}
		});
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfRoom = comboBox_6.getSelectedItem().toString();

			}

		});

		comboBox.setModel(new DefaultComboBoxModel(city));

		JLabel lblNewLabel = new JLabel("Adress");

		JLabel lblNewLabel_1 = new JLabel("Type Of Real Estate");

		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Type", "Office", "House", "Land", "TimeShare" }));

		JLabel lblFor = new JLabel("For");

		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "For", "Sale", "Rent" }));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Period", "Long Term", "Short Term" }));

		txtMin.setHorizontalAlignment(SwingConstants.CENTER);
		txtMin.setText("MIN");
		txtMin.setColumns(10);

		txtMax.setText("MAX");
		txtMax.setHorizontalAlignment(SwingConstants.CENTER);
		txtMax.setColumns(10);
		meterMin.setText("MIN");
		meterMin.setHorizontalAlignment(SwingConstants.CENTER);
		meterMin.setColumns(10);
		meterMax.setText("MAX");
		meterMax.setHorizontalAlignment(SwingConstants.CENTER);
		meterMax.setColumns(10);
		comboBox_6.setModel(
				new DefaultComboBoxModel(new String[] { "Number Of Room", "1+1", "2+1", "3+1", "3+2", "4+1", "4+2" }));

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JButton btnPostAdd = new JButton("Post Add");
		menuBar.add(btnPostAdd);

		JButton btnSignout = new JButton("SignOut");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(btnSignout);
		btnSignout.addMouseListener(new MouseListener() {

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
					seeAds.frame.setVisible(true);
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

		btnPostAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				postAd = new PostAd(seeAds);

				// admin myAdmin = new admin();
				// myAdmin.frame.setVisible(true); // open the postadd frame.
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			// filtres selected
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != null) {
					selectedCity = comboBox.getSelectedItem().toString();
				}
				if (comboBox_1.getSelectedItem() != null) {
					selectedTown = comboBox_1.getSelectedItem().toString();
				}

				if (comboBox_3.getSelectedItem() != null) {
					selectedDistrict = comboBox_3.getSelectedItem().toString();
				}

				try {
					int furnishedInt = 1;
					int forSaleInt = 1;
					int forRentInt = 1;
					if (furnished == true) {
						furnishedInt = 1;
					}
					if (furnished == false) {
						furnishedInt = 0;
					}
					if (isForSale == true) {
						forSaleInt = 1;
					}
					if (isForSale == false) {
						forSaleInt = 0;
					}
					if (isForRent == true) {
						forRentInt = 1;
					}
					if (isForRent == false) {
						forRentInt = 0;
					}
					if (!txtMin.getText().isEmpty() && txtMin.getText().length() != 0
							&& !txtMin.getText().equalsIgnoreCase("MIN")) {
						boolean flag = true;
						for (int i = 0; i < txtMin.getText().length(); i++) {
							if ('0' > txtMin.getText().charAt(i) || txtMin.getText().charAt(i) > '9') {
								flag = false;
								break;
							}
						}
						if (flag == true) {
							priceMin = Double.parseDouble(txtMin.getText());
						} else {
							priceMin = 0;
						}

					} else {
						priceMin = 0;
					}
					if (!txtMax.getText().isEmpty() && txtMax.getText().length() != 0
							&& !txtMax.getText().equalsIgnoreCase("MAX")) {
						boolean flag = true;
						for (int i = 0; i < txtMax.getText().length(); i++) {
							if ('0' > txtMax.getText().charAt(i) || txtMax.getText().charAt(i) > '9') {
								flag = false;
								break;
							}
						}
						if (flag == true) {
							priceMax = Double.parseDouble(txtMax.getText());
						} else {
							priceMax = 1000000000000000.0;
						}

					} else {
						priceMax = 1000000000000000.0;
					}

					if (!meterMin.getText().isEmpty() && meterMin.getText().length() != 0
							&& !meterMin.getText().equalsIgnoreCase("MIN")) {
						boolean flag = true;
						for (int i = 0; i < meterMin.getText().length(); i++) {
							if ('0' > meterMin.getText().charAt(i) || meterMin.getText().charAt(i) > '9') {
								flag = false;
								break;
							}
						}
						if (flag == true) {
							metreMinRange = Double.parseDouble(meterMin.getText());
						} else {
							metreMinRange = 0.0;
						}

					} else {
						metreMinRange = 0.0;
					}
					if (!meterMax.getText().isEmpty() && meterMax.getText().length() != 0
							&& !meterMax.getText().equalsIgnoreCase("MAX")) {
						boolean flag = true;
						for (int i = 0; i < meterMax.getText().length(); i++) {
							if ('0' > meterMax.getText().charAt(i) || meterMax.getText().charAt(i) > '9') {
								flag = false;
								break;
							}
						}
						if (flag == true) {
							metreMaxRange = Double.parseDouble(meterMax.getText());
						} else {
							metreMaxRange = 1000000000000000.0;
						}

					} else {
						metreMaxRange = 1000000000000000.0;
					}
					if (rdbtnUsd.isSelected() || rdbtnEur.isSelected()){
						priceMax = priceMax * 3.4;
						priceMin = priceMin * 3.4;
					}
					
					ArrayList<RealEstate> result = new ArrayList<RealEstate>();

					result = FileHandler.search(selectedCity, selectedTown, selectedDistrict, priceMin, priceMax, type,
							numberOfRoom, furnishedInt, forSaleInt, forRentInt, metreMinRange, metreMaxRange);
					for (int i = 0; i < result.size(); i++) {
						System.out.println(result.get(i));
					}
					// filter are shown
					afterSearchFilter(result);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// frame.setVisible(false);
				// new searchResultFrame().setVisible(true); // open search
				// result frame
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(16)
										.addComponent(meterMin, GroupLayout.PREFERRED_SIZE, 51,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(meterMax, GroupLayout.PREFERRED_SIZE, 51,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblNumberOfRoom,
										GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBox_6,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblFurnished,
										GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(6)
										.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addGap(16).addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(35).addComponent(btnSearch,
										GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBox_5,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBox,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBox_1,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBox_3,
										GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblPriceRange,
										GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(6).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnTl, GroupLayout.PREFERRED_SIZE, 61,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup().addGap(60).addComponent(rdbtnUsd,
												GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
										.addComponent(rdbtnEur, GroupLayout.PREFERRED_SIZE, 52,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(16)
										.addComponent(txtMin, GroupLayout.PREFERRED_SIZE, 51,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(txtMax, GroupLayout.PREFERRED_SIZE, 51,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(lblM,
										GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 138,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFor, GroupLayout.PREFERRED_SIZE, 114,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 138,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 114,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(logo, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 601,
												Short.MAX_VALUE)
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(
												groupLayout
														.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
																.createSequentialGroup().addComponent(lblNewLabel_1)
																.addGap(11)
																.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(24).addComponent(lblFor).addGap(9)
																.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(logo, GroupLayout.PREFERRED_SIZE, 123,
																GroupLayout.PREFERRED_SIZE))
												.addGap(8).addComponent(lblPeriod).addGap(11)
												.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(11).addComponent(lblNewLabel).addGap(11)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(11)
												.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(11)
												.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(11).addComponent(lblPriceRange).addGap(7)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbtnTl).addComponent(rdbtnUsd)
														.addComponent(rdbtnEur))
												.addGap(7)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtMin, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(txtMax, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(11).addComponent(lblM).addGap(11)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup().addGap(1)
																.addComponent(meterMin, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(meterMax, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(11).addComponent(lblNumberOfRoom).addGap(8)
												.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(11).addComponent(lblFurnished).addGap(7)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbtnYes).addComponent(rdbtnNo))
												.addGap(37).addComponent(btnSearch)))
										.addGap(54)));
		frame.getContentPane().setLayout(groupLayout);

		panel.setLayout(new GridLayout(0, 1));

		ArrayList<JLabel> temp = new ArrayList<JLabel>();
		if (FileHandler.readEstateFromFile().size() > 0) {
			for (int i = 0; i < FileHandler.readEstateFromFile().size(); i++) {

				ImageIcon imageIcon = new ImageIcon(FileHandler.readEstateFromFile().get(i).getPhoto());
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(220, 145, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);
				temp.add(new JLabel("JLabel " + i));
				temp.get(i).setIcon(imageIcon);
				temp.get(i).setText(FileHandler.readEstateFromFile().get(i).toString());
				panel.add(temp.get(i));
				panel.add(temp.get(i));

			}
		}
	}

	public void afterPostAdd() throws FileNotFoundException, IOException {
		// System.out.println(realEstate.toString());
		ArrayList<JLabel> temp = new ArrayList<JLabel>();
		panel.removeAll();
		if (FileHandler.readEstateFromFile().size() > 0) {
			for (int i = 0; i < FileHandler.readEstateFromFile().size(); i++) {

				ImageIcon imageIcon = new ImageIcon(FileHandler.readEstateFromFile().get(i).getPhoto());
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(220, 145, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);
				temp.add(new JLabel("JLabel " + i));
				temp.get(i).setIcon(imageIcon);
				temp.get(i).setText(FileHandler.readEstateFromFile().get(i).toString());
				panel.add(temp.get(i));

			}
		}
		panel.revalidate();
		panel.repaint();

	}

	public void afterSearchFilter(ArrayList<RealEstate> realEstates) throws FileNotFoundException, IOException {
		// System.out.println(realEstate.toString());
		ArrayList<JLabel> temp = new ArrayList<JLabel>();
		panel.removeAll();
		System.out.println("Real Estates Result : " + realEstates.size());
		if (realEstates.size() > 0) {
			for (int i = 0; i < realEstates.size(); i++) {

				ImageIcon imageIcon = new ImageIcon(FileHandler.readEstateFromFile().get(i).getPhoto());
				Image image = imageIcon.getImage();
				Image newimg = image.getScaledInstance(220, 145, java.awt.Image.SCALE_SMOOTH);
				imageIcon = new ImageIcon(newimg);
				temp.add(new JLabel("JLabel " + i));
				temp.get(i).setIcon(imageIcon);
				temp.get(i).setText(realEstates.get(i).toString());
				panel.add(temp.get(i));
				// panel.add(temp.get(i));

			}
		} else {
			temp.add(new JLabel("JLabel " + 0));
			temp.get(0).setText("No Resul Found");
			panel.add(temp.get(0));
			// panel.add(temp.get(0));
		}
		panel.revalidate();
		panel.repaint();

	}

	private void searchCriteriaFilterAndShow() {

	}

}
