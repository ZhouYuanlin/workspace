package cn.uuf.stu.framework.common;



public class Message {
	private String type;
	private String content;
	public Message(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 错误消息
	 * @param content
	 * @return
	 */
	public static Message error(String content) {
		return new Message("error",content);
	}
	
	/**
	 * 成功消息
	 * @param content
	 * @return
	 */
	public static Message success(String content) {
		return new Message("success",content);
	}
	
}
