package Main;

import java.util.ArrayList;

import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;
import PresentationLayer.MainInterface;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        
    	Restaurant restaurant = new Restaurant();
    	RestaurantSerializator serializator = new RestaurantSerializator();
    	restaurant = serializator.deserializare();
    	MainInterface mainI = new MainInterface();
    	mainI.initMainFrame(serializator, restaurant);

    	//MainInterface main2I = new MainInterface();
    	//main2I.initMainFrame(serializator, restaurant);
    }
}
