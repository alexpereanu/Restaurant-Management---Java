package DataLayer;

import java.awt.MenuItem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import BusinessLayer.Order;
import BusinessLayer.Restaurant;


public class RestaurantSerializator {

	public RestaurantSerializator() {

	}

	public void serializare(Restaurant re) {
		try {
			FileOutputStream file = new FileOutputStream("restaurant.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(re);
			out.close();
			file.close();
			System.out.println("am serializat");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Restaurant deserializare() {
		Restaurant res = null;
		
		try {
			FileInputStream file = new FileInputStream("restaurant.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			
			res = (Restaurant)in.readObject();
			System.out.println("Am deserializat");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	
}