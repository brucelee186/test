package invocation;


public class GetClass {

 /**
  * @param args
  */
 public static void main(String[] args) {
//   Person p =new Person();
//   System.out.println(p.getClass());
//   Person p1 = new Person(18);
//  GetClass a = new GetClass();
//  a.createObject();
	 //Collection c=new ArrayList(); 
//	 Class clazz=c.getClass(); 
//	 List ll=c.getMethod("sublist",int.class,int.class).invoke(c,0,0); 
 }

 class Person {
  int age;

  public Person() {
   System.out.println("����һ��Person����");
  }

  public Person(int age) {
   this.age = age;
  }
 }

 public void createObject() {
  Person p = new Person(18);
  System.out.println("Person��class����   =     "+p.getClass());
 }
}

