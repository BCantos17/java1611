package com.revature.beans;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name="TRAINEE")
public class Trainee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="trainee_pk")
	@SequenceGenerator(name="trainee_pk", sequenceName="TRAINEE_PK")
	@Column(name="TRAINEE_ID")
	@Digits(fraction=0, integer=2_000_000_000)
	private int id;
	@Column(name="TRAINEE_NAME")
	@NotNull
	@Size(min=1, max=50)
	private String name;
	@Column(name="MAJOR")
	@Size(min=1, max=50)
	private String major;
	
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + "]";
	}
	public Trainee() {
		super();
	}
	public Trainee(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (id != other.id)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
