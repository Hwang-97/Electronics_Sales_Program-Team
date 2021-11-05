/*
package createObject;

public class Basket {
	int memberNum;
	int itemNumber;
	int numberOfItem;
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getNumberOfItem() {
		return numberOfItem;
	}
	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}
	@Override
	public String toString() {
		return "basketData [memberNum=" + memberNum + ", itemNumber=" + itemNumber + ", numberOfItem=" + numberOfItem
				+ "]";
	}
	
	
}
*/

package createObject;

public class Basket {
	//int memberNum;
	//int itemNumber;
	//int numberOfItem;
	
	private int memberNum; // 회원번호
	private int productNum; // 상품번호
	private String productCode; // 상품코드
	private String productName; // 상품명
	private int productPrice; // 상품금액
	private int productCount; // 상품수량
	
	public Basket() 
	{
		this(0,0,null,null,0,0);
	}
	public Basket(int memberNum, int productNum, String productCode, String productName, int productPrice, int productCount)
	{
		this.memberNum = memberNum;
		this.productNum = productNum;
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	/*
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public int getNumberOfItem() {
		return numberOfItem;
	}
	public void setNumberOfItem(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}
	*/
	
	
}

