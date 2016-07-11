package cn.uuf.domain.daily;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.uuf.domain.BaseDomain;

/**
 * 工作日志===日程，日程类型，分为3种 计划、日志、个人
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-17
 */
@Entity
@Table(name="uf_ltx_work_daily")
public class Workdaily extends BaseDomain{

	private static final long serialVersionUID = 576550601268371747L;
	private String sfzh;						//证件号(哪个人的，不做关联)
	private String xm;							//姓名(都来自用户信息)
	private Long pid;							//哪个部门的用于查看所在部门下的信息
	private Date createDate;					//创建日期
	private Date xrsj;							//写入时间						
	private String kssj;						//开始时间(小时：分)
	private String jssj;						//结束时间(小时：分)
	private String content;						//内容
	private String type;						//类型(计划、日志、个人)
	private String sfwc;						//是否完成(由计划改成日志变成是)
	private String status;						//是否已读
	private boolean sfsx;						//是否超过当前时间
	private String sfzy;						//是否重要
	/**
	 * @return the sfzh
	 */
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
	 * @return the content
	 */
	@Column(length=3000) 
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
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the sfsx
	 */
	@Transient
	public boolean isSfsx() {
		boolean bol = false;
		Date date = new Date();
		try {
			if(this.getCreateDate() != null){
				if(date.after(this.getCreateDate()))//是否在当前时间段内
					bol = true;
			}
		} catch (Exception e) {}//表示未设置有效时间，长期有效
		return bol;
	}
	/**
	 * @param sfsx the sfsx to set
	 */
	public void setSfsx(boolean sfsx) {
		this.sfsx = sfsx;
	}
	/**
	 * @return the kssj
	 */
	public String getKssj() {
		return kssj;
	}
	/**
	 * @param kssj the kssj to set
	 */
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	/**
	 * @return the jssj
	 */
	public String getJssj() {
		return jssj;
	}
	/**
	 * @param jssj the jssj to set
	 */
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	/**
	 * @return the sfwc
	 */
	public String getSfwc() {
		return sfwc;
	}
	/**
	 * @param sfwc the sfwc to set
	 */
	public void setSfwc(String sfwc) {
		this.sfwc = sfwc;
	}
	
	public Date getXrsj() {
		return xrsj;
	}
	
	public void setXrsj(Date xrsj) {
		this.xrsj = xrsj;
	}
	public String getSfzy() {
		return sfzy;
	}
	public void setSfzy(String sfzy) {
		this.sfzy = sfzy;
	}
	
	
	
	
}

