package cn.uuf.domain.ret;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 组织关系(类似学籍异动，党支部调整)
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Entity
@Table(name="uf_ltx_organized")
public class Retorganize extends BaseDomain{

	private static final long serialVersionUID = 3960445776717608066L;
	private Retirement ret;				//退休人员
	private Retireparty yparty;			//原党支部
	private Retireparty hparty;			//调整后党支部
	private String tzsj;				//调整时间
	private String tzyy;				//调整原因
	
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
	 * @return the yparty
	 */
	@ManyToOne
	@JoinColumn(name="yparty_id")
	public Retireparty getYparty() {
		return yparty;
	}
	/**
	 * @param yparty the yparty to set
	 */
	public void setYparty(Retireparty yparty) {
		this.yparty = yparty;
	}
	/**
	 * @return the hparty
	 */
	@ManyToOne
	@JoinColumn(name="hparty_id")
	public Retireparty getHparty() {
		return hparty;
	}
	/**
	 * @param hparty the hparty to set
	 */
	public void setHparty(Retireparty hparty) {
		this.hparty = hparty;
	}
	/**
	 * @return the tzsj
	 */
	public String getTzsj() {
		return tzsj;
	}
	/**
	 * @param tzsj the tzsj to set
	 */
	public void setTzsj(String tzsj) {
		this.tzsj = tzsj;
	}
	/**
	 * @return the tzyy
	 */
	@Column(length=4000)
	public String getTzyy() {
		return tzyy;
	}
	/**
	 * @param tzyy the tzyy to set
	 */
	public void setTzyy(String tzyy) {
		this.tzyy = tzyy;
	}
}

