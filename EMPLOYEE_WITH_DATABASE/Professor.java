
public class Professor extends Employee {

	/*
	 * variables
	 */
	private String subject;
	private String type;
	private int yearTaught;
	private double baseSalary;
	private double bonus;
	private double extraPay;

	/*
	 * Constructors
	 */
	public Professor() {
	}

	public Professor(String nameP, int employeeIDP, String phoneNumP, String addressP, String subjectP, String typep,
			int yearTaughtP) {
		super(nameP, employeeIDP, phoneNumP, addressP);
		this.subject = subjectP;
		this.type = typep;
		this.yearTaught = yearTaughtP;
	}

	/*
	 * Methods
	 */

	public void printerProf() {
		System.out.println(this.getName() + " Subject Taught: " + this.subject);
		System.out.println(this.getName() + " Professor Type: " + this.type);
		System.out.println(this.getName() + "Years Taught: " + this.yearTaught);
	}

	public void teach() {
		System.out.println(this.getName() + " is starting lessons!");
		System.out.println(this.getName() + " is teaching " + this.subject);
		System.out.println(this.getName() + " finished teaching!");
	}

	public void grade(String stdName) {
		System.out.println(this.getName() + " is grading " + stdName + " homwork.");
		System.out.println(this.getName() + " finished grading!");
	}

	/*
	 * Getters
	 */

	public int getYearTaught() {
		return this.yearTaught;
	}

	public String getSubject() {
		return this.subject;
	}

	public String getType() {
		return this.type;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getBonus() {
		return bonus;
	}

	public double getExtraPay() {
		return extraPay;
	}

	/*
	 * Setters
	 */
	public void setYearTaught(int years) {
		this.yearTaught = years;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setExtraPay(double extraPay) {
		this.extraPay = extraPay;
	}

	@Override
	public void setName(String name) {
		setName(name);
	}

	
	 // Implementations for abstract methods
	 
	@Override
	public double calculateSalary() {

		// adding components that add up to total salary
		return baseSalary + bonus + extraPay;
	}

	@Override
	public void printInformation() {
		System.out.println("Professor' name is " + getName());
		System.out.println(getName() + " " + "employeeID is " + getEmployeeID());
		System.out.println(getName() + " " + "phoneNumber is " + getPhoneNum());
		System.out.println(getName() + " address is " + getAddress());
		System.out.println(getName() + " teaches " + subject);
		System.out.println(getName() + " has taught " + yearTaught + " years");
		System.out.println(getName() + " gets a base salary of " + baseSalary);
		System.out.println(getName() + " gets a bonus of " + bonus);
		System.out.println(getName() + " gets an extra Pay of " + extraPay);
	}

	
	 // gets an overtime compensation of 20% of base salary
	
	@Override
	public double overTimeCompesation() {

		return 0.2 * baseSalary;
	}

}
