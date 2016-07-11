package cn.uuf.stu.entity.framework;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import cn.uuf.stu.entity.base.CommonEntity;

/**
* 实体基类
* @ClassName: BaseEntity 
* @author tangpeng
* @date 2015年7月31日 下午2:57:05 
*
*/
@MappedSuperclass
public abstract class BaseEntity extends CommonEntity {

	private static final long serialVersionUID = 5213109003118324971L;
	
	/** ID */
	private Long id;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="frame")
	@SequenceGenerator(name="frame",sequenceName="frame_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
