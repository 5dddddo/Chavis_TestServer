package dto;
public class MemberVO {
   private int member_no;
   private String member_id;
   private String member_pw;
   private String member_mname;
   private String member_phonenumber;
   

   public MemberVO() {
      super();
   }
   
   
   public MemberVO(int member_no, String member_id, String member_pw, String member_mname,
         String member_phonenumber, int car_no) {
      super();
      this.member_no = member_no;
      this.member_id = member_id;
      this.member_pw = member_pw;
      this.member_mname = member_mname;
      this.member_phonenumber = member_phonenumber;
   }

   
   public int getMember_no() {
      return member_no;
   }
   public void setMember_no(int member_no) {
      this.member_no = member_no;
   }
   public String getMember_id() {
      return member_id;
   }
   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }
   public String getMember_pw() {
      return member_pw;
   }
   public void setMember_pw(String member_pw) {
      this.member_pw = member_pw;
   }
   public String getMember_mname() {
      return member_mname;
   }
   public void setMember_mname(String member_mname) {
      this.member_mname = member_mname;
   }
   public String getMember_phonenumber() {
      return member_phonenumber;
   }
   public void setMember_phonenumber(String member_phonenumber) {
      this.member_phonenumber = member_phonenumber;
   }
 
   
   
   
}