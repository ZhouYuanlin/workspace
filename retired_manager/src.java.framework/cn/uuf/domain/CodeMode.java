package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 养老模式
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Entity
@DiscriminatorValue("mode")
public class CodeMode extends AbstractCode{

	private static final long serialVersionUID = 8679098130304565091L;

}

