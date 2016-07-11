package cn.uuf.stu.framework.common;

public class ExcelVo {
	public ExcelVo(String sxm, String sxz) {
		this.sxm = sxm;
		this.sxz = sxz;
	}
	private String sxm;//属性名
	private String sxz;//属性值
	public String getSxm() {
		return sxm;
	}
	public void setSxm(String sxm) {
		this.sxm = sxm;
	}
	public String getSxz() {
		return sxz;
	}
	public void setSxz(String sxz) {
		this.sxz = sxz;
	}
	
	
}
