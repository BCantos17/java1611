package comparator;

public class Bean implements Comparable<Bean>{
	
	private int id; // natural order
	private String variable; 
	private String description;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
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
		Bean other = (Bean) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (variable == null) {
			if (other.variable != null)
				return false;
		} else if (!variable.equals(other.variable))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bean [id=" + id + ", variable=" + variable + ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Bean(int id, String variable, String description) {
		super();
		this.id = id;
		this.variable = variable;
		this.description = description;
	}
	public Bean() {
		super();
	}
	@Override
	public int compareTo(Bean o) {
		return this.id - o.id;
	}
}
