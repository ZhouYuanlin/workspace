package cn.uuf.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-08
 */
@Entity
@Table(name="uf_folder")
public class Folder extends BaseDomain{

	private static final long serialVersionUID =116241272941110L;
	private User user;		  	//用户
	@NotEmpty(message="文件名不能为空")
	private String fileName;	//文件名
	private Date createDate;	//创建日期
	private Folder parent;		//父类
	private List<Folder> children;//子类	
	private String status;		//是否公开
	private String sort;		//排序
	private String type;		//文件后缀
	private String fileType;	//文件、文件夹
	private int downNum;		//下载次数
	private String fileUrl;		//文件路径
	private String newUrl;		//转换路径
	private String shares;		//共享
	/**
	 * 文件名
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 创建者
	 * @return
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 父类文件夹
	 */
	@ManyToOne
	public Folder getParent() {
		return parent;
	}
	public void setParent(Folder parent) {
		this.parent = parent;
	}
	/**
	 * 包含所有文件夹
	 * @return
	 */
	@OneToMany(mappedBy = "parent",cascade=CascadeType.REMOVE)
	@OrderBy(value="sort desc")
	public List<Folder> getChildren() {
		return children;
	}
	public void setChildren(List<Folder> children) {
		this.children = children;
	}
	public void addChild(Folder folder) {
		if (this.children==null) {
			this.children=new ArrayList<Folder>();
		}
		this.children.add(folder);
	}

	/**
	 * 创建、上传日期
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 是否公开
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 文件名后缀
	 * @return
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 文件路径
	 * @return
	 */
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 下载次数
	 * @return
	 */
	public int getDownNum() {
		return downNum;
	}
	public void setDownNum(int downNum) {
		this.downNum = downNum;
	}
	/**
	 * 可播放的文件使用路径
	 * @return
	 */
	public String getNewUrl() {
		return newUrl;
	}
	public void setNewUrl(String newUrl) {
		this.newUrl = newUrl;
	}
	/**
	 * 文件类型（状态：文件、文件夹）
	 * @return
	 */
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 共享（任何人可以存放;状态位：是、否）
	 * @return
	 */
	public String getShares() {
		return shares;
	}
	public void setShares(String share) {
		this.shares = share;
	}
	
}
