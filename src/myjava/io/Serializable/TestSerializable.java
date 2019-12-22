package myjava.io.Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class TestSerializable {
	public static void serialize(String fileNamePath) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileNamePath));
			oos.writeObject("ph1");
			oos.writeObject(new Date());
			User u = new User("neo", 20);
			oos.writeObject(u);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deSerialize(String fileNamePath) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileNamePath));
			String name = (String) ois.readObject();
			Date d = (Date) ois.readObject();
			User u = (User) ois.readObject();
			System.err.println(name);
			System.err.println(d);
			System.err.println(u.toString());
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String fileNamePath = "D:\\io\\Serializable\\myfile.txt";
		System.err.println("start Serializable");
		serialize(fileNamePath);
		System.err.println("serialize Already");
		deSerialize(fileNamePath);
		System.err.println("deSerialize Already");
	}
}
