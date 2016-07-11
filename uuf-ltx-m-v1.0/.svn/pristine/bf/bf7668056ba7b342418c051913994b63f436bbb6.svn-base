package cn.uuf.stu.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
* <p>标题：通用的属性</p>
* <p>简介：</p>
* @author tangp
* @date 2015年12月29日 下午9:27:42
 */
@MappedSuperclass
public abstract class CommonEntity implements Serializable {
	
	public static final String ID_PROPERTY_NAME = "id";
	
	private static final long serialVersionUID = 6586257735852173581L;

	/** "创建日期"属性名称 */
	public static final String CREATE_DATE_PROPERTY_NAME = "createDate";

	/** "修改日期"属性名称 */
	public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";

	/** 创建日期 */
	private Date createDate;

	/** 修改日期 */
	private Date modifyDate;
	
	@Column(nullable = false, updatable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(nullable = false)
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
