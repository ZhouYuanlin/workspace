package cn.uuf.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 养老模式
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@Table(name="uf_ltx_live")
public class Retirelive extends BaseDomain{

	private static final long serialVersionUID = 4266070028905719453L;
	@NotEmpty(message="养老模式不能为空")
	private String ylms;				//养老模式(来自码表)
	private String yldz;				//养地址
	private String ylsj;				//时间
	private String yldh;				//电话
	private String ylsm;				//备注
	private Retirement ret;				//人员
	/**
	 * @return the ylms
	 */
	public String getYlms() {
		return ylms;
	}
	/**
	 * @param ylms the ylms to set
	 */
	public void setYlms(String ylms) {
		this.ylms = ylms;
	}
	/**
	 * @return the yldz
	 */
	public String getYldz() {
		return yldz;
	}
	/**
	 * @param yldz the yldz to set
	 */
	public void setYldz(String yldz) {
		this.yldz = yldz;
	}
	/**
	 * @return the ylsj
	 */
	public String getYlsj() {
		return ylsj;
	}
	/**
	 * @param ylsj the ylsj to set
	 */
	public void setYlsj(String ylsj) {
		this.ylsj = ylsj;
	}
	/**
	 * @return the yldh
	 */
	public String getYldh() {
		return yldh;
	}
	/**
	 * @param yldh the yldh to set
	 */
	public void setYldh(String yldh) {
		this.yldh = yldh;
	}
	/**
	 * @return the ylsm
	 */
	public String getYlsm() {
		return ylsm;
	}
	/**
	 * @param ylsm the ylsm to set
	 */
	public void setYlsm(String ylsm) {
		this.ylsm = ylsm;
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

