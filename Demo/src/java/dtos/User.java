/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author heaty566
 */
public class User {

	private String UserName;
	private String UserPassword;
	private String FullName;

	public User(String UserName, String UserPassword, String FullName) {
		this.UserName = UserName;
		this.UserPassword = UserPassword;
		this.FullName = FullName;
	}

	public User() {
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
	}

	@Override
	public String toString() {
		return "User{" + "UserName=" + UserName + ", UserPassword=" + UserPassword + ", FullName=" + FullName + '}';
	}

	

}
