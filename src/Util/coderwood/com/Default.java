package Util.coderwood.com;

import java.text.*;
import java.util.*;

public class Default {
	static DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) {
		try {
			 test();
			
//			String str=FileUtil.readFile("d:\\file\\test.txt", 1000);
//			String str2="澳门喜来登金沙城中心酒店(Sheraton Macao Hotel, Cotai Central)";
//			str=str.replace("\"","");
//			System.out.println(str);
//			System.out.println(str2);
//			System.out.println(str.equals(str2));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public static void test() {

		List<Vendor> vendors = getVendorsFile();
		System.out.println(vendors.size());

		List<VendorReleation> vendorReleations = getVendorReleationsFile();
		System.out.println(vendorReleations.size());

		List<Vendor> usefulVendors = getUsefulVendors(vendors, vendorReleations);
		System.out.println(usefulVendors.size());

		//String source = genarateStringFromUsefulVendors(usefulVendors);
		//FileUtil.createFile("d:\\file\\usefulvendor.txt", source);
		
		List<EbkHotel> ebkHotels= getEbkHotelsFile();
		System.out.println(ebkHotels.size());
		
		System.out.println("good");
	}
	
	/** 生成可用团购供应商字符串*/
	public static String genarateStringFromUsefulVendors(List<Vendor> usefulVendors) {
		String source = "";
		StringBuilder sb = new StringBuilder();

		for (Vendor v : usefulVendors) {
			try {
				sb.append(v.id + "\t" + v.name + "\t" + v.loginName + "\r\n");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		source = sb.toString();

		return source;
	}


	/** 排除掉已绑定供应商关系后的团购供应商*/
	public static List<Vendor> getUsefulVendors(List<Vendor> vendors,
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
	
	/** 从文件中读取ebk酒店信息 */
	public static List<EbkHotel> getEbkHotelsFile() {
		List<EbkHotel> ebkHotels = null;

		String s = FileUtil.readFile("d:\\file\\ebkhotel.txt", 16000000);
		String[] vs = s.split("\r\n");

		ebkHotels = new ArrayList<EbkHotel>();
		for (String s2 : vs) {
			String[] tmp = s2.split("\t");
			EbkHotel eh = null;
			try {
				eh = new EbkHotel(Integer.parseInt(tmp[0]), tmp[1].replace("\"",""), Integer.parseInt(tmp[2]));
			} catch (Exception e) {
				e.printStackTrace();
			}

			ebkHotels.add(eh);
		}

		return ebkHotels;
	}

	/** 从文件中读取已绑定的供应商关系 */
	public static List<VendorReleation> getVendorReleationsFile() {

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

	/** 从文件中读取团购供应商信息 */
	public static List<Vendor> getVendorsFile() {
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
