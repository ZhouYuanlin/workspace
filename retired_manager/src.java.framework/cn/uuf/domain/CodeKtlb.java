package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 课堂类别
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@DiscriminatorValue("ktlb")
public class CodeKtlb extends AbstractCode{

	private static final long serialVersionUID = -5744382410562279666L;

}

