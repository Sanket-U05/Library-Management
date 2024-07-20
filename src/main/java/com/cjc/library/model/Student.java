package com.cjc.library.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.cjc.library.constant.ProjectConstant;
@Entity
@NamedQueries({
@NamedQuery(query=ProjectConstant.deletebyid,name="deletebyid"),
@NamedQuery(query=ProjectConstant.getAll,name="getbystudent"),
@NamedQuery(query=ProjectConstant.getAllStudentbydivision,name="getstudentbydivision")
})
public class Student {
	@Id
	private int id;
	private String sname;
	private String sdiv;
	private String sadd;
	private long mobile_no;
	private long adharno;
	
	@OneToMany(cascade = CascadeType.ALL)
	
	private List<Book> book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSdiv() {
		return sdiv;
	}

	public void setSdiv(String sdiv) {
		this.sdiv = sdiv;
	}

	public String getSadd() {
		return sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public long getAdharno() {
		return adharno;
	}

	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sdiv=" + sdiv + ", sadd=" + sadd + ", mobile_no=" + mobile_no
				+ ", adharno=" + adharno + ", book=" + book + "]";
	}

	
	
}
