package com.web.model;

public class UserDetail {
		private int id;
		private String name;
		private String email;
		private String password;
		private String moblie_no;
		private String city;
		public UserDetail() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDetail(String name, String email, String password, String moblie_no, String city) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
			this.moblie_no = moblie_no;
			this.city = city;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getMoblie_no() {
			return moblie_no;
		}
		public void setMoblie_no(String moblie_no) {
			this.moblie_no = moblie_no;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		
		
		
		
		
		
		
	}


