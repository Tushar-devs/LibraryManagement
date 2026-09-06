package model;

public class Publisher {
	private int publisherId;
	private String publisherName;
	private String publisherCity;
	private String publisherEmail;
	private String publisherPhone;
	private String website;

	public Publisher() {

	}

	public Publisher(int publisherId, String publisherName, String publisherCity, String publisherEmail,
			String publisherPhone, String website) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherCity = publisherCity;
		this.publisherEmail = publisherEmail;
		this.publisherPhone = publisherPhone;
		this.website = website;
	}
	
	public Publisher(String publisherName, String publisherCity, String publisherEmail,
			String publisherPhone, String website) {
		this.publisherName = publisherName;
		this.publisherCity = publisherCity;
		this.publisherEmail = publisherEmail;
		this.publisherPhone = publisherPhone;
		this.website = website;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherCity() {
		return publisherCity;
	}

	public void setPublisherCity(String publisherCity) {
		this.publisherCity = publisherCity;
	}

	public String getPublisherEmail() {
		return publisherEmail;
	}

	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}

	public String getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherCity="
				+ publisherCity + ", publisherEmail=" + publisherEmail + ", publisherPhone=" + publisherPhone
				+ ", website=" + website + "]";
	}

}
