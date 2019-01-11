package fise3.info6.projetlu.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_Id", unique=true, nullable=false, precision=10)
	private int userId;

	@Column(name="password",nullable=false, length=255)
	private String password;

	@Column(name="roles")
	private String roles;
	@Column(name = "active")
	private int active;
	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}