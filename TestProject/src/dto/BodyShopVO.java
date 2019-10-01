package dto;


public class BodyShopVO {
    String bodyshop_num;
    String address;
    String latitude;
    String longitude;
    String body_pw;
    String body_id;

    public BodyShopVO() {
    }

    public BodyShopVO(String bodyshop_num, String address, String latitude, String longitude, String body_pw, String body_id) {
        this.bodyshop_num = bodyshop_num;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.body_pw = body_pw;
        this.body_id = body_id;
    }

    public String getBodyshop_num() {
        return bodyshop_num;
    }

    public void setBodyshop_num(String bodyshop_num) {
        this.bodyshop_num = bodyshop_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBody_pw() {
        return body_pw;
    }

    public void setBody_pw(String body_pw) {
        this.body_pw = body_pw;
    }

    public String getBody_id() {
        return body_id;
    }

    public void setBody_id(String body_id) {
        this.body_id = body_id;
    }
}