package cn.uuf.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Entity
@Table(name="uf_code_option")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public abstract class AbstractCode extends BaseDomain{

	private static final long serialVersionUID = -3234815525682406138L;
	@NotEmpty(message="代码不能为空")
	@Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "代码为2-20位")
	private String code;			//代码
	@NotEmpty(message="名称不能为空")
	private String name;			//名称
	private String bz;				//备注
	private String sfejdw;			//是否二级单位
	/**
	 * 代码
	 * @return
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 代码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 备注
	 * @return
	 */
	@Column(length=2000)
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
	/**
	 * 是否二级单位
	 * @return
	 */
	public String getSfejdw() {
		return sfejdw;
	}
	/**
	 * 是否二级单位
	 * @param sfejdw
	 */
	public void setSfejdw(String sfejdw) {
		this.sfejdw = sfejdw;
	}
	
	
}

