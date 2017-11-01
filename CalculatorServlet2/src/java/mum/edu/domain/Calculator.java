package mum.edu.domain;

import java.io.Serializable;

public class Calculator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String add1;
	private String add2;
	private String mult1;
	private String mult2;
	private Float sum;
	private Float product;

	public Calculator(String add1, String add2, String mult1, String mult2) {
		this.add1 = add1;
		this.add2 = add2;
		this.mult1 = mult1;
		this.mult2 = mult2;
	}
	
	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getMult1() {
		return mult1;
	}

	public void setMult1(String mult1) {
		this.mult1 = mult1;
	}

	public String getMult2() {
		return mult2;
	}

	public void setMult2(String mult2) {
		this.mult2 = mult2;
	}

	public Float getSum() {
		return sum;
	}

	public Float getProduct() {
		return product;
	}

	public void add() {
		sum = Float.parseFloat(add1) + Float.parseFloat(add2);
	}

	public void mult() {
		product = Float.parseFloat(mult1) * Float.parseFloat(mult2);
	}

}
