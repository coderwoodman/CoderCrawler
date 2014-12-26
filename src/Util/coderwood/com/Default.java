package Util.coderwood.com;

import java.io.*;
import java.util.*;

public class Default {
	public static void main(String[] args) {
		try {
			List<Vendor> vendors = GetVendors();
			System.out.println(vendors.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static List<Vendor> GetVendors() {
		FileInputStream fis = null;
		List<Vendor> vendors=null;
		try {
			fis = new FileInputStream("d:\\file\\vendor.csv");
			byte[] data = new byte[16000000];
			int i = fis.read(data);

			String s = new String(data, 0, i);
			String[] vs = s.split("\r\n");

			vendors = new ArrayList<Vendor>();
			for (String s2 : vs) {
				String[] tmp = s2.split(",");
				Vendor v = null;
				v = new Vendor(Integer.parseInt(tmp[0]), tmp[1]);
				vendors.add(v);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vendors;
	}
}
