package cn.uuf.domain.health;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

@Entity
@Table(name="uf_ltx_dhlx")
public class Retphone extends BaseDomain {
	private static final long serialVersionUID = 3607933315505327062L;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lxrq;						//联系日期
	private String lxr;						//联系人
	private String lxxq;					//联系详情
	private String djr;						//登记人
	private Date djrq;						//登记日期
		
	private String sfzh;					//身份证号
	
	private Retirement retirement;			//人员

	public Date getLxrq() {
		return lxrq;
	}
	public void setLxrq(Date lxrq) {
		this.lxrq = lxrq;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxxq() {
		return lxxq;
	}
	public void setLxxq(String lxxq) {
		this.lxxq = lxxq;
	}
	public String getDjr() {
		return djr;
	}
	public void setDjr(String djr) {
		this.djr = djr;
	}
	public Date getDjrq() {
		return djrq;
	}
	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}
	
	@Transient
	public Retirement getRetirement() {
		return retirement;
	}
	public void setRetirement(Retirement retirement) {
		this.retirement = retirement;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	
	
}
