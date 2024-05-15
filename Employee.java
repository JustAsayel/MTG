import java.util.Scanner;

public class Employee {
    private static final int MAX_LEAVE_REQUESTS = 200;
    private static final int LEAVE_REQUEST_FIELDS = 4;
    private final int maxEmp = 100; 
    private String name;
    private int empID;
    private String empid;
    private Scanner input;
    private String userID;
    private String[][] tickets;
    private String[][] employeeInfo;
    private String[][] leaveRequests;
    private int nEmp;
    private int numOfLeaveRequests;

    public Employee(String name, int empID, String empid) {
        this.name = name;
        this.empID = empID;
        this.empid = empid;
        this.userID = ""; 
        this.input = new Scanner(System.in); 
        this.tickets = new String[maxEmp][2];
        this.employeeInfo = new String[maxEmp][4]; 
        this.leaveRequests = new String[MAX_LEAVE_REQUESTS][LEAVE_REQUEST_FIELDS]; 
        this.nEmp = 0; 
        this.numOfLeaveRequests = 0; 
    }

    public void addEmployeeInfo(String name, int empID, int departmentID, String userID) {
        if (nEmp < maxEmp) {
            employeeInfo[nEmp][0] = name;
            employeeInfo[nEmp][1] = String.valueOf(empID);
            employeeInfo[nEmp][2] = String.valueOf(departmentID);
            employeeInfo[nEmp][3] = userID;
            nEmp++;
        } else {
            System.out.println("Maximum number of employees reached.");
        }
    }


    public void viewPersonalInfo(int empID) {
        boolean foundEmployee = false;
        for (int i = 0; i < nEmp; i++) {
            if (employeeInfo[i][1].equals(String.valueOf(empID))) {
                System.out.println("Personal information for employee with ID " + empID + ":");
                System.out.println("Name: " + employeeInfo[i][0]);
                System.out.println("Department ID: " + employeeInfo[i][2]);
                System.out.println("User ID: " + employeeInfo[i][3]);
                foundEmployee = true;
                break;
            }
        }
        if (!foundEmployee) {
            System.out.println("Employee with ID " + empID + " not found.");
        }
    }

    public void printProjects(String[][] projects) {
        System.out.println("Projects assigned to employee " + name + ":");
        for (String[] project : projects) {
            if (project[1].equals(empid) && !project[0].isEmpty()) {
                System.out.println(project[0]);
            }
        }
    }

    public void addLeaveRequest() {
        System.out.println("Enter employee ID, department ID, from date, to date (format: yyyy-mm-dd):");
        try {
            int eID = input.nextInt();
            int dID = input.nextInt();
            String fromDate = input.next();
            String toDate = input.next();
            leaveRequests[numOfLeaveRequests][0] = String.valueOf(eID);
            leaveRequests[numOfLeaveRequests][1] = String.valueOf(dID);
            leaveRequests[numOfLeaveRequests][2] = fromDate;
            leaveRequests[numOfLeaveRequests][3] = toDate;
            numOfLeaveRequests++; 
            System.out.println("Leave request added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input format. Please enter valid input.");
            input.nextLine(); 
        }
    }
    

    public void submitLeaveRequests() {
        addLeaveRequest();
    }

    public int getEmployeeID() {
        return empID;
    }

    public void addTicket(String ticketType, String details) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] == null && tickets[i][1] == null) {
                tickets[i][0] = ticketType;
                tickets[i][1] = details;
                System.out.println("Ticket added successfully.");
                return; 
            }
        }
        System.out.println("Cannot add more tickets.");
    }
    public void viewTickets() {
        System.out.println("Tickets:");
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0] != null && tickets[i][1] != null) {
                System.out.println("Ticket Type: " + tickets[i][0]);
                System.out.println("Details: " + tickets[i][1]);
            }
        }
    }
    

    public String[][] getTickets() {
        return tickets;
    }
}
