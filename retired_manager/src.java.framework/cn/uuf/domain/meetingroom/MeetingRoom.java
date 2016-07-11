package cn.uuf.domain.meetingroom;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.Account;
import cn.uuf.domain.BaseDomain;

@Entity
@Table(name="uf_meeting_info")
public class MeetingRoom extends BaseDomain{

	/**
	 * 会议室信息表
	 */
	private static final long serialVersionUID = 1L;
	private String name;   //会议室名称
	private String address;   //会议室地址
	private Integer enableState;        //是否启用   1表示启用  0或者null表示停用或者禁用 
	private Integer upperLimit;         //最大使用人数
	private String description;     //说明
	private String area;            //面积
	private String imgurl;		    //网络图片路径带URL，通过系统设置中进行捕捉前缀域名
	private Account ac;  //用户信息类
	private String device;        //会议室设备
	private String createDate;   //创建时间
	private String updateDate;   //更新时间
	
	@ManyToOne
	public Account getAc() {
		return ac;
	}
	public void setAc(Account ac) {
		this.ac = ac;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getEnableState() {
		return enableState;
	}
	public void setEnableState(Integer enableState) {
		this.enableState = enableState;
	}
	public Integer getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	
}
