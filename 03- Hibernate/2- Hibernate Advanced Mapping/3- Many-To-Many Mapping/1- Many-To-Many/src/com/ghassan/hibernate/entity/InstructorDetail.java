package com.ghassan.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//annotate the class as an Entity and map it to DB table
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	//define fields
	//annotate the fields with db column names
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; 
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	//Add new field for Instructor
	//add one to one annotation with mappedBy=instructorDetail
	//This will make Hiberante to handle the association through instructorDetail field in the 
	//Instructor class. It will check the @JoinColumn there
	//Then we add the casCading type
	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
	private Instructor instructor;
	
	//generate constructors
	public InstructorDetail() {
		
	}
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	//generate getter/setter methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYoutubeChannel() {
		return youtubeChannel;
	}
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	//generate getter and setter for instructor
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	//generate toString 
	@Override
	public String toString() {
		return "InstructorDetail ["
				+ "id=" + id + 
				", youtubeChannel=" + youtubeChannel +
				", hobby=" + hobby +
				"]";
	}
	
	


	

}
