package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * JPA annotations instead HBM XML files
 * #1 easier; #2 beans compatible with other ORM/Persistence Frameworks
 */

@Entity
@Table(name="ORM_PARENT_TABLE") // name of Physical table
public class Parent {			// name of bean is different

	@Id
	@Column(name="ORM_PARENT_ID")	// name of column
	@GeneratedValue(strategy=GenerationType.AUTO) // HIBERNATE_SEQUENCE
	private int id;					// name of bean property
	
									// set constraints on columns
	@Column(nullable=false, unique=true, length=50, updatable=false)
	private String name;
	
	@OneToOne(cascade=CascadeType.REMOVE) 	// delete orphans
	@JoinColumn(nullable=false)				// configure FK columns
	private Phone phone;
	
	@ManyToMany
	@JoinTable							
	private Set<Child> kids = new HashSet<Child>();
	
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
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Set<Child> getKids() {
		return kids;
	}
	public void setKids(Set<Child> kids) {
		this.kids = kids;
	}
	public Parent(String name, Phone phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	public Parent() {
		super();
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", phone=" + phone + ", kids=" + kids + "]";
	}
	
	
	
}
