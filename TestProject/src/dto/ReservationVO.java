package dto;

public class ReservationVO {

	private int reservation_no;
	private int bodyshop_no;
	private int member_no;
	private String key;
	private String key_expire_time;
	private String reservation_time;
	private String repaired_time;
	private String repaired_person;

	public ReservationVO() {
		super();
	}

	public ReservationVO(int reservation_no) {
		super();
		this.reservation_no = reservation_no;
	}

	public ReservationVO(int reservation_no, int bodyshop_no, int member_no, String key, String key_expire_time,
			String reserve_time, String reservation_time, String repaired_person) {
		super();
		this.reservation_no = reservation_no;
		this.bodyshop_no = bodyshop_no;
		this.member_no = member_no;
		this.key = key;
		this.key_expire_time = key_expire_time;
		this.reservation_time = reservation_time;
		this.repaired_time = repaired_time;
		this.repaired_person = repaired_person;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public int getBodyshop_no() {
		return bodyshop_no;
	}

	public void setBodyshop_no(int bodyshop_no) {
		this.bodyshop_no = bodyshop_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey_expire_time() {
		return key_expire_time;
	}

	public void setKey_expire_time(String key_expire_time) {
		this.key_expire_time = key_expire_time;
	}

	public String getReservation_time() {
		return reservation_time;
	}

	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}

	public String getRepaired_time() {
		return repaired_time;
	}

	public void setRepaired_time(String repaired_time) {
		this.repaired_time = repaired_time;
	}

	public String getRepaired_person() {
		return repaired_person;
	}

	public void setRepaired_person(String repaired_person) {
		this.repaired_person = repaired_person;
	}

}