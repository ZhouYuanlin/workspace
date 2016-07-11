package cn.uuf.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 去掉字符串中的带脚本注入的特殊符号
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Jul 14, 2015
 */
public class CleanStringUtil {

	/**
	 * 去掉注入脚本
	 * @param inputString
	 * @return
	 */
	public static String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_html1;
		Matcher m_html1;
		try {
			String regEx_html2 = "<([^>]*)>";
			p_html1 = Pattern.compile(regEx_html2, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
		}

		return textStr;// 返回文本字符串
	}
	
		@SuppressWarnings("static-access")
		public static Object CleanObj(Object o1,Object o2){
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
	
	public static void main(String[] args) {
	}
}

