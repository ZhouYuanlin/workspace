package cn.uuf.domain.meetingroom;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;


@Entity
@Table(name="uf_meeting_apply")
public class MeetingApply extends BaseDomain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;   //会议主题
	private int attendNum;  //参会人数
	private String startTime;   //开始时间
	private String endTime;     //结束时间
	private Long applicantId; //申请编号
	private String applicantName; //申请人姓名
	private int status;       //审核状态   0表示待审核，1表示审核通过，2表示审核不通过；
	private MeetingRoom meetingRoom;//会议室信息
	private String reason;
	private String useTime;
	private String applyTime;
	private String addTime;
	//审核建议
	private String opinion;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public  MeetingApply(){
		super();
		this.meetingRoom=new MeetingRoom();
	}
	@ManyToOne
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAttendNum() {
		return attendNum;
	}
	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
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
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	

}
