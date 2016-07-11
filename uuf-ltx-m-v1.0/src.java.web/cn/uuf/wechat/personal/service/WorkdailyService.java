package cn.uuf.wechat.personal.service;

import java.util.List;

import cn.uuf.domain.daily.Workdaily;
import cn.uuf.stu.framework.service.IBaseService;

public interface WorkdailyService extends IBaseService<Workdaily, Long>{
	
	List<Workdaily> queryList(Workdaily workdaily);
}
