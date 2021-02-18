package PresentationLayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLayer.*;
import BusinessLayer.MenuItem;
import DataLayer.RestaurantSerializator;


public class AdministratorGraphicalUserInterface extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frameAdministrator;
	public JPanel panelAdministrator;
	JButton addNewMenuItem;
	public JButton editMenuItem, deleteMenuItem, viewMenuItems, backBut;

	public DefaultTableModel model;
	public JTable jTable = new JTable();
	//RestaurantSerializator serializator = new RestaurantSerializator();
	//Restaurant t = serializator.deserializare();
	//Restaurant t = new Restaurant();
	public IRestaurantProcessing restaurant;

	public void initAdministratorInterface(RestaurantSerializator serializator, Restaurant re) {

		final JFrame frameAdministrator = new JFrame("Administrator Interface");
		JPanel panelAdministrator = new JPanel();
		frameAdministrator.setVisible(true);
		frameAdministrator.setSize(500, 400);
		panelAdministrator.setLayout(null);
		frameAdministrator.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelAdministrator.setSize(499, 399);
		frameAdministrator.add(panelAdministrator);

		//aici adaug restaurantul

		this.restaurant = re;

		addNewMenuItem = new JButton("Add New Menu Item");
		panelAdministrator.add(addNewMenuItem);
		addNewMenuItem.setBounds(40, 70, 200, 50);
		addNewMenuItem.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		editMenuItem = new JButton("Edit Menu Item");
		panelAdministrator.add(editMenuItem);
		editMenuItem.setBounds(290, 70, 150, 50);
		editMenuItem.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		deleteMenuItem = new JButton("Delete Menu Item");
		panelAdministrator.add(deleteMenuItem);
		deleteMenuItem.setBounds(40, 160, 200, 50);
		deleteMenuItem.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		viewMenuItems = new JButton("View Menu Items");
		panelAdministrator.add(viewMenuItems);
		viewMenuItems.setBounds(40, 250, 200, 50);
		viewMenuItems.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		backBut = new JButton("BACK");
		panelAdministrator.add(backBut);
		backBut.setBounds(290, 160, 150, 140);
		backBut.setFont(new Font("TimesRoman", Font.PLAIN, 17));

		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameAdministrator.setVisible(false);
				MainInterface t = new MainInterface();
				t.initMainFrame(serializator, re);
			}
		});

		addNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameAdministrator.setVisible(false);

				final JFrame addItem = new JFrame("Add New Menu Item");
				JPanel addPanel = new JPanel();
				addPanel.setLayout(null);
				addItem.add(addPanel);
				addItem.setSize(500, 400);
				addItem.setVisible(true);
				addItem.setDefaultCloseOperation(EXIT_ON_CLOSE);

				JButton back = new JButton("BACK");
				addPanel.add(back);
				back.setBounds(400, 260, 70, 50);

				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addItem.setVisible(false);
						frameAdministrator.setVisible(true);
					}
				});

				JLabel labelText = new JLabel("INSERT A NEW MENU ITEM");
				addPanel.add(labelText);
				labelText.setBounds(90,30,230,30);
				labelText.setFont(new Font("TimesRoman", Font.BOLD,16));

				JComboBox<String> selectItem = new JComboBox<String>();
				selectItem.addItem("SELECT");
				selectItem.addItem("Base Product");
				selectItem.addItem("Composite Product");
				addPanel.add(selectItem);
				selectItem.setBounds(310,33,120,25);

				selectItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String s = (String)selectItem.getSelectedItem();

						switch (s){

							case "SELECT":{
							break;

							}
							case "Base Product":{
								JLabel composite1 = new JLabel("Nume produs");
								addPanel.add(composite1);
								composite1.setBounds(60,90,150,30);
								composite1.setFont(new Font("TimesRoman", Font.BOLD,14));

								JTextField textComposite1 = new JTextField();
								addPanel.add(textComposite1);
								textComposite1.setBounds(160,97,70,20);

								JLabel composite2 = new JLabel("Cantitate");
								addPanel.add(composite2);
								composite2.setBounds(60,140,150,30);
								composite2.setFont(new Font("TimesRoman", Font.BOLD,14));

								JTextField textComposite2 = new JTextField();
								addPanel.add(textComposite2);
								textComposite2.setBounds(160,147,70,20);

								JLabel composite3 = new JLabel("Pret");
								addPanel.add(composite3);
								composite3.setBounds(60,190,150,30);
								composite3.setFont(new Font("TimesRoman", Font.BOLD,14));

								JTextField textComposite3 = new JTextField();
								addPanel.add(textComposite3);
								textComposite3.setBounds(160,197,70,20);

								JButton addBaseProduct = new JButton("SUBMIT");
								addPanel.add(addBaseProduct);
								addBaseProduct.setBounds(155,247,80,20);

								addBaseProduct.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										String nume = textComposite1.getText();
										int cantitate = Integer.parseInt(textComposite2.getText());
										int pret = Integer.parseInt(textComposite3.getText());
										BaseProduct base = new BaseProduct(nume,cantitate,pret);
										restaurant.createNewMenu(base);
										serializator.serializare(re);

										textComposite1.setText(null);
										textComposite2.setText(null);
										textComposite3.setText(null);

									}
								});


								break;
							}

							case "Composite Product":{
								JLabel composite1 = new JLabel("Introduceti numarul de produse din compozitie:");
								addPanel.add(composite1);
								composite1.setBounds(30,70,350,30);
								composite1.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE,15));

								JTextField nrProduse = new JTextField();
								addPanel.add(nrProduse);
								nrProduse.setBounds(355,75,50,20);

								JButton okProduse = new JButton("OK");
								addPanel.add(okProduse);
								okProduse.setBounds(400,75,80,20);

								okProduse.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {

										int nr = Integer.parseInt(nrProduse.getText());

										switch (nr){
											case 1:{
												JLabel composite = new JLabel("PRODUS:");
												addPanel.add(composite);
												composite.setBounds(80,100,100,30);
												composite.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE,14));

												JTextField nrP = new JTextField();
												addPanel.add(nrP);
												nrP.setBounds(160,107,70,20);

												JButton ok1 = new JButton("INSERT");
												addPanel.add(ok1);
												ok1.setBounds(240,107,80,20);

												ok1.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														String nume = nrP.getText();
														CompositeProduct cc = new CompositeProduct(nume,1,1);
														re.createNewMenu(cc);
														JOptionPane.showMessageDialog(null, "Composite Product-ul va fi inserat !");
														serializator.serializare(re);
														/*for(MenuItem x : re.items){
															if(x instanceof BaseProduct){
																if(((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(nume)){
																	JOptionPane.showMessageDialog(null, "Meniul Composite s-a efectuat !");
																	re.createNewMenu(new CompositeProduct(nume,1,1));
																	return;
																}
															}

															if(x instanceof CompositeProduct){
																if(((CompositeProduct) x).getNume().equalsIgnoreCase(nume)){
																	JOptionPane.showMessageDialog(null, "Meniul Composite s-a efectuat !");
																	re.createNewMenu(new CompositeProduct(nume,1,1));
																	return;
																}
															}
														}*/
														//JOptionPane.showMessageDialog(null, "Composite Product-ul nu exista in meniul nostru !");
														//return;
													}
												});

												break;
											}

											case 2:{
												JLabel composite2 = new JLabel("PRODUS1:");
												addPanel.add(composite2);
												composite2.setBounds(80,100,100,30);
												composite2.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE,14));

												JTextField numeProdus1 = new JTextField();
												addPanel.add(numeProdus1);
												numeProdus1.setBounds(160,107,70,20);

												JLabel composite3 = new JLabel("PRODUS2:");
												addPanel.add(composite3);
												composite3.setBounds(80,160,100,30);
												composite3.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE,14));

												JTextField numeProdus2 = new JTextField();
												addPanel.add(numeProdus2);
												numeProdus2.setBounds(160,167,70,20);

												JButton okComposite = new JButton("INSERT");
												addPanel.add(okComposite);
												okComposite.setBounds(240,140,100,20);

												okComposite.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent arg0) {
														String nume1 = numeProdus1.getText();
														String nume2 = numeProdus2.getText();
														int xs = 0;


														for(MenuItem x:re.items){
															if(x instanceof BaseProduct){
																if(((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(nume1)){
																	//JOptionPane.showMessageDialog(null, "Produsul " + nume1 + " se afla in meniu");
																	xs++;
																	break;
																}
															}
															else
																if(x instanceof CompositeProduct){
																	if(((CompositeProduct) x).getNume().equalsIgnoreCase(nume1)){
																		//JOptionPane.showMessageDialog(null, "Produsul " + nume1 + " se afla in meniu");
																		xs++;
																		break;
																	}
																}
														}
														if(xs == 0){
															JOptionPane.showMessageDialog(null, "Produsul " + nume1 + " nu se afla in meniu");
															return;
														}


														int feri=0;
														for(MenuItem x:re.items){
															if(x instanceof BaseProduct){
																if(((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(nume2)){
																	//JOptionPane.showMessageDialog(null, "Produsul " + nume2 + " se afla in meniu");
																	feri++;
																	break;
																}
															}
															else
															if(x instanceof CompositeProduct){
																if(((CompositeProduct) x).getNume().equalsIgnoreCase(nume2)){
																	//JOptionPane.showMessageDialog(null, "Produsul " + nume2 + " se afla in meniu");
																	feri++;
																	break;
																}
															}
														}
														if(feri == 0){
															JOptionPane.showMessageDialog(null, "Produsul " + nume2 + " nu se afla in meniu");
															return;
														}

														BaseProduct b1 = new BaseProduct(nume1,1,1);
														BaseProduct b2 = new BaseProduct(nume2,1,1);
														ArrayList<MenuItem> produse = new ArrayList<MenuItem>();
														produse.add(b1);
														produse.add(b2);
														String s = nume1+"+"+nume2;
														CompositeProduct c = new CompositeProduct(s,1,1,produse);
														re.createNewMenu(c);
														serializator.serializare(re);


													}
												});



												break;

											}
										}
									}
								});


								}
								break;
							}
						}
				});



			}
			
		});

		editMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFrame addItem = new JFrame("Edit Menu Item");
				JPanel addPanel = new JPanel();
				addPanel.setLayout(null);
				addItem.add(addPanel);
				addItem.setSize(500, 400);
				addItem.setVisible(true);
				addItem.setDefaultCloseOperation(EXIT_ON_CLOSE);

				JLabel label1 = new JLabel("Menu Item:");
				//JLabel label2 = new JLabel("Composite product: ");

				final JTextField t10 = new JTextField();
				final JTextField t20 = new JTextField();
				final JTextField t30 = new JTextField();

				JLabel label3 = new JLabel("Nume");

				label1.setBounds(45, 132, 100, 50);
				addPanel.add(label1);
				label1.setFont(new Font("TimesRoman", Font.PLAIN, 17));

				label3.setBounds(160, 100, 50, 50);
				addPanel.add(label3);
				label3.setFont(new Font("TimesRoman", Font.PLAIN, 16));

				t10.setBounds(140, 150, 80, 20);
				addPanel.add(t10);

				JLabel label4 = new JLabel("Cantitate");

				label4.setBounds(250, 100, 100, 50);
				addPanel.add(label4);
				label4.setFont(new Font("TimesRoman", Font.PLAIN, 16));

				t20.setBounds(257, 150, 50, 20);
				addPanel.add(t20);

				JLabel label5 = new JLabel("Pret");

				label5.setBounds(343, 100, 100, 50);
				addPanel.add(label5);
				label5.setFont(new Font("TimesRoman", Font.PLAIN, 16));

				t30.setBounds(335, 150, 50, 20);
				addPanel.add(t30);

				JButton baseProd = new JButton("EDIT");
				addPanel.add(baseProd);
				baseProd.setBounds(400, 140, 65, 40);

				//addPanel.add(label2);
				//label2.setBounds(1, 160, 140, 50);
				//label2.setFont(new Font("TimesRoman", Font.PLAIN, 15));

				JTextField t4 = new JTextField();
				JTextField t5 = new JTextField();
				JTextField t6 = new JTextField();

				//addPanel.add(t4);
				//addPanel.add(t5);
				//addPanel.add(t6);

				t4.setBounds(140, 176, 80, 20);
				t5.setBounds(257, 176, 50, 20);
				t6.setBounds(335, 176, 50, 20);

				JButton compositeProd = new JButton("EDIT");
				//addPanel.add(compositeProd);
				compositeProd.setBounds(400, 165, 65, 40);

				JButton back = new JButton("BACK");
				addPanel.add(back);
				back.setBounds(400, 260, 70, 50);

				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addItem.setVisible(false);
						frameAdministrator.setVisible(true);
					}
				});
				
				baseProd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addItem.setVisible(false);
						frameAdministrator.setVisible(true);
						String nume = t10.getText();
						int cant = Integer.parseInt(t20.getText());
						int pret = Integer.parseInt(t30.getText());
						//t.editMenuItem(nume,cant,pret);
						restaurant.editMenuItem(nume,cant,pret);
						serializator.serializare(re);
						
					}
				});

			}
		});
		deleteMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frameAdministrator.setVisible(false);
				final JFrame deleteItem = new JFrame("Delete Menu Item");
				JPanel deletePanel = new JPanel();
				deletePanel.setLayout(null);
				deleteItem.add(deletePanel);
				deleteItem.setSize(500, 400);
				deleteItem.setVisible(true);
				deleteItem.setDefaultCloseOperation(EXIT_ON_CLOSE);

				JLabel l1 = new JLabel("Numele meniului de sters:");
				deletePanel.add(l1);
				l1.setBounds(20, 80, 270, 50);
				l1.setFont(new Font("TimesRoman", Font.PLAIN, 15));

				final JTextField t1 = new JTextField();
				deletePanel.add(t1);
				t1.setBounds(240, 93, 100, 25);

				JButton deleteBaseProduct = new JButton("Delete Base Product");
				deletePanel.add(deleteBaseProduct);
				deleteBaseProduct.setBounds(50, 130, 150, 30);

				JLabel l2 = new JLabel("Numele meniului composite product de sters:");
				//deletePanel.add(l2);
				l2.setBounds(20, 200, 300, 50);
				l2.setFont(new Font("TimesRoman", Font.PLAIN, 15));

				final JTextField t2 = new JTextField();
				//deletePanel.add(t2);
				t2.setBounds(318, 213, 100, 25);

				JButton deleteCompositeProduct = new JButton("Delete Composite Product");
				//deletePanel.add(deleteCompositeProduct);
				deleteCompositeProduct.setBounds(50, 250, 190, 30);

				JButton back = new JButton("BACK");
				deletePanel.add(back);
				back.setBounds(400, 260, 70, 50);

				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						deleteItem.setVisible(false);
						frameAdministrator.setVisible(true);
					}
				});

				deleteBaseProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nume = t1.getText();
						re.deleteMenuItem(nume);
						frameAdministrator.setVisible(true);
						deleteItem.setVisible(false);
						//serializator.serializare(t);
						serializator.serializare(re);


					}
				});

				deleteCompositeProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nume = t2.getText();
						//t.deleteMenuItem(nume);
						frameAdministrator.setVisible(true);
						deleteItem.setVisible(false);
						//serializator.serializare(t);
						serializator.serializare(re);

					}
				});
			}
		});

		viewMenuItems.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//frameAdministrator.setVisible(false);
				Tabela ta = new Tabela();
				System.out.println(re.items);
				//restaurant = serializator.deserializare();
				String[][] result = ta.retrieveProperties(re.items);
				ta.tableItems(result);
					
			}

		});
	}

	public void actionPerformed(ActionEvent e) {

	}

}