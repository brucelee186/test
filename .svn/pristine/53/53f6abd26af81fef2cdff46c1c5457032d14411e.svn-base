package flowcontrol;

public class Label {
	public static void main(String[] args) {
		a:
			for (int i = 0; i < 10; i++) {
				System.err.println("i = " + i);
				for (int j = 0; j < 10; j++) {
					System.err.println("j = " + j);
					//break a;
				}
			}
		label2:
			System.err.println("label2");
		label3:
			for (int i = 0; i < 10; i++) {
				System.err.println("i = " + i);
				for (int j = 0; j < 10; j++) {
					System.err.println("j = " + j);
					//continue label3;
				}
			}
		}

}
