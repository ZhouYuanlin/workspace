package cn.uuf.domain.survey;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
/**
 * 问卷试卷明细表
 * @author home
 *
 */
@Entity
@Table(name = "UUF_LTX_SURVEY_QUESTIONLINE")
public class Questionline extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1173293131779049516L;
	@NotEmpty(message="账号不能为空")
	private String zh;//账号
	
	private Survey survey;//关联主表 关联主表id
	
	private Questionten questionten;//关联表、问卷试卷id
	
	private int xh;//序号
	
	private String mc;//名称
	
	private int lx;//类型
	
	private String nr;//选项内容
	
	private String ry;//人员
	
	private String wjmc;//问卷名称
	
	private String fbr;//发布人
	
	private String fbrq;//发布日期

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}
	@ManyToOne
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	@ManyToOne
	public Questionten getQuestionten() {
		return questionten;
	}

	public void setQuestionten(Questionten questionten) {
		this.questionten = questionten;
	}

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

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getRy() {
		return ry;
	}

	public void setRy(String ry) {
		this.ry = ry;
	}

	public String getWjmc() {
		return wjmc;
	}

	public void setWjmc(String wjmc) {
		this.wjmc = wjmc;
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

}
