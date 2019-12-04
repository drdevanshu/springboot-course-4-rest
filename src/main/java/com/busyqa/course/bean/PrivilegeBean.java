package com.busyqa.course.bean;

public class PrivilegeBean {

	int idPrivilege;
	String privilegeName;
	
	public PrivilegeBean(int idPrivilege, String privilegeName) {
		super();
		this.idPrivilege = idPrivilege;
		this.privilegeName = privilegeName;
	}
	
	public int getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(int idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	@Override
	public String toString() {
		return "PrivilegeBean [idPrivilege=" + idPrivilege + ", privilegeName=" + privilegeName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrivilege;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivilegeBean other = (PrivilegeBean) obj;
		if (idPrivilege != other.idPrivilege)
			return false;
		return true;
	}
	
}
