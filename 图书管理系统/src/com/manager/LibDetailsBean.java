package com.manager;

public class LibDetailsBean {
	private int    id;
	private String barcode;
	private String bookname;
	private String author;
	private String translator;
	private double price;
	private String page;
	private String bookcase;
	private String getInTime;
	private int    typeid;
	private String typename;
	private int    canReadDays;
	private int    beenLendedTimes;
	private int    isLended;
	
	public int getId() {
		return id;
	}
	public void setId(int libId) {
		this.id = libId;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getBookcase() {
		return bookcase;
	}
	public void setBookcase(String bookcase) {
		this.bookcase = bookcase;
	}
	public String getGetInTime() {
		return getInTime;
	}
	public void setGetInTime(String getInTime) {
		this.getInTime = getInTime;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getCanReadDays() {
		return canReadDays;
	}
	public void setCanReadDays(int canReadDays) {
		this.canReadDays = canReadDays;
	}
	public int getBeenLendedTimes() {
		return beenLendedTimes;
	}
	public void setBeenLendedTimes(int beenLendedTimes) {
		this.beenLendedTimes = beenLendedTimes;
	}
	public int getIsLended() {
		return isLended;
	}
	public void setIsLended(int isLended) {
		this.isLended = isLended;
	}
	
}
