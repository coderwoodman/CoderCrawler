

public class HelloWorld {
	public static void main(String[] args){
		try {
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	static void swap(int num1,int num2){
		
		int tmp;
		
		tmp=num1;
		num1=num2;
		num2=tmp;
		
	}
	
	static void printGrade(int score){
		String grade="";
		
		if(score>80)
			grade="A";
		else if(score>60)
			grade="B";
		else
			grade="C";
		
		System.out.println(grade);
	}
}
