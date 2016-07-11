package cn.uuf.domain.ret;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 党建工作
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@Table(name="uf_ltx_party_work")
public class Retirepartywork extends BaseDomain{

	private static final long serialVersionUID = 4034557397701336535L;
	@NotEmpty(message="标题不能为空")
	private String title;					//标题
	private String kfrq;					//时间
	private String zcr;						//主持人
	private String kfdzb;					//所在党支部
	private String cfry;					//参会人员
	private String content;					//内容
	private String fkxx;					//反馈信息
	
	private Retireparty retireparty;        //不映射实体,查询使用
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the kfrq
	 */
	public String getKfrq() {
		return kfrq;
	}
	/**
	 * @param kfrq the kfrq to set
	 */
	public void setKfrq(String kfrq) {
		this.kfrq = kfrq;
	}
	/**
	 * @return the zcr
	 */
	public String getZcr() {
		return zcr;
	}
	/**
	 * @param zcr the zcr to set
	 */
	public void setZcr(String zcr) {
		this.zcr = zcr;
	}
	/**
	 * @return the kfdzb
	 */
	public String getKfdzb() {
		return kfdzb;
	}
	/**
	 * @param kfdzb the kfdzb to set
	 */
	public void setKfdzb(String kfdzb) {
		this.kfdzb = kfdzb;
	}
	/**
	 * @return the cfry
	 */
	@Column(length=4000)
	public String getCfry() {
		return cfry;
	}
	/**
	 * @param cfry the cfry to set
	 */
	public void setCfry(String cfry) {
		this.cfry = cfry;
	}
	/**
	 * @return the content
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	@Column(columnDefinition="CLOB", nullable=true) 
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	
	@Transient
	public Retireparty getRetireparty() {
		return retireparty;
	}
	public void setRetireparty(Retireparty retireparty) {
		this.retireparty = retireparty;
	}
	
	
}

