package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class RegisterBookForm {

	private Integer id;
	@NotBlank(message="名前を入力して下さい")
	private String name;	
	@NotBlank(message="著者を入力して下さい")
	private String author;
	@NotBlank(message="出版社を入力して下さい")
	private String publisher;
	@NotNull(message="価格を入力して下さい")
	private Integer price;
	@Pattern(regexp = "[0-9]-[0-9] {4}-[0-9] {4}-[0-9]", message="〇-〇〇〇〇-〇〇〇〇-〇と入力してください")
	private String isbncode;
	@Pattern(regexp = "[0-9] {4}/[0-1][0-9]/[0-3][0-9]", message="〇〇〇〇/〇〇/〇〇と入力してください")
	private String saledate;
	@NotBlank(message="説明を入力して下さい")
	private String explanation;
	private MultipartFile imageFile;
	@NotNull(message="在庫数を入力して下さい")
	private Integer stock;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getIsbncode() {
		return isbncode;
	}
	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}
	public String getSaledate() {
		return saledate;
	}
	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
