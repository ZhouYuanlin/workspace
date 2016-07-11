package cn.uuf.domain.life;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.User;

/**
 * 评论、评分（回复）
 * @author vogue
 *
 */
@Entity
@Table(name="uf_ltx_reply")
public class Reply extends BaseDomain{

	private static final long serialVersionUID = 913681024472421115L;
	private Integer score;	//评分
	private String content;	//内容
	private Date cdate;	//评论日期
	private User user;	//评论人		(匿名、系统人员)
	
	private Photo photo;	//图片
	private Video video;	//视频
	private Article acritcle;	//文章

	/**
	 * 评论内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 评论人
	 * @return
	 */
	
	/**
	 * 评论日期
	 * @return
	 */
	public Date getCdate() {
		return cdate;
	}

	/**
	 * @return the user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 评论日期
	 * @return
	 */
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	/**
	 * 评分
	 * @return
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 评分
	 * @return
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 关联图片
	 * @return
	 */
	@ManyToOne
	public Photo getPhoto() {
		return photo;
	}
	/**
	 * 关联图片
	 * @return
	 */
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	/**
	 * 关联视频
	 * @return
	 */
	@ManyToOne
	public Video getVideo() {
		return video;
	}
	/**
	 * 关联视频
	 * @return
	 */
	public void setVideo(Video video) {
		this.video = video;
	}
	/**
	 * 关联文章
	 * @return
	 */
	@ManyToOne
	public Article getAcritcle() {
		return acritcle;
	}
	/**
	 * 关联文章
	 * @return
	 */
	public void setAcritcle(Article acritcle) {
		this.acritcle = acritcle;
	}
}
