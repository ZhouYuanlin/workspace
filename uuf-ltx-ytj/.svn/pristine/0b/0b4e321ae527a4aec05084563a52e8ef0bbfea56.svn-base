package cn.uuf.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 登录账户
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_account")
public class Account extends BaseDomain{

	private static final long serialVersionUID = 4321873157971303711L;
	@NotEmpty(message="登录名不能为空")
	@Pattern(regexp = "[A-Za-z0-9]{3,20}", message = "登录名为4-20位字母或数字") 
	private String username;	//登录名
	private String lxdh;		//联系电话
	private String gzzh;		//工作证号
	@Pattern(regexp = "[A-Za-z0-9]{5,60}", message = "密码不能为空，且为5-10位") 
	private String password;	//密码
	private String realname;	//真实姓名
	private String status;		//状态(启用、停用)
	private List<Role> roles;
	
	private String styleColor;		//用于存用户换肤的样式表

	private String dqsj;//账号到期时间
	public String getDqsj() {
		return dqsj;
	}

	public void setDqsj(String dqsj) {
		this.dqsj = dqsj;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the gzzh
	 */
	public String getGzzh() {
		return gzzh;
	}

	/**
	 * @param gzzh the gzzh to set
	 */
	public void setGzzh(String gzzh) {
		this.gzzh = gzzh;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
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
	 * @return the roles
	 */
	@ManyToMany
	@JoinTable(
		name="uf_account_roles",
		joinColumns={@JoinColumn(name="account_id")}, 
		inverseJoinColumns={@JoinColumn(name="role_id")}
	)
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the styleColor
	 */
	public String getStyleColor() {
		return styleColor;
	}

	/**
	 * @param styleColor the styleColor to set
	 */
	public void setStyleColor(String styleColor) {
		this.styleColor = styleColor;
	}
}

