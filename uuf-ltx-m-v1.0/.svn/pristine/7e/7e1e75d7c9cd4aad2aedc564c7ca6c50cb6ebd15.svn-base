package cn.uuf.wechat.connect.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.User;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.connect.dao.IUserDao;
import cn.uuf.wechat.connect.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements IUserService {
	
	@Resource
	private void setBaseDao(IUserDao userDao){
		super.setBaseDao(userDao);
	}
}
