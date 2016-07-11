package cn.uuf.domain;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * 所有表的基本字段
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
@MappedSuperclass
public class BasicField implements Serializable{

	private static final long serialVersionUID = -2279833523435729415L;
	private String sfsc;			//是否删除(都不重物理上删除，走逻辑删除)
	/**
	 * @return the sfsc
	 */
	public String getSfsc() {
		return sfsc;
	}

	/**
	 * @param sfsc the sfsc to set
	 */
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
}



