
public abstract class Employee {

	private String name;
	private int employeeID;
	private String phoneNum;
	private String address;

	/*
	 * Constructors
	 */
	public Employee() {
	}

	public Employee(String nameP, int employeeIDP, String phoneNumP, String addressP) {
		this.name = nameP;
		this.employeeID = employeeIDP;
		this.phoneNum = phoneNumP;
		this.address = addressP;
	}
	/*
	 * Methods
	 */

	public void Admin() {
		System.out.println("Employee: " + this.name);
		System.out.println("ID = " + Integer.toString(this.employeeID));
		System.out.println("Phone Number: " + this.phoneNum);
		System.out.println("Address: " + this.address);
	}

	/*
	 * Getters
	 */
	public String getName() {
		return this.name;
	}

	public int getEmployeeID() {
		return this.employeeID;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public String getAddress() {
		return this.address;
	}

	/*
	 * Setters
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setEmployeeID(int id) {
		this.employeeID = id;
	}

	public void setPhoneNum(String num) {
		this.phoneNum = num;
	}

	public void setAddress(String add) {
		this.address = add;
	}

	/*
	 * Abstract Methods
	 */
	public abstract double calculateSalary();

	public abstract void printInformation();

	public abstract double overTimeCompesation();

}
