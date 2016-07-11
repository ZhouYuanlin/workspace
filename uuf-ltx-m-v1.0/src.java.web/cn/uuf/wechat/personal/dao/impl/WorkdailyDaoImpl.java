package cn.uuf.wechat.personal.dao.impl;


import org.springframework.stereotype.Repository;

import cn.uuf.domain.daily.Workdaily;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.wechat.personal.dao.WorkdailyDao;

@Repository(value="workdailyDao")
public class WorkdailyDaoImpl extends BaseDaoImpl<Workdaily, Long> implements WorkdailyDao {

}
