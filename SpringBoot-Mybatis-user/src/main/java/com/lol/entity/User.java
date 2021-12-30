
package com.lol.entity;


import java.util.List;

public class User {
	private Integer id;
	private long uid;
	private String name;
	private String password;
	private String tel;
	private String address;
	//一定要写，要不然会报错 no matching constructor
	public User(){

	}
	public User(Integer id, long uid, String name, String password, String tel, String address) {
		this.id = id;
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "{" +
				"id:" + id +
				", uid:" + uid +
				", name:'" + name + '\'' +
				", password:'" + password + '\'' +
				", tel:'" + tel + '\'' +
				", address:'" + address + '\'' +
				'}';
	}

	public String UserPostBody(){
		return "{\"id\": " + id + "," +
				"\"uid\": \"" + uid + "\"," +
				"\"name\": \"" + name + "\"," +
				"\"password\": \"" + password + "\"," +
				"\"tel\": \"" + tel +  "\"," +
				"\"address\": \"" + address +
				"\"}";
	}
	public User buildUser(String idweb,String value){
		value=value.replace(",","");
		value=value.replace(":","");
		String[] values = value.split("\"");
		int nid=Integer.parseInt(idweb);
		long nuid=Long.parseLong(values[4]);
		User user=new User(nid,nuid,values[7],values[11],values[15],values[19]);
		return user;
	}
}
