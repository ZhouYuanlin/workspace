package cn.uuf.stu.entity.framework;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
* 账号 account
* @ClassName: Account 
* @author tangpeng
* @date 2015年8月11日 下午12:28:15 
*
*/
@Entity
@Table(name="uuf_wx_account")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class WAccount extends BaseEntity {
	private static final long serialVersionUID = 1493213459675291156L;
	
	/** 用户名*/
	private String username;
	
	/** 身份证号码*/
	private String sfzh;
	
	/** 密码*/
	private String password;
	
	/** 是否启用*/
	private Boolean isEnabled;
	
	/** 是否锁住*/
	private Boolean isLocked;
	
	/** 登录失败次数*/
	private Integer loginFailureCount;
	
	/** 锁住时间*/
	private Date lockedDate;
	
	/** 登录时间*/
	private Date loginDate;
	
	/** 最后登录IP*/
	private String loginIp;
	
	//激活(1表示激活，0表示未激活)
	private String activate;
	
	private Date jhsj; //激活时间
	
	/**
	 * 姓名
	 */
	private String xm;
	
	/** 角色集*/
	private List<WRole> roles;
	
	
	/**
	* 获取用户名
	* @return    
	* String
	*/
	@NotEmpty(groups = Save.class)
	@Pattern(regexp = "^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
	@Length(min = 2, max = 20)
	@Column(nullable = false,updatable = false,unique = true)
	public String getUsername() {
		return username;
	}
	
	/**
	* 设置用户名
	* @param username    
	* void
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	* 获取密码
	* @return    
	* String
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	* 设置密码
	* @param password    
	* void
	*/
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	* 获得启用状态
	* @return    
	* Boolean
	*/
	@NotNull
	@Column(nullable = false)
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	/**
	* 设置启用状态
	* @param isEnabled    
	* void
	*/
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	/**
	* 获得锁状态
	* @return    
	* Boolean
	*/
	@Column(nullable = false)
	public Boolean getIsLocked() {
		return isLocked;
	}
	
	/**
	* 设置锁状态
	* @param isLocked    
	* void
	 */
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	/**
	 * @return the activate
	 */
	public String getActivate() {
		return activate;
	}

	/**
	 * @param activate the activate to set
	 */
	public void setActivate(String activate) {
		this.activate = activate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
    
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="uuf_wx_account_role",
			joinColumns={@JoinColumn(name="account_id")},
			inverseJoinColumns={@JoinColumn(name="role_id")}
			)
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	public List<WRole> getRoles() {
		return roles;
	}

	public void setRoles(List<WRole> roles) {
		this.roles = roles;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Date getJhsj() {
		return jhsj;
	}

	public void setJhsj(Date jhsj) {
		this.jhsj = jhsj;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
	
	
}
