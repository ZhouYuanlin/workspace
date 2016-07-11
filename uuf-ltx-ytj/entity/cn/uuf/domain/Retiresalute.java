package cn.uuf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 慰问服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Entity
@Table(name="uf_ltx_salute")
public class Retiresalute extends BaseDomain{
	
	private static final long serialVersionUID = 9121438120438654526L;
	@NotEmpty(message="慰问类型不能为空")
	private String wwlx;			//慰问类型
	@NotEmpty(message="慰问时间不能为空")
	private String wwsj;			//慰问时间
	private String wwdd;			//慰问地点
	private String wwp;				//慰问品标准
	private String kwry;			//看望人员
	private String zxzt;			//执行状态
	private String fkxx;			//反馈信息
	private String sfzhs;			//哪些人员的身份证(不存库)
	private String rets;			//人员姓名(用于页面显示，不做其它用)
	private String bz;				//说明
	
	/**
	 * @return the wwlx
	 */
	public String getWwlx() {
		return wwlx;
	}
	/**
	 * @param wwlx the wwlx to set
	 */
	public void setWwlx(String wwlx) {
		this.wwlx = wwlx;
	}
	/**
	 * @return the wwsj
	 */
	public String getWwsj() {
		return wwsj;
	}
	/**
	 * @param wwsj the wwsj to set
	 */
	public void setWwsj(String wwsj) {
		this.wwsj = wwsj;
	}
	/**
	 * @return the wwdd
	 */
	public String getWwdd() {
		return wwdd;
	}
	/**
	 * @param wwdd the wwdd to set
	 */
	public void setWwdd(String wwdd) {
		this.wwdd = wwdd;
	}
	/**
	 * @return the wwp
	 */
	public String getWwp() {
		return wwp;
	}
	/**
	 * @param wwp the wwp to set
	 */
	public void setWwp(String wwp) {
		this.wwp = wwp;
	}
	/**
	 * @return the kwry
	 */
	public String getKwry() {
		return kwry;
	}
	/**
	 * @param kwry the kwry to set
	 */
	public void setKwry(String kwry) {
		this.kwry = kwry;
	}
	/**
	 * @return the zxzt
	 */
	public String getZxzt() {
		return zxzt;
	}
	/**
	 * @param zxzt the zxzt to set
	 */
	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}
	/**
	 * @return the fkxx
	 */
	@Column(length=4000)
	public String getFkxx() {
		return fkxx;
	}
	/**
	 * @param fkxx the fkxx to set
	 */
	public void setFkxx(String fkxx) {
		this.fkxx = fkxx;
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
	 * @return the rets
	 */
	@Column(length=4000)
	public String getRets() {
		return rets;
	}
	/**
	 * @param rets the rets to set
	 */
	public void setRets(String rets) {
		this.rets = rets;
	}
	/**
	 * @return the sfzhs
	 */
	@Transient
	public String getSfzhs() {
		return sfzhs;
	}
	/**
	 * @param sfzhs the sfzhs to set
	 */
	public void setSfzhs(String sfzhs) {
		this.sfzhs = sfzhs;
	}
}

