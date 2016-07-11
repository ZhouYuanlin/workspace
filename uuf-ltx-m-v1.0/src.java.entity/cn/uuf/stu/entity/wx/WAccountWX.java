package cn.uuf.stu.entity.wx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.uuf.stu.entity.framework.BaseEntity;

/**
 * 角色
 * 
 * @ClassName: WAccountWX
 * @author libao
 * @date 2016年3月31日 22:54
 */
@Entity
@Table(name = "uuf_wx_account_wx")
public class WAccountWX extends BaseEntity {

	private static final long serialVersionUID = 6120681941634368559L;
	private Long account_ID;
	private String openID;

	// 账号内码
	//@Column(nullable = false, updatable = false, unique = true)
	public Long getAccount_ID() {
		return account_ID;
	}

	public void setAccount_ID(Long value) {
		account_ID = value;
	}

	// 微信OpenID
	//@Column(nullable = false)
	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String value) {
		openID = value;
	}

	

}
