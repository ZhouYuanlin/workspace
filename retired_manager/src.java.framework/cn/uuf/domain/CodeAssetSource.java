package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("assetSource")
public class CodeAssetSource extends AbstractCode{
	private static final long serialVersionUID = -1153486921616247782L;
}
