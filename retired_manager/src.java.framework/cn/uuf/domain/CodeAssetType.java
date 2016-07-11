package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 设备为电子设备，办公设备
 * 物资分为xxxxx
 * @author ll
 *
 */
@Entity
@DiscriminatorValue("aType")
public class CodeAssetType extends AbstractCode{
	private static final long serialVersionUID = -7133690835816298788L;
}
