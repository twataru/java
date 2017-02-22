package bean;

public class SystemBean {
	String systemName;
	String environment;
	String siStatus;
	String comment;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getVmEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getStatus() {
		return siStatus;
	}

	public void setStatus(String status) {
		this.siStatus = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


}
