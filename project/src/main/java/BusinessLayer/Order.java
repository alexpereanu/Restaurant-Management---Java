package BusinessLayer;

import java.io.Serializable;

public class Order implements Serializable{

	private int OrderID;
	private int ora;
	private int minutul;
	private int masa;
	//private int pret;
	
	public Order(int orderID, int ora, int minutul, int masa) {
		super();
		this.OrderID = orderID;
		this.ora = ora;
		this.minutul = minutul;
		this.masa = masa;
	}
	
	public Order() {
		
	}
	
	
	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getOra() {
		return ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public int getMinutul() {
		return minutul;
	}

	public void setMinutul(int minutul) {
		this.minutul = minutul;
	}

	public int getMasa() {
		return masa;
	}

	public void setMasa(int masa) {
		this.masa = masa;
	}

	public int hashCode() {
		return (this.OrderID + this.masa) % 100;
	}
	
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (this.OrderID != other.OrderID)
			return false;

		
		return true;
	}

}