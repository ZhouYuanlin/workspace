package cn.uuf.domain.life;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.User;

/**
 * 视频
 * @author vogue
 *
 */
@Entity
@Table(name="uf_ltx_video")
public class Video extends BaseDomain{

	private static final long serialVersionUID =3015241272441110L;
	@NotEmpty(message="标题不能为空")
	private String title; //标题
	private String url;	//视频路径
	
	private String delUrl;	//视频删除地址
	private String slUrl;	//视频缩率图
	

	private String content;	//文章内容
	private Date cdate;//发布日期
	private Integer count=0;	//赞
	private Integer viewNum=0;	//浏览量
	private Integer downNum=0;	//下载量
	private String zjh;				//创建者
	private User user;			//审核人
	private String status;	//审核状态
	private Date approveDate;//审核日期
	private String approveSug;	//审核意见
	private List<Reply> replies;	//评论 
	private List<Goods> goods;		//赞
	
	private DocGrp grp;				//分组
	/**
	 * 标题
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 标题
	 * @return
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 视频路径
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 视频路径
	 * @return
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 视频说明
	 * @return
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 视频说明
	 * @return
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 发布日期
	 * @return
	 */
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	/**
	 * 浏览量
	 * @return
	 */
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 关联评论
	 * @return
	 */
	@OneToMany(mappedBy="video",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	/**
	 * 添加评论（推荐）
	 * @param reply
	 */
	public void addReplies(Reply reply) {
		if (this.replies==null) {
			this.replies=new ArrayList<Reply>();
		}
		this.replies.add(reply);
	}
	/**
	 * 关联-赞
	 * @return
	 */
	@OneToMany(mappedBy="video",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	/**
	 * 添加赞（推荐）
	 * @param good
	 */
	public void addGoods(Goods good) {
		if (this.goods==null) {
			this.goods=new ArrayList<Goods>();
		}
		this.goods.add(good);
	}
	/**
	 * 分组
	 * @return
	 */
	@ManyToOne
	public DocGrp getGrp() {
		return grp;
	}
	public void setGrp(DocGrp grp) {
		this.grp = grp;
	}
	/**
	 * 审核人
	 * @return
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 创建者
	 * @return
	 */
	public String getZjh() {
		return zjh;
	}
	public void setZjh(String zjh) {
		this.zjh = zjh;
	}
	/**
	 * 审核状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 审核日期
	 * @return
	 */
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	/**
	 * 浏览量
	 * @return
	 */
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	/**
	 * 审核意见
	 * @return
	 */
	public String getApproveSug() {
		return approveSug;
	}
	public void setApproveSug(String approveSug) {
		this.approveSug = approveSug;
	}
	/**
	 * 下载量
	 * @return
	 */
	public Integer getDownNum() {
		return downNum;
	}
	public void setDownNum(Integer downNum) {
		this.downNum = downNum;
	}
	/**
	 * 视频缩率图路径
	 * @return
	 */
	public String getSlUrl() {
		return slUrl;
	}
	public void setSlUrl(String slUrl) {
		this.slUrl = slUrl;
	}
	/**
	 * 删除地址
	 * @return
	 */
	public String getDelUrl() {
		return delUrl;
	}
	public void setDelUrl(String delUrl) {
		this.delUrl = delUrl;
	}
	
}
