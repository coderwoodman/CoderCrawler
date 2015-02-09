package Util.coderwood.com;

public class MyTest {
	public static String testString(int count) {
		String result = "";

		for (int i = 0; i < count; i++) {
			result += "hello ";
		}

		return result;
	}

	public static String testStringBuilder(int count) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < count; i++) {
			sb.append("hello");
		}

		return sb.toString();
	}
}
