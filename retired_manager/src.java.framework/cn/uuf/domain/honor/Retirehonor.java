package cn.uuf.domain.honor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 表彰
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Entity
@Table(name="uf_ltx_honor")
public class Retirehonor extends BaseDomain{

	private static final long serialVersionUID = -8531107818026984256L;
	@NotEmpty(message="表彰名称不能为空")
	private String bzmc;						//表彰名称
	private String bzsj;						//表彰时间
	private String bzjb;						//表彰级别(来自码表)
	private String bzdw;						//表彰单位
	private String cyhs;						//表彰人员的身份证号(不做关联供查询用)
	private String cyxms;						//人员(显示用)
	private String bznr;						//表彰内容
	private String bz;							//备注
	/**
	 * @return the bzmc
	 */
	public String getBzmc() {
		return bzmc;
	}
	/**
	 * @param bzmc the bzmc to set
	 */
	public void setBzmc(String bzmc) {
		this.bzmc = bzmc;
	}
	/**
	 * @return the bzsj
	 */
	public String getBzsj() {
		return bzsj;
	}
	/**
	 * @param bzsj the bzsj to set
	 */
	public void setBzsj(String bzsj) {
		this.bzsj = bzsj;
	}
	/**
	 * @return the bzjb
	 */
	public String getBzjb() {
		return bzjb;
	}
	/**
	 * @param bzjb the bzjb to set
	 */
	public void setBzjb(String bzjb) {
		this.bzjb = bzjb;
	}
	/**
	 * @return the bzdw
	 */
	public String getBzdw() {
		return bzdw;
	}
	/**
	 * @param bzdw the bzdw to set
	 */
	public void setBzdw(String bzdw) {
		this.bzdw = bzdw;
	}
	/**
	 * @return the cyhs
	 */
	@Column(length=4000)
	public String getCyhs() {
		return cyhs;
	}
	/**
	 * @param cyhs the cyhs to set
	 */
	public void setCyhs(String cyhs) {
		this.cyhs = cyhs;
	}
	/**
	 * @return the cyxms
	 */
	@Column(length=4000)
	public String getCyxms() {
		return cyxms;
	}
	/**
	 * @param cyxms the cyxms to set
	 */
	public void setCyxms(String cyxms) {
		this.cyxms = cyxms;
	}
	/**
	 * @return the bznr
	 */
	@Column(length=4000)
	public String getBznr() {
		return bznr;
	}
	/**
	 * @param bznr the bznr to set
	 */
	public void setBznr(String bznr) {
		this.bznr = bznr;
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
	
}

