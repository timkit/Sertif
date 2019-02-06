package application;


public class Data {
	
	private String sert;
	private String mat;
	private String steel;
	private String size;
	
	public Data(String sert, String mat, String steel, String size) {
	

		this.sert = sert;
		this.mat = mat;
		this.steel = steel;
		this.size = size;
	}

	public String getSert() {
		return sert;
	}

	public void setSert(String sert) {
		this.sert = sert;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getSteel() {
		return steel;
	}

	public void setSteel(String steel) {
		this.steel = steel;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}



}
