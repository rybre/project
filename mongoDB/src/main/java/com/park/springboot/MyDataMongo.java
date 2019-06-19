package com.park.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String code;
	private String name;
	private Date date;
	
	private double UI;
	private double Culture;
	private double Capstone;
	private double Jquery;
	private double Pass;
	private double Mento;
	private double Smart1;
	private double Smart2;
	private double Jsp;
	private double Linux;
	private double Amount;
	private double GradeAvg;
	private double Average;

	public MyDataMongo(String name, String code, double UI, double Culture, double Capstone, double Jquery,
			double Pass, double Mento, double Smart1, double Smart2
			, double Jsp, double Linux) {

		super();
		this.name = name;
		this.code = code;
		this.date = new Date();
		this.UI = UI;
		this.Culture = Culture;
		this.Capstone = Capstone;
		this.Jquery = Jquery;
		this.Pass = Pass;
		this.Mento = Mento;
		this.Smart1 = Smart1;
		this.Smart2 = Smart2;
		this.Jsp = Jsp;
		this.Linux = Linux;
		this.Amount = UI + Culture + Capstone + Jquery + Pass + Mento + Smart1 + Smart2 + Jsp + Linux;
		this.GradeAvg = (UI * 2 + Culture * 2 + Capstone * 2 + Jquery * 2 + Pass * 1 + Mento * 1 + Smart1 * 3 + Smart2 * 3 +
				Jsp * 2 + Linux * 2); 
				
		this.Average = Amount / 10;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	/**과목**/
	public double getUI() {
		return UI;
	}

	public void setUI(double UI) {
		UI = UI;
	}

	public double getCulture() {
		return Culture;
	}

	public void setCulture(double Culture) {
		Culture = Culture;
	}

	public double getCapstone() {
		return Capstone;
	}

	public void setCapstone(double Capstone) {
		Capstone = Capstone;
	}
	/**캡스톤 완료**/
	public double getJquery() {
		return Jquery;
	}

	public void setJquery(double Jquery) {
		Jquery = Jquery;
	}
	
	public double getPass() {
		return Pass;
	}

	public void setPass(double Pass) {
		Pass = Pass;
	}

	public double getMento() {
		return Mento;
	}

	public void setMento(double Mento) {
		Mento = Mento;
	}
	/**멘토링까지**/
	public double getSmart1() {
		return Smart1;
	}

	public void setSmart1(double Smart1) {
		Smart1 = Smart1;
	}
	
	public double getSmart2() {
		return Smart2;
	}

	public void setSmart2(double Smart2) {
		Smart2 = Smart2;
	}
	
	public double getJsp() {
		return Jsp;
	}

	public void setJsp(double Jsp) {
		Jsp = Jsp;
	}
	/**자바까지**/
	public double getLinux() {
		return Linux;
	}

	public void setLinux(double Linux) {
		Linux = Linux;
	}
	
	/**과목선언완료**/
	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public double getAverage() {
		return Average;
	}

	public void setAverage(double average) {
		Average = average;
	}

	public double getGradeAge() {
		return GradeAvg;
	}

	public void setGradeAge(double GradeAge) {
		Average = GradeAge;
	}

}
