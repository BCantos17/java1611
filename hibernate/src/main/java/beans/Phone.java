package beans;

import javax.persistence.*;

@Entity
public class Phone {

	@Id
	@Column(name="PHONE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) // HIBERNATE_SEQUENCE
	//	DO NOT PUT ID in equals or hashcode
	// We cannot rely on what the value will be
	private int id;
	
	@Column(name="PHONE_NUMBER")
	private String number;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Phone(String number) {
		super();
		this.number = number;
	}
	public Phone() {
		super();
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + "]";
	}
	
	
	
}
