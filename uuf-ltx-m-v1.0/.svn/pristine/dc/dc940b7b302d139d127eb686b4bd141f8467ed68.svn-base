package cn.uuf.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 困难帮扶
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Entity
@Table(name="uf_ltx_help")
public class Retirehelp extends BaseDomain{

	private static final long serialVersionUID = 6131362085024020588L;
	@NotEmpty(message="帮扶原因不能为空")
	private String bfyy;			//困难帮扶原因
	private String bfed;			//帮扶额度
	private String bfxm;			//帮扶项目(来自码表)
	private String bfrq;			//帮扶日期
	private Date createDate;		//创建时间
	private String bz;				//说明
	private Retirement ret;
	/**
	 * @return the bfyy
	 */
	public String getBfyy() {
		return bfyy;
	}
	/**
	 * @param bfyy the bfyy to set
	 */
	public void setBfyy(String bfyy) {
		this.bfyy = bfyy;
	}
	/**
	 * @return the bfed
	 */
	public String getBfed() {
		return bfed;
	}
	/**
	 * @param bfed the bfed to set
	 */
	public void setBfed(String bfed) {
		this.bfed = bfed;
	}
	/**
	 * @return the bfxm
	 */
	public String getBfxm() {
		return bfxm;
	}
	/**
	 * @param bfxm the bfxm to set
	 */
	public void setBfxm(String bfxm) {
		this.bfxm = bfxm;
	}
	/**
	 * @return the bfrq
	 */
	public String getBfrq() {
		return bfrq;
	}
	/**
	 * @param bfrq the bfrq to set
	 */
	public void setBfrq(String bfrq) {
		this.bfrq = bfrq;
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

