package cn.uuf.domain.survey;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
/**
 * 问卷主表
 * @author home
 *
 */
@Entity
@Table(name ="uuf_ltx_survey")
public class Survey extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4907735098070485731L;
	@NotEmpty(message="问卷主题不能为空")
	private String wjzt;//问卷主题
	
	private String bz;//备注
	
	private String nm;//匿名
	
	private String kssj;//调查问卷发布的起始时间
	
	private String jssj;//调查问卷发布的结束时间
	
	private String fbr;//发布人
	
	private String fbrq;//发布日期
	
	private String status;//状态

	public String getWjzt() {
		return wjzt;
	}

	public void setWjzt(String wjzt) {
		this.wjzt = wjzt;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getFbr() {
		return fbr;
	}

	public void setFbr(String fbr) {
		this.fbr = fbr;
	}

	public String getFbrq() {
		return fbrq;
	}

	public void setFbrq(String fbrq) {
		this.fbrq = fbrq;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
