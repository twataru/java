package bean;

public class SystemBean {
	String systemName;
	String vmEnvironment;
	String siStatus;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getVmEnvironment() {
		return vmEnvironment;
	}

	public void setVmEnvironment(String vmEnvironment) {
		this.vmEnvironment = vmEnvironment;
	}

	public String getSiStatus() {
		return siStatus;
	}

	public void setSiStatus(String siStatus) {
		this.siStatus = siStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	String comment;
}
