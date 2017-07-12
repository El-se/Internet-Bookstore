package com.zgp.vo;

import com.zgp.domain.User;

public class UserPwdVO extends User {

	private String newpass;

	@Override
	public String toString() {
		return "UserPwdVO [newpass=" + newpass + "]";
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

}
