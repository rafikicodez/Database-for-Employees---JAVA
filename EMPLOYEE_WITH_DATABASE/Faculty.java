
public class Faculty extends Employee {

	/*
	 * Variables
	 */

	private String section;
	private int studentCount;
	private double baseSalary;

	/*
	 * Constructors
	 */

	public Faculty() {
	}

	public Faculty(String nameP, int employeeIDP, String phoneNumP, String addressP, String sectioinp,
			int studentCountp) {
		super(nameP, employeeIDP, phoneNumP, addressP);
		this.section = sectioinp;
		this.studentCount = studentCountp;
	}

	/*
	 * Methods
	 */

	public void printerFaculty() {
		System.out.println(this.getName() + " Section working: " + this.section);
		System.out.println(this.getName() + " Student Count: " + this.studentCount);
	}

	public void advise(String student) {
		System.out.println(this.getName() + " has started advising " + student);
		System.out.println(this.getName() + " finished advising " + student);
		System.out.println(student + " is on their way to success!");

	}

	public void expelStudent(String student) {
		System.out.println(this.getName() + " is looking over " + student + "'s record");
		System.out.println(this.getName() + " found violations of student policy");
		System.out.println(this.getName() + " started to expel " + student);
		System.out.println(student + " has been expelled");
	}

	/*
	 * Getters
	 */

	public String getSection() {
		return this.section;
	}

	public int getStudentCount() {
		return this.studentCount;
	}

	public double getBaseSalary() {
		return baseSalary;
	}
	/*
	 * Setters
	 */

	public void setSection(String sec) {
		this.section = sec;
	}

	public void setStudentCount(int count) {
		this.studentCount = count;
	}

	public void setName(String name) {
		setName(name);
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public double calculateSalary() {
		// faculty's salary only composed of basic salary
		return baseSalary;
	}

	@Override
	public void printInformation() {
		System.out.println("Faculty's name is " + getName());
		System.out.println(getName() + " " + "employeeID is " + getEmployeeID());
		System.out.println(getName() + " " + "phoneNumber is " + getPhoneNum());
		System.out.println(getName() + " address is " + getAddress());
		System.out.println(getName() + " student count is  " + studentCount);
		System.out.println(getName() + " section is  " + section);
		System.out.println(getName() + " gets a base salary of " + baseSalary);

	}

	/*
	 * gets an overtime compensation of 10% of base salary
	 */
	@Override
	public double overTimeCompesation() {
		
		return 0.1*baseSalary;
	}

}
