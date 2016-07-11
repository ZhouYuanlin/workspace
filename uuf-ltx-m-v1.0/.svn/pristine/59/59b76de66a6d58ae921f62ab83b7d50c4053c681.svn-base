package cn.uuf.stu.entity.framework;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 首页模块信息显示
* <p>标题：IndexShow</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月25日 下午3:33:25
 */
@Entity
@Table(name="uuf_wx_indexshow")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IndexShow extends BaseEntity {
	private static final long serialVersionUID = -7785757592407644137L;
	private String functionName;//方法名
	private String pageName;    //页面名
	
	private WRole role;       //角色
	
	/**
	 * 方法名
	 * @return
	 */
	public String getFunctionName() {
		return functionName;
	}
	
	/**
	 * 方法名
	 * @param functionName
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	/**
	 * 页面名
	 * @return
	 */
	public String getPageName() {
		return pageName;
	}
	
	/**
	 * 页面名
	 * @param pageName
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	@OneToOne(mappedBy="indexShow")  
	public WRole getRole() {
		return role;
	}

	public void setRole(WRole role) {
		this.role = role;
	}
	
	

}
