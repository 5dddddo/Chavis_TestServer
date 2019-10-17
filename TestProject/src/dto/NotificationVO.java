package dto;

public class NotificationVO {

	private int notification_no;
	private int member_no;
	private String notification_time;
	private String title;
	private String contents;

	public NotificationVO() {
	}

	public NotificationVO(int notification_no, int member_no, String notification_time, String title, String contents) {
		super();
		this.notification_no = notification_no;
		this.member_no = member_no;
		this.notification_time = notification_time;
		this.title = title;
		this.contents = contents;
	}

	public int getNotification_no() {
		return notification_no;
	}

	public void setNotification_no(int notification_no) {
		this.notification_no = notification_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getNotification_time() {
		return notification_time;
	}

	public void setNotification_time(String notification_time) {
		this.notification_time = notification_time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
