package cn.uuf.domain.survey;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 问卷试卷
 * 
 * @author home
 *
 */
@Entity
@Table(name = "UUF_LTX_SURVEY_QUESTIONTEN")
public class Questionten extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6102414783832374910L;

	private int xh; //序号
	
	@NotEmpty(message="名称不能为空")
	private String mc;//名称
	
	private int lx;//类型

	private String fbr;//发布人
	
	private String fbrq;//发布日期
	
	private Survey survey;//主表关联 主表id关联
	
	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public int getLx() {
		return lx;
	}

	public void setLx(int lx) {
		this.lx = lx;
	}

	public String getFbr() {
		return fbr;
	}

	public void setFbr(String fbr) {
		this.fbr = fbr;
	}

	public String getFbrq() {
		return fbrq;
	}

	public void setFbrq(String fbrq) {
		this.fbrq = fbrq;
	}
	@ManyToOne
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
}
