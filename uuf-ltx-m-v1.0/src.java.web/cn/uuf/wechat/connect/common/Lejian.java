package cn.uuf.wechat.connect.common;

import javax.servlet.http.HttpServletRequest;

import org.sword.wechat4j.WechatSupport;
import org.sword.wechat4j.common.Config;

/**
* 连接类
* <p>标题：Lejian</p>
* <p>简介：</p>
* @author tl
* @date 2016年5月16日 下午7:21:50
 */
public class Lejian extends WechatSupport{
	

	public Lejian(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected void onText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onVoice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onVideo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onShortVideo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLocation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onLink() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnknown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void click() {
		Config config = Config.instance();
		String key = super.wechatRequest.getEventKey();
		System.out.println("key:"+key);
		String openId = super.wechatRequest.getFromUserName();
		switch(key){
			case "click_my_ltx":{
				System.out.println("离退休！");
				responseNew("您好，点击进入我的离退休主页面！", "", config.getUrl()+"/resources/wechat/img/welcome.jpg", config.getUrl()+"/wechat/wechatcoreconnect/index?openId="+openId);
			}break;
			case "click_my_gsjs":{
				responseNew("您好，欢迎您关注中科信普.", 
						"北京中科信普科技有限公司（UUFocus Technology Co., Ltd.）位于北京中关村高科技园区，是一家专门从事政府、教育、企业信息技术开发和服务的高新技术企业。", 
						"http://mmbiz.qpic.cn/mmbiz/fXHqSbqf6yyQIiagKLlRL0iccM3XVx5rCOfdIRUVDwueDc09cwZzMOuBAnSWiaRyHofibU4PINkRrnNicE6zVqLCVSg/640?wx_fmt=jpeg&wxfrom=5", 
						"http://mp.weixin.qq.com/s?__biz=MzI0MTEzODIxNg==&mid=401857971&idx=1&sn=ab4d92a93d94fb4ccbd9098ed38ce3ab#rd");
				
			}break;
			case "click_my_ltxgzxt":{
				responseNew("离退休工作管理系统 ", 
						"", 
						"http://mmbiz.qpic.cn/mmbiz/fXHqSbqf6yzgI1VE5yCOWDCKmY5SmIS8SfSTzaSNzHRYrYY5MibTbYmYOk9FL4kkiaraHoicKmY52UFLiaCjjQpXCA/640?wx_fmt=jpeg&wxfrom=5", 
						"http://mp.weixin.qq.com/s?__biz=MzI0MTEzODIxNg==&mid=402394559&idx=1&sn=3c243582787c6ebe8b1a6338f85f1a28#rd");
			}break;
			case "click_my_wx":{
				responseNew("微信应用 ", 
						"        微信应用是我们公司新上的系统， 旨在解决用户使用手机等移动终端查阅自已的信息以及办理与自已相关的业务。\n        微信应用的上线可以使用户既轻松的解决自已的问题， 又避免了繁琐的APP安装及设置工作。极大的提高了系统用户的可操作性。", 
						"http://mmbiz.qpic.cn/mmbiz/fXHqSbqf6yyRctNOiao7iaKEyVV85BMXicx4e0KF0GQuT24hzn9brmoBEK5a8uibKNTnWwhY5u4t5LiaMPhEhibANhqw/640?wx_fmt=png&wxfrom=5&wx_lazy=1", 
						"http://mp.weixin.qq.com/s?__biz=MzI0MTEzODIxNg==&mid=403089046&idx=1&sn=2a9ddebd93caffa3309461133daa1424#rd");
			}break;
		}
	}

	@Override
	protected void subscribe() {
		responseNew("您好，欢迎您关注中科信普！", 
				"        北京中科信普科技有限公司（UUFocus Technology Co., Ltd.）位于北京中关村高科技园区，是一家专门从事政府、教育、企业信息技术开发和服务的高新技术企业。公司立足于互联网+信息服务平台，专注于解决传统管理和服务工作中的痛点，为客户提供管理、服务与IT融为一体的信息化解决方案和产品，让工作变得更加便捷和高效。", 
				"http://mmbiz.qpic.cn/mmbiz/fXHqSbqf6yyQIiagKLlRL0iccM3XVx5rCOfdIRUVDwueDc09cwZzMOuBAnSWiaRyHofibU4PINkRrnNicE6zVqLCVSg/640?wx_fmt=jpeg&wxfrom=5", 
				"");
	}

	@Override
	protected void unSubscribe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void scan() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void location() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void view() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void templateMsgCallback() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void scanCodePush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void scanCodeWaitMsg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void picSysPhoto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void picPhotoOrAlbum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void picWeixin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void locationSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void kfCreateSession() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void kfCloseSession() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void kfSwitchSession() {
		// TODO Auto-generated method stub
		
	}

}
