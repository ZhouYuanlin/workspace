package cn.uuf.domain.activity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;

/**
 * 添动管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Entity
@Table(name="uf_activity_release")
public class Activity extends BaseDomain{

	private static final long serialVersionUID = -4789138893225049721L;
	
	private String activityName;		//活动名称
	private String address;				//活动地点
	private String startTime;				//开始时间
	private String endTime;					//结束时间
	private String introduction;		//活动介绍
	private String person;				//负责人
	private String tel;				//电话
	private String remarks;				//备注	
	private String carNumber;			//车辆数量	
	private String peopleNub;		//乘坐人数
	private String addEndTime;				//活动结束时间
	private String imgurl;		    //网络图片路径带URL，通过系统设置中进行捕捉前缀域名
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public String getPeopleNub() {
		return peopleNub;
	}
	public void setPeopleNub(String peopleNub) {
		this.peopleNub = peopleNub;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddEndTime() {
		return addEndTime;
	}
	public void setAddEndTime(String addEndTime) {
		this.addEndTime = addEndTime;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	
}

