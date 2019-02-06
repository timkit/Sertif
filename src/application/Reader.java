package application;

import java.util.regex.Pattern;

public class Reader {
	private String matertal;
	private String steel;
	private String size;
	private String sertificat;
	private String fName;

	public String getMatertal() {
		return matertal;
	}

	public void setMatertal(String matertal) {
		this.matertal = matertal;
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

	public String getSertificat() {
		return sertificat;
	}

	public void setSertificat(String sertificat) {
		this.sertificat = sertificat;
	}

	public String getfName() {
		fName = String.join("&", this.matertal, this.steel, this.size,this.sertificat);
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String[] outSert(String input) {
		Pattern pattern = Pattern.compile("[,.&]");
		/*
		 * Matcher matcher=pattern.matcher(input); matcher.find();
		 * outPut=matcher.group(0)+matcher.group(1);
		 */
		String[] words = pattern.split(input);
		return words;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader r = new Reader();
		r.setMatertal("01");
		r.setSteel("05");
		r.setSize("32x5");
		r.setSertificat("ภั-588932-1");
		System.out.println(r.outSert(r.getfName())[3]+"\n");
		System.out.println(r.getfName());

	}

}
