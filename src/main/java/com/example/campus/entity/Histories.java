package com.example.campus.entity;

import java.sql.Timestamp;

public class Histories {

	private int id;
	private int users_id;
	private int point;
	private Timestamp created_at;

	public Histories() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsersId() {
		return users_id;
	}
	public void setUsersId(int users_id) {
		this.users_id = users_id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Timestamp getCreatedAt() {
		return created_at;
	}
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}

}
