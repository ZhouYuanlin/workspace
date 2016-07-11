package cn.uuf.domain.life;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.uuf.domain.BaseDomain;
import cn.uuf.domain.User;

/**
 * 文章、图片、视频——赞操作
 * @author vogue
 *
 */
@Entity
@Table(name="uf_ltx_goods")
public class Goods extends BaseDomain{

	private static final long serialVersionUID =116241272941110L;
	private User user;		  //用户
	private Date cdate;			  //赞日期
	
	private Photo photo;	//图片
	private Video video;	//视频
	private Article article;	//文章
	
	/**
	 * 日期
	 * @return
	 */
	public Date getCdate() {
		return cdate;
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
	 * @param cdate the cdate to set
	 */
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
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
	public void setVideo(Video video) {
		this.video = video;
	}


	/**
	 * 关联文章
	 * @return
	 */
	@ManyToOne
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}	
		
}
