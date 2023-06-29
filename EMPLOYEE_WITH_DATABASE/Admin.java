import java.util.Scanner;

public class Admin extends Employee {

	/*
	 * Variables
	 */

	private String jobTitle;
	private String responsibilities;
	private int numCalls;
	private String workLocation;
	private double baseSalary;
	private double bonus;
	Scanner scan = new Scanner(System.in);

	public Admin(String nameP, int employeeIDP, String phoneNumP, String addressP, String titleP,
			String responsibilitiesP, int numCallsP, String workLocal) {
		// To use the Employee code you need to use the Super and the values needed in
		// the employee class
		super(nameP, employeeIDP, phoneNumP, addressP);
		this.jobTitle = titleP;
		this.responsibilities = responsibilitiesP;
		this.numCalls = numCallsP;
		this.workLocation = workLocal;
	}

	/*
	 * Methods
	 */

	public void printerAdmin() {
		System.out.println("Job title: " + this.jobTitle);
		System.out.println("Job responsibilities: " + this.responsibilities);
		System.out.println("Number of Calls: " + Integer.toString(this.numCalls));
		System.out.println("Assigned Working Location: " + this.workLocation);
	}

	public void repairComputer(int compNum) {
		System.out.println(this.getName() + " Starting repair process");
		System.out.println(this.getName() + " Connecting to Computer " + compNum);
		System.out.println(this.getName() + " Repairing Computer " + compNum);
		System.out.println(this.getName() + " Finished repairing Computer " + compNum);
	}

	public void troubleshoot() {
		System.out.println(this.getName() + " ...Entering Troubleshooting mode...");
		System.out.println("Enter value for troubleshooting options");
		System.out.println("Enter 1 for Monitor issues");
		System.out.println("Enter 2 for Network issues");
		System.out.println("Enter 3 for PC Issues");
		int i = scan.nextInt();
		if (i == 1) {
			System.out.println(this.getName() + " Fixing monitor issues");
		} else if (i == 2) {
			System.out.println(this.getName() + " Fixing Network issues");
		} else {
			System.out.println(this.getName() + " Fixing PC issues");
		}
	}

	/*
	 * Getters
	 */

	public String getTitle() {
		return this.jobTitle;
	}

	public String getResposibilities() {
		return this.responsibilities;
	}

	public int getNumCalls() {
		return this.numCalls;
	}

	public String getWorkLocation() {
		return this.workLocation;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getBonus() {
		return bonus;
	}

	/*
	 * Setters
	 */
	public void setTitle(String title) {
		this.jobTitle = title;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public void setNumCalls(int numCalls) {
		this.numCalls = numCalls;
	}

	public void setWorkLocation(String local) {
		this.workLocation = local;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public double calculateSalary() {
		// admin's pay is composed of base salary and bonus
		return baseSalary + bonus;
	}

	@Override
	public void printInformation() {

		System.out.println("Admin's name is " + getName());
		System.out.println(getName() + " " + "employeeID is " + getEmployeeID());
		System.out.println(getName() + " " + "phoneNumber is " + getPhoneNum());
		System.out.println(getName() + " address is " + getAddress());
		System.out.println(getName() + " responsibilities are  " + responsibilities);
		System.out.println(getName() + " work location is  " + workLocation);
		System.out.println(getName() + " gets a base salary of " + baseSalary);
		System.out.println(getName() + " gets a bonus of " + bonus);

	}

	
	// overtime compensation of 15% of base salary
	 
	@Override
	public double overTimeCompesation() {
		return 0.15 * baseSalary;
	}

}
