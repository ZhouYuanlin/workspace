package cn.uuf.wechat.personal.dao.impl;

import org.springframework.stereotype.Repository;

import cn.uuf.domain.CodeDwb;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.wechat.personal.dao.ICodeDwbDao;

@Repository(value="dwbDao")
public class CodeDwbDaoImpl extends BaseDaoImpl<CodeDwb, Long> implements ICodeDwbDao {

}
