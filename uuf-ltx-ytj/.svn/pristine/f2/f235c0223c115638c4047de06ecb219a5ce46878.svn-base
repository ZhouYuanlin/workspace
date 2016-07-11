package cn.uuf.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 角色
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_role")
public class Role extends BaseDomain{
	
	private static final long serialVersionUID = -3643097611943710279L;
	@NotEmpty(message="角色名称不能为空")
	private String name;	//角色名
	private String scope;	//当前角色访问学生信息的范围
	private String description;//描述
	
	private List<Account> accounts;//用户
	private List<Resource> resources;//资源
	
	private Date createDate;	//创建时间
	private Date lastDate;	//修改时间
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
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the accounts
	 */
	@ManyToMany(mappedBy="roles")
	public List<Account> getAccounts() {
		return accounts;
	}
	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	/**
	 * @return the resources
	 */
	@ManyToMany(mappedBy="roles")
	@OrderBy(value="sort asc")
	public List<Resource> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
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
	 * @return the lastDate
	 */
	public Date getLastDate() {
		return lastDate;
	}
	/**
	 * @param lastDate the lastDate to set
	 */
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	/**
	 * 添加资源
	 * @param resource
	 */
	public void addResource(Resource resource){
		if(this.resources == null)
			this.resources = new ArrayList<Resource>();
		this.resources.add(resource);
	}
}

