package cn.uuf.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 高级查询条件主表
 * @author Suntingwen
 *
 */
@Entity
@Table(name="uf_code_gjcxb")
public class CodeTjb extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4740533821833370987L;
	private String code;				//代码
	private String tjbywm;				//条件表英文名
	private String tjbzwm;				//条件表中文名
	private String bz;					//说明
	
	
	private List<CodeZdytjb> zdytjbs; 	//所包含的自定义条件字段
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTjbywm() {
		return tjbywm;
	}
	public void setTjbywm(String tjbywm) {
		this.tjbywm = tjbywm;
	}
	public String getTjbzwm() {
		return tjbzwm;
	}
	public void setTjbzwm(String tjbzwm) {
		this.tjbzwm = tjbzwm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	@OneToMany(mappedBy="tjb",cascade=CascadeType.REMOVE)
	public List<CodeZdytjb> getZdytjbs() {
		return zdytjbs;
	}
	public void setZdytjbs(List<CodeZdytjb> zdytjbs) {
		this.zdytjbs = zdytjbs;
	}
	
	
}

