package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Child {

	@Id
	@Column(name="KID_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) // HIBERNATE_SEQUENCE
	private int id;
	
	@Column(name="KID_NAME")
	private String name;
	
	// Bi-directional.. already mapped by Parent.kids property
	@ManyToMany(mappedBy="kids")
	private Set<Parent> parents = new HashSet<Parent>();
	
	// Left-to-Right.. This class-to-That Class
	// already mapped by Toy.owner property
	@OneToMany(mappedBy="owner")
	private Set<Toy> toys = new HashSet<Toy>();
	
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
	public Set<Parent> getParents() {
		return parents;
	}
	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
	public Set<Toy> getToys() {
		return toys;
	}
	public void setToys(Set<Toy> toys) {
		this.toys = toys;
	}
	public Child(String name) {
		super();
		this.name = name;
	}
	public Child() {
		super();
	}
	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + ", parents=" + parents + ", toys=" + toys + "]";
	}
	
	
	
}
