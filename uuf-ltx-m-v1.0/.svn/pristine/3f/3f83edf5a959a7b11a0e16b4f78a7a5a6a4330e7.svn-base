package cn.uuf.stu.framework.util;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import cn.uuf.stu.framework.common.CommonAttributes;
import cn.uuf.stu.framework.common.EnumConverter;
import cn.uuf.stu.framework.common.SystemParamter;


/**
* 系统参数
* @ClassName: SystemParamterUtils 
* @author tangpeng
* @date 2015年8月4日 下午9:24:53 
*
 */
public final class SystemParamterUtils {
	
	/**缓存管理*/
	private static final CacheManager cacheManager = CacheManager.create();
	
	private static final BeanUtilsBean beanUtils;
	
	static{
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean() {
			@Override
			public String convert(Object value) {
				if (value != null) {
					Class<?> type = value.getClass();
					if (type.isEnum() && super.lookup(type) == null) {
						super.register(new EnumConverter(type), type);
					} else if (type.isArray() && type.getComponentType().isEnum()) {
						if (super.lookup(type) == null) {
							ArrayConverter arrayConverter = new ArrayConverter(type, new EnumConverter(type.getComponentType()), 0);
							arrayConverter.setOnlyFirstToString(false);
							super.register(arrayConverter, type);
						}
						Converter converter = super.lookup(type);
						return ((String) converter.convert(String.class, value));
					}
				}
				return super.convert(value);
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(String value, Class clazz) {
				if (clazz.isEnum() && super.lookup(clazz) == null) {
					super.register(new EnumConverter(clazz), clazz);
				}
				return super.convert(value, clazz);
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(String[] values, Class clazz) {
				if (clazz.isArray() && clazz.getComponentType().isEnum() && super.lookup(clazz.getComponentType()) == null) {
					super.register(new EnumConverter(clazz.getComponentType()), clazz.getComponentType());
				}
				return super.convert(values, clazz);
			}

			@Override
			@SuppressWarnings("rawtypes")
			public Object convert(Object value, Class targetType) {
				if (super.lookup(targetType) == null) {
					if (targetType.isEnum()) {
						super.register(new EnumConverter(targetType), targetType);
					} else if (targetType.isArray() && targetType.getComponentType().isEnum()) {
						ArrayConverter arrayConverter = new ArrayConverter(targetType, new EnumConverter(targetType.getComponentType()), 0);
						arrayConverter.setOnlyFirstToString(false);
						super.register(arrayConverter, targetType);
					}
				}
				return super.convert(value, targetType);
			}
		};

		DateConverter dateConverter = new DateConverter();
		dateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
		convertUtilsBean.register(dateConverter, Date.class);
		beanUtils = new BeanUtilsBean(convertUtilsBean);
	}
	
	/**
	 * 不可实例化
	 */
	private SystemParamterUtils() {
	}
	
	/**
	 * 获取系统设置
	 * 
	 * @return 系统设置
	 */
	@SuppressWarnings("unchecked")
	public static SystemParamter get() {
		Ehcache cache = cacheManager.getEhcache(SystemParamter.CACHE_NAME);
		net.sf.ehcache.Element cacheElement = cache.get(SystemParamter.CACHE_KEY);
		SystemParamter setting;
		if (cacheElement != null) {
			setting = (SystemParamter) cacheElement.getObjectValue();
		} else {
			setting = new SystemParamter();
			try {
				File zkxpXmlFile = new ClassPathResource(CommonAttributes.SYSTEM_PARAMETER_PATH).getFile();
				Document document = new SAXReader().read(zkxpXmlFile);
				List<Element> elements = document.selectNodes("/zkxp/system");
				for (Element element : elements) {
					String name = element.attributeValue("name");
					String value = element.attributeValue("value");
					try {
						beanUtils.setProperty(setting, name, value);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			cache.put(new net.sf.ehcache.Element(SystemParamter.CACHE_KEY, setting));
		}
		return setting;
	}
	
	
}
