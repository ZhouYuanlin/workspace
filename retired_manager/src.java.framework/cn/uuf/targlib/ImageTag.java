/**
 * 
 */
package cn.uuf.targlib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author <a href="mailto:litianhua@baiing.cn">lth</a><br>
 * @serial 1.0<br>
 * @date 2013-2-7
 */
public class ImageTag extends SimpleTagSupport{
	
	
	private String base = "/upload/user";//基础路径
	
	private String id = "userimage";//src名称
	
	private String user = "123abc321";//证件号
	
	private String size;//大小
	
	private String sex="男";//性别
	
	private String change = "defaults";
	
	private int width = 90;
	
	private int height= 90;
	
	private String suffix = ".jpg";//后缀名
	
	public void doTag()throws JspException, IOException{
		String url = "<img src='";
		if(change.equals("defaults"))
			url += base + "/" + user + "/" + size + suffix + "' width='"+width+"' height='"+height+"' id='" + id +"' />";
		else if(sex.equals("男"))
			url += "/defaults/images/head_default" + suffix + "' width='"+width+"' height='"+height+"' />";
		else
			url += "/defaults/images/head_default_girl" + suffix + "' width='"+width+"' height='"+height+"' />";
		this.getJspContext().getOut().write(url);
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
