package cn.uuf.domain.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.Retirement;

/**
 * 老有所为
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Entity
@Table(name="uf_ltx_worthiness")
public class Retireworthiness extends BaseDomain{

	private static final long serialVersionUID = 5209966136325669090L;
	private Retirement ret;					//哪个人员
	@NotEmpty(message="宣讲主题不能为空")
	private String title;					//宣讲组题
	private String sfxjxz;					//是否宣讲小组
	private String xjsj;					//宣讲时间
	private String xjdd;					//宣讲地点
	private Double xjfy;					//宣讲费用
	private String bz;						//说明
	private Date createDate;				//创建时间
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
	 * @return the sfxjxz
	 */
	public String getSfxjxz() {
		return sfxjxz;
	}
	/**
	 * @param sfxjxz the sfxjxz to set
	 */
	public void setSfxjxz(String sfxjxz) {
		this.sfxjxz = sfxjxz;
	}
	/**
	 * @return the xjsj
	 */
	public String getXjsj() {
		return xjsj;
	}
	/**
	 * @param xjsj the xjsj to set
	 */
	public void setXjsj(String xjsj) {
		this.xjsj = xjsj;
	}
	/**
	 * @return the xjdd
	 */
	public String getXjdd() {
		return xjdd;
	}
	/**
	 * @param xjdd the xjdd to set
	 */
	public void setXjdd(String xjdd) {
		this.xjdd = xjdd;
	}
	/**
	 * @return the xjfy
	 */
	public Double getXjfy() {
		return xjfy;
	}
	/**
	 * @param xjfy the xjfy to set
	 */
	public void setXjfy(Double xjfy) {
		this.xjfy = xjfy;
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
}

