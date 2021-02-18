package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;

public interface IRestaurantProcessing {

	public void createNewMenu(MenuItem item);
	
	public void deleteMenuItem(String item);
	
	public void editMenuItem(String item, int cantitate, int pret);
	
	public void createNewOrder(Order comanda, ArrayList<MenuItem> produse);
	
	public void deleteOrder(Order order);
	
	public void editOrder(Order order);
	
}
