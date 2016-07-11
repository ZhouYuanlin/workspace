package cn.uuf.stu.framework.dao.impl;

import org.springframework.stereotype.Repository;

import cn.uuf.stu.entity.framework.RoleScope;
import cn.uuf.stu.framework.dao.IRoleScopeDao;

@Repository(value="roleScopeDao")
public class RoleScopeDaoImpl extends BaseDaoImpl<RoleScope, Long> implements IRoleScopeDao {

}
