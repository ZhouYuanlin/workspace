package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 政治面貌
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@DiscriminatorValue("zzmmb")
public class CodeZzmmb extends AbstractCode{

	private static final long serialVersionUID = -644733539770464145L;

}

