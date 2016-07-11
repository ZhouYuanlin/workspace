package cn.uuf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 离世人员信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
@Entity
@Table(name="uf_ltx_death")
public class Retiredeath extends BasicField{
	
	private static final long serialVersionUID = 3854742494612296716L;
	@Id
	@NotEmpty(message="身份证不能为空")
	private String sfzh;			//身份证号
	@NotEmpty(message="姓名不能为空")
	private String xm;				//姓名
	private String xb;				//性别
	@ManyToOne
	@JoinColumn(name="dwb_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private CodeDwb dwb;			//原工作单位
	@ManyToOne
	@JoinColumn(name="mzb_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private CodeMzb mzb;			//民族
	@ManyToOne
	@JoinColumn(name="lxb_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private CodeLxb lxb;			//类型
	private String csrq;			//出生日期(生日)
	private String jg;				//籍贯
	private String sscj;			//丧事从简(说明：丧事从简勾选后，不出现以下信息)
	//离世信息
	@Column(length=4000)
	private String lsyy;			//离世原因
	private String lssj;			//离世时间
	private String lsdd;			//离世地点
	private String gbyssj;			//告别仪式时间
	private String gbysdd;			//告别仪式地点
	@Column(length=4000)
	private String grsp;			//个人生平
	/**
	 * @return the sfzh
	 */
	public String getSfzh() {
		return sfzh;
	}
	/**
	 * @param sfzh the sfzh to set
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}
	/**
	 * @param xm the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * @return the xb
	 */
	public String getXb() {
		return xb;
	}
	/**
	 * @param xb the xb to set
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}
	
	/**
	 * @return the csrq
	 */
	public String getCsrq() {
		return csrq;
	}
	/**
	 * @param csrq the csrq to set
	 */
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	/**
	 * @return the dwb
	 */
	public CodeDwb getDwb() {
		return dwb;
	}
	/**
	 * @param dwb the dwb to set
	 */
	public void setDwb(CodeDwb dwb) {
		this.dwb = dwb;
	}
	/**
	 * @return the mzb
	 */
	public CodeMzb getMzb() {
		return mzb;
	}
	/**
	 * @param mzb the mzb to set
	 */
	public void setMzb(CodeMzb mzb) {
		this.mzb = mzb;
	}
	/**
	 * @return the lxb
	 */
	public CodeLxb getLxb() {
		return lxb;
	}
	/**
	 * @param lxb the lxb to set
	 */
	public void setLxb(CodeLxb lxb) {
		this.lxb = lxb;
	}
	/**
	 * @return the lsyy
	 */
	public String getLsyy() {
		return lsyy;
	}
	/**
	 * @param lsyy the lsyy to set
	 */
	public void setLsyy(String lsyy) {
		this.lsyy = lsyy;
	}
	/**
	 * @return the lssj
	 */
	public String getLssj() {
		return lssj;
	}
	/**
	 * @param lssj the lssj to set
	 */
	public void setLssj(String lssj) {
		this.lssj = lssj;
	}
	/**
	 * @return the lsdd
	 */
	public String getLsdd() {
		return lsdd;
	}
	/**
	 * @param lsdd the lsdd to set
	 */
	public void setLsdd(String lsdd) {
		this.lsdd = lsdd;
	}
	/**
	 * @return the gbyssj
	 */
	public String getGbyssj() {
		return gbyssj;
	}
	/**
	 * @param gbyssj the gbyssj to set
	 */
	public void setGbyssj(String gbyssj) {
		this.gbyssj = gbyssj;
	}
	/**
	 * @return the gbysdd
	 */
	public String getGbysdd() {
		return gbysdd;
	}
	/**
	 * @param gbysdd the gbysdd to set
	 */
	public void setGbysdd(String gbysdd) {
		this.gbysdd = gbysdd;
	}
	/**
	 * @return the grsp
	 */
	public String getGrsp() {
		return grsp;
	}
	/**
	 * @param grsp the grsp to set
	 */
	public void setGrsp(String grsp) {
		this.grsp = grsp;
	}
	/**
	 * @return the jg
	 */
	public String getJg() {
		return jg;
	}
	/**
	 * @param jg the jg to set
	 */
	public void setJg(String jg) {
		this.jg = jg;
	}
	/**
	 * @return the sscj
	 */
	public String getSscj() {
		return sscj;
	}
	/**
	 * @param sscj the sscj to set
	 */
	public void setSscj(String sscj) {
		this.sscj = sscj;
	}
}

