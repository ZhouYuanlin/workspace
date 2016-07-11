package cn.uuf.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 家庭成员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@Table(name="uf_ltx_member")
public class Retiremember extends BaseDomain{

	private static final long serialVersionUID = -7623757106508269104L;
	@NotEmpty(message="成员姓名不能为空")
	private String mxm;				//成员姓名
	private String mgx;				//关系
	private String mgzdw;			//工作单位
	private String mzw;				//职务
	private String mdh;				//电话
	private String mjzgx;			//居住关系
	private String mkwpc;			//看望频次
	private Retirement ret;			//
	/**
	 * @return the mxm
	 */
	public String getMxm() {
		return mxm;
	}
	/**
	 * @param mxm the mxm to set
	 */
	public void setMxm(String mxm) {
		this.mxm = mxm;
	}
	/**
	 * @return the mgx
	 */
	public String getMgx() {
		return mgx;
	}
	/**
	 * @param mgx the mgx to set
	 */
	public void setMgx(String mgx) {
		this.mgx = mgx;
	}
	/**
	 * @return the mgzdw
	 */
	public String getMgzdw() {
		return mgzdw;
	}
	/**
	 * @param mgzdw the mgzdw to set
	 */
	public void setMgzdw(String mgzdw) {
		this.mgzdw = mgzdw;
	}
	/**
	 * @return the mzw
	 */
	public String getMzw() {
		return mzw;
	}
	/**
	 * @param mzw the mzw to set
	 */
	public void setMzw(String mzw) {
		this.mzw = mzw;
	}
	/**
	 * @return the mdh
	 */
	public String getMdh() {
		return mdh;
	}
	/**
	 * @param mdh the mdh to set
	 */
	public void setMdh(String mdh) {
		this.mdh = mdh;
	}
	/**
	 * @return the mjzgx
	 */
	public String getMjzgx() {
		return mjzgx;
	}
	/**
	 * @param mjzgx the mjzgx to set
	 */
	public void setMjzgx(String mjzgx) {
		this.mjzgx = mjzgx;
	}
	/**
	 * @return the mkwpc
	 */
	public String getMkwpc() {
		return mkwpc;
	}
	/**
	 * @param mkwpc the mkwpc to set
	 */
	public void setMkwpc(String mkwpc) {
		this.mkwpc = mkwpc;
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

