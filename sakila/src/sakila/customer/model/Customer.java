package sakila.customer.model;

import sakila.address.model.Address;
import sakila.business.model.Store;

public class Customer {
	private int customerId;
	private Store store;
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	private String createDate;
	private String lastUpdate;
	private int active;
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", store=" + store + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", address=" + address + ", createDate=" + createDate
				+ ", lastUpdate=" + lastUpdate + ", active=" + active + "]";
	}
}
