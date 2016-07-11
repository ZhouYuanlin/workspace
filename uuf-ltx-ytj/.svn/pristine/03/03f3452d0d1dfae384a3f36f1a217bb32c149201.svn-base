package cn.uuf.domain.health;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 住院
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_ltx_hospital")
public class Rethospital extends BaseDomain{

	private static final long serialVersionUID = -1732895993561378025L;
	private Retirement ret;					//人员
	@NotEmpty(message="住院日期不能为空")
	private String zyrq;					//住院日期
	private String yymc;					//哪家医院
	private String yyks;					//科室
	private String yylc;					//楼层
	private String yycw;					//床位
	private String zyyy;					//住院原因
	private String tsrq;					//探视日期
	private String tsry;					//探视人员
	private String bz;						//说明
	private String djr;						//登记人
	private String djrq;					//登记日期
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
	 * @return the zyrq
	 */
	public String getZyrq() {
		return zyrq;
	}
	/**
	 * @param zyrq the zyrq to set
	 */
	public void setZyrq(String zyrq) {
		this.zyrq = zyrq;
	}
	/**
	 * @return the yymc
	 */
	public String getYymc() {
		return yymc;
	}
	/**
	 * @param yymc the yymc to set
	 */
	public void setYymc(String yymc) {
		this.yymc = yymc;
	}
	/**
	 * @return the yyks
	 */
	public String getYyks() {
		return yyks;
	}
	/**
	 * @param yyks the yyks to set
	 */
	public void setYyks(String yyks) {
		this.yyks = yyks;
	}
	/**
	 * @return the yylc
	 */
	public String getYylc() {
		return yylc;
	}
	/**
	 * @param yylc the yylc to set
	 */
	public void setYylc(String yylc) {
		this.yylc = yylc;
	}
	/**
	 * @return the yycw
	 */
	public String getYycw() {
		return yycw;
	}
	/**
	 * @param yycw the yycw to set
	 */
	public void setYycw(String yycw) {
		this.yycw = yycw;
	}
	/**
	 * @return the zyyy
	 */
	public String getZyyy() {
		return zyyy;
	}
	/**
	 * @param zyyy the zyyy to set
	 */
	public void setZyyy(String zyyy) {
		this.zyyy = zyyy;
	}
	/**
	 * @return the tsrq
	 */
	public String getTsrq() {
		return tsrq;
	}
	/**
	 * @param tsrq the tsrq to set
	 */
	public void setTsrq(String tsrq) {
		this.tsrq = tsrq;
	}
	/**
	 * @return the tsry
	 */
	public String getTsry() {
		return tsry;
	}
	/**
	 * @param tsry the tsry to set
	 */
	public void setTsry(String tsry) {
		this.tsry = tsry;
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
	public String getDjr() {
		return djr;
	}
	public void setDjr(String djr) {
		this.djr = djr;
	}
	public String getDjrq() {
		return djrq;
	}
	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}
	
}

