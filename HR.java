public class HR {
    private final double bonusSal;
    private final int attPer;
    private final Object[][] eInfo;
    private final int mEmp;
    private final String[][] tickets;

    public HR(double bonusSal, int attPer, int mEmp) {
        this.bonusSal = bonusSal;
        this.attPer = attPer;
        this.mEmp = mEmp;
        this.eInfo = new Object[mEmp][4];
        this.tickets = new String[mEmp][4];
    }

    public void searchEmp(int id, int departmentID) {
        boolean foundEmp = false;
        for (int i = 0; i < mEmp; i++) {
            if (eInfo[i] != null && (int) eInfo[i][1] == id && (int) eInfo[i][2] == departmentID) {
                System.out.println(
                        "Employee found: " + eInfo[i][0] + ", ID: " + eInfo[i][1] + ", Department ID: " + eInfo[i][2]);
                foundEmp = true;
                break;
            }
        }
        if (!foundEmp) {
            System.out.println("Employee not found.");
        }
    }
    

    public void addEmployeeInfo(String name, int id, int departmentID, String departmentName) {
        for (int i = 0; i < mEmp; i++) {
            if (eInfo[i][0] == null) {
                eInfo[i][0] = name;
                eInfo[i][1] = id;
                eInfo[i][2] = departmentID;
                eInfo[i][3] = departmentName;
                System.out.println("Employee added successfully.");
                return;
            }
        }
        System.out.println("Cannot add more employees.");
    }
    


    public void SalaryCalculation(String name, int basicSalary, int attendance, double bonusPercentage) {
        System.out.println("Employee: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Attendance: " + attendance + "%");

        int salaryBeforeBonus = (int) (basicSalary * (attendance / 100.0));
        double bonus = 0.0;

        if (bonusPercentage > 0 && attendance >= 97) {
            bonus = basicSalary * (bonusPercentage / 100.0);
        }

        int salaryAfterBonus = (int) (salaryBeforeBonus + bonus);

        System.out.println("Salary calculated for employee " + name + " (before bonus): " + salaryBeforeBonus);
        if (bonus > 0) {
            System.out.println("Bonus: " + bonus);
        }
        System.out.println("Salary calculated for employee " + name + " (after bonus): " + salaryAfterBonus);
    }

    public boolean acceptLeave(int employeeID, String leaveType, int duration) {
        return true;
    }

    public void addTicket(String ticketType, String details) {
        for (int i = 0; i < mEmp; i++) {
            if (tickets[i][0] == null && tickets[i][1] == null) {
                tickets[i][0] = ticketType;
                tickets[i][1] = details;
                System.out.println("Ticket added successfully.");
                return;
            }
        }
        System.out.println("Cannot add more tickets.");
    }

    public String[][] getTickets() {
        return tickets;
    }
}
