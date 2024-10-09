package student.management.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {// Assuming roll number is still used as a unique identifier
	@Id
    private String name;
    private String email; // New field for email
    private String mobile; // New field for mobile number
    private String designation; // New field for designation
    private String gender; // New field for gender
    private String courses; // New field for selected courses (could be a CSV string)
    private String image; // New field for image filename or path
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String email, String mobile, String designation, String gender, String courses,
			String image) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.designation = designation;
		this.gender = gender;
		this.courses = courses;
		this.image = image;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourses() {
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", mobile=" + mobile + ", designation=" + designation
				+ ", gender=" + gender + ", courses=" + courses + ", image=" + image + "]";
	}

   
}
