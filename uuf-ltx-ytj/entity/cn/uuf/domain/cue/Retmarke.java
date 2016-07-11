package cn.uuf.domain.cue;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 提示语
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-24
 */
@Entity
@Table(name="uf_marke")
public class Retmarke extends BaseDomain{

	private static final long serialVersionUID = -8750628933581927378L;
	@NotEmpty(message="开始时间不能为空")
	private String kssj;				//开始时间
	@NotEmpty(message="结束时间不能为空")
	private String jssj;				//结束时间
	@NotEmpty(message="提示语不能为空")
	private String content;				//提示语
	/**
	 * @return the kssj
	 */
	public String getKssj() {
		return kssj;
	}
	/**
	 * @param kssj the kssj to set
	 */
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	/**
	 * @return the jssj
	 */
	public String getJssj() {
		return jssj;
	}
	/**
	 * @param jssj the jssj to set
	 */
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}

