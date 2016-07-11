package cn.uuf.domain.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 其它活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Entity
@Table(name="uf_ltx_activity_other")
public class Retireactivother extends BaseDomain{

	private static final long serialVersionUID = 4656421270142030712L;
	@NotEmpty(message="活动名称不能为空")
	private String name;				//活动名称==活动标题
	private String hddd;				//活动地点
	private String hdsj;				//活动时间起
	private String hdsjjz;				//活动时间截止到~   (新)
	private String fzr;					//负责人
	private String fzrlxdh;  			//负责人联系电话       (新)
	private String cyrys;				//参与人员(不关联只存人名)
	private String cyry;	            //参与人员身份证号
	private String hdsm;				//活动开始介绍说明       (新)
	private String hdjssm;				//活动结束说明         (新)
	private String sfqd;				//是否签到		   (新)
	private String bz;					//说明或反馈信息
	private String sfzhstr;				//活动报名人身份证号字符串用逗号分隔
	private String imgurl;				//网络图片路径带URL，通过系统设置中进行捕捉前缀域名
	private String content;				//活动内容HTML，其中的图片路径必须要带上IP和端口号或者域名
	
	public String getCyry() {
		return cyry;
	}
	public void setCyry(String cyry) {
		this.cyry = cyry;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the hddd
	 */
	public String getHddd() {
		return hddd;
	}
	/**
	 * @param hddd the hddd to set
	 */
	public void setHddd(String hddd) {
		this.hddd = hddd;
	}
	/**
	 * @return the hdsj
	 */
	public String getHdsj() {
		return hdsj;
	}
	/**
	 * @param hdsj the hdsj to set
	 */
	public void setHdsj(String hdsj) {
		this.hdsj = hdsj;
	}
	/**
	 * @return the fzr
	 */
	public String getFzr() {
		return fzr;
	}
	/**
	 * @param fzr the fzr to set
	 */
	public void setFzr(String fzr) {
		this.fzr = fzr;
	}
	/**
	 * @return the cyrys
	 */
	@Column(length=4000)
	public String getCyrys() {
		return cyrys;
	}
	/**
	 * @param cyrys the cyrys to set
	 */
	public void setCyrys(String cyrys) {
		this.cyrys = cyrys;
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSfzhstr() {
		return sfzhstr;
	}
	public void setSfzhstr(String sfzhstr) {
		this.sfzhstr = sfzhstr;
	}
	
	/**
	 * 活动结束时间截止
	 * @return
	 */
	public String getHdsjjz() {
		return hdsjjz;
	}
	public void setHdsjjz(String hdsjjz) {
		this.hdsjjz = hdsjjz;
	}
	
	/**
	 * 负责人联系电话
	 * @return
	 */
	public String getFzrlxdh() {
		return fzrlxdh;
	}
	public void setFzrlxdh(String fzrlxdh) {
		this.fzrlxdh = fzrlxdh;
	}
	/**
	 * 活动说明介绍
	 * @return
	 */
	public String getHdsm() {
		return hdsm;
	}
	public void setHdsm(String hdsm) {
		this.hdsm = hdsm;
	}
	
	/**
	 * 活动结束说明
	 * @return
	 */
	public String getHdjssm() {
		return hdjssm;
	}
	public void setHdjssm(String hdjssm) {
		this.hdjssm = hdjssm;
	}
	
	/**
	 * 签到记录
	 * @return
	 */
	public String getSfqd() {
		return sfqd;
	}
	public void setSfqd(String sfqd) {
		this.sfqd = sfqd;
	}
	
	
}

