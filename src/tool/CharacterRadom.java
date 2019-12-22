package tool;

public class CharacterRadom {
	public static String getCharacterRadom() {
		char c = '0';
		double d = Math.random()*1000;
		int i = (int)d;
		//c = (char)i1;
		String character = Character.getName(i);
		System.err.println(character);
		//return Character.getName((int)Math.random()*100);
		return character;
	}
	public static void main(String[] args) {
		getCharacterRadom();
	}
}
