package cn.uuf.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * 所有实体基础类
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@MappedSuperclass
public class BaseDomain extends BasicField{

	private static final long serialVersionUID = -4370798429553212862L;
	private Long id;
	/**
	 * @return the id
	 */
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ret")
    @SequenceGenerator(name="ret", sequenceName="ret_sequence")
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}

