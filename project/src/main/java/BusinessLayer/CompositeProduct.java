package BusinessLayer;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class CompositeProduct extends MenuItem implements Serializable {

	private String nume;
	private int cantitate;
	private int pret;
	private ArrayList<MenuItem> items;
	
	public CompositeProduct(String name,int cant,int pret) {
		this.nume = name;
		this.cantitate = cant;
		this.pret = pret;
		items = new ArrayList<MenuItem>();
		//CompositeProduct c = new CompositeProduct(name,cant,pret);
		//items.add(c);
	}

	public CompositeProduct(String name, int cant, int pret, ArrayList<MenuItem> x) {
		this.nume = name;
		this.cantitate = cant;
		this.pret = pret;
		this.items = new ArrayList<MenuItem>();
		items = x;
	}
	
	
	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public int getCantitate() {
		return cantitate;
	}


	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}


	public int getPret() {
		return pret;
	}


	public void setPret(int pret) {
		this.pret = pret;
	}


	public ArrayList<MenuItem> getItems() {
		return items;
	}


	public void setItems(ArrayList<MenuItem> items) {
		this.items = items;
	}


	@Override
	public int computePrice() {
		int suma = 0;
		if(this.items.size() == 0){
			suma += this.getCantitate() * this.getPret();
			return suma;
		}
		else {
			for (MenuItem x : items) {
				if (x instanceof BaseProduct) {
					suma += x.computePrice();
				} else
					suma += this.getCantitate() * this.getPret();
			}

		}
		return suma;
	}

}
