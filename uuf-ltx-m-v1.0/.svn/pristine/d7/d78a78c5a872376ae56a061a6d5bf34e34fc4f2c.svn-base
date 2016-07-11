package cn.uuf.stu.entity.framework;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
* 角色
* @ClassName: Role 
* @author tangpeng
* @date 2015年7月31日 下午3:48:41 
*/
@Entity
@Table(name="uuf_wx_role")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WRole extends BaseEntity {
	
	private static final long serialVersionUID = 4664369109566229632L;

	/** 角色名*/
	private String roleName;
	
	/** 是否超级管理员*/
	private Boolean isSuperAdministrator;
	
	/** 角色描述*/
	private String decription;
	
	/** 账号*/
	private List<WAccount> accounts;
	
	/** 资源集*/
	private List<WResource> resoures;
	
	/** 角色域*/
	private RoleScope roleScope;
	
	
	
	/** 首页模块信息*/
	private IndexShow indexShow;

	@NotEmpty
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getIsSuperAdministrator() {
		return isSuperAdministrator;
	}

	public void setIsSuperAdministrator(Boolean isSuperAdministrator) {
		this.isSuperAdministrator = isSuperAdministrator;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	//账号维护关联关系
	@ManyToMany(mappedBy="roles",fetch=FetchType.LAZY)
	public List<WAccount> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<WAccount> accounts) {
		this.accounts = accounts;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="uuf_wx_role_resoure",
			joinColumns = {@JoinColumn(name="role_id")},
			inverseJoinColumns = {@JoinColumn(name="resource_id")}
			)
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<WResource> getResoures() {
		return resoures;
	}

	public void setResoures(List<WResource> resoures) {
		this.resoures = resoures;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rolescope_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public RoleScope getRoleScope() {
		return roleScope;
	}

	public void setRoleScope(RoleScope roleScope) {
		this.roleScope = roleScope;
	}
	
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="indexshow_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public IndexShow getIndexShow() {
		return indexShow;
	}

	public void setIndexShow(IndexShow indexShow) {
		this.indexShow = indexShow;
	}	
}
