package cn.uuf.domain.health;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 医保卡
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_ltx_hoscard")
public class Rethoscard extends BaseDomain{

	private static final long serialVersionUID = -8508575922000032056L;
	private Retirement ret;					//哪个人员
	private String sfff;					//是否发放
	@NotEmpty(message="发放日期不能为空")
	private String fyrq;					//发放日期
	private String jjyyo;					//就近医院1
	private Date xgrqo;						//修改日期
	private String jjyyt;					//就近医院2
	private Date xgrqt;						//修改日期
	private String jjyyh;					//就近医院3
	private Date xgrqh;						//修改日期
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
	 * @return the sfff
	 */
	public String getSfff() {
		return sfff;
	}
	/**
	 * @param sfff the sfff to set
	 */
	public void setSfff(String sfff) {
		this.sfff = sfff;
	}
	/**
	 * @return the fyrq
	 */
	public String getFyrq() {
		return fyrq;
	}
	/**
	 * @param fyrq the fyrq to set
	 */
	public void setFyrq(String fyrq) {
		this.fyrq = fyrq;
	}
	/**
	 * @return the jjyyo
	 */
	public String getJjyyo() {
		return jjyyo;
	}
	/**
	 * @param jjyyo the jjyyo to set
	 */
	public void setJjyyo(String jjyyo) {
		this.jjyyo = jjyyo;
	}
	/**
	 * @return the xgrqo
	 */
	public Date getXgrqo() {
		return xgrqo;
	}
	/**
	 * @param xgrqo the xgrqo to set
	 */
	public void setXgrqo(Date xgrqo) {
		this.xgrqo = xgrqo;
	}
	/**
	 * @return the jjyyt
	 */
	public String getJjyyt() {
		return jjyyt;
	}
	/**
	 * @param jjyyt the jjyyt to set
	 */
	public void setJjyyt(String jjyyt) {
		this.jjyyt = jjyyt;
	}
	/**
	 * @return the xgrqt
	 */
	public Date getXgrqt() {
		return xgrqt;
	}
	/**
	 * @param xgrqt the xgrqt to set
	 */
	public void setXgrqt(Date xgrqt) {
		this.xgrqt = xgrqt;
	}
	/**
	 * @return the jjyyh
	 */
	public String getJjyyh() {
		return jjyyh;
	}
	/**
	 * @param jjyyh the jjyyh to set
	 */
	public void setJjyyh(String jjyyh) {
		this.jjyyh = jjyyh;
	}
	/**
	 * @return the xgrqh
	 */
	public Date getXgrqh() {
		return xgrqh;
	}
	/**
	 * @param xgrqh the xgrqh to set
	 */
	public void setXgrqh(Date xgrqh) {
		this.xgrqh = xgrqh;
	}
	
}

