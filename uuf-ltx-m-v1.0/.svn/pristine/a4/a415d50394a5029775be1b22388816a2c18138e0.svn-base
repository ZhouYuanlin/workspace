package cn.uuf.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_log")
public class Log extends BaseDomain{

	private static final long serialVersionUID = 5395688423387654446L;
	private String action;		//执行操作
	private String loginName;	//登录账号
	private String path;		//访问路径
	private String ip;			//ip
	private Date loginDate;		//操作时间
	/**
	 * 执行动作
	 * @return
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 执行动作
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 当前用户
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 当前用户
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 当前Ip
	 * @return
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * 当前ip
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 操作时间
	 * @return
	 */
	public Date getLoginDate() {
		return loginDate;
	}
	/**
	 * 操作时间
	 * @param loginDate
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}	
}

