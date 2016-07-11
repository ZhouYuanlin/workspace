package cn.uuf.stu.framework.common;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;



/**
* 系统参数设置
* @ClassName: Setting 
* @author tangpeng
* @date 2015年8月3日 下午2:49:33 
*
*/
public class SystemParamter implements Serializable {

	private static final long serialVersionUID = 6325189319945739217L;
	
	/** 分隔符 */
	private static final String SEPARATOR = ",";
	
	/** 缓存名称 */
	public static final String CACHE_NAME = "systemparam";

	/** 缓存Key */
	public static final Integer CACHE_KEY = 0;

	/**
	 * 验证码类型
	 */
	public enum CaptchaType {
		
		/** 后台登录 */
		adminLogin,

		/** 找回密码 */
		findPassword,

		/** 重置密码 */
		resetPassword,

		/** 其它 */
		other
	}
	
	/**
	 * 账号锁定类型
	 */
	public enum AccountLockType {
		
		/** 管理员 */
		admin,
		other
	}
	
	/** 验证码类型 */
	private CaptchaType[] captchaTypes;

	/** 账号锁定类型 */
	private AccountLockType[] accountLockTypes;

	/** 连续登录失败最大次数 */
	private Integer accountLockCount;

	/** 自动解锁时间 */
	private Integer accountLockTime;
	
	/** 管理员后台按钮图片路径*/
	private String buttonImgDir;
	
	/** 上传文件大小限制*/
	private Integer uploadMaxSize;

	/** 图片上传路径 */
	private String imageUploadPath;
	
	/** 文件上传路径 */
	private String fileUploadPath;
	
	/** 入校前获奖信息路径（添加学籍信息里面）*/
	private String hjxxUploadPath;
	
	/** 允许上传图片扩展名 */
	private String uploadImageExtension;
	
	/** 允许上传文件扩展名 */
	private String uploadFileExtension;
	
	/** 允许上传的扩展名 */
	private String uploadOtherExtension;
	
	/** 文章图片服务器地址*/
	private String articleImageUrl;
	
	public CaptchaType[] getCaptchaTypes() {
		return captchaTypes;
	}

	public void setCaptchaTypes(CaptchaType[] captchaTypes) {
		this.captchaTypes = captchaTypes;
	}

	public AccountLockType[] getAccountLockTypes() {
		return accountLockTypes;
	}

	public void setAccountLockTypes(AccountLockType[] accountLockTypes) {
		this.accountLockTypes = accountLockTypes;
	}

	public Integer getAccountLockCount() {
		return accountLockCount;
	}

	public void setAccountLockCount(Integer accountLockCount) {
		this.accountLockCount = accountLockCount;
	}

	public Integer getAccountLockTime() {
		return accountLockTime;
	}

	public void setAccountLockTime(Integer accountLockTime) {
		this.accountLockTime = accountLockTime;
	}

	public String getButtonImgDir() {
		return buttonImgDir;
	}

	public void setButtonImgDir(String buttonImgDir) {
		this.buttonImgDir = buttonImgDir;
	}

	public Integer getUploadMaxSize() {
		return uploadMaxSize;
	}

	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}

	public String getImageUploadPath() {
		return imageUploadPath;
	}

	public void setImageUploadPath(String imageUploadPath) {
		this.imageUploadPath = imageUploadPath;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public String getUploadImageExtension() {
		return uploadImageExtension;
	}

	public void setUploadImageExtension(String uploadImageExtension) {
		this.uploadImageExtension = uploadImageExtension;
	}

	public String getUploadFileExtension() {
		return uploadFileExtension;
	}

	public void setUploadFileExtension(String uploadFileExtension) {
		this.uploadFileExtension = uploadFileExtension;
	}
	
	/**
	 * 获取允许上传文件扩展名
	 * 
	 * @return 允许上传文件扩展名
	 */
	public String[] getUploadFileExtensions() {
		return StringUtils.split(uploadFileExtension, SEPARATOR);
	}
	
	/**
	 * 获取允许上传图片扩展名
	 * 
	 * @return 允许上传图片扩展名
	 */
	public String[] getUploadImageExtensions() {
		return StringUtils.split(uploadImageExtension, SEPARATOR);
	}
	
	/**
	* 获取文章图片地址
	* @return    
	* String
	*/
	public String getArticleImageUrl() {
		return articleImageUrl;
	}

	/**
	* 设置文章图片地址
	* @return    
	* String
	*/
	public void setArticleImageUrl(String articleImageUrl) {
		this.articleImageUrl = articleImageUrl;
	}

	public String getHjxxUploadPath() {
		return hjxxUploadPath;
	}

	public void setHjxxUploadPath(String hjxxUploadPath) {
		this.hjxxUploadPath = hjxxUploadPath;
	}

	public String getUploadOtherExtension() {
		return uploadOtherExtension;
	}

	public void setUploadOtherExtension(String uploadOtherExtension) {
		this.uploadOtherExtension = uploadOtherExtension;
	}
	
	/**
	 * 获取允许上传的扩展名
	 * 
	 * @return 允许上传图片扩展名
	 */
	public String[] getUploadOtherExtensions() {
		return StringUtils.split(uploadOtherExtension, SEPARATOR);
	}
	
	
}
