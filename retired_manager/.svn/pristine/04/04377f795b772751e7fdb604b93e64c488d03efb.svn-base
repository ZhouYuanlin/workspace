package cn.uuf.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 截取字符串
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Jun 8, 2013
 */
public class SubstringTag extends SimpleTagSupport{

	private String value;
	
	private String suffix;
	
	private int length;
	
	private boolean isClean = false;

	@Override
	public void doTag() throws JspException, IOException {
		String substr = isClean ? html2Text(value) : value;
		if (suffix == null || suffix.length() == 0) {
			substr = subString(substr, length * 2);
		} else {
			substr = subString(substr, length * 2, suffix);
		}
		this.getJspContext().getOut().write(substr);
	}
	
	private String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";

		Pattern p_html1;
		Matcher m_html1;

		try {
			String regEx_html2 = "<([^>]*)>";
			p_html1 = Pattern.compile(regEx_html2, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
		}

		return textStr;// 返回文本字符串
	}
	
	/**
	 * 截取字符串
	 * @param str
	 * @param len
	 * @return
	 */
	public static String subString(String str, int len) {
		return subString(str, len, "...");
	}
	
	public static String subString(String str, int len, String suffix) {
		if (str == null || "".equals(str.trim()) || len <= 0) return "";
		if (lengthForString(str) <= len) return str;
		int suffixLen = lengthForString(suffix), redefineLen = 0;
		if ((redefineLen = len - suffixLen) <= 0) return "";
		int i = 0, j = 0;
		for (char c : str.toCharArray()) {
			i += getCharBytes(c);
			++j;
			if (i == redefineLen) break;
			if (i > redefineLen) {
				--j;
				break;
			}
		}
		return str.substring(0, j) + (suffix != null ? suffix : "");
	}
	
	public static int lengthForString(String str) {
		if (str == null || "".equals(str.trim())) return 0;
		int len = 0;
		for (char c : str.toCharArray()) {
			len += getCharBytes(c);
		}
		return len;
	}
	
	public static int getCharBytes(char ch) {
		Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]$");
		Matcher matcher = pattern.matcher(String.valueOf(ch));
		return matcher.find() ? 2 : 1;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the isClean
	 */
	public boolean isClean() {
		return isClean;
	}

	/**
	 * @param isClean the isClean to set
	 */
	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
}

