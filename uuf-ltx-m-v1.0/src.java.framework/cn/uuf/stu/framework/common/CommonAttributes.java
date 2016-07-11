/*
 * 
 * 
 * 
 */
package cn.uuf.stu.framework.common;

/**
 * 公共参数
 * 
 * 
 * 
 */
public final class CommonAttributes {

	/** 日期格式配比 */
	public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };

	/** systemParameter.xml文件路径 */
	public static final String SYSTEM_PARAMETER_PATH = "/systemParameter.xml";

	/** zkxp.properties文件路径 */
	public static final String ZKXP_PROPERTIES_PATH = "/zkxp.properties";

	/**
	 * 不可实例化
	 */
	private CommonAttributes() {
	}

}