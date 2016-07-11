package cn.uuf.stu.entity.framework;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
* 资源
* @ClassName: Resource 
* @author tangpeng
* @date 2015年7月31日 下午4:00:11 
*/
@Entity
@Table(name="uuf_wx_resource")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WResource extends BaseEntity {
	private static final long serialVersionUID = 2388398470447113575L;
	
	/** 资源名称*/
	private String resourceName;
	
	/** 类型*/
	public enum Type{
		/** 一级菜单*/
		onemenu,
		/** 二级菜单*/
		twomenu,
		/** 按钮*/
		button
	}
	
	/** 类型*/
	private Type type;
	
	/** 访问路径*/
	private String accessUrl;
	
	/** 权限字符串*/
	private String permissionString;
	
	/** 是否启用*/
	private Boolean isEnabled;
	
	/** 排序*/
	private Integer sort;
	
	/** 菜单图片名字*/
	private String menuImgName;
	
	/** 按钮的样式名*/
	private String buttonCssName;
	
	/** 按钮的ID名*/
	private String buttonIdName;
	
	private String buttonHref;
	
	private String buttonDataToggle;
	
	/** 角色*/
	private List<WRole> roles;
	
	/** 父节点*/
	private WResource parent;
	
	/** 子节点*/
	private List<WResource> childrens;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(nullable=true)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAccessUrl() {
		return accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public String getButtonIdName() {
		return buttonIdName;
	}

	public void setButtonIdName(String buttonIdName) {
		this.buttonIdName = buttonIdName;
	}

	public String getPermissionString() {
		return permissionString;
	}

	public void setPermissionString(String permissionString) {
		this.permissionString = permissionString;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Integer getSort() {
		return sort;
	}

	/**
	 * @return the buttonHref
	 */
	public String getButtonHref() {
		return buttonHref;
	}

	/**
	 * @param buttonHref the buttonHref to set
	 */
	public void setButtonHref(String buttonHref) {
		this.buttonHref = buttonHref;
	}

	/**
	 * @return the buttonDataToggle
	 */
	public String getButtonDataToggle() {
		return buttonDataToggle;
	}

	/**
	 * @param buttonDataToggle the buttonDataToggle to set
	 */
	public void setButtonDataToggle(String buttonDataToggle) {
		this.buttonDataToggle = buttonDataToggle;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public WResource getParent() {
		return parent;
	}

	public void setParent(WResource parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy = "parent",cascade=CascadeType.PERSIST)
	@OrderBy(value="sort asc")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<WResource> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<WResource> childrens) {
		this.childrens = childrens;
	}
	
	//角色维护关联关系
	@ManyToMany(mappedBy="resoures",fetch=FetchType.LAZY)
	public List<WRole> getRoles() {
		return roles;
	}

	public void setRoles(List<WRole> roles) {
		this.roles = roles;
	}

	public String getMenuImgName() {
		return menuImgName;
	}

	public void setMenuImgName(String menuImgName) {
		this.menuImgName = menuImgName;
	}

	public String getButtonCssName() {
		return buttonCssName;
	}

	public void setButtonCssName(String buttonCssName) {
		this.buttonCssName = buttonCssName;
	}
	
}
