package createObject;

public class Order {
	private int orderNumber;
	private int goodsNumber;
	private int memberNumber;
	private int usePoint;
	private int accumulatePoint;
	private String Name;
	private String address;
	private String phoneNumber;
	private String selectPayment;
	private boolean cancelCheck;
	private String orderDate;
	private String invoiceNumber;
	
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	public int getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}
	public int getAccumulatePoint() {
		return accumulatePoint;
	}
	public void setAccumulatePoint(int accumulatePoint) {
		this.accumulatePoint = accumulatePoint;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSelectPayment() {
		return selectPayment;
	}
	public void setSelectPayment(String selectPayment) {
		this.selectPayment = selectPayment;
	}
	public boolean isCancelCheck() {
		return cancelCheck;
	}
	public void setCancelCheck(boolean cancelCheck) {
		this.cancelCheck = cancelCheck;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String temp) {
		this.orderDate = temp;
	}
	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", goodsNumber=" + goodsNumber + ", memberNumber=" + memberNumber
				+ ", usePoint=" + usePoint + ", accumulatePoint=" + accumulatePoint + ", Name=" + Name + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", selectPayment=" + selectPayment + ", cancelCheck="
				+ cancelCheck + ", orderDate=" + orderDate + ", invoiceNumber=" + invoiceNumber + "]\r\n";
	}
	
}
