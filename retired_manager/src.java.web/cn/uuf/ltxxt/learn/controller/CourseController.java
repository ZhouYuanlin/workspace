package cn.uuf.ltxxt.learn.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.ltxxt.login.controller.BaseController;

@Controller
@RequestMapping("{course:course;*.?}")
public class CourseController extends BaseController{
	

}
