package cn.uuf.domain.record;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;

/**
 * 通信录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Entity
@Table(name="uf_ltx_record")
public class Retrecord extends BaseDomain{

	private static final long serialVersionUID = 6298837020928779048L;
	private String name;				//姓名
	private Retdepart departs;			//部门
	private String bgdh;				//办公电话
	private String mobile;				//手机
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
	 * @return the departs
	 */
	@ManyToOne
	public Retdepart getDeparts() {
		return departs;
	}
	/**
	 * @param departs the departs to set
	 */
	public void setDeparts(Retdepart departs) {
		this.departs = departs;
	}
	/**
	 * @return the bgdh
	 */
	public String getBgdh() {
		return bgdh;
	}
	/**
	 * @param bgdh the bgdh to set
	 */
	public void setBgdh(String bgdh) {
		this.bgdh = bgdh;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}

