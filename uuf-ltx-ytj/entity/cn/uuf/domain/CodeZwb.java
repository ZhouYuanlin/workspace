package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 职务表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@DiscriminatorValue("zwb")
public class CodeZwb extends AbstractCode{

	private static final long serialVersionUID = -7538440208347161180L;

}

