package cn.uuf.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.record.Retdepart;

/**
 * 用户表存用户信息的
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_user")
public class User implements Serializable{

	private static final long serialVersionUID = 6147213685977183361L;
	@NotEmpty(message="身份证不能为空")
	private String sfzh;			//身份证号(与登录表的username对应该)
	private String lxdh;			//联系电话
	private String gzzh;			//工作证号
	@NotEmpty(message="姓名不能为空")
	private String xm;				//姓名
	private String xb;				//性别
	private CodeDwb codedwb;			//原工作单位
	private String imgsfsc;			//头像是否上传
//	private Retireparty party;		//支委
	
	private String role;
	
	/**
	 * @return the sfzh
	 */
	@Id
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
	 * @return the gzzh
	 */
	public String getGzzh() {
		return gzzh;
	}
	/**
	 * @param gzzh the gzzh to set
	 */
	public void setGzzh(String gzzh) {
		this.gzzh = gzzh;
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
	 * @return the imgsfsc
	 */
	public String getImgsfsc() {
		return imgsfsc;
	}
	/**
	 * @param imgsfsc the imgsfsc to set
	 */
	public void setImgsfsc(String imgsfsc) {
		this.imgsfsc = imgsfsc;
	}
	/**
	 * @return the codedwb
	 */
	@ManyToOne
	@JoinColumn(name="dwb_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public CodeDwb getCodedwb() {
		return codedwb;
	}
	/**
	 * @param codedwb the codedwb to set
	 */
	public void setCodedwb(CodeDwb codedwb) {
		this.codedwb = codedwb;
	}
	@Transient
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
//	/**
//	 * @return the party
//	 */
//	@ManyToOne
//	@JoinColumn(name="party_id")
//	public Retireparty getParty() {
//		return party;
//	}
//	/**
//	 * @param party the party to set
//	 */
//	public void setParty(Retireparty party) {
//		this.party = party;
//	}
}

