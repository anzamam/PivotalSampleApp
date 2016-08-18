package com.anz.trsender.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name="StepsTrack.findBySenderId", query = "SELECT c FROM StepsTrack c where c.senderId=:senderId")
		/*@NamedQuery(name = "query2", query = "SELECT c FROM a c where c.client_id=:client_id and step_number=:step")*/ })
@Table(name="TR_Sender_Log")
public class StepsTrack implements Serializable{


	private static final long serialVersionUID = -8277497279335859893L;

	@Column(name="group_id",nullable=false)
	private String groupId;
	@Id
	@Column(name="sender_id",nullable=false)
	private String senderId;
	
	@Column(name="sender_lat")
	private String senderLat;
	
	@Column(name="sender_lng")
	private Date senderLng;
	
	@Id
	@Column(name="timestamp")
	private String timeStamp;
	
	@Column(name="sender_name")
	private String senderName;
	
	@Column(name="location")
	private String location;
	

	@Column(name="trip_id")
	private String tripId;


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getSenderId() {
		return senderId;
	}


	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}


	public String getSenderLat() {
		return senderLat;
	}


	public void setSenderLat(String senderLat) {
		this.senderLat = senderLat;
	}


	public Date getSenderLng() {
		return senderLng;
	}


	public void setSenderLng(Date senderLng) {
		this.senderLng = senderLng;
	}


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getTripId() {
		return tripId;
	}


	public void setTripId(String tripId) {
		this.tripId = tripId;
	}
	

	
	
	
}
	