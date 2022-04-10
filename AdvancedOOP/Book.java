/**
 * 
 */

/**
 * Murtatha Hussein
 *
 */
public class Book {
	private int ID; 
	private String title; 
	private String author; 
	private int year; 
	private int edition; 
	private String publisher; 
	private String isbn; 
	private String cover; 
	private String condition; 
	private int price; 
	private String notes;
	
	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public Book(int ID, String title, String author, int year, int edition, String publisher, String isbn, String cover, String condition, int price, String notes) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.year = year;
		this.edition = edition;
		this.publisher = publisher;
		this.isbn = isbn;
		this.cover = cover;
		this.condition = condition;
		this.price = price;
		this.notes = notes;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book [ID= " + ID + ", title= " + title + ", author= " + author + " year= " + year +" edition= " + edition +" publisher= " + publisher +" isbn= " + isbn +" cover= " + cover +" condition= " + condition +" price= " + price +" notes= " + notes + " ]";
	}
  // below we will implement getters and setter for Book class using the variables above 
	// getter for ID
	public int getBookID() {
		return this.ID;
	}
 //setter for ID
	public void setBookIDTitle(int ID) {
		this.ID = ID;
	}
	// getter for title
	public String getTitle() {
		return this.title;
	}
	//setter for title
	public void setTitle(String title) {
		this.title = title;
	}
	// getter for author
	public String getAuthor() {
		return this.author;
	}
	//setter for author
	public void setAuthor(String author) {
		this.author = author;
	}
	// getter for year
	public int getYear() {
		return this.year;
	}
	//setter for year
	public void setYear(int year) {
		this.year = year;
	}
	// getter for edition
	public int getEdition() {
		return this.edition;
	}
	//setter for edition
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	// getter for publisher
	public String getPublisher() {
		return this.publisher;
	}
	//setter for publisher
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	// getter for isbn
	public String getISBN() {
		return this.isbn;
	}
	//setter for isbn
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	// getter for cover
	public String getCover() {
		return this.cover;
	}
	//setter for cover
	public void setCover(String cover) {
		this.cover = cover;
	}
	// getter for condition
	public String getCondition() {
		return this.condition;
	}
	//setter for conditon
	public void setCondition(String condition) {
		this.condition = condition;
	}
	// getter for price
	public int getPrice() {
		return this.price;
	}
	//setter for price
	public void setPrice(int price) {
		this.price = price;
	}
	// getter for notes
	public String getNotes() {
		return this.notes;
	}
	//setter for notes
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
