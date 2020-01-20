package scjp;

class Doubler {
	public static int doubleMe(Holder h) {
		return h.getAmount()*2;
	}
}

class  Holder {
	int amont = 10;
	public void doubleAmont() {
		amont = Doubler.doubleMe(this);
	}
	public int getAmount() {
		return this.amont;
	}
}

// 减小耦合,传参时不采用对象的方式
public class TestCoubling {
	public static void main(String[] args) {
		Holder h = new Holder();
		h.doubleAmont();
	}
}
