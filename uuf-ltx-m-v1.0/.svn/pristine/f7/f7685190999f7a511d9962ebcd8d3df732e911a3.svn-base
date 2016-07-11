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

/**
 * 文件分组
 * @author vogue
 *
 */
@Entity
@Table(name="uf_ltx_doc_grp")
public class DocGrp extends BaseDomain{

	private static final long serialVersionUID =116241272941110L;
	@NotEmpty(message="分组名称不能为空")
	private String name;			//名称
	private DocGrp parent;		//父类
	private List<DocGrp> childs;	//子类
	
	private String zjh;				//创建者
	
	private Boolean ifleaf;	//是否叶子节点
	private Integer sort=0;		//排序
	private String type;			//分类类型（视频、文章、图片）
	private Photo ph;				//缩率图
	private String delUrl;			//删除图片集路径
	private List<Photo> photo;	//图片
	private List<Video> video;	//视频
	private List<Article> article;	//文章
	
	private Date cdate;			//创建日期
	private String summary;		//描述
	
	
	/**
	 * 名称
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 父类
	 * @return
	 */
	@ManyToOne
	public DocGrp getParent() {
		return parent;
	}

	public void setParent(DocGrp parent) {
		this.parent = parent;
	}
	/**
	 * 子类
	 * @return
	 */
	@OneToMany(mappedBy = "parent",cascade=CascadeType.ALL)
	public List<DocGrp> getChilds() {
		return childs;
	}
	@Deprecated
	public void setChilds(List<DocGrp> childs) {
		this.childs = childs;
	}
	/**
	 * 添加子类
	 * @return
	 */
	public void addChilds(DocGrp child) {
		if (this.childs==null) {
			this.childs=new ArrayList<DocGrp>();
		}
		this.childs.add(child);
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
	 * 类型
	 * @return
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 是否叶子节点
	 * @return
	 */	
	public Boolean getIfleaf() {
		return ifleaf;
	}

	public void setIfleaf(Boolean ifleaf) {
		this.ifleaf = ifleaf;
	}

	/**
	 * 排序
	 * @return
	 */
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 删除图片集路径
	 * @return
	 */
	public String getDelUrl() {
		return delUrl;
	}

	public void setDelUrl(String delUrl) {
		this.delUrl = delUrl;
	}
	/**
	 * 图片
	 * @return
	 */
	@OneToMany(mappedBy="grp",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	/**
	 * 添加图片
	 * @param article
	 */
	public void addPhoto(Photo ph){
		if (this.photo==null) {
			this.photo=new ArrayList<Photo>();
		}
		this.photo.add(ph);
	}
	/**
	 * 视频
	 * @return
	 */
	@OneToMany(mappedBy="grp",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}
	/**
	 * 添加视频
	 * @param article
	 */
	public void addVideo(Video vi){
		if (this.video==null) {
			this.video=new ArrayList<Video>();
		}
		this.video.add(vi);
	}
	/**
	 * 文章
	 * @return
	 */
	@OneToMany(mappedBy="grp",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}
	/**
	 * 添加文章
	 * @param article
	 */
	public void addArticle(Article article){
		if (this.article==null) {
			this.article=new ArrayList<Article>();
		}
		this.article.add(article);
	}
	/**
	 * 描述
	 * @return
	 */
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 创建日期
	 * @return
	 */
	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	/**
	 * 缩率图对象
	 * @return
	 */
	@ManyToOne
	public Photo getPh() {
		return ph;
	}

	public void setPh(Photo ph) {
		this.ph = ph;
	}


}
