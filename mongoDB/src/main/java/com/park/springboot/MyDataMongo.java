package com.park.springboot;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id

	private String id;
	
	private String code;
	private String name;
	private Date date;
	
	private int UI;
	private int Culture;
	private int Capstone;
	private int Jquery;
	private int Pass;
	private int Mento;
	private int Smart1;
	private int Smart2;
	private int Jsp;
	private int Linux;
	private int Amount;
	private int Average;

	public MyDataMongo(String name, String code, int UI, int Culture, int Capstone, int Jquery, int Pass, int Mento, int Smart1, int Smart2
			, int Jsp, int Linux) {

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
	public int getUI() {
		return UI;
	}

	public void setUI(int UI) {
		UI = UI;
	}

	public int getCulture() {
		return Culture;
	}

	public void setCulture(int Culture) {
		Culture = Culture;
	}

	public int getCapstone() {
		return Capstone;
	}

	public void setCapstone(int Capstone) {
		Capstone = Capstone;
	}
	/**캡스톤 완료**/
	public int getJquery() {
		return Jquery;
	}

	public void setJquery(int Jquery) {
		Jquery = Jquery;
	}
	
	public int getPass() {
		return Pass;
	}

	public void setPass(int Pass) {
		Pass = Pass;
	}

	public int getMento() {
		return Mento;
	}

	public void setMento(int Mento) {
		Mento = Mento;
	}
	/**멘토링까지**/
	public int getSmart1() {
		return Smart1;
	}

	public void setSmart1(int Smart1) {
		Smart1 = Smart1;
	}
	
	public int getSmart2() {
		return Smart2;
	}

	public void setSmart2(int Smart2) {
		Smart2 = Smart2;
	}
	
	public int getJsp() {
		return Jsp;
	}

	public void setJsp(int Jsp) {
		Jsp = Jsp;
	}
	/**자바까지**/
	public int getLinux() {
		return Linux;
	}

	public void setLinux(int Linux) {
		Linux = Linux;
	}
	
	/**과목선언완료**/
	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public int getAverage() {
		return Average;
	}

	public void setAverage(int average) {
		Average = average;
	}

}
