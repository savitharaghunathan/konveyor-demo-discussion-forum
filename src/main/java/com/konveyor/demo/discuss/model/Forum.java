package com.konveyor.demo.discuss.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum")
public class Forum implements Serializable{

	private static final long serialVersionUID = -1530301713579762269L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userEmail;

	@Column(length = 200, nullable = false)
	private String heading;
	
	@Column(length = 400, nullable = true)
	private String body;
	
	private Date timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Forum{" +
        "id='" + id + '\'' +
        ", email='" + userEmail + '\'' +
        ", heading='" + heading + '\'' +
        ", body='" + body + '\'' +
        ", timestamp=" + timestamp +
        '}';
	}
	
}
