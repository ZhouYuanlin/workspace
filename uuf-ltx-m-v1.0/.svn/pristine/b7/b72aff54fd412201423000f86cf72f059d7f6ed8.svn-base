package cn.uuf.stu.framework.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import cn.uuf.stu.framework.common.CommonAttributes;
import cn.uuf.stu.framework.common.LogConfig;
import cn.uuf.stu.framework.service.ILogConfigService;


/**
* 日志配置 service
* @ClassName: LogConfigServiceImpl 
* @author tangpeng
* @date 2015年9月8日 下午2:04:39 
*
*/
@Service(value="logConfigService")
public class LogConfigServiceImpl implements ILogConfigService {

	@SuppressWarnings("unchecked")
	@Override
	public List<LogConfig> getAll() {
		try {
			File file = new ClassPathResource(CommonAttributes.SYSTEM_PARAMETER_PATH).getFile();
			Document document = new SAXReader().read(file);
			List<org.dom4j.Element> elements = document.selectNodes("/zkxp/logConfig");
			List<LogConfig> logConfigs = new ArrayList<LogConfig>();
			for (org.dom4j.Element element : elements) {
				String operation = element.attributeValue("operation");
				String urlPattern = element.attributeValue("urlPattern");
				LogConfig logConfig = new LogConfig();
				logConfig.setOperation(operation);
				logConfig.setUrlPattern(urlPattern);
				logConfigs.add(logConfig);
			}
			return logConfigs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
