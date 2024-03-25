package basic.classes;

public class Address {
	private String sido;
	private String detail;
	
	public Address(String sido, String detail) {
		super();
		this.sido = sido;
		this.detail = detail;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Address [sido=" + sido + ", detail=" + detail + "]";
	}
	
	
}
