package cn.uuf.domain.asset;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
/**
 * 资产领用
 * @author zkxp
 *
 */

@Entity
@Table(name="uf_ltx_assetRecord")
public class AssetRecord extends BaseDomain{
	private static final long serialVersionUID = 1L;
    private AssetFushu fushu;  //资产信息类
	private String register;   //领用登记人
	private String registerDate; //领用登记时间
	private String usePerson;   //领用人
	private String useDate; //领用时间
	private String returnTime;  //归还时间
	private String returnRegister;    //归还登记者
	private String returnRegisterTime; //归还登记时间
	private int returnState;    //归还状态  0表示：未归还    1表示已归还
	
	public String getUsePerson() {
		return usePerson;
	}
	public void setUsePerson(String usePerson) {
		this.usePerson = usePerson;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public int getReturnState() { 
		return returnState;
	}
	public void setReturnState(int returnState) {
		this.returnState = returnState;
	}
	@ManyToOne
	public AssetFushu getFushu() {
		return fushu;
	}
	public void setFushu(AssetFushu fushu) {
		this.fushu = fushu;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getReturnRegister() {
		return returnRegister;
	}
	public void setReturnRegister(String returnRegister) {
		this.returnRegister = returnRegister;
	}
	public String getReturnRegisterTime() {
		return returnRegisterTime;
	}
	public void setReturnRegisterTime(String returnRegisterTime) {
		this.returnRegisterTime = returnRegisterTime;
	}
	
	

}
