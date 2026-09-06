package model;

public class Book {
	private int bookId;
	private String isbn;
	private String title;
	private int authorId;
	private int categoryId;
	private int publisherId;
	private String edition;
	private int publicationYear;
	private String language;
	private String rackNumber;
	private double price;
	private int totalCopies;
	private int availableCopies;
	private String availabilityStatus;
	private String description;

	public Book() {

	}

	public Book(int bookId, String isbn, String title, int authorId, int categoryId, int publisherId, String edition,
			int publicationYear, String language, String rackNumber, double price, int totalCopies, int availableCopies,
			String availabilityStatus, String description) {
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.authorId = authorId;
		this.categoryId = categoryId;
		this.publisherId = publisherId;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.language = language;
		this.rackNumber = rackNumber;
		this.price = price;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
		this.availabilityStatus = availabilityStatus;
		this.description = description;
	}

	public Book(String isbn, String title, int authorId, int categoryId, int publisherId, String edition,
			int publicationYear, String language, String rackNumber, double price, int totalCopies, int availableCopies,
			String availabilityStatus, String description) {
		this.isbn = isbn;
		this.title = title;
		this.authorId = authorId;
		this.categoryId = categoryId;
		this.publisherId = publisherId;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.language = language;
		this.rackNumber = rackNumber;
		this.price = price;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
		this.availabilityStatus = availabilityStatus;
		this.description = description;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	public String getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", title=" + title + ", authorId=" + authorId
				+ ", categoryId=" + categoryId + ", publisherId=" + publisherId + ", edition=" + edition
				+ ", publicationYear=" + publicationYear + ", language=" + language + ", rackNumber=" + rackNumber
				+ ", price=" + price + ", totalCopies=" + totalCopies + ", availableCopies=" + availableCopies
				+ ", availabilityStatus=" + availabilityStatus + ", description=" + description + "]";
	}

}
