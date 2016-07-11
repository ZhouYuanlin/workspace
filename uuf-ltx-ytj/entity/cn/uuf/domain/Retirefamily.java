package cn.uuf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 家庭信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@Table(name="uf_ltx_family")
public class Retirefamily extends BaseDomain{

	private static final long serialVersionUID = 2072642767492842645L;
	@NotEmpty(message="家庭住址不能为空")
	private String jtdz;				//家庭住址
	private String yzbm;				//邮编
	private String jtdh;				//联系电话
	private String lxdh;				//手机
	private String sfmr;				//是否默认地址(只能有一个为是,改变一个其它都为否)
	private String description;			//备注
	private Retirement ret;				//人员
	/**
	 * @return the jtdz
	 */
	@Column(length=4000)
	public String getJtdz() {
		return jtdz;
	}
	/**
	 * @param jtdz the jtdz to set
	 */
	public void setJtdz(String jtdz) {
		this.jtdz = jtdz;
	}
	/**
	 * @return the yzbm
	 */
	public String getYzbm() {
		return yzbm;
	}
	/**
	 * @param yzbm the yzbm to set
	 */
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	/**
	 * @return the jtdh
	 */
	public String getJtdh() {
		return jtdh;
	}
	/**
	 * @param jtdh the jtdh to set
	 */
	public void setJtdh(String jtdh) {
		this.jtdh = jtdh;
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
	 * @return the sfmr
	 */
	public String getSfmr() {
		return sfmr;
	}
	/**
	 * @param sfmr the sfmr to set
	 */
	public void setSfmr(String sfmr) {
		this.sfmr = sfmr;
	}
	/**
	 * @return the description
	 */
	@Column(length=4000)
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
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
	
}

