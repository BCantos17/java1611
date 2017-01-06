package soap;

public class JavaBean {

	private int id;
	private String beanName;
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public JavaBean(int id, String beanName, String author) {
		super();
		this.id = id;
		this.beanName = beanName;
		this.author = author;
	}
	public JavaBean() {
		super();
	}
	@Override
	public String toString() {
		return "JavaBean [id=" + id + ", beanName=" + beanName + ", author=" + author + "]";
	}
	
	
	
}
