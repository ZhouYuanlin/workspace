package cn.uuf.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 离退休人员工作经历
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@Table(name="uf_ltx_work")
public class Retirework extends BaseDomain{

	private static final long serialVersionUID = -6148106030226117005L;
	//	private Date gzsj;				//参加工作时间
//	private Date jssj;				//离退休时间
	private String content;		//工作经历(描述)
	private Retirement ret;			//退休人员
	private Date createDate;
	
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
	 * @return the ret
	 */
	@ManyToOne
	public Retirement getRet() {
		return ret;
	}
	
	/**
	 * @param ret the ret to set
	 */
	public void setRet(Retirement ret) {
		this.ret = ret;
	}
}

