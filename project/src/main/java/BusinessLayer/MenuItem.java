package BusinessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {

	
	public MenuItem() {
		
	}


	public abstract int computePrice();
		
	
}
