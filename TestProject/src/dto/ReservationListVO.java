package dto;

public class ReservationListVO {
    String key;
    String client_name;
    String car_type;
    String reserve_time;
    String repair_time;

    public ReservationListVO() {
    }

	public ReservationListVO(String key, String client_name, String car_type, String reserve_time, String repair_time) {
		super();
		this.key = key;
		this.client_name = client_name;
		this.car_type = car_type;
		this.reserve_time = reserve_time;
		this.repair_time = repair_time;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getReserve_time() {
		return reserve_time;
	}

	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}

	public String getRepair_time() {
		return repair_time;
	}

	public void setRepair_time(String repair_time) {
		this.repair_time = repair_time;
	}

}