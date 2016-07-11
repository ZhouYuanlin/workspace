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
 * 资产管理
 * @author ll
 *
 */
@Entity
@Table(name="uf_ltx_asset")
public class AssetManage extends BaseDomain{
	private static final long serialVersionUID = 1L;
	private String assetId;   //资产编号
	private String name;   //资产名称
	private String version;//资产型号
	private long unitPrice; //单价
	private long aNum;    //数量
	private String purchaseDate;//采购日期
	private String registerDate;//登记日期
	private String shelfLife;//质保期
	
	private CodeAsset ca;	//资产类型(设备：电子设备，办公设备，物资：物资1，物资2，物资3)
	
	private CodeAssetSource codeAs;	//资产来源
	private String ls;
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getaNum() {
		return aNum;
	}

	public void setaNum(long aNum) {
		this.aNum = aNum;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	@ManyToOne
	@JoinColumn(name="ca_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public CodeAsset getCa() {
		return ca;
	}

	public void setCa(CodeAsset ca) {
		this.ca = ca;
	}
	
	@ManyToOne
	@JoinColumn(name="zcly_id")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public CodeAssetSource getCodeAs() {
		return codeAs;
	}

	public void setCodeAs(CodeAssetSource codeAs) {
		this.codeAs = codeAs;
	}
	
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	@Transient   
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}

}
