package cn.uuf.stu.framework.util;

import java.lang.reflect.Method;

/**
* <p>标题：反射工具类</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月25日 下午8:28:22
 */
@SuppressWarnings(value = {"unchecked","unused","rawtypes"})
public final class ReflectUtil {
	
	/**
	 * 
	 * @param className 类名 全路径
	 * @param funcName 方法名
	 * @param paramMap 参数map
	 * @throws Exception
	 */
	public static Object invokeFunc(String className,String funcName,Class[] classes,Object ... objs) throws Exception{
		Class cls = Class.forName(className);
		Method method = cls.getDeclaredMethod(funcName, classes);
		return method.invoke(cls.newInstance(), objs);
	}
	
}
