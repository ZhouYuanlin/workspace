package cn.uuf.domain.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 首页图片轮播
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Jun 9, 2014
 */
@Entity
@Table(name="uuf_ltx_carousel")
public class Carousel extends BaseDomain{

	private static final long serialVersionUID = -5009925436143767593L;
	@NotEmpty(message="名称不能为空")
	private String name;			//名称
	@NotEmpty(message="图片地址不能为空")
	private String imgpath;			//图片地址
	private int sort;				//排序
	private Date createDate;		//创建时间
	private String ip;
	
	/**
	 * 名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 图片地址
	 * @return
	 */
	public String getImgpath() {
		return imgpath;
	}
	/**
	 * 图片地址
	 * @param imgpath
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	/**
	 * 排序
	 * @return
	 */
	public int getSort() {
		return sort;
	}
	/**
	 * 排序
	 * @param sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 创建时间
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}

