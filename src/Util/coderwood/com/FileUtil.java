package Util.coderwood.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class FileUtil {

	//�����ļ�·�����ļ����ݴ����ļ�
	public static void createFile(String filePath, String source) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);

			byte[] b = source.getBytes();
			fos.write(b);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//�����ļ�·�����ļ���С��ȡ�ļ�
	public static String readFile(String filePath, int length) {
		String result = "";
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filePath);
			byte[] data = new byte[length];
			int i = fis.read(data);

			result = new String(data, 0, i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
