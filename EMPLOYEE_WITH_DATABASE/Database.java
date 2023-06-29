import java.util.ArrayList;

public class Database {
	/*
	 * ArrayList to act as database for performing Employee CRUD operations They are
	 * all made public because we want them to be used throughout the application.
	 * Making them public means that they can be modified anywhere throughout the
	 * application,the good thing is that only one database instance can exist hence
	 * all files in the application will have access to same database reference.
	 */
	public ArrayList<Professor> professorDB = new ArrayList<Professor>();
	public ArrayList<Admin> adminDB = new ArrayList<Admin>();
	public ArrayList<Faculty> facultyDB = new ArrayList<Faculty>();
	public static Database database = null;

	// It is important to make database constructor private to ensure it can only
	// be created from within this class.
	// The reason to make it private is to always ensure that only one instance of
	// database can exist.
	// This feature ensures data integrity
	private Database() {

	}

	// create a database only when it does not exist
	// when a database exist return it
	public static Database instance() {

		if (database == null) {
			database = new Database();
		}
		return database;
	}

}
