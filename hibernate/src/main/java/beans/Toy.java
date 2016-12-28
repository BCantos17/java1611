package beans;

import javax.persistence.*;

@Entity
public class Toy {
	@Id
	@Column(name="TOY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) // HIBERNATE_SEQUENCE
	private int id;
	@Column
	private String description;
	@Column
	private boolean noisy;
	
	// Bi-directional relationships
	// inverse of the Child.toys property
	@ManyToOne
	@JoinColumn(name="TOY_OWNER_ID", nullable=true)
	private Child owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isNoisy() {
		return noisy;
	}

	public void setNoisy(boolean noisy) {
		this.noisy = noisy;
	}

	public Child getOwner() {
		return owner;
	}

	public void setOwner(Child owner) {
		this.owner = owner;
	}

	public Toy(String description, boolean noisy, Child owner) {
		super();
		this.description = description;
		this.noisy = noisy;
		this.owner = owner;
	}

	public Toy() {
		super();
	}

	@Override
	public String toString() {
		return "Toy [id=" + id + ", description=" + description + ", noisy=" + noisy + ", owner=" + owner + "]";
	}
	
	
	
}
