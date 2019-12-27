package sakila.business.model;


import sakila.address.model.Address;

public class Staff {
	private int StaffId;
	private String firstName;
	private String lastName;
	private Address address;
	private String picture;
	private String email;
	private Store store;
	private int active;
	private String userName;
	private String password;
	private String lastUpdate;
	public int getStaffId() {
		return StaffId;
	}
	public void setStaffId(int staffId) {
		StaffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Staff [StaffId=" + StaffId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", picture=" + picture + ", email=" + email + ", store=" + store + ", active=" + active
				+ ", userName=" + userName + ", password=" + password + ", lastUpdate=" + lastUpdate + "]";
	}
}
