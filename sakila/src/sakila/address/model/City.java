package sakila.address.model;

public class City {
	private int cityId;
	private String city;
	private Country contry;
	private String lastUpate;
	
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getContry() {
		return contry;
	}
	public void setContry(Country contry) {
		this.contry = contry;
	}
	public String getLastUpate() {
		return lastUpate;
	}
	public void setLastUpate(String lastUpate) {
		this.lastUpate = lastUpate;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city + ", contry=" + contry + ", lastUpate=" + lastUpate + "]";
	}
	
	
	
}
