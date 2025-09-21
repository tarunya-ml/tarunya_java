// Interface for Student-related details
interface Studentdetails {
    // Abstract methods for student information
    void studentName(String studentname);
    void studentAge(int Studentage);
    void studentSection(String Studentsection);
    void studentID(Long Studentid);

    // Default method (common functionality for all students)
    default void collegeName() {
        System.out.println("Welcome to IILM University");
    }
}

// Interface for Faculty-related details
interface FacultyDetails {
    void FacultyName(String facultyname);
    void FacultyAge(int facultage);
    void FacultySubject(String facultysubject);
    void FacultyID(Long facultyid);
    void FacultySalary(float Facultysalary);
}

// Interface combining both Student and Faculty details
// Demonstrates multiple inheritance in interfaces
interface CollegeData extends FacultyDetails, Studentdetails {
    void TotalRevenue(Double totalRevenue);
    void TotalExpenditure(Double totalExpenditure);
    void NetMargin();
    void campusArea(double campusarea);

    // Overriding default method (different implementation than Studentdetails)
    default void collegeName() {
        System.out.println("IILM University");
    }
}

// Implementation class that defines all abstract methods
class Data implements CollegeData {
    // Defining private attributes for encapsulation
    private String Studentname;
    private int Studentage;
    private String StudentSection;
    private Long StudentID;
    private String facultyname;
    private int facultage;
    private String facultysubject;
    private Long facultyid;
    private float Facultysalary;
    private Double totalRevenue;
    private Double totalExpenditure;
    private double netmargin;
    private double campusarea;

    // Constants for output formatting----> final means the variable can only be assigned once (like a constant).
    private static final String CURRENCY = "cr";
    private static final String AREA_UNIT = "acre";

    // ------------------- Student Details -------------------
    @Override
    public void studentName(String studentname) {
        collegeName(); // Call default method to print college name
        this.Studentname = studentname;
        System.out.println("Student name is: " + Studentname);
    }

    @Override
    public void studentAge(int Studentage) {
        this.Studentage = Studentage;
        System.out.println(Studentname + " age is: " + Studentage);
    }

    @Override
    public void studentSection(String Studentsection) {
        this.StudentSection = Studentsection;
        System.out.println(Studentname + " Section allotted is: " + StudentSection);
    }

    @Override
    public void studentID(Long Studentid) {
        this.StudentID = Studentid;
        System.out.println(Studentname + " ID number is: " + StudentID);
    }

    // ------------------- Faculty Details -------------------
    @Override
    public void FacultyName(String facultyname) {
        this.facultyname = facultyname;
        System.out.println("Faculty name is: " + facultyname);
    }

    @Override
    public void FacultyAge(int facultage) {
        this.facultage = facultage;
        System.out.println(facultyname + " age is: " + facultage);
    }

    @Override
    public void FacultySubject(String facultysubject) {
        this.facultysubject = facultysubject;
        System.out.println(facultyname + " teaches " + facultysubject);
    }

    @Override
    public void FacultyID(Long facultyid) {
        this.facultyid = facultyid;
        System.out.println(facultyname + " ID is : " + facultyid);
    }

    @Override
    public void FacultySalary(float Facultysalary) {
        this.Facultysalary = Facultysalary;
        System.out.println(facultyname + " salary is: " + Facultysalary);
    }

    // ------------------- College Data -------------------
    @Override
    public void TotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
        System.out.println("In 2024 the Total Revenue generated is: " + totalRevenue + " " + CURRENCY);
    }

    @Override
    public void TotalExpenditure(Double totalExpenditure) {
        this.totalExpenditure = totalExpenditure;
        System.out.println("Total Expenditure in 2024 is: " + totalExpenditure + " " + CURRENCY);
    }

    @Override
    public void NetMargin() {
        if (totalRevenue != null && totalExpenditure != null) {
            netmargin = totalRevenue - totalExpenditure;
            System.out.println("This Year college generated a Net Margin of: " + netmargin + " " + CURRENCY);
        } else {
            System.out.println("Revenue and Expenditure data missing!");
        }
    }

    @Override
    public void campusArea(double campusarea) {
        this.campusarea = campusarea;
        System.out.println("Total used Campus area in 2024 is: " + campusarea + " " + AREA_UNIT);
    }
}

// ------------------- Main Class -------------------
public class InheritanceInInterface {
    public static void main(String[] tarunya) {
        // Creating object of Data class
        Data ObjData = new Data();

        // Calling Student-related methods
        ObjData.studentName("Tarun chaudhary");
        ObjData.studentAge(20);
        ObjData.studentSection("2CSE24");
        ObjData.studentID(2410031531L);

        // Calling Faculty-related methods
        ObjData.FacultyName("Rahul Singh");
        ObjData.FacultyAge(45);
        ObjData.FacultySubject("Maths");
        ObjData.FacultyID(2410096313L);
        ObjData.FacultySalary(150000);

        // Calling College-related methods
        ObjData.TotalRevenue(500.34);
        ObjData.TotalExpenditure(300.50);
        ObjData.NetMargin();
        ObjData.campusArea(30);
    }
}
