package me.lime.rxjavademo.entity;

public class Mobile {
	private int prefix;		//手机号码号段。
	private String mobile;	//查询的手机号码
	private String province;//归属地省份名称。
	private String city;	//归属地城市名称
	private String isp;		//归属的运营商名称
	private int code; 		//归属地行政编号
	private int zipcode;  	//归属地邮政编码
	private String types;	//手机号码卡信息
	
	public Mobile() {
		super();
	}
	
	public Mobile(int prefix, String mobile, String province, String city, String isp, int code, int zipcode,
			String types) {
		super();
		this.prefix = prefix;
		this.mobile = mobile;
		this.province = province;
		this.city = city;
		this.isp = isp;
		this.code = code;
		this.zipcode = zipcode;
		this.types = types;
	}
	
	public int getPrefix() {
		return prefix;
	}
	public Mobile setPrefix(int prefix) {
		this.prefix = prefix;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public Mobile setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getProvince() {
		return province;
	}
	public Mobile setProvince(String province) {
		this.province = province;
		return this;
	}
	public String getCity() {
		return city;
	}
	public Mobile setCity(String city) {
		this.city = city;
		return this;
	}
	public String getIsp() {
		return isp;
	}
	public Mobile setIsp(String isp) {
		this.isp = isp;
		return this;
	}
	public int getCode() {
		return code;
	}
	public Mobile setCode(int code) {
		this.code = code;
		return this;
	}
	public int getZipcode() {
		return zipcode;
	}
	public Mobile setZipcode(int zipcode) {
		this.zipcode = zipcode;
		return this;
	}
	public String getTypes() {
		return types;
	}
	public Mobile setTypes(String types) {
		this.types = types;
		return this;
	}

	@Override
	public String toString() {
		return "Mobile {prefix=" + prefix + ", mobile=" + mobile + ", province=" + province + ", city=" + city
				+ ", isp=" + isp + ", code=" + code + ", zipcode=" + zipcode + ", types=" + types + "}";
	}
}
