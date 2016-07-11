package cn.uuf.domain.car;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;

/**
 * 车辆信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_use_apply")
public class Carapply extends BaseDomain{

	private static final long serialVersionUID = 1L;

	//车辆信息类
	private Carinfo carinfo ;
	
	//录入人id
	private Long applyId;
	
	//使用人
	@NotEmpty(message="使用人不能为空")
	private String applyName;	
	
	//使用日期
	@NotEmpty(message="使用日期不能为空")
	private String useTime;	
	
	//使用开始时间
	@NotEmpty(message="使用开始时间不能为空")
	private String startTime;	

	//使用结束时间
	@NotEmpty(message="使用结束时间不能为空")
	private String endTime;	
	
	//乘车人数
	@NotEmpty(message="乘车人数不能为空")
	private String peopleNumber;
	
	//联系电话
	@NotEmpty(message="联系电话不能为空")
	private String tel;
	
	//使用原因
	@NotEmpty(message="使用原因不能为空")
	private String peason;
	
	//审核状态
	@NotEmpty(message="审核状态不能为空")
	private String state;
	
	//审核建议
	private String opinion;
	
	//审核日期
	private String applyTime;
	
	//申请时间
	private String addTime;

	@ManyToOne
	public Carinfo getCarinfo() {
		return carinfo;
	}
	
	public void setCarinfo(Carinfo carinfo) {
		this.carinfo = carinfo;
	}

	public Long getApplyId() {
		return applyId;
	}

	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
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

	public String getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPeason() {
		return peason;
	}

	public void setPeason(String peason) {
		this.peason = peason;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
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
	
	
	
}

