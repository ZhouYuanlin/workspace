package cn.uuf.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 高级查询自定义条件
 * @author Suntingwen
 *
 */
@Entity
@Table(name="uf_code_zdytjb")
public class CodeZdytjb extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9134233555252405824L;
	
	private String code;			//代码
	private String zdywm;			//字段英文名
	private String zdzwm;			//字段中文名
	private String sfxs;			//是否显示
	private String texttype;		//文本类型
	private String textvalue;     	//文本值
	private String bz;				//说明
	private CodeTjb tjb;			//属于哪个表的字段
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getZdywm() {
		return zdywm;
	}
	public void setZdywm(String zdywm) {
		this.zdywm = zdywm;
	}
	public String getZdzwm() {
		return zdzwm;
	}
	public void setZdzwm(String zdzwm) {
		this.zdzwm = zdzwm;
	}
	public String getSfxs() {
		return sfxs;
	}
	public void setSfxs(String sfxs) {
		this.sfxs = sfxs;
	}
	public String getTexttype() {
		return texttype;
	}
	public void setTexttype(String texttype) {
		this.texttype = texttype;
	}
	public String getTextvalue() {
		return textvalue;
	}
	public void setTextvalue(String textvalue) {
		this.textvalue = textvalue;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	@ManyToOne
	public CodeTjb getTjb() {
		return tjb;
	}
	public void setTjb(CodeTjb tjb) {
		this.tjb = tjb;
	}
	
	

}

