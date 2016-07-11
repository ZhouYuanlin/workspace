package cn.uuf.domain.health;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 医疗费用
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_ltx_hoscost")
public class Rethoscosts extends BaseDomain{

	private static final long serialVersionUID = -8910982505361014508L;
	private Retirement ret;					//哪个人
	@NotEmpty(message="领取日期不能为空")
	private String lqrq;					//领取日期
	private String lqje;					//领取金额
	private String lqr;						//领取人
	private String ybrgx;					//与本人关系
	private String spr;						//审批人
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
	 * @return the lqrq
	 */
	public String getLqrq() {
		return lqrq;
	}
	/**
	 * @param lqrq the lqrq to set
	 */
	public void setLqrq(String lqrq) {
		this.lqrq = lqrq;
	}
	/**
	 * @return the lqje
	 */
	public String getLqje() {
		return lqje;
	}
	/**
	 * @param lqje the lqje to set
	 */
	public void setLqje(String lqje) {
		this.lqje = lqje;
	}
	/**
	 * @return the lqr
	 */
	public String getLqr() {
		return lqr;
	}
	/**
	 * @param lqr the lqr to set
	 */
	public void setLqr(String lqr) {
		this.lqr = lqr;
	}
	/**
	 * @return the ybrgx
	 */
	public String getYbrgx() {
		return ybrgx;
	}
	/**
	 * @param ybrgx the ybrgx to set
	 */
	public void setYbrgx(String ybrgx) {
		this.ybrgx = ybrgx;
	}
	/**
	 * @return the spr
	 */
	public String getSpr() {
		return spr;
	}
	/**
	 * @param spr the spr to set
	 */
	public void setSpr(String spr) {
		this.spr = spr;
	}
}

