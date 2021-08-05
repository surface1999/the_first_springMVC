package admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	
	@Column(name="publisher")
	private String publisher;
	
	@Column(name="price")
	private int Price;
	
	@Column(name="add_day")
	@DateTimeFormat(pattern ="dd-MM-yyyy")
	private String addDay;
	
	@Column(name="avatar")
	private String avatar;
	@Transient
	private MultipartFile bookImage;

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getAddDay() {
		return addDay;
	}

	public void setAddDay(String addDay) {
		this.addDay = addDay;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", category=" + category + ", publisher=" + publisher + ", Price="
				+ Price + ", addDay=" + addDay + ", avatar=" + avatar + "]";
	}
	
	

}
