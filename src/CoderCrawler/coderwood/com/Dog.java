package CoderCrawler.coderwood.com;

public class Dog extends Animal implements IEatable,IKilled {
	
	String color;
	public final float weight =9;
	
	public Dog(){
	
	}
	
	public Dog(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	void printDog(){
		System.out.println("Name: "+this.name);
		System.out.println("Age: "+this.age);
		System.out.println("");
	}
	
	public void barking(){
		System.out.println("wo~wo~");
	}
	
	void sleeping(){
		
	}
	
	public  void printWeight(){
		System.out.println(this.weight);
	}
	
	public void killed(){
		System.out.println(this.name+" is killed");
	}
}
