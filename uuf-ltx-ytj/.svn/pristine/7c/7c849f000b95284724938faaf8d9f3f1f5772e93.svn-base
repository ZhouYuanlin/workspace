package cn.uuf.domain.health;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 保健标记
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-2
 */
@Entity
@Table(name="uf_ltx_label")
public class Retlabel extends BaseDomain{

	private static final long serialVersionUID = 2361627963188545774L;
	private Retirement ret;
	private String bjbj;				//保健标记(来自码表，不做关联)
	private Date createDate;			//创建时间
	/**
	 * @return the ret
	 */
	@ManyToOne
	public Retirement getRet() {
		return ret;
	}
	/**
	 * @param ret the ret to set
	 */
	public void setRet(Retirement ret) {
		this.ret = ret;
	}
	/**
	 * @return the bjbj
	 */
	public String getBjbj() {
		return bjbj;
	}
	/**
	 * @param bjbj the bjbj to set
	 */
	public void setBjbj(String bjbj) {
		this.bjbj = bjbj;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}

