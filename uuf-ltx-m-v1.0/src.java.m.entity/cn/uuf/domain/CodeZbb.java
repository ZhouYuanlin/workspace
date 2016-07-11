package cn.uuf.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 正部级、副部级按部级统计，正副地局司级按局级统计，正副处级按处级统计、正副科级按科级统计
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-15
 */
@Entity
@DiscriminatorValue("zbb")
public class CodeZbb extends AbstractCode{

	private static final long serialVersionUID = -7133690835816298788L;

}


