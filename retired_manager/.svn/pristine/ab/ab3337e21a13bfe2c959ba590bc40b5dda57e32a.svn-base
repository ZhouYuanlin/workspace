package cn.uuf.domain.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.Account;
import cn.uuf.domain.BaseDomain;

/**
 * 车辆信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Entity
@Table(name="uf_car_manage")
public class Carinfo extends BaseDomain{

	private static final long serialVersionUID = -4111111085462711520L;
	
	//车辆名称及型号
	@NotEmpty(message="车辆名称及型号不能为空")
	private String carName ;
	
	//车牌
	@NotEmpty(message="车牌不能为空")
	private String carNumber;		
	
	//可坐人数
	@NotEmpty(message="可坐人数不能为空")
	private String peopleNumber  ;	
	
	//车辆类型
	@NotEmpty(message="车辆类型不能为空")
	private String carType  ;	
	
	//司机
	@NotEmpty(message="司机不能为空")
	private String carDriver  ;	
	
	//司机电话
	@NotEmpty(message="司机电话不能为空")
	private String tel  ;	
	
	private   Account  account;    //车辆审批人
		
	@ManyToOne
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	//备注
	private String explain  ;
	
	private String createDate; //创建时间
	private String updateDate; //修改时间
	
	

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

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarDriver() {
		return carDriver;
	}

	public void setCarDriver(String carDriver) {
		this.carDriver = carDriver;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	
	
}

