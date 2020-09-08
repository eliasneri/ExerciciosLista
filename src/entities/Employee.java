package entities;

public class Employee {

	private Integer id;
	private String name;
	private Double salary;
	
	public Employee() {
		
	}
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	
	public Integer getId() {
		return id;
	}
	
	public void IncreaseSalary(double percentage) {
		salary = salary + (salary * (percentage/100));
	}
	
	public String toString() {
		return id + ", " + name.toUpperCase() + ", " + String.format("%.2f", salary);
				  
	}
	
}
