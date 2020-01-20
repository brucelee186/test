package 设计模式.五原型模式_Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializableObject implements Serializable {
	private static final long serialVersionUID = 1L;
} 

public class PrototypeClone implements Cloneable, Serializable {
	
	private static final long serialVersionUID = -2566362561071165852L;
	
	private String string;
	
	private SerializableObject obj; 
	
	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	/**
	 * 原型模式就是对象复制模式,对象复制分为两种,浅复制(基本属性完全复制,引用属性不复制), 深复制(基本属性,引用属性都完全复制成另外一个副本)
	 * 浅复制
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		PrototypeClone prototypeClone = (PrototypeClone) super.clone();
		return prototypeClone;
	}
	
	protected Object deepClone(Object object) {
		try {
			ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
			objectOutputStream.writeObject(this);
			
			ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
			ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
			object = objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
}
