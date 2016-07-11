package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 资产类型表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@DiscriminatorValue("asset")
public class CodeAsset extends AbstractCode{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6765901272991315133L;
	private Long assetId;					//类别属于哪个类型
	/**
	 * 
	 * @return
	 */
	public Long getAssetId() {
		return assetId;
	}
	/**
	 * 
	 * @param assetId
	 */
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

}
