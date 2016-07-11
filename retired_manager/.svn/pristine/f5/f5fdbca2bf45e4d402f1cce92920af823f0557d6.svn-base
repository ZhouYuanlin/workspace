package cn.uuf.domain.learning;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 在线学习
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name="uf_ltx_course")
public class Course extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4555072678866304916L;
	@NotEmpty(message="课程不能为空")
	private String kcmc;// 课程名称
	private String kcjs;//课程介绍
	private String url;//视频路径
	private String spjs;//视频介绍
	private String zjr;//主讲人
	private String zjrjs;//主讲人介绍
	private String cjz;//创建者
	private Date cDate;//发布日期
	private Integer goodCount;//点赞数量
	private Integer viewNum;//浏览量
	/**
	 * @return 课程名称
	 */
	public String getKcmc() {
		return kcmc;
	}
	/**
	 * @param 课程名称
	 */
	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}
	/**
	 * @return 课程介绍
	 */
	public String getKcjs() {
		return kcjs;
	}
	/**
	 * @param 课程介绍
	 */
	public void setKcjs(String kcjs) {
		this.kcjs = kcjs;
	}
	/**
	 * @return 视频路径
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param 视频路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return 视频路径
	 */
	public String getSpjs() {
		return spjs;
	}
	/**
	 * @param 视频路径
	 */
	public void setSpjs(String spjs) {
		this.spjs = spjs;
	}
	/**
	 * @return 主讲人
	 */
	public String getZjr() {
		return zjr;
	}
	/**
	 * @param 主讲人
	 */
	public void setZjr(String zjr) {
		this.zjr = zjr;
	}
	/**
	 * @return 主讲人介绍
	 */
	public String getZjrjs() {
		return zjrjs;
	}
	/**
	 * @param 主讲人介绍
	 */
	public void setZjrjs(String zjrjs) {
		this.zjrjs = zjrjs;
	}
	/**
	 * @return 创建者
	 */
	public String getCjz() {
		return cjz;
	}
	/**
	 * @param 创建者
	 */
	public void setCjz(String cjz) {
		this.cjz = cjz;
	}
	/**
	 * @return 发布日期
	 */
	public Date getcDate() {
		return cDate;
	}
	/**
	 * @param 发布日期
	 */
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	/**
	 * @return 点赞数量
	 */
	public Integer getGoodCount() {
		return goodCount;
	}
	/**
	 * @param 点赞数量
	 */
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}
	/**
	 * @return 浏览量
	 */
	public Integer getViewNum() {
		return viewNum;
	}
	/**
	 * @param 浏览量
	 */
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	
	
	
	
	
}
