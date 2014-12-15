import java.util.*;
import java.text.*;

public class HelloWorld {
	public static void main(String[] args){
		Dog dog=new Dog("gogo",5);
		Dog dog2=new Dog("jiji",6);
		
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date date=new Date();
		System.out.println(ft.format(date));
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		
		GregorianCalendar gc=new GregorianCalendar();
		System.out.println(gc.get(Calendar.YEAR));
			
	}
}
