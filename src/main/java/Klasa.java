import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="KLASE")
public class Klasa {
	@Column
	private String ime;
	@Temporal(TemporalType.DATE)
	private Date godina;
	@GenericGenerator(name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
	@Id
	private int id;
	
	
	public Klasa() {
	}
	public Klasa(String ime, Date godina) {
		super();
		this.ime = ime;
		this.godina = godina;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getGodina() {
		return godina;
	}
	public void setGodina(Date godina) {
		this.godina = godina;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		String dat=godina.getDate()+"-"+godina.getMonth()+"-"+godina.getYear();
		return "Klasa [ime=" + ime + ", godina=" + dat + ", id=" + id + "]";
	}

	
}
