package cn.uuf.stu.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class CommonBaseEntity extends CommonEntity {
	
	public static final String ID_PROPERTY_NAME = "id";
	
	private static final long serialVersionUID = 6889978676831608459L;
	
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
