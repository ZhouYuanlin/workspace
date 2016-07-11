package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 表彰级别
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Entity
@DiscriminatorValue("jbb")
public class CodeJbb extends AbstractCode{

	private static final long serialVersionUID = 6223436902352590988L;

}

