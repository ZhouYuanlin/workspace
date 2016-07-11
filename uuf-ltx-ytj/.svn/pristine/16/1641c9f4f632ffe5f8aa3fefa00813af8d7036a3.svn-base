package cn.uuf.domain.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 老年大学
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Entity
@Table(name="uf_ltx_oldun")
public class Retireoldun extends BaseDomain{

	private static final long serialVersionUID = -5480625855191105871L;
	private Retirement ret;			//哪个人员
	@NotEmpty(message="入学日期不能为空")
	private String rxrq;			//入学日期
	@NotEmpty(message="毕业日期不能为空")
	private String byrq;			//毕业日期
	private String ktlx;			//课堂类型
	private String ktzw;			//课堂职务
	private String bz;				//说明
	private Date createDate;		//创建时间
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
	 * @return the rxrq
	 */
	public String getRxrq() {
		return rxrq;
	}
	/**
	 * @param rxrq the rxrq to set
	 */
	public void setRxrq(String rxrq) {
		this.rxrq = rxrq;
	}
	/**
	 * @return the byrq
	 */
	public String getByrq() {
		return byrq;
	}
	/**
	 * @param byrq the byrq to set
	 */
	public void setByrq(String byrq) {
		this.byrq = byrq;
	}
	/**
	 * @return the ktlx
	 */
	public String getKtlx() {
		return ktlx;
	}
	/**
	 * @param ktlx the ktlx to set
	 */
	public void setKtlx(String ktlx) {
		this.ktlx = ktlx;
	}
	/**
	 * @return the ktzw
	 */
	public String getKtzw() {
		return ktzw;
	}
	/**
	 * @param ktzw the ktzw to set
	 */
	public void setKtzw(String ktzw) {
		this.ktzw = ktzw;
	}
	/**
	 * @return the bz
	 */
	@Column(length=4000)
	public String getBz() {
		return bz;
	}
	/**
	 * @param bz the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
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

