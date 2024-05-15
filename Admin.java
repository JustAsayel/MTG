import java.util.Scanner;

public class Admin {
    private static final int MAX_EMP = 200;
    private static final int EMP = 4;

    private Object[][] eInfo;
    private int nEmp;
    private HR hr;
    private User user;
    private Employee employee;

    public Admin() {
        eInfo = new Object[MAX_EMP][EMP];
        nEmp = 0;
    }

    public Admin() {
        eInfo = new Object[MAX_EMP][EMP];
        nEmp = 0;
        this.hr = null;
        this.user = null;
        this.employee = null;
    }

    public void addEmp(String name, int id, int departmentID, int userID) {
        if (nEmp < MAX_EMP) {
            eInfo[nEmp][0] = name;
            eInfo[nEmp][1] = id;
            eInfo[nEmp][2] = departmentID;
            eInfo[nEmp][3] = userID;
            nEmp++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Cannot add more employees. Maximum limit reached.");
        }
    }

    public void searchEmp(int id, int departmentID) {
        boolean foundEmp = false;
        for (int i = 0; i < nEmp; i++) {
            if ((int) eInfo[i][1] == id && (int) eInfo[i][2] == departmentID) {
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

    public void deleteEmp(int id, int departmentID) {
        boolean foundEmp = false;
        for (int i = 0; i < nEmp; i++) {
            if ((int) eInfo[i][1] == id && (int) eInfo[i][2] == departmentID) {
                for (int j = i; j < nEmp - 1; j++) {
                    eInfo[j] = eInfo[j + 1];
                }
                nEmp--;
                foundEmp = true;
                System.out.println("Employee deleted successfully.");
                break;
            }
        }
        if (!foundEmp) {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmp(int id, int departmentID, String newName, int newDepartmentID, int newUserID) {
        boolean foundEmp = false;
        for (int i = 0; i < nEmp; i++) {
            if ((int) eInfo[i][1] == id && (int) eInfo[i][2] == departmentID) {
                eInfo[i][0] = newName;
                eInfo[i][2] = newDepartmentID;
                eInfo[i][3] = newUserID;
                foundEmp = true;
                System.out.println("Employee information updated successfully.");
                break;
            }
        }
        if (!foundEmp) {
            System.out.println("Employee not found.");
        }
    }

    public void viewTickets() {
        System.out.println("Tickets added by HR:");
        for (int i = 0; i < hr.getTickets().length; i++) {
            if (hr.getTickets()[i][0] != null && hr.getTickets()[i][1] != null) {
                System.out.println("Ticket Type: " + hr.getTickets()[i][0]);
                System.out.println("Details: " + hr.getTickets()[i][1]);
                System.out.println("--------------------------");
            }
        }

        System.out.println("Tickets added by User:");
        for (int i = 0; i < user.getTickets().length; i++) {
            if (user.getTickets()[i][0] != null && user.getTickets()[i][1] != null) {
                System.out.println("Ticket Type: " + user.getTickets()[i][0]);
                System.out.println("Details: " + user.getTickets()[i][1]);
                System.out.println("--------------------------");
            }
        }

        System.out.println("Tickets added by Employee:");
        for (int i = 0; i < employee.getTickets().length; i++) {
            if (employee.getTickets()[i][0] != null && employee.getTickets()[i][1] != null) {
                System.out.println("Ticket Type: " + employee.getTickets()[i][0]);
                System.out.println("Details: " + employee.getTickets()[i][1]);
                System.out.println("--------------------------");
            }
        }
    }

    public HR getHr() {
        return hr;
    }

    public void setHr(HR hr) {
        this.hr = hr;
    }

    public Object[][] geteInfo() {
        return eInfo;
    }

    public void seteInfo(Object[][] eInfo) {
        this.eInfo = eInfo;
    }

    public int getNEmp() {
        return nEmp;
    }

    public void setNumOfEmp(int nEmp) {
        this.nEmp = nEmp;
    }

}
