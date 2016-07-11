package cn.uuf.domain.ret;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 缴费信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@Table(name="uf_ltx_pay")
public class Retirepay extends BaseDomain{

	private static final long serialVersionUID = -4325079997939349965L;
	private Retirement ret;				//退休人员
	private String jfsj;				//缴费时间
	private String dfjs;				//党费基数
	private String jfzq;				//缴费周期
	private Double money;				//金额
	private String czr;					//操作人
	private Date createDate;			//
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
	 * @return the jfsj
	 */
	public String getJfsj() {
		return jfsj;
	}
	/**
	 * @param jfsj the jfsj to set
	 */
	public void setJfsj(String jfsj) {
		this.jfsj = jfsj;
	}
	/**
	 * @return the dfjs
	 */
	public String getDfjs() {
		return dfjs;
	}
	/**
	 * @param dfjs the dfjs to set
	 */
	public void setDfjs(String dfjs) {
		this.dfjs = dfjs;
	}
	/**
	 * @return the jfzq
	 */
	public String getJfzq() {
		return jfzq;
	}
	/**
	 * @param jfzq the jfzq to set
	 */
	public void setJfzq(String jfzq) {
		this.jfzq = jfzq;
	}
	/**
	 * @return the money
	 */
	public Double getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(Double money) {
		this.money = money;
	}
	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}
	/**
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
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

