package cn.uuf.domain.ret;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 党支部
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-11
 */
@Entity
@Table(name="uf_ltx_party")
public class Retireparty extends BaseDomain{

	private static final long serialVersionUID = -5966448564487196757L;
	@NotEmpty(message="党支部名称不能为空")
	private String dzbmc;			//党支部名称
	private String dzbjc;			//党支部简称
	private String lxdh;			//联系电话
	private String dzbdm;			//党支部代码
	private Date createDate;		//创建时间
	private String zzms;			//职责简述
	private List<Retirement> zws;	//支委
	private List<Retirement> ments;//离退休人员 
	private String dzbsj;			//党支部书记
	private String dzbfsj;			//党支部副书记
	private String zblny;			//联络员
	private Date canceDate;		//注消时间
	/**
	 * @return the dzbmc
	 */
	public String getDzbmc() {
		return dzbmc;
	}
	/**
	 * @param dzbmc the dzbmc to set
	 */
	public void setDzbmc(String dzbmc) {
		this.dzbmc = dzbmc;
	}
	/**
	 * @return the dzbjc
	 */
	public String getDzbjc() {
		return dzbjc;
	}
	/**
	 * @param dzbjc the dzbjc to set
	 */
	public void setDzbjc(String dzbjc) {
		this.dzbjc = dzbjc;
	}
	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}
	/**
	 * @param lxdh the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
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
	/**
	 * @return the zzms
	 */
	@Column(length=4000)
	public String getZzms() {
		return zzms;
	}
	/**
	 * @param zzms the zzms to set
	 */
	public void setZzms(String zzms) {
		this.zzms = zzms;
	}
	/**
	 * @return the dzbsj
	 */
	public String getDzbsj() {
		return dzbsj;
	}
	/**
	 * @param dzbsj the dzbsj to set
	 */
	public void setDzbsj(String dzbsj) {
		this.dzbsj = dzbsj;
	}
	
	/**
	 * @return the zws
	 */
	@OneToMany(mappedBy="zw")
	public List<Retirement> getZws() {
		return zws;
	}
	/**
	 * @param zws the zws to set
	 */
	public void setZws(List<Retirement> zws) {
		this.zws = zws;
	}
	/**
	 * @return the dzbfsj
	 */
	public String getDzbfsj() {
		return dzbfsj;
	}
	/**
	 * 党支部代码
	 * @return
	 */
	public String getDzbdm() {
		return dzbdm;
	}
	public void setDzbdm(String dzbdm) {
		this.dzbdm = dzbdm;
	}
	/**
	 * @param dzbfsj the dzbfsj to set
	 */
	public void setDzbfsj(String dzbfsj) {
		this.dzbfsj = dzbfsj;
	}
	/**
	 * @return the zblny
	 */
	public String getZblny() {
		return zblny;
	}
	
	/**
	 * @return the canceDate
	 */
	public Date getCanceDate() {
		return canceDate;
	}
	/**
	 * @param canceDate the canceDate to set
	 */
	public void setCanceDate(Date canceDate) {
		this.canceDate = canceDate;
	}
	/**
	 * @param zblny the zblny to set
	 */
	public void setZblny(String zblny) {
		this.zblny = zblny;
	}
	/**
	 * @return the ments
	 */
	@OneToMany(mappedBy="party")
	@OrderBy("asc sfzh")
	public List<Retirement> getMents() {
		return ments;
	}
	/**
	 * @param ments the ments to set
	 */
	public void setMents(List<Retirement> ments) {
		this.ments = ments;
	}
	/**
	 * 添加党员
	 * @param m
	 */
	public void addMents(Retirement m){
		if(this.ments == null)
			this.ments = new ArrayList<Retirement>();
		this.ments.add(m);
	}
	/**
	 * 添加支委
	 * @param u
	 */
	public void addZws(Retirement z){
		if(this.zws == null)
			this.zws = new ArrayList<Retirement>();
		this.zws.add(z);
	}
	
}

