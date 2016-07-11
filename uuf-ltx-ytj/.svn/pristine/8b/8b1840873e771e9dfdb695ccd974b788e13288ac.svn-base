package cn.uuf.domain.message;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 通知公告
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-21
 */
@Entity
@Table(name="uf_ltx_notice")
public class Notice extends BaseDomain{

	private static final long serialVersionUID = 6885312142001553429L;
	@NotEmpty(message="标题不能为空")
	private String title;				//标题
	private Date createDate;			//发布时间
	private String attach;				//附件
	private String content;				//内容
	private String dwbs;				//发给哪些部门的通知可见，其它部门不可见，为空限都可见。(存部门id，不做关联)
	private String fbz;					//发布者
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the content
	 */
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	@Column(columnDefinition="CLOB", nullable=true) 
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the dwbs
	 */
	public String getDwbs() {
		return dwbs;
	}
	/**
	 * @param dwbs the dwbs to set
	 */
	public void setDwbs(String dwbs) {
		this.dwbs = dwbs;
	}
	/**
	 * @return the fbz
	 */
	public String getFbz() {
		return fbz;
	}
	/**
	 * @param fbz the fbz to set
	 */
	public void setFbz(String fbz) {
		this.fbz = fbz;
	}
	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}
	/**
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
}

