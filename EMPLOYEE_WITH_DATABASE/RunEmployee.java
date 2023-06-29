import java.util.Scanner;

public class RunEmployee {

	// To prompt user for input
	private Scanner employeeScanner = new Scanner(System.in);
	private Database database = Database.instance();

	public static void main(String[] args) {

		// instance of RunEmployee to be able to call member methods
		RunEmployee runEmp = new RunEmployee();

		// when program starts it should start with few users below in the database

		Professor professor = new Professor("Professor Skywalker", 1247, "011110001", "n00b court", "Maths Major", "",
				12);
		professor.setBaseSalary(20000);
		professor.setExtraPay(1000);
		professor.setBonus(500);

		Admin admin = new Admin("Nicholas", 3424, "01120021", "1337 Lane", "Maths Department Admininstrator",
				"maintaining discipline in the  math department", 4, "LA");

		admin.setBaseSalary(1500);
		admin.setBonus(700);

		Faculty faculty = new Faculty("Alexander", 8458, "0102340202", "8675309 Lane", "Literature", 34);
		faculty.setBaseSalary(1000);

		// add the few employees to the database
		runEmp.database.professorDB.add(professor);
		runEmp.database.adminDB.add(admin);
		runEmp.database.facultyDB.add(faculty);

		while (true) {

			System.out.println("Choose one of the following options.");
			System.out.println("1. Process Professor.");
			System.out.println("2. Process Admin.");
			System.out.println("3. Process Faculty.");
			System.out.println("Q. Quit Program.");

			String opSelected = runEmp.employeeScanner.nextLine();
			// check if user wants to quit
			runEmp.checkUserExitStatus(opSelected);
			// handle user selected operation
			runEmp.handleInputProcessOption(opSelected);

		}

	}

	private void handleInputProcessOption(String operationType) {
		int operation = -1;
		try {
			operation = Integer.parseInt(operationType);

		} catch (Exception nfe) {
			System.out.println("Only numerical types accepted ie. 1,2,3 and alphabet Q");
		}

		switch (operation) {
		case 1:
			// ask which professor CRUD operation to perform

			System.out.println("Choose one of the following operations.");
			System.out.println("1. Add a new Professor.");
			System.out.println("2. Display information of a professor.");
			System.out.println("3. Update information of a professor");
			System.out.println("4. Delete a professor from Database.");
			System.out.println("5. Display all professors in the Database");
			System.out.println("Q. Quit program.");

			// prompt for prof operation
			String profOp = employeeScanner.nextLine();
			handleProfessorOperation(profOp);
			break;
		case 2:
			// prompt which Administrator CRUD to process
			System.out.println("Choose one of the following operations.");
			System.out.println("1. Add a new Administrator.");
			System.out.println("2. Display information of an Adminstrator.");
			System.out.println("3. Update information of an Adminstrator");
			System.out.println("4. Delete an Adminstrator from Database.");
			System.out.println("5. Display all Administrators in the Database.");
			System.out.println("Q. Quit program.");

			// prompt for admin operation
			String adminOp = employeeScanner.nextLine();
			handleAdministratorOperation(adminOp);
			break;
		case 3:
			// prompt which Faculty CRUD operation to process
			System.out.println("Choose one of the following operations.");
			System.out.println("1. Add a new Faculty.");
			System.out.println("2. Display information of a Faculty.");
			System.out.println("3. Update information of a Faculty");
			System.out.println("4. Delete a Faculty from Database.");
			System.out.println("5. Display all Faculty in the Database.");
			System.out.println("Q. Quit program.");

			// prompt for faculty operation
			String facultyOp = employeeScanner.nextLine();
			handleFacultyOperation(facultyOp);
			break;
		default:
			System.out.println("Option entered not supported");
			checkUserExitStatus("q");
			break;
		}

	}

	private void handleFacultyOperation(String facultyOp) {
		checkUserExitStatus(facultyOp);
		int facultyOperation = -1;
		try {
			facultyOperation = Integer.parseInt(facultyOp);
		} catch (Exception e) {
			System.out.println("Faculty operation can only be of numerical type");
		}

		switch (facultyOperation) {
		case 1:

			// add a new faculty
			String name;
			String employeeID;
			String phoneNumber;
			String address;
			String section;
			String studentCount;
			String baseSalary;

			// take faculty properties
			System.out.println("Enter faculty name.");
			name = employeeScanner.nextLine();
			System.out.println("Enter faculty employeeID.");
			employeeID = employeeScanner.nextLine();
			System.out.println("Enter faculty PhoneNumber.");
			phoneNumber = employeeScanner.nextLine();
			System.out.println("Enter faculty address.");
			address = employeeScanner.nextLine();
			System.out.println("Enter faculty section");
			section = employeeScanner.nextLine();
			System.out.println("Enter faculty student count");
			studentCount = employeeScanner.nextLine();
			System.out.println("Enter faculty base salary.");
			baseSalary = employeeScanner.nextLine();

			try {
				Faculty faculty = new Faculty(name, Integer.parseInt(employeeID), phoneNumber, address, section,
						Integer.parseInt(studentCount));
				faculty.setBaseSalary(Integer.parseInt(baseSalary));
				database.facultyDB.add(faculty);
			} catch (Exception e) {
				System.out.println("Faculty was not created due to some wrong input(s)");
				checkUserExitStatus("q");
			}
			break;
		case 2:
			// display information of a faculty
			System.out.println("Enter faculty ID to display their information.");
			String faclID = employeeScanner.nextLine();

			if (database.facultyDB.size() == 0) {
				System.out.println("No information available for the faculty with ID specified");
			} else {
				for (Faculty fc : database.facultyDB) {
					try {
						if (fc.getEmployeeID() == Integer.parseInt(faclID)) {
							printHeader(fc.getName());
							fc.printInformation();
						}
					} catch (Exception e) {
						System.out.println("Wrong input for faculty ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}
			break;
		case 3:

			// update information of a faculty
			String newName;
			String newEmployeeID;
			String oldEmployeeID;
			String newPhoneNumber;
			String newAddress;
			String newSection;
			String newStudentCount;
			String newBaseSalary;

			System.out.println("Enter facultyID to update");
			oldEmployeeID = employeeScanner.nextLine();

			for (Faculty ff : database.facultyDB) {
				try {
					if (ff.getEmployeeID() == Integer.parseInt(oldEmployeeID)) {
						// remove old faculty
						database.facultyDB.remove(ff);
						// take faculty properties
						System.out.println("Enter new faculty name.");
						newName = employeeScanner.nextLine();
						System.out.println("Enter new faculty employeeID.");
						newEmployeeID = employeeScanner.nextLine();
						System.out.println("Enter new faculty PhoneNumber.");
						newPhoneNumber = employeeScanner.nextLine();
						System.out.println("Enter new faculty address.");
						newAddress = employeeScanner.nextLine();
						System.out.println("Enter new faculty section");
						newSection = employeeScanner.nextLine();
						System.out.println("Enter new faculty student count");
						newStudentCount = employeeScanner.nextLine();
						System.out.println("Enter new faculty base salary.");
						newBaseSalary = employeeScanner.nextLine();

						// create and add new faculty to database
						Faculty faculty = new Faculty(newName, Integer.parseInt(newEmployeeID), newPhoneNumber,
								newAddress, newSection, Integer.parseInt(newStudentCount));
						faculty.setBaseSalary(Integer.parseInt(newBaseSalary));

						database.facultyDB.add(faculty);
					}
				} catch (Exception e) {
					System.out.println("Faculty was not updated due to some wrong input(s)");
					checkUserExitStatus("q");
				}
			}

			break;
		case 4:

			// delete a faculty
			System.out.println("Enter faculty ID to delete.");
			String fccID = employeeScanner.nextLine();

			if (database.facultyDB.size() == 0) {
				System.out.println("No information available for the faculty with ID specified");
			} else {
				for (Faculty facll : database.facultyDB) {
					try {
						if (facll.getEmployeeID() == Integer.parseInt(fccID)) {
							database.facultyDB.remove(facll);
							System.out.println("faculty with id " + fccID + " was deleted successfully");
						}
					} catch (Exception e) {
						System.out.println("Wrong input for faculty ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}

			break;
		case 5:
			if (database.facultyDB.size() == 0)
				System.out.println("No infomation available for faculty");
			for (Faculty faa : database.facultyDB) {
				printHeader(faa.getName());
				faa.printInformation();
			}

			break;
		default:
			System.out.println("Operation for fuculty not supporte");
			checkUserExitStatus("q");
			break;
		}

	}

	private void handleAdministratorOperation(String adminOp) {
		checkUserExitStatus(adminOp);
		int adminstratorOperation = -1;
		try {
			adminstratorOperation = Integer.parseInt(adminOp);
		} catch (Exception e) {
			System.out.println("Administrator operation can only be of numerical type");
		}

		switch (adminstratorOperation) {
		case 1:
			// add a new administrator
			String name;
			String employeeID;
			String phoneNumber;
			String address;
			String title;
			String responsibilities;
			String workLocation;
			String baseSalary;
			String bonus;

			// take admin properties
			System.out.println("Enter admin name.");
			name = employeeScanner.nextLine();
			System.out.println("Enter admin employeeID.");
			employeeID = employeeScanner.nextLine();
			System.out.println("Enter admin PhoneNumber.");
			phoneNumber = employeeScanner.nextLine();
			System.out.println("Enter admin address.");
			address = employeeScanner.nextLine();
			System.out.println("Enter admin title");
			title = employeeScanner.nextLine();
			System.out.println("Enter admin responsibilities");
			responsibilities = employeeScanner.nextLine();
			System.out.println("Enter admin base salary.");
			baseSalary = employeeScanner.nextLine();
			System.out.println("Enter admin work location");
			workLocation = employeeScanner.nextLine();
			System.out.println("Enter admin bonus");
			bonus = employeeScanner.nextLine();

			try {
				Admin admin = new Admin(name, Integer.parseInt(employeeID), phoneNumber, address, title,
						responsibilities, 0, workLocation);

				admin.setBaseSalary(Integer.parseInt(baseSalary));
				admin.setBonus(Integer.parseInt(bonus));
				database.adminDB.add(admin);
			} catch (Exception e) {
				System.out.println("Admin was not created due to some wrong input(s)");
				checkUserExitStatus("q");
			}
			break;
		case 2:

			// display information of an administrator
			System.out.println("Enter administrator ID to display their information.");
			String admID = employeeScanner.nextLine();

			if (database.adminDB.size() == 0) {
				System.out.println("No information available for the administrator with ID specified");
			} else {
				for (Admin adm : database.adminDB) {
					try {
						if (adm.getEmployeeID() == Integer.parseInt(admID)) {
							printHeader(adm.getName());
							adm.printInformation();
						}
					} catch (Exception e) {
						System.out.println("Wrong input for administrator ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}
			break;
		case 3:

			// update information of an administrator
			String newName;
			String newEmployeeID;
			String oldEmployeeID;
			String newPhoneNumber;
			String newAddress;
			String newTitle;
			String newResponsibilities;
			String newWorkLocation;
			String newBaseSalary;
			String newBonus;

			System.out.println("Enter adminID to update");
			oldEmployeeID = employeeScanner.nextLine();

			for (Admin addd : database.adminDB) {
				try {
					if (addd.getEmployeeID() == Integer.parseInt(oldEmployeeID)) {

						// remove old admin
						database.adminDB.remove(addd);

						// take new admin properties
						System.out.println("Enter admin new name.");
						newName = employeeScanner.nextLine();
						System.out.println("Enter admin new employeeID.");
						newEmployeeID = employeeScanner.nextLine();
						System.out.println("Enter admin new PhoneNumber.");
						newPhoneNumber = employeeScanner.nextLine();
						System.out.println("Enter admin new address.");
						newAddress = employeeScanner.nextLine();
						System.out.println("Enter admin new title");
						newTitle = employeeScanner.nextLine();
						System.out.println("Enter admin new responsibilities");
						newResponsibilities = employeeScanner.nextLine();
						System.out.println("Enter admin new base salary.");
						newBaseSalary = employeeScanner.nextLine();
						System.out.println("Enter admin new work location");
						newWorkLocation = employeeScanner.nextLine();
						System.out.println("Enter admin new bonus");
						newBonus = employeeScanner.nextLine();

						// update admin with new properties
						Admin admin = new Admin(newName, Integer.parseInt(newEmployeeID), newPhoneNumber, newAddress,
								newTitle, newResponsibilities, 0, newWorkLocation);

						admin.setBaseSalary(Integer.parseInt(newBaseSalary));
						admin.setBonus(Integer.parseInt(newBonus));
						database.adminDB.add(admin);
					}
				} catch (Exception e) {
					System.out.println("Admin was not updated due to some wrong input(s)");
					checkUserExitStatus("q");
				}
			}

			break;
		case 4:

			// delete an administrator from database
			System.out.println("Enter Admin ID to delete.");
			String admnnID = employeeScanner.nextLine();

			if (database.adminDB.size() == 0) {
				System.out.println("No information available for the admin with ID specified");
			} else {
				for (Admin ad : database.adminDB) {
					try {
						if (ad.getEmployeeID() == Integer.parseInt(admnnID)) {
							database.adminDB.remove(ad);
							System.out.println("Admin with id " + admnnID + " was deleted successfully");
						}
					} catch (Exception e) {
						System.out.println("Wrong input for admin ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}
			break;
		case 5:
			// display all administrators in the database
			if (database.adminDB.size() == 0)
				System.out.println("No infomation available for administrators");
			for (Admin add : database.adminDB) {
				printHeader(add.getName());
				add.printInformation();
			}
			break;
		default:
			System.out.println("Operation for admin not supported");
			checkUserExitStatus("q");
			break;
		}

	}

	private void handleProfessorOperation(String profOp) {
		checkUserExitStatus(profOp);
		int profOperation = -1;
		try {
			profOperation = Integer.parseInt(profOp);
		} catch (Exception e) {
			System.out.println("Professor operation can only be of numerical type");
		}

		switch (profOperation) {
		case 1:
			// add a new professor
			String name;
			String employeeID;
			String phoneNumber;
			String address;
			String subject;
			String numberOfYearsTaught;
			String baseSalary;
			String extraPay;
			String bonus;

			// take professor properties
			System.out.println("Enter professor name.");
			name = employeeScanner.nextLine();
			System.out.println("Enter professor employeeID.");
			employeeID = employeeScanner.nextLine();
			System.out.println("Enter professor PhoneNumber.");
			phoneNumber = employeeScanner.nextLine();
			System.out.println("Enter professor address.");
			address = employeeScanner.nextLine();
			System.out.println("Enter professor subject");
			subject = employeeScanner.nextLine();
			System.out.println("Enter professor number of years taught");
			numberOfYearsTaught = employeeScanner.nextLine();
			System.out.println("Enter professor base salary.");
			baseSalary = employeeScanner.nextLine();
			System.out.println("Enter professor extra pay");
			extraPay = employeeScanner.nextLine();
			System.out.println("Enter professor bonus");
			bonus = employeeScanner.nextLine();

			try {
				Professor professor = new Professor(name, Integer.parseInt(employeeID), phoneNumber, address, subject,
						"", Integer.parseInt(numberOfYearsTaught));
				professor.setBaseSalary(Integer.parseInt(baseSalary));
				professor.setExtraPay(Integer.parseInt(extraPay));
				professor.setBonus(Integer.parseInt(bonus));
				database.professorDB.add(professor);
			} catch (Exception e) {
				System.out.println("Professor was not created due to some wrong input(s)");
				checkUserExitStatus("q");
			}

			break;
		case 2:
			// display information of a professor
			System.out.println("Enter professor ID to display their information.");
			String professorID = employeeScanner.nextLine();

			if (database.professorDB.size() == 0) {
				System.out.println("No information available for the professor with ID specified");
			} else {
				for (Professor pf : database.professorDB) {
					try {
						if (pf.getEmployeeID() == Integer.parseInt(professorID)) {
							printHeader(pf.getName());
							pf.printInformation();
						}
					} catch (Exception e) {
						System.out.println("Wrong input for professor ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}
			break;
		case 3:
			// update information of a professor
			String newName;
			String newEmployeeID;
			String oldEmployerID;
			String newPhoneNumber;
			String newAddress;
			String newSubject;
			String newNumberOfYearsTaught;
			String newBaseSalary;
			String newExtraPay;
			String newBonus;

			System.out.println("Enter professor ID to update");
			oldEmployerID = employeeScanner.nextLine();

			for (Professor prfss : database.professorDB) {
				try {
					// remove old professor from system
					if (prfss.getEmployeeID() == Integer.parseInt(oldEmployerID)) {
						database.professorDB.remove(prfss);

						// take professor properties
						System.out.println("Enter new professor name.");
						newName = employeeScanner.nextLine();
						System.out.println("Enter new professor employeeID.");
						newEmployeeID = employeeScanner.nextLine();
						System.out.println("Enter new professor PhoneNumber.");
						newPhoneNumber = employeeScanner.nextLine();
						System.out.println("Enter new professor address.");
						newAddress = employeeScanner.nextLine();
						System.out.println("Enter new professor subject");
						newSubject = employeeScanner.nextLine();
						System.out.println("Enter new professor number of years taught");
						newNumberOfYearsTaught = employeeScanner.nextLine();
						System.out.println("Enter new professor base salary.");
						newBaseSalary = employeeScanner.nextLine();
						System.out.println("Enter new professor extra pay");
						newExtraPay = employeeScanner.nextLine();
						System.out.println("Enter new professor bonus");
						newBonus = employeeScanner.nextLine();

						// create and add a new professor
						Professor professor = new Professor(newName, Integer.parseInt(newEmployeeID), newPhoneNumber,
								newAddress, newSubject, "", Integer.parseInt(newNumberOfYearsTaught));
						professor.setBaseSalary(Integer.parseInt(newBaseSalary));
						professor.setExtraPay(Integer.parseInt(newExtraPay));
						professor.setBonus(Integer.parseInt(newBonus));

						database.professorDB.add(professor);
					}

				} catch (Exception e) {
					System.out.println("Professor was not updated due to some wrong input(s)");
					checkUserExitStatus("q");
				}
			}

			break;
		case 4:
			// delete professor
			System.out.println("Enter professor ID to delete.");
			String professorsID = employeeScanner.nextLine();

			if (database.professorDB.size() == 0) {
				System.out.println("No information available for the professor with ID specified");
			} else {
				for (Professor pf : database.professorDB) {
					try {
						if (pf.getEmployeeID() == Integer.parseInt(professorsID)) {
							database.professorDB.remove(pf);
							System.out.println("Professor with id " + professorsID + " was deleted successfully");
						}
					} catch (Exception e) {
						System.out.println("Wrong input for professor ID, try again..");
						checkUserExitStatus("q");
					}

				}
			}
			break;
		case 5:
			// list all professor
			if (database.professorDB.size() == 0)
				System.out.println("No infomation available for professors");
			for (Professor pf : database.professorDB) {
				printHeader(pf.getName());
				pf.printInformation();
			}

			break;
		default:
			System.out.println("Operation for professor not supported");
			checkUserExitStatus("q");
			break;
		}

	}

	private void checkUserExitStatus(String quit) {
		if (quit.equalsIgnoreCase("Q")) {
			// message to user showing program is quitting
			System.out.println("byee...");
			// inform the operating system program quitting
			System.exit(0);
			return;
		}

	}

	private void printHeader(String name) {

		System.out.println("*************************************************");
		System.out.println("INFORMATION FOR: " + name);
		System.out.println("*************************************************");
	}

}
