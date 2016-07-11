/**
 * 
 */
package cn.uuf.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
* @author 作者 :蒋朋
* @version 创建时间：2016年3月21日 上午10:15:20
* 类说明：财统工资
*/
@Entity
@Table(name="uf_ltx_wages")
public class Retirewages extends BaseDomain{
	
	private static final long serialVersionUID = 9121438120438654526L;
	private String xm;				//姓名 
	private String sfzh;			//身份证号(与登录表的username对应该)
	private BigDecimal ltxf;		//离退休费
	private BigDecimal shb;			//生活补
	private BigDecimal jt;			//交通
	private BigDecimal zjb;			//在京补
	private BigDecimal dhb;			//电话补
	private BigDecimal sbf;			//书报费
	private BigDecimal xl;			//洗理
	private BigDecimal hl;			//护理
	private BigDecimal zgf;			//自雇费
	private BigDecimal qt;			//其他
	private BigDecimal qtbt;		//其他补贴
	private BigDecimal bgz;			//补工资
	private BigDecimal yfxj;		//应发小计
	private BigDecimal gkxj;		//扣款小计
	private BigDecimal sfxj;		//实发小计
	private String yf;				//发放月份
	private String ffsj;			//发放时间
	private Date cjsj;				//创建时间
	
	/**
	 * @return the ffsj
	 */
	public String getFfsj() {
		return ffsj;
	}

	/**
	 * @param ffsj the ffsj to set
	 */
	public void setFfsj(String ffsj) {
		this.ffsj = ffsj;
	}
	private Retiresubsidy bjjbt;	//本级津补贴
	
	/**
	 * @return the sfzh
	 */
	public String getSfzh() {
		return sfzh;
	}

	/**
	 * @param sfzh the sfzh to set
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	/**
	 * 
	 */
	public Retirewages() {
		super();
		// TODO Auto-generated constructor stub
		this.bjjbt=new Retiresubsidy();
	}
	
	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}
	/**
	 * @param xm the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}
	/**
	 * @return the ltxf
	 */
	public BigDecimal getLtxf() {
		return ltxf;
	}
	/**
	 * @param ltxf the ltxf to set
	 */
	public void setLtxf(BigDecimal ltxf) {
		this.ltxf = ltxf;
	}
	/**
	 * @return the shb
	 */
	public BigDecimal getShb() {
		return shb;
	}
	/**
	 * @param shb the shb to set
	 */
	public void setShb(BigDecimal shb) {
		this.shb = shb;
	}
	/**
	 * @return the jt
	 */
	public BigDecimal getJt() {
		return jt;
	}
	/**
	 * @param jt the jt to set
	 */
	public void setJt(BigDecimal jt) {
		this.jt = jt;
	}
	/**
	 * @return the zjb
	 */
	public BigDecimal getZjb() {
		return zjb;
	}
	/**
	 * @param zjb the zjb to set
	 */
	public void setZjb(BigDecimal zjb) {
		this.zjb = zjb;
	}
	/**
	 * @return the dhb
	 */
	public BigDecimal getDhb() {
		return dhb;
	}

	/**
	 * @param dhb the dhb to set
	 */
	public void setDhb(BigDecimal dhb) {
		this.dhb = dhb;
	}

	/**
	 * @return the sbf
	 */
	public BigDecimal getSbf() {
		return sbf;
	}
	/**
	 * @param sbf the sbf to set
	 */
	public void setSbf(BigDecimal sbf) {
		this.sbf = sbf;
	}
	/**
	 * @return the xl
	 */
	public BigDecimal getXl() {
		return xl;
	}
	/**
	 * @param xl the xl to set
	 */
	public void setXl(BigDecimal xl) {
		this.xl = xl;
	}
	/**
	 * @return the hl
	 */
	public BigDecimal getHl() {
		return hl;
	}
	/**
	 * @param hl the hl to set
	 */
	public void setHl(BigDecimal hl) {
		this.hl = hl;
	}
	/**
	 * @return the zgf
	 */
	public BigDecimal getZgf() {
		return zgf;
	}
	/**
	 * @param zgf the zgf to set
	 */
	public void setZgf(BigDecimal zgf) {
		this.zgf = zgf;
	}
	/**
	 * @return the qt
	 */
	public BigDecimal getQt() {
		return qt;
	}
	/**
	 * @param qt the qt to set
	 */
	public void setQt(BigDecimal qt) {
		this.qt = qt;
	}
	/**
	 * @return the qtbt
	 */
	public BigDecimal getQtbt() {
		return qtbt;
	}
	/**
	 * @param qtbt the qtbt to set
	 */
	public void setQtbt(BigDecimal qtbt) {
		this.qtbt = qtbt;
	}
	/**
	 * @return the bgz
	 */
	public BigDecimal getBgz() {
		return bgz;
	}
	/**
	 * @param bgz the bgz to set
	 */
	public void setBgz(BigDecimal bgz) {
		this.bgz = bgz;
	}
	/**
	 * @return the yfxj
	 */
	public BigDecimal getYfxj() {
		return yfxj;
	}
	/**
	 * @param yfxj the yfxj to set
	 */
	public void setYfxj(BigDecimal yfxj) {
		this.yfxj = yfxj;
	}
	/**
	 * @return the gkxj
	 */
	public BigDecimal getGkxj() {
		return gkxj;
	}
	/**
	 * @param gkxj the gkxj to set
	 */
	public void setGkxj(BigDecimal gkxj) {
		this.gkxj = gkxj;
	}
	/**
	 * @return the sfxj
	 */
	public BigDecimal getSfxj() {
		return sfxj;
	}
	/**
	 * @param sfxj the sfxj to set
	 */
	public void setSfxj(BigDecimal sfxj) {
		this.sfxj = sfxj;
	}
	/**
	 * @return the yf
	 */
	public String getYf() {
		return yf;
	}
	/**
	 * @param yf the yf to set
	 */
	public void setYf(String yf) {
		this.yf = yf;
	}
	/**
	 * @return the cjsj
	 */
	public Date getCjsj() {
		return cjsj;
	}
	/**
	 * @param cjsj the cjsj to set
	 */
	public void setCjsj(Date cjsj) {
		this.cjsj = cjsj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the bjjbt
	 */
	/////
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="subsidy_id")
	public Retiresubsidy getBjjbt() {
		return bjjbt;
	}
	/**
	 * @param bjjbt the bjjbt to set
	 */
	
	public void setBjjbt(Retiresubsidy bjjbt) {
		this.bjjbt = bjjbt;
	}
	
}
