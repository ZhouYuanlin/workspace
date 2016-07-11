package cn.uuf.domain.asset;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.CodeAsset;
import cn.uuf.domain.CodeAssetSource;

/**
 * 资产附属
 * @author ll
 *
 */
@Entity
@Table(name="uf_ltx_assetSubsidiary")
public class AssetFushu extends BaseDomain{
	private static final long serialVersionUID = 1L;
	private String assetId;   //资产编号
	private int useState;        //是否领用   1表示领用  0或者null表示停用或者未领用
	private String usePerson;   //领用人
	private String useDate;    //领用时间
	private String returnTime;    //归还时间
	private AssetManage assetManage;	//资产管理信息类
	private String ls;
	
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public int getUseState() {
		return useState;
	}
	public void setUseState(int useState) {
		this.useState = useState;
	}
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
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	@Transient   
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}
	@ManyToOne
	public AssetManage getAssetManage() {
		return assetManage;
	}
	public void setAssetManage(AssetManage assetManage) {
		this.assetManage = assetManage;
	}

}
