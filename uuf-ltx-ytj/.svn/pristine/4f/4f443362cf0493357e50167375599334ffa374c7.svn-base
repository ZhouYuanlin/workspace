package cn.uuf.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 系统参数表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-19
 */
@Entity
@Table(name="uf_sys_param")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Retparam extends BaseDomain{

	private static final long serialVersionUID = 7390714350433315227L;
	@NotEmpty(message="标题不能为空")
	private String name;				//标题(唯一)
	@NotEmpty(message="参数值不能为空")
	private String pvalue;				//具体值
	private String bz;					//说明
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pvalue
	 */
	public String getPvalue() {
		return pvalue;
	}
	/**
	 * @param pvalue the pvalue to set
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
	/**
	 * @return the bz
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * @param bz the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
}

