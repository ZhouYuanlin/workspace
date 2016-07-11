package cn.uuf.stu.entity.framework;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
* 异常监控
* @ClassName: ExceptionMonitor 
* @author tangpeng
* @date 2015年9月8日 下午5:05:14 
*
*/
@Entity
@Table(name="uuf_wx_exception_monitor")
public class ExceptionMonitor extends BaseEntity {
	
	private static final long serialVersionUID = 4713275893145393459L;
	
	/** 方法执行错误的路径*/
	private String path;
	
	/** 异常监控信息*/
	private String message;
	
	/** 整个异常详细信息*/
	private String exception;
	
	/** 请求参数*/
	private String parameter;

	/**
	* 获得路径
	* @return    
	* String
	*/
	@Column(nullable=false,updatable=false)
	public String getPath() {
		return path;
	}
	
	/**
	* 设置路径
	* @param path    
	* void
	*/
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	* 获得异常信息
	* @return    
	* String
	*/
	@Column(nullable=false,updatable=false)
	public String getMessage() {
		return message;
	}
	
	/**
	* 设置异常信息
	* @param message    
	* void
	*/
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	* 获得异常详细信息
	* @return    
	* String
	*/
	@Lob
	@Column(nullable=false,updatable=false)
	public String getException() {
		return exception;
	}
	
	/**
	* 设置异常详细信息
	* @param exception    
	* void
	*/
	public void setException(String exception) {
		this.exception = exception;
	}
	
	/**
	* 获取请求参数
	* @return    
	* String
	*/
	@Lob
	@Column(updatable=false)
	public String getParameter() {
		return parameter;
	}
	
	/**
	* 
	* 设置请求参数
	* @param parameter    
	* void
	*/
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
