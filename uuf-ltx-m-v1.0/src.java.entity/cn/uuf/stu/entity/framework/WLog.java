package cn.uuf.stu.entity.framework;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
* 
* 微信日志
* @ClassName: Log 
* @author tangpeng
* @date 2015年9月8日 上午11:29:19 
*
*/
@Entity
@Table(name="uuf_wx_log")
public class WLog extends BaseEntity {
	private static final long serialVersionUID = -6895261151105281902L;
	
	/** "日志内容"属性名称 */
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = WLog.class.getName() + ".CONTENT";

	/** 操作 */
	private String operation;

	/** 操作员 */
	private String operator;

	/** 内容 */
	private String content;

	/** IP */
	private String ip;
	
	/** 请求参数*/
	private String parameter;

	/**
	* 获取操作 
	* @return    
	* String
	*/
	@Column(nullable=false,updatable=false)
	public String getOperation() {
		return operation;
	}
	
	/**
	* 设置操作  
	* @param operation    
	* void
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	* 获取操作员
	* @return    
	* String
	*/
	@Column(updatable=false)
	public String getOperator() {
		return operator;
	}
	
	/**
	* 设置操作员
	* @param operator    
	* void
	*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	* 获取内容
	* @return    
	* String
	*/
	@Column(updatable=false)
	public String getContent() {
		return content;
	}
	
	/**
	* 设置内容
	* @param content    
	* void
	*/
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	* 获取IP
	* @return    
	* String
	*/
	@Column(nullable=false,updatable=false)
	public String getIp() {
		return ip;
	}
	
	/**
	* 设置IP
	* @param ip    
	* void
	*/
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	* 获取参数
	* @return    
	* String
	*/
	@Lob
	@Column(updatable=false)
	public String getParameter() {
		return parameter;
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	

}
