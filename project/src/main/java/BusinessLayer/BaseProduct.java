package BusinessLayer;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeBaseProduct;
	private int cantitateBaseProduct;
	private int pretBaseProduct;
	
	public BaseProduct(String numeBaseProduct, int cantitateBaseProduct, int pretBaseProduct) {
		//super();
		this.numeBaseProduct = numeBaseProduct;
		this.cantitateBaseProduct = cantitateBaseProduct;
		this.pretBaseProduct = pretBaseProduct;
	}


	public String getNumeBaseProduct() {
		return numeBaseProduct;
	}


	public void setNumeBaseProduct(String numeBaseProduct) {
		this.numeBaseProduct = numeBaseProduct;
	}


	public int getCantitateBaseProduct() {
		return cantitateBaseProduct;
	}


	public void setCantitateBaseProduct(int cantitateBaseProduct) {
		this.cantitateBaseProduct = cantitateBaseProduct;
	}


	public int getPretBaseProduct() {
		return pretBaseProduct;
	}


	public void setPretBaseProduct(int pretBaseProduct) {
		this.pretBaseProduct = pretBaseProduct;
	}


	@Override
	public int computePrice() {
		return this.getPretBaseProduct() * this.getCantitateBaseProduct();
	}

}
