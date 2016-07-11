package cn.uuf.targlib;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.uuf.util.Page;


/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 15, 2013
 */
public class PaginationTag extends TagSupport{

	private static final long serialVersionUID = 7755753309320762427L;
	private Page page;
	private String namespace;
	private String controller;
	private String action;
	private String suffix;
	private String styleClass;
	private Integer window = 5;
	private boolean includeParams;
	private boolean formWay ;
	private String formId;
	private boolean ajax;
	private String containerId;
	private int pages;
	
	
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		if(page == null)
			return SKIP_PAGE;
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : queryString;
		
		//特殊处理
		String[] filterParams = new String[]{"statusCode=303", "dealState=1", "dealState=3", "dealState=5", "dealState=6", "dealState=-1"};
		for (String filterParam : filterParams) {
			if (queryString.indexOf(filterParam) > -1) {
				queryString = queryString.replace(filterParam, "");
				break;
			}
		}
		
		try {
			out.write(multi(uri, queryString));
		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	/**
	 * 分页相关链接
	 * @param uri
	 * @return
	 */
	protected String multi(String uri, String queryString) {
		
		Integer offset = window >= 5 ? (window - 1) / 2 : window;
		Integer from = 0;
		Integer to = 0;

		//如果总页数小于标签指定要输出的页数window，则只输出到实际页数为止
		if(window > page.getPageCount()) {
			from = 1;
			to = page.getPageCount();
		} else {
		// 如果大于的话，就要输出window个页数
			from = page.getCurrentPage() - offset;
			to = from + window - 1;
			if(from < 1) {
				to = page.getCurrentPage() + 1 - from;
				from = 1;
				if(to - from < window) {
					to = window;
				}
			} else if(to > page.getPageCount()) {
				from = page.getPageCount() - window + 1;
				to = page.getPageCount();
			}
		}
		
		// 转换query string
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(includeParams) {
			String[] parameters = queryString.split("\\&");
			for(int i=0; parameters != null && i < parameters.length; i++) {
				if(parameters[i].equals("")) continue;
				String[] entry = parameters[i].split("=");
				if(entry[0].equals("page") || entry.length < 2) continue;
				if (ajax && formWay && !entry[0].equals("page")) continue;
				params.put(entry[0], entry[1]);
			}
		}
		
		
		if(formWay) 
			return buildForm(generateUri(uri), params, page, from, to, offset);
		else 
			return buildLink(generateUri(uri), params, page, null, from, to, offset);
	}
	
	/**
	 * 没有指定action，将截取uri倒数第一个/与第二个/之前的字符当做action，
	 * 如何namespace也为空，则用actino之前的字符当做namespace.
	 * 1.截取action
	 * 2.截取controller
	 * 3.截取name space
	 * @param uri
	 * @return
	 */
	protected String generateUri(String uri) {
		
		// 截取controller
		String temp = uri.substring(0, uri.lastIndexOf("/"));
		String uriController = temp.substring(temp.lastIndexOf("/") + 1);
		
		controller = (null == controller) ? uriController : controller;
		namespace = null == namespace ? 
				temp.substring(0, temp.indexOf(uriController)) : 
				namespace.equals("/") ? namespace : namespace + "/";
		
		temp = this.namespace + this.controller;
		temp += (this.action != null && !this.action.equals("")) ? "/" + this.action : "";
		
		return temp;
	}
	
	/**
	 * 构建 a 链接方式
	 * @param uri
	 * @param page
	 * @param from
	 * @param to
	 * @param offset
	 * @return
	 */
	protected String buildLink(String uri, Map<String, Object> params, Page page, String onclick, Integer from, Integer to, Integer offset) {
		if (ajax && containerId != null) {
			if (formWay && formId != null)
			onclick = "var formParams='';$('#" + formId + " input:hidden').each(function(){if(formParams != ''){formParams+='&';}if($.trim($(this).attr('name'))!=''){formParams+=$(this).attr('name')+'='+((/.*[\u4e00-\u9fa5]+.*$/.test($(this).attr('value'))) ? escape(encodeURIComponent($(this).attr('value'))) : $(this).attr('value'));}});";
			onclick += "$.get($(this).attr('href')+($(this).attr('href').indexOf('?')==-1?'?':'&')+formParams, function(data){$('#" + containerId + "').html(data)});return false;";
		}
		return defaultLinkHtml(uri,params,page,onclick,from,to,offset);
	}
	
	/**
	 * 默认的分页
	 * @param uri
	 * @param params
	 * @param page
	 * @param onclick
	 * @param from
	 * @param to
	 * @param offset
	 * @param size
	 * @return
	 */
	protected String defaultLinkHtml(String uri, Map<String, Object> params, Page page, String onclick, Integer from, Integer to, Integer offset){
		long size = 10;
		
		
		StringBuffer html = new StringBuffer();
		html.append("<div id=\"pager\"" + (styleClass != null ? " class=\"" + styleClass +"\">" : ">"));
		
		String queryString = "";
		
		for(Object key : params.keySet()) {
			Object value = params.get(key);
			queryString += key + "=" + value + "&amp;";
		}
		//获得首页
		if(null!=page.getFirstPage() && page.getPageCount() > 1){
			html.append("<a href=\""+uri
					+(suffix != null ? "." + suffix : "")
					+ "?" + queryString + "page=1\""
					+ (onclick != null ? " onclick=\""+onclick+"\"" : "")
					+ " class=\"first\">首页</a>");
		}
		
		if(page.getPageCount() > 1) {
			int count = page.getPageCount() > window ? (((page.getCurrentPage() -1) / window)+1)*window : page.getPageCount();
			count = page.getPageCount() > count ? (((page.getCurrentPage() -1) / window)+1)*window : page.getPageCount();
			int k=0;
			int z=0;
			//总页数＜=5
			if(page.getPageCount()<=5){
				k=1;
				z=page.getPageCount();
			}else{
			
				if(page.getCurrentPage()>=window/2+1){
					if(count==page.getPageCount()){
						k=page.getPageCount()-window+1;
						z=k+(window-1);
					}else if(page.getCurrentPage()==page.getPageCount()-1){
						k=page.getCurrentPage()-(window/2)-1;	
						z=k+(window-1);
					}else{
						k=page.getCurrentPage()-(window/2);	
						z=k+(window-1);
					}
				}else if(page.getCurrentPage()==window/2){ 
					k=page.getCurrentPage()-(window/2-1);
					z=k+(window-1);
				}else{
					k=page.getCurrentPage();
					z=k+(window-1);
				}
			}
			//循环出当前页面里的页数
			for(int i = k ; i <= z ; i++){
				String link = "<a href=\"" + uri
							+ "?" + queryString + "page=" + i + "\""
							+ (onclick != null ? " onclick=\""+onclick+"\"" : "") 
							+ " class=\""+(i == page.getCurrentPage() ? "pgnum pgclick" : "pgnum")+"\""
							+ " >"+i+"</a>";
				html.append(link);
			}
			//末页
			if(null!=page.getLastPage() && page.getPageCount() > 1){
				html.append("<a href=\""+uri
						+(suffix != null ? "." + suffix : "")
						+ "?" + queryString + "page="+page.getLastPage()+"\""
						+ (onclick != null ? " onclick=\""+onclick+"\"" : "")
						+ " class=\"last\">末页</a>");
			}
		}
		try{
			if(null!=page.getPageCount() && page.getPageCount() > 1){
				html.append("<form type=\"post\" action=\""+uri+"\">");
				for(Object key : params.keySet()) {
					Object value = params.get(key);
					html.append("<input type='hidden' name='"+key+"' id='"+key+"' value=\""+URLDecoder.decode(value.toString(),"UTF-8")+"\"/>");
				}
				html.append("<input type='text' name='page' id='page'" 
						+ " class=\"last\" ></input>");
				html.append("<input type='submit' value='Go' id='go'></input>");
			}
		}catch(Exception e){
			
		}
		//第  当前页/总页数   页
		if(page.getPageCount() > 1){
			html.append("<label class=\"fleft\">第"+page.getCurrentPage()+"/"+page.getPageCount()+"页 共("+page.getCount()+")条</label>");
		}
		
		html.append("</form>");
		html.append("</div>");
		return html.toString();
	}
	
	/**
	 * 构建form表单
	 * @param uri
	 * @param page
	 * @param from
	 * @param to
	 * @param offset
	 * @param params
	 * @return
	 */
	protected String buildForm(String uri, Map<String, Object> params, Page page, Integer from, Integer to, Integer offset) {
		
		
		StringBuffer html = new StringBuffer();
		
				
		html.append(buildLink(uri, params, page,
				"var f=document.getElementById('"+formId+"'); f.method = 'post';" 
				+ " f.attributes['action'].value = this.href; f.submit(); return false;", 
				from, to, offset));
		
		
		return html.toString();
	}

	// getter setter ============================================================================================
	
	public void setPage(Page page) {
		this.page = page;
	}
	
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * window必须大小等于5，并且不能为偶数
	 * @param window
	 */
	public void setWindow(Integer window) {
		if(window < 5 || (window + 1) % 2 != 0)
			throw new IllegalArgumentException("Window值必须大于等于5,并且不能为偶数！");
		this.window = window;
	}


	public void setIncludeParams(boolean includeParams) {
		this.includeParams = includeParams;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}

	public void setFormWay(boolean formWay) {
		this.formWay = formWay;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
}

