package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Restaurant implements IRestaurantProcessing,Serializable {

	public HashMap<Order, ArrayList<MenuItem>> table;
	public ArrayList<Order> orders;
	public ArrayList<MenuItem> items;

	// RestaurantSerializator serial = new RestaurantSerializator();

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public HashMap<Order, ArrayList<MenuItem>> getTable() {
		return table;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public Restaurant() {

		this.table = new HashMap<Order, ArrayList<MenuItem>>();
		this.orders = new ArrayList<Order>();
		this.items = new ArrayList<MenuItem>();
	}
	
	public Restaurant(int a) {
		
	}

	public boolean isWellFormed() {
		assert !table.isEmpty();
		boolean result = false;
		int size = table.size();

		int contor = 1;

		for (Order x : this.table.keySet()) {
			if (x.getOrderID() != contor)
				return result;
			contor++;
		}

		if (contor == size)
			return true;

		return result;
	}

	public void createNewMenu(MenuItem item) {

		assert item != null;
		System.out.println(item.toString());
		int alex = items.size();
		try {

			items.add(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (alex + 1 == items.size()) {
			JOptionPane.showMessageDialog(null, "SUCCES ! ");
		} else {
			JOptionPane.showMessageDialog(null, "FAIL ! ");
		}
		assert alex+1 == items.size();
	}

	public void deleteMenuItem(String item) {

		assert item != null;
		int alex = items.size();
		assert items != null;

		int res = 0;
		for (MenuItem x : items) {
			if (x instanceof BaseProduct) {
				if (((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(item)) {
					items.remove(x);
					res++;
					JOptionPane.showMessageDialog(null, "SUCCESFUL DELETE ! ");
					return;
				}
			} else {
				if (x instanceof CompositeProduct) {
					if (((CompositeProduct) x).getNume().equalsIgnoreCase(item)) {
						items.remove(x);
						res++;
						JOptionPane.showMessageDialog(null, "SUCCESFUL DELETE ! ");
						return;
					}
				}
			}
		}
			assert alex - 1 == items.size();
			if (res == 0) {
				JOptionPane.showMessageDialog(null, "THIS MENU ITEM ISN'T IN OUR LIST !");
			}



	}

	public void editMenuItem(String item, int cantitate, int pret) {
		assert item != "";
		int res = 0;
		for (MenuItem x : items) {
			if (x instanceof BaseProduct) {
				if (((BaseProduct) x).getNumeBaseProduct().equalsIgnoreCase(item)) {
					int alu = items.indexOf(x);
					items.set(alu, new BaseProduct(item, cantitate, pret));
					res++;
					JOptionPane.showMessageDialog(null, "SUCCESFUL UPDATE BASE PRODUCT! ");
				}
			} else {
				if (x instanceof CompositeProduct) {
					if (((CompositeProduct) x).getNume().equalsIgnoreCase(item)) {
						int balu = items.indexOf(x);
						items.set(balu, new CompositeProduct(item, cantitate, pret));
						res++;
						JOptionPane.showMessageDialog(null, "SUCCESFUL UPDATE COMPOSITE PRODUCT! ");
					}
				}
			}

		}
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "THIS PRODUCT ISN'T IN OUR BASE");
		}

	}

	public void createNewOrder(Order comanda, ArrayList<MenuItem> produse) {

		assert table != null;
		assert comanda != null;
		assert produse != null;
		int size = table.size();
		try {
			System.out.println(this.table);
			table.put(comanda, produse);
			orders.add(comanda);
		} catch (Exception e) {
			System.out.println("Eroare la inserarea unei noi comenzi ! " + e);
		}

		int size2 = table.size();
		assert size == size2 + 1;

	}

	public void deleteOrder(Order order) {
		assert table != null;
		assert order != null;
		int size = table.size();
		boolean x = false;
		try {
			x = findOrderById(order.getOrderID());
			if (x == true) {
				table.remove(order);
			} else
				JOptionPane.showMessageDialog(null, "Comanda nu exista ! ");

		} catch (Exception e) {
			System.out.println("Nu pot executa stergerea comenzii");
		}

		int sizeFinal = table.size() - 1;
		assert size == sizeFinal - 1;

	}

	public void editOrder(Order order) {
		assert table != null;

	}

	public boolean findOrderById(int id) {
		assert id != 0;
		boolean result = false;
		for (Order x : this.table.keySet()) {
			if (x.getOrderID() == id) {
				result = true;

			}

		}
		return result;
	}

	public void afisareOrder() {

		assert orders != null;
		try {
			for (Order x : this.orders) {
				System.out.println(x.getOrderID() + " " + x.getMasa() + " " + x.getMinutul() + " " + x.getOra());
			}
		} catch (Exception e) {
			System.out.println("Aici e problema ! ");
		}

	}

	

}