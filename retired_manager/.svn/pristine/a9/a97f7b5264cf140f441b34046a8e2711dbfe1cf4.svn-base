package cn.uuf.domain.record;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 通信录部门
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Entity
@Table(name="uf_ltx_depart")
public class Retdepart extends BaseDomain{

	private static final long serialVersionUID = -2175078094281843316L;
	@NotEmpty(message="部门名称不能为空")
	private String name;				//部门名称
	private Retdepart parent;			//父类
	private List<Retdepart> children;	//子类
	private List<Retrecord> records;	//人员或联系方式
	private String bz;					//说明
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
	 * @return the parent
	 */
	@ManyToOne
	public Retdepart getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Retdepart parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	@OneToMany(mappedBy = "parent",cascade=CascadeType.REMOVE)
	@OrderBy(value=" id asc")
	public List<Retdepart> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Retdepart> children) {
		this.children = children;
	}
	/**
	 * @return the bz
	 */
	@Column(length=4000)
	public String getBz() {
		return bz;
	}
	/**
	 * @param bz the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * @return the records
	 */
	@OneToMany(mappedBy="departs",cascade=CascadeType.REMOVE)
	public List<Retrecord> getRecords() {
		return records;
	}
	/**
	 * @param records the records to set
	 */
	public void setRecords(List<Retrecord> records) {
		this.records = records;
	}
	/**
	 * 添加通信录
	 * @param r
	 */
	public void addRecords(Retrecord r){
		if(this.records == null)
			this.records = new ArrayList<Retrecord>();
		this.records.add(r);
	}
}

