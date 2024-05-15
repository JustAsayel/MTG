public class User {
    private String[][] projects;
    private String[][] tickets;
    private String[][] employees;

    public User(String[][] projects, String[][] employees) {
        this.projects = projects;
        this.tickets = new String[100][2];
        this.employees = employees;
    }

    public void assignProject(String employeeName, String projectName) {
        for (String[] employee : employees) {
            if (employee != null && employee[0] != null && employee[0].equalsIgnoreCase(employeeName)) {
                for (String[] project : projects) {
                    if (project != null && (project[0] == null || project[0].isEmpty())
                            && (project[1] == null || project[1].isEmpty())) {
                        project[0] = projectName;
                        project[1] = employee[1];
                        System.out.println("Project assigned to employee: " + employeeName
                                + ", Employee ID: " + employee[1] + ", Project: " + projectName);
                        return;
                    }
                }
                System.out.println("No available project slot for assignment.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void deleteProject(String employeeName, String projectName) {
        for (String[] employee : employees) {
            if (employee != null && employee[0] != null && employee[0].equalsIgnoreCase(employeeName)) {
                for (String[] project : projects) {
                    if (project != null && project[0] != null && project[0].equalsIgnoreCase(projectName)
                            && project[1].equals(employee[1])) {
                        project[0] = null;
                        project[1] = null;
                        System.out.println("Project deleted for employee: " + employeeName + ", Employee ID: "
                                + employee[1] + ", Project: " + projectName);
                        return;
                    }
                }
                System.out.println("Project not found for deletion.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void searchEmployee(int id, int departmentID) {
        boolean foundEmployee = false;
        for (String[] employee : employees) {
            if (employee != null && Integer.parseInt(employee[1]) == id) {
                System.out.println("Employee found: " + employee[0] + ", Employee ID: " + employee[1]
                        + ", Department ID: " + departmentID);
                foundEmployee = true;
                boolean hasProjects = false;
                for (String[] project : projects) {
                    if (project != null && project[1].equals(employee[1])) {
                        hasProjects = true;
                        System.out.println("Project Name: " + project[0]);
                    }
                }
                if (!hasProjects) {
                    System.out.println("Employee has no projects.");
                }
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void updateProject(String employeeName, String currentProjectName, String newProjectName) {
        for (String[] employee : employees) {
            if (employee != null && employee[0] != null && employee[0].equalsIgnoreCase(employeeName)) {
                for (String[] project : projects) {
                    if (project != null && project[0] != null && project[0].equalsIgnoreCase(currentProjectName)
                            && project[1].equals(employee[1])) {
                        project[0] = newProjectName;
                        System.out.println("Project updated successfully for employee: " + employeeName +
                                ", Employee ID: " + employee[1] + ", Old Project: " + currentProjectName +
                                ", New Project: " + newProjectName);
                        return;
                    }
                }
                System.out.println("Project not found for update.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void addTicket(String ticketType, String details) {
        for (String[] ticket : tickets) {
            if (ticket[0] == null && ticket[1] == null) {
                ticket[0] = ticketType;
                ticket[1] = details;
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
