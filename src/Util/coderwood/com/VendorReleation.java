package Util.coderwood.com;

import java.util.Date;

public class VendorReleation {
	
	public int id;
	public int vendorid;
	public int huid;
	public Date createTime;
	
	public VendorReleation(int id,int vendorid,int huid,Date createtime){
		this.id=id;
		this.vendorid=vendorid;
		this.huid=huid;
		this.createTime=createtime;
	}
}
