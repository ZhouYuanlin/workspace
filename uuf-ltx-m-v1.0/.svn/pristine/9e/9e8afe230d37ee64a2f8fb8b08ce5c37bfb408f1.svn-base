package cn.uuf.stu.framework.common;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import cn.uuf.stu.entity.base.CommonEntity;



/**
* 实体操作拦截
* @ClassName: EntityStatusIntercepter 
* @author tangpeng 
* @date 2015年8月6日 下午5:53:08 
*
**/
@Component("entityOperateIntercepter")
public class EntityOperateIntercepter extends EmptyInterceptor {
	private static final long serialVersionUID = 4586857719394785345L;
	
	/**
	 * 保存实体之前为实体添加属性值
	 */
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if(entity instanceof CommonEntity){
			CommonEntity baseEntity = (CommonEntity) entity;
			baseEntity = (CommonEntity) entity;
			Date date = new Date();
			baseEntity.setCreateDate(date);
			baseEntity.setModifyDate(date);
			state[0]= date;
			state[1]= date;
			return super.onSave(baseEntity, id, state, propertyNames, types);
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}

	/**
	 * 更新实体对象之前为实体对象修改属性值
	 */
	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if(entity instanceof CommonEntity){ 
			CommonEntity baseEntity = (CommonEntity) entity;
			Date date = new Date();
			baseEntity.setModifyDate(new Date());
			currentState[1] = date;
			return super.onFlushDirty(baseEntity, id, currentState, previousState,
					propertyNames, types);
		}
		return super.onFlushDirty(entity, id, currentState, previousState,
				propertyNames, types);
		
	}
	
	
	
	
}
