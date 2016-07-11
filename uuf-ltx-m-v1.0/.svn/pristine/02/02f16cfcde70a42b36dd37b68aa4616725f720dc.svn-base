package cn.uuf.stu.entity.framework;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
* <p>标题：角色域</p>
* <p>简介：</p>
* @author tangp
* @date 2015年12月31日 上午10:00:29
 */
@Table(name="uuf_wx_rolescope")
@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class RoleScope extends BaseEntity {
	
	private static final long serialVersionUID = 7407641303612000974L;
	
	/** 域*/
	public enum RSCOPE{
		/** 所有*/
		ALL,
		/** 部门*/
		YX,
		/** 个人*/
		GR,
		/** 辅导员*/
		FDY
	}
	
	/** 角色域*/
	private RSCOPE rScope;
	
	/** 排序*/
	private Integer sort;
	
	/**  备注*/
	private String bz;
	
	/**
	 * 排序
	 * @return
	 */
	public Integer getSort() {
		return sort;
	}
	
	/** 角色域名*/
	@Enumerated(EnumType.STRING)
	public RSCOPE getrScope() {
		return rScope;
	}

	/**
	 * 角色域名
	 * @param rScope
	 */
	public void setrScope(RSCOPE rScope) {
		this.rScope = rScope;
	}

	/**
	 * 排序
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 备注
	 * @return
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * 备注
	 * @param bz
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	
	
}
