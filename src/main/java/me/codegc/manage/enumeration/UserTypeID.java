package me.codegc.manage.enumeration;
/**
 * 用户类型ID
 * @author Ding
 *
 */
public enum UserTypeID {
	
	STUDENT(0,"学生"),DORM_MANNAGE(1,"宿管员"),ADMIN(2,"系统管理员");
	
	
	private int typeid;
	
	private String readme;
	

	private UserTypeID(int typeid, String readme) {
		this.typeid = typeid;
		this.readme = readme;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	
}
