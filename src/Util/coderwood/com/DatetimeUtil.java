package Util.coderwood.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {
	
	//��ӡ��ǰʱ��
	public static void printDatetimeNow() {
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		Date date = new Date();
		System.out.println(format2.format(date.getTime()));
	}

}
