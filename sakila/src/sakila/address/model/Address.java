package sakila.address.model;

public class Address {
	private int adressId;
	private String adress;
	private String adress2;
	private String district;
	private City city;
	private String postalCode;
	private String phone;
	private String lastUpdate;
	
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getAdress2() {
		return adress2;
	}
	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address [adressId=" + adressId + ", adress=" + adress + ", adress2=" + adress2 + ", district="
				+ district + ", city=" + city + ", postalCode=" + postalCode + ", phone=" + phone + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
