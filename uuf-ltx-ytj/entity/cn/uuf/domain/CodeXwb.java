package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 学位表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-1
 */
@Entity
@DiscriminatorValue("xwb")
public class CodeXwb extends AbstractCode{

	private static final long serialVersionUID = 4251552764631519599L;

}

