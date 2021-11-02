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