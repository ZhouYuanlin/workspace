package cn.uuf.domain.health;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 医疗健康
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_ltx_health")
public class Rethealth extends BaseDomain{

	private static final long serialVersionUID = -4553272085462711520L;
	private Retirement ret;				//人员
	@NotEmpty(message="体检时间不能为空")
	private String tjsj;				//体检时间
	private String tjyy;				//体检医院
	private String tjjg;				//体检结果
	private String bz;					//说明
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
	 * @return the tjsj
	 */
	public String getTjsj() {
		return tjsj;
	}
	/**
	 * @param tjsj the tjsj to set
	 */
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	/**
	 * @return the tjyy
	 */
	public String getTjyy() {
		return tjyy;
	}
	/**
	 * @param tjyy the tjyy to set
	 */
	public void setTjyy(String tjyy) {
		this.tjyy = tjyy;
	}
	/**
	 * @return the tjjg
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	@Column(columnDefinition="CLOB", nullable=true) 
	public String getTjjg() {
		return tjjg;
	}
	/**
	 * @param tjjg the tjjg to set
	 */
	public void setTjjg(String tjjg) {
		this.tjjg = tjjg;
	}
	/**
	 * @return the bz
	 */
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

