package createObject;

public class Review
{
	private int reviewNum; // 리뷰 번호
	private int memberNum; // 회원 번호
	private String itemCode; // 상품 코드
	private int itemScore; // 상품 평점
	private String reviewContent; // 리뷰 내용
	
	public int getReviewNum() 
	{
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) 
	{
		this.reviewNum = reviewNum;
	}
	public int getMemberNum() 
	{
		return memberNum;
	}
	public void setMemberNum(int memberNum) 
	{
		this.memberNum = memberNum;
	}
	public String getItemCode() 
	{
		return itemCode;
	}
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
	public int getItemScore()
	{
		return itemScore;
	}
	public void setItemScore(int itemScore)
	{
		this.itemScore = itemScore;
	}
	public String getReviewContent() 
	{
		return reviewContent;
	}
	public void setReviewContent(String reviewContent)
	{
		this.reviewContent = reviewContent;
	}
	public Review()
	{
		this(0, 0, null, 0, null);
	}
	public Review(int reviewNum, int memberNum, String itemCode, int itemScore, String reviewContent)
	{
		this.reviewNum = reviewNum;
		this.memberNum = memberNum;
		this.itemCode = itemCode;
		this.itemScore = itemScore;
		this.reviewContent = reviewContent;
	}
}