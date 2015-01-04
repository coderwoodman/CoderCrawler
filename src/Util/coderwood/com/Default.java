package Util.coderwood.com;

import java.text.*;
import java.util.*;

public class Default {
	static DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	static DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

	public static void main(String[] args) {
		try {
			
			Date date=null;
			date=new Date();
			String s=format2.format(date.getTime());
			System.out.println(s);

			List<Vendor> vendors = getVendors();
			System.out.println(vendors.size());
			
			date=new Date();
			s=format2.format(date.getTime());
			System.out.println(s);

			// String dateString="2014-01-21 23:30:54";
			// DateFormat format= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// Date dateTmp = format.parse(dateString);
			// System.out.println(format.format(dateTmp));

			List<VendorReleation> vendorReleations = getVendorReleations();
			System.out.println(vendorReleations.size());
			
			date=new Date();
			s=format2.format(date.getTime());
			System.out.println(s);

			List<Vendor> usefulVendors = getUsefulVendors(vendors,
					vendorReleations);
			System.out.println(usefulVendors.size());
			
			date=new Date();
			s=format2.format(date.getTime());
			System.out.println(s);

			String source = getStringFromUsefulVendors(usefulVendors);
			date=new Date();
			s=format2.format(date.getTime());
			System.out.println(s);

			FileUtil.createFile("d:\\file\\usefulvendor.txt", source);
			System.out.println("good");
			date=new Date();
			s=format2.format(date.getTime());
			System.out.println(s);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String getStringFromUsefulVendors(List<Vendor> usefulVendors) {
		String source = "";
		StringBuilder sb=new StringBuilder();

		for (Vendor v : usefulVendors) {
			try {
				sb.append(v.id + "\t" + v.name + "\t" + v.loginName + "\r\n");
				//source += v.id + "\t" + v.name + "\t" + v.loginName + "\r\n";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		source=sb.toString();

		return source;
	}

	private static List<Vendor> getUsefulVendors(List<Vendor> vendors,
			List<VendorReleation> vendorReleations) {
		List<Vendor> usefulVendors = new ArrayList<Vendor>();

		for (Vendor v : vendors) {
			Boolean flag = false;
			for (VendorReleation vr : vendorReleations) {
				try {
					if (v.id == vr.vendorid) {
						flag = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (!flag) {
				usefulVendors.add(v);
			}
		}

		return usefulVendors;

	}

	private static List<VendorReleation> getVendorReleations() {

		List<VendorReleation> vendors = null;

		String s = FileUtil.readFile("d:\\file\\releation.txt", 16000000);
		String[] vs = s.split("\r\n");

		vendors = new ArrayList<VendorReleation>();
		for (String s2 : vs) {
			String[] tmp = s2.split("\t");
			VendorReleation vr = null;
			Date dateTmp = null;
			try {
				dateTmp = format.parse(tmp[3]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			vr = new VendorReleation(Integer.parseInt(tmp[0]),
					Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), dateTmp);
			vendors.add(vr);
		}

		return vendors;
	}

	private static List<Vendor> getVendors() {
		List<Vendor> vendors = null;

		String s = FileUtil.readFile("d:\\file\\vendor.txt", 16000000);
		String[] vs = s.split("\r\n");

		vendors = new ArrayList<Vendor>();
		for (String s2 : vs) {
			String[] tmp = s2.split("\t");
			Vendor v = null;
			try {
				v = new Vendor(Integer.parseInt(tmp[0]), tmp[1], tmp[2]);
			} catch (Exception e) {
				e.printStackTrace();
			}

			vendors.add(v);
		}

		return vendors;
	}
}
