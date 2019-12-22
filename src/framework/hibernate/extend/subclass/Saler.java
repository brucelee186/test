
package framework.hibernate.extend.subclass;

public class Saler extends Employee {
	private int saleAmount;

	public int getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(int saleAmount) {
		this.saleAmount = saleAmount;
	}
	
}
