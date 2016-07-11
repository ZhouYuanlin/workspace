package cn.uuf.domain.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 添动管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@Table(name="uf_ltx_activity")
public class Retireactivity extends BaseDomain{

	private static final long serialVersionUID = -4789138893225049721L;
	@NotEmpty(message="活动名称不能为空")
	private String title;				//活动名称
	private String xzlx;				//小组类型(来自码表)
	private String xzzz;				//小组组长
	private String cyzh;				//(存的身份证号，不做关联)
	private String xzcy;				//小组成员
	private String lxdh;				//联系电话
	private Integer hdcs;				//活动次数
	private Date createDate;			//创建时间
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
	 * @return the xzlx
	 */
	public String getXzlx() {
		return xzlx;
	}
	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(String xzlx) {
		this.xzlx = xzlx;
	}
	/**
	 * @return the xzzz
	 */
	public String getXzzz() {
		return xzzz;
	}
	/**
	 * @param xzzz the xzzz to set
	 */
	public void setXzzz(String xzzz) {
		this.xzzz = xzzz;
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
	 * @return the xzcy
	 */
	@Column(length=4000)
	public String getXzcy() {
		return xzcy;
	}
	/**
	 * @param xzcy the xzcy to set
	 */
	public void setXzcy(String xzcy) {
		this.xzcy = xzcy;
	}
	/**
	 * @return the hdcs
	 */
	public Integer getHdcs() {
		return hdcs;
	}
	/**
	 * @return the cyzh
	 */
	@Column(length=4000)
	public String getCyzh() {
		return cyzh;
	}
	/**
	 * @param cyzh the cyzh to set
	 */
	public void setCyzh(String cyzh) {
		this.cyzh = cyzh;
	}
	/**
	 * @param hdcs the hdcs to set
	 */
	public void setHdcs(Integer hdcs) {
		this.hdcs = hdcs;
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

