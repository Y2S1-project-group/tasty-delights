package com.model;


public class DeliveryUsers extends Person {

		private String nic;
	    private String name;
	    private String dob;
	    private String age;
	    private String gender;
	    private String contact;
	    private String email;
	    private String job_position;
	    private String user_name;
	    private String password;
	    
		
	
	public DeliveryUsers(int id,String nic,String name,String dob,String age,String gender,
			String contact,String email,String job_position,String user_name,String password) {
		 super(id);
	        this.id = id;
	        this.nic = nic;
	        this.name = name;
	        this.dob = dob;
	        this.age = age;
	        this.gender = gender;
	        this.contact = contact;
	        this.email = email;
	        this.job_position = job_position;
	        this.user_name = user_name;
	        this.password = password;
		
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob_position() {
		return job_position;
	}
	public void setJob_position(String job_position) {
		this.job_position = job_position;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
    
}
