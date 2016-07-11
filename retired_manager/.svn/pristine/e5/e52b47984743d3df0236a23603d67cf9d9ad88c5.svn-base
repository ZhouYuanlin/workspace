package cn.uuf.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_resource")
public class Resource extends BaseDomain{

	private static final long serialVersionUID = 5469329402104653881L;
	@NotEmpty(message="代码为能空")
	private String code;	//菜单代码，用于页面分层
	@NotEmpty(message="菜单名称不能为空")
	private String name;	//菜单名称
	private String action;	//菜单url
	private String imageUrl;//父页面显示图片地址
	
	private Boolean ifleaf;	//是否叶子节点 0表示不是叶子节点，1表示是叶子节点
	private String status;	//状态
	@NotNull(message="排序号不能为空")
	private Integer sort;		//排序
	
	private Resource parent;
	private List<Resource> children;//子项
	private List<Role> roles;		//可访问的角色
	//新增控制操作方法显示、隐藏
	private String aalias;			//别名如id="mysp";
	private String aclass;			//连接的样式
	private String iclass;			//<li中的样式
	private String ahref;			//连接方法可以写javascript:void(0)
	private String domethod;		//调用方法
	private String arole;			//连接上的属性个别的会有用到
	private String data_toggle;		//连接上的属性个别的会有用到
	private String data_formid;		//连接上的属性个别的会有用到
	private String data_action;		//连接上的属性个别的会有用到
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the ifleaf
	 */
	public Boolean getIfleaf() {
		return ifleaf;
	}
	/**
	 * @param ifleaf the ifleaf to set
	 */
	public void setIfleaf(Boolean ifleaf) {
		this.ifleaf = ifleaf;
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
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * @return the parent
	 */
	@ManyToOne
	public Resource getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Resource parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	@OneToMany(mappedBy = "parent",cascade=CascadeType.ALL)
	@OrderBy(value="sort ASC")
	public List<Resource> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Resource> children) {
		this.children = children;
	}
	/**
	 * @return the roles
	 */
	@ManyToMany
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
	 * 加入可访问角色
	 * @param role
	 */
	public void addRoles(Role role){
		if(this.roles == null)
			this.roles = new ArrayList<Role>();
		this.roles.add(role);
	}
	/**
	 * 添加子类
	 * @param resource
	 */
	public void addChildren(Resource resource){
		if(this.children == null)
			this.children = new ArrayList<Resource>();
		this.children.add(resource);
	}
	/**
	 * @return the domethod
	 */
	public String getDomethod() {
		return domethod;
	}
	/**
	 * @param domethod the domethod to set
	 */
	public void setDomethod(String domethod) {
		this.domethod = domethod;
	}
	/**
	 * @return the aalias
	 */
	public String getAalias() {
		return aalias;
	}
	/**
	 * @param aalias the aalias to set
	 */
	public void setAalias(String aalias) {
		this.aalias = aalias;
	}
	/**
	 * @return the aclass
	 */
	public String getAclass() {
		return aclass;
	}
	/**
	 * @param aclass the aclass to set
	 */
	public void setAclass(String aclass) {
		this.aclass = aclass;
	}
	/**
	 * @return the iclass
	 */
	public String getIclass() {
		return iclass;
	}
	/**
	 * @param iclass the iclass to set
	 */
	public void setIclass(String iclass) {
		this.iclass = iclass;
	}
	/**
	 * @return the ahref
	 */
	public String getAhref() {
		return ahref;
	}
	/**
	 * @param ahref the ahref to set
	 */
	public void setAhref(String ahref) {
		this.ahref = ahref;
	}
	/**
	 * @return the arole
	 */
	public String getArole() {
		return arole;
	}
	/**
	 * @param arole the arole to set
	 */
	public void setArole(String arole) {
		this.arole = arole;
	}
	/**
	 * @return the data_toggle
	 */
	public String getData_toggle() {
		return data_toggle;
	}
	/**
	 * @param data_toggle the data_toggle to set
	 */
	public void setData_toggle(String data_toggle) {
		this.data_toggle = data_toggle;
	}
	/**
	 * @return the data_formid
	 */
	public String getData_formid() {
		return data_formid;
	}
	/**
	 * @param data_formid the data_formid to set
	 */
	public void setData_formid(String data_formid) {
		this.data_formid = data_formid;
	}
	/**
	 * @return the data_action
	 */
	public String getData_action() {
		return data_action;
	}
	/**
	 * @param data_action the data_action to set
	 */
	public void setData_action(String data_action) {
		this.data_action = data_action;
	}
	
}

