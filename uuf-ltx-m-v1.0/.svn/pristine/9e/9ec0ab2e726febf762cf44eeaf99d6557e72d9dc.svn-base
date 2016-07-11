package cn.uuf.stu.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.SQLQuery;
import org.hibernate.type.DateType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Jun 4, 2015
 */
public class AddSQLQuery {

	/**
	 * 
	 * @param query
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unused")
	public static SQLQuery addScalar(SQLQuery query,Class<?> c){
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields) {
			String type = f.getType().getName();
			if(!"serialVersionUID".equals(f.getName())){
				if (type.contains("java.lang.String")) {
					query.addScalar(f.getName(),StringType.INSTANCE);
				} else if (type.contains("java.lang.Long") || type.contains("long")) {
					query.addScalar(f.getName(),LongType.INSTANCE);
				} else if (type.contains("java.lang.Integer") || type.contains("int")) {
					query.addScalar(f.getName(),IntegerType.INSTANCE);
				} else if (type.contains("java.lang.Double") || type.contains("double")) {
					query.addScalar(f.getName(),DoubleType.INSTANCE);
				} else if (type.contains("java.lang.Float") || type.contains("float")) {
					query.addScalar(f.getName(),FloatType.INSTANCE);
				} else if (type.contains("java.util.Date")) {
					query.addScalar(f.getName(),DateType.INSTANCE);
				}
			}
		}
		return query;
	}
	
	/**
	 * 第一个参数为多一个参数对像，第二个为要转成相同对像
	 * @param o1
	 * @param o2
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Object setObjectValue(Object o1,Object o2){
		try{
			Field[] fields = o1.getClass().getDeclaredFields();
			PropertyUtils pro = new PropertyUtils();
			for(Field f : fields){
				if(!"serialVersionUID".equals(f.getName()) && pro.getProperty(o1,f.getName()) != null){
					Object object = pro.getProperty(o1,f.getName());
					Method[] methods = object.getClass().getMethods();
					if(hasAttribute(methods,"getId")){
						Object property = pro.getProperty(object,"id");
						if(property==null){
							pro.setProperty(o2,f.getName().toLowerCase(),null);
							continue;
						}
					}
					pro.setProperty(o2,f.getName().toLowerCase(),pro.getProperty(o1,f.getName()));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return o2;
	}
	
	
	public static boolean hasAttribute(Method[] methods,String name){
			for (Method method : methods) {
				String name2 = method.getName();
				if(name2.equals(name)){
					return true;
				}
		}
		return false;
	}
	
	
	
}

