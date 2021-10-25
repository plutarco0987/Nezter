package com.Nezter.Objects;

public class User {
	private int ID;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	private String Name;
	private String Address;
	private int CellPhone;
	private int ZipCode;
	public User(int ID,String Name, String Address,int CellPhone,int ZipCode) {
		this.ID=ID;
		this.Name=Name;
		this.Address=Address;
		this.CellPhone=CellPhone;
		this.ZipCode=ZipCode;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getCellPhone() {
		return CellPhone;
	}
	public void setCellPhone(int cellPhone) {
		CellPhone = cellPhone;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	
}
