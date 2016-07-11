package cn.uuf.domain.ret;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 捐款记录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@Table(name="uf_ltx_donation")
public class Retiredonations extends BaseDomain{

	private static final long serialVersionUID = -5990174601398019863L;
	private Retirement ret;				//人员
	private Double jkje;				//捐款金额
	private String jkrq;				//捐款日期
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
	 * @return the jkje
	 */
	public Double getJkje() {
		return jkje;
	}
	/**
	 * @param jkje the jkje to set
	 */
	public void setJkje(Double jkje) {
		this.jkje = jkje;
	}
	/**
	 * @return the jkrq
	 */
	public String getJkrq() {
		return jkrq;
	}
	/**
	 * @param jkrq the jkrq to set
	 */
	public void setJkrq(String jkrq) {
		this.jkrq = jkrq;
	}
	
}

