package createObject;

public class Product implements Comparable<Product>
{
//	상품번호		productNum			전역변수로 선언
//	상품코드		productCode			☆카테고리1(1자리)-카테고리2(1자리)-상품명식별(3자리)-모델식별(1자리)
//	상품명		productName			카테고리1추출
//	모델			productModel		모델A~모델H(순차적 생성)
//	카테고리1		productCategory1	CName1.lenght
//	카테고리2		productCategory2	CName2.lenght
//	가격			productPrice		100000~3000000
//	재고			productStock		0~300
//	할인율		productSale			0(70%), 0.05(20%), 0.1(10%) 
//	주문횟수		productOrderNum		20~40
//	환불횟수		productRefundNum	1~10
	private int productNum;
	private String productCode;
	private String productName;
	private String productModel;
	private String productCategory1;
	private String productCategory2;
	private int productPrice;
	private int productStock;
	private double productSale;
	private int productOrderNum;
	private int productRefundNum;
	
	/*
	public Product() 
	{
		this(0,null,null,null,null,null,0,0,0.0,0,0);
	}
	public Product(int productNum, String productCode, String productName, String productModel, String productCategory1, String productCategory2, int productPrice, int productStock, double productSale, int productOrderNum, int productRefundNum) 
	{
		this.productNum = productNum;
		this.productCode = productCode;
		this.productName = productName;
		this.productModel = productModel;
		this.productCategory1 = productCategory1;
		this.productCategory2 = productCategory2;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.productSale = productSale;
		this.productOrderNum = productOrderNum;
		this.productRefundNum = productRefundNum;
	}
	*/
	
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
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public String getProductCategory1() {
		return productCategory1;
	}
	public String getProductCategory1Name() {
		return ProductList.CName1[Integer.parseInt(getProductCategory1())-1];
	}
	public void setProductCategory1(String productCategory1) {
		this.productCategory1 = productCategory1;
	}
	public String getProductCategory2() {
		return productCategory2;
	}
	public String getProductCategory2Name() {
		return ProductList.CName2[Integer.parseInt(getProductCategory2())-1];
	}
	public void setProductCategory2(String productCategory2) {
		this.productCategory2 = productCategory2;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public double getProductSale() {
		return productSale;
	}
	public void setProductSale(double productSale) {
		this.productSale = productSale;
	}
	public int getProductOrderNum() {
		return productOrderNum;
	}
	public void setProductOrderNum(int productOrderNum) {
		this.productOrderNum = productOrderNum;
	}
	public int getProductRefundNum() {
		return productRefundNum;
	}
	public void setProductRefundNum(int productRefundNum) {
		this.productRefundNum = productRefundNum;
	}
	@Override
	public int compareTo(Product product)
	{
		if(this.productPrice < product.productPrice)
			return 1;
		else if(this.productPrice > product.productPrice)
			return -1;
	
		return 0;
	}
	@Override
	public String toString() 
	{
		
		return String.format("%s\t" // 상품번호
				+ "%s\t" // 상품코드
				+ "%s\t" // 상품명
				+ "%s\t" // 모델이름
				+ "%s\t" // 카테고리1
				+ "%s\t" // 카테고리2
				+ "%,8d원\t" // 가격
				+ "%s개\t" // 재고
				+ "%s%%\t" // 할인율
				+ "%s회\t" // 주문횟수
				+ "%s회" // 환불횟수
				, this.getProductNum()
				, this.getProductCode()
				, this.getProductName()
				, this.getProductModel()
				, this.getProductCategory1Name()
				, this.getProductCategory2Name()
				, this.getProductPrice()
				, this.getProductStock()
				, this.getProductSale() * 100
				, this.getProductOrderNum()
				, this.getProductRefundNum());
	
	}	
}