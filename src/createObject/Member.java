package createObject;

import java.util.List;

public class Member {

	private int memberNumber;// 회원 번호
	private int currentPoint;// 현재 포인트
	private int totalPoint;// 누적 포인트 > 사용한 포인트 계산 용
	private int totalMoney; // 주문한 총 금액
	private String id; // 로그인 아이디
	private String pw; // 로그인 패스워드
	private String name;// 이름
	private String tel;// 전화번호
	
	private String address;// 주소
	private String gender;// 성별
	private String mail;// 이메일
	private String registrationNumber;// 주민등록번호
	private String birthday;// 생년월일?
	private String signUp;
	private String leave;

	private boolean isAdmin;// 관리자여부
	private boolean isQuit;// 탈퇴 여부

	private List<Order> orderList;// 주문내역

	private List<Basket> basketList;// 장바구니

	public Member() {
		this(0, 0, 0, 0, "", "", "", "", "", "", "", "", "", "", "", false, false, null, null);
	}

	public Member(int memberNumber, 
			int currentPoint, 
			int totalPoint, 
			int totalMoney, 
			String id, 
			String pw, 
			String name,
			String tel, 
			String address, 
			String gender, 
			String mail, 
			String registrationNumber, 
			String birthday,
			String signUp, 
			String leave, 
			boolean isAdmin, 
			boolean isQuit, 
			List<Order> orderList,
			List<Basket> basketList) {
		super();
		this.memberNumber = memberNumber;
		this.currentPoint = currentPoint;
		this.totalPoint = totalPoint;
		this.totalMoney = totalMoney;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.gender = gender;
		this.mail = mail;
		this.registrationNumber = registrationNumber;
		this.birthday = birthday;
		this.signUp = signUp;
		this.leave = leave;
		this.isAdmin = isAdmin;
		this.isQuit = isQuit;
		this.orderList = orderList;
		this.basketList = basketList;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSignUp() {
		return signUp;
	}

	public void setSignUp(String signUp) {
		this.signUp = signUp;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getIsAdmin() {
		return isAdmin ? "1" : "0";
	}

	public void setAdmin(String isAdmin) {
		if (isAdmin.equals("1")) {
			this.isAdmin = true;
		} else {
			this.isAdmin = false;
		}

	}

	public String getisQuit() {
		return isQuit ? "1" : "0";
	}

	public void setQuit(String quit) {
		if (quit.equals("1")) {
			this.isQuit = true;
		} else {
			this.isQuit = false;
		}
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Basket> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<Basket> basketList) {
		this.basketList = basketList;
	}

	@Override
	public String toString() {
		String temp = "";
		temp += "아이디 : " + this.id + "\r\n";
		temp += "이름 : " + this.name + "\r\n";
		temp += "성별 : " + this.gender + "\r\n";
		temp += "생년월일 : " + this.birthday + "\r\n";
		temp += "전화번호 : " + this.tel + "\r\n";
		temp += "주소 : " + this.address + "\r\n";
		if (!this.signUp.equals("")) {
			temp += "이메일 : " + this.mail + "\r\n";
			temp += "총 결제 금액 : " + this.totalMoney + "(원)\r\n";
			temp += "남은 포인트(누적 포인트) : " + this.currentPoint + "(" + this.totalPoint + ")" + "\r\n";
			temp += "가입 일자 : " + this.signUp + "\r\n";
		}
		return temp;

	}

}
