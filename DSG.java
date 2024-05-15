import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DSG extends JFrame {
    public DSG() {
        setTitle("Employee Tracker System ");
        setSize(300, 200);
        setLayout(new GridLayout(6, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton ad = new JButton("Admin");
        ad.addActionListener(e -> admingui());
        add(ad);

        JButton hr = new JButton("HR");
        hr.addActionListener(e -> hrgui());
        add(hr);

        JButton user = new JButton("Supervisor");
        user.addActionListener(e -> usergui());
        add(user);

        JButton emp = new JButton("Employee");
        emp.addActionListener(e -> empgui());
        add(emp);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton);
    }

    private void admingui() {
        new AdminDS().setVisible(true);
    }

    private void hrgui() {
        new hrDS().setVisible(true);
    }

    private void usergui() {
        new userDS().setVisible(true);
    }

    private void empgui() {
        new finalDS().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DSG().setVisible(true));
    }

    class AdminDS extends JFrame {
        public AdminDS() {
            setTitle("Admin System Dashboard");
            setSize(300, 200);
            setLayout(new GridLayout(4, 1));
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton viewInfoButton = new JButton("View Information");
            viewInfoButton.addActionListener(e -> createEmployeeInfoGUI());
            add(viewInfoButton);

            JButton addLeaveRequestButton = new JButton("Tasks");
            addLeaveRequestButton.addActionListener(e -> empGUI());
            add(addLeaveRequestButton);

            JButton addTicketButton = new JButton("View Tickets");
            addTicketButton.addActionListener(e -> createTicketGUI());
            add(addTicketButton);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dispose());
            add(closeButton);
        }

        private void createEmployeeInfoGUI() {
            new EmployeeInfoGUI().setVisible(true);
        }

        private void empGUI() {
            new EmployeeManagementSystem().setVisible(true);
        }

        private void createTicketGUI() {
            new TicketGUI().setVisible(true);
        }

        class EmployeeInfoGUI extends JFrame {
            public EmployeeInfoGUI() {
                setTitle("Employee Information");
                setSize(500, 350);
                setLayout(new BorderLayout());
                setLocationRelativeTo(null);

                String[] columnNames = { "ID", "Name", "User ID", "Dept Number", "Department Name" };
                Object[][] data = {
                        { "445", "Saja", "A123", "Dept01", "IT" }
                };

                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);

                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        dispose();
                    }
                });
            }
        }

        class EmployeeManagementSystem extends JFrame {
            private DefaultTableModel model;
            private JTable table;
            private JTextField idField, nameField, deptNumberField, jobTitleField, contactField;
            private JButton addButton, deleteButton, searchButton, updateButton, backButton;

            public EmployeeManagementSystem() {
                setTitle("Employee Management System");
                setSize(600, 400);
                setLayout(new BorderLayout());
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                String[] columnNames = { "Employee ID", "Name", "Department Number", "Job Title", "Contact" };
                model = new DefaultTableModel(columnNames, 0);
                table = new JTable(model);
                model.addRow(new Object[] { "001", "Ahmed", "100", "Manager", "555-1001" });
                model.addRow(new Object[] { "002", "Mona", "101", "Developer", "555-1002" });
                model.addRow(new Object[] { "003", "John", "102", "Analyst", "555-1003" });
                model.addRow(new Object[] { "004", "Sara", "103", "Clerk", "555-1004" });
                model.addRow(new Object[] { "005", "Mike", "104", "Designer", "555-1005" });

                JScrollPane scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);

                JPanel inputPanel = new JPanel();
                idField = new JTextField(10);
                nameField = new JTextField(10);
                deptNumberField = new JTextField(10);
                jobTitleField = new JTextField(10);
                contactField = new JTextField(10);

                inputPanel.setLayout(new GridLayout(5, 2));
                inputPanel.add(new JLabel("Employee ID:"));
                inputPanel.add(idField);
                inputPanel.add(new JLabel("Name:"));
                inputPanel.add(nameField);
                inputPanel.add(new JLabel("Department Number:"));
                inputPanel.add(deptNumberField);
                inputPanel.add(new JLabel("Job Title:"));
                inputPanel.add(jobTitleField);
                inputPanel.add(new JLabel("Contact:"));
                inputPanel.add(contactField);

                JPanel buttonPanel = new JPanel();
                addButton = new JButton("Add");
                addButton.addActionListener(e -> addEmployee());
                deleteButton = new JButton("Delete");
                deleteButton.addActionListener(e -> deleteEmployee());
                searchButton = new JButton("Search by ID");
                searchButton.addActionListener(e -> searchEmployeeById());
                updateButton = new JButton("Update");
                updateButton.addActionListener(e -> updateEmployeeById());
                backButton = new JButton("Back");
                backButton.addActionListener(e -> dispose());

                buttonPanel.add(addButton);
                buttonPanel.add(deleteButton);
                buttonPanel.add(searchButton);
                buttonPanel.add(updateButton);
                buttonPanel.add(backButton);

                add(inputPanel, BorderLayout.NORTH);
                add(buttonPanel, BorderLayout.SOUTH);
            }

            private void addEmployee() {
                model.addRow(new Object[] {
                        idField.getText(),
                        nameField.getText(),
                        deptNumberField.getText(),
                        jobTitleField.getText(),
                        contactField.getText()
                });
                clearFields();
            }

            private void deleteEmployee() {
                String idToDelete = idField.getText();
                for (int i = model.getRowCount() - 1; i >= 0; i--) {
                    if (model.getValueAt(i, 0).equals(idToDelete)) {
                        model.removeRow(i);
                        clearFields();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Employee ID not found.", "Delete Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            private void searchEmployeeById() {
                String idToSearch = idField.getText();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(idToSearch)) {
                        nameField.setText(model.getValueAt(i, 1).toString());
                        deptNumberField.setText(model.getValueAt(i, 2).toString());
                        jobTitleField.setText(model.getValueAt(i, 3).toString());
                        contactField.setText(model.getValueAt(i, 4).toString());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Employee ID not found.", "Search Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            private void updateEmployeeById() {
                String idToUpdate = idField.getText();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(idToUpdate)) {
                        model.setValueAt(nameField.getText(), i, 1);
                        model.setValueAt(deptNumberField.getText(), i, 2);
                        model.setValueAt(jobTitleField.getText(), i, 3);
                        model.setValueAt(contactField.getText(), i, 4);
                        clearFields();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Employee ID not found.", "Update Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            private void clearFields() {
                idField.setText("");
                nameField.setText("");
                deptNumberField.setText("");
                jobTitleField.setText("");
                contactField.setText("");
            }
        }

        class TicketGUI extends JFrame {
            private DefaultTableModel model;
            private JTable table;
            private JTextField ticketIdField, typeField, detailsField, statusField, deptNumberField;

            public TicketGUI() {
                setTitle("Tickets");
                setSize(600, 400);
                setLayout(new BorderLayout());
                setLocationRelativeTo(null);

                String[] columnNames = { "Ticket ID", "Type", "Details", "Status", "Department Number" };

                model = new DefaultTableModel(columnNames, 0);
                table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                model.addRow(new Object[] { "001", "Network Issue", "Cannot connect to VPN", "Pending", "IT" });
                model.addRow(new Object[] { "002", "Hardware", "Mouse not working", "Resolved", "Tech Support" });
                model.addRow(new Object[] { "003", "Software", "License issue", "Pending", "IT" });
                model.addRow(new Object[] { "004", "Admin", "Access denied on module", "Resolved", "Admin" });
                model.addRow(new Object[] { "005", "Network", "Slow internet speed", "Investigating", "IT" });

                add(scrollPane, BorderLayout.CENTER);

                JPanel inputPanel = new JPanel(new GridLayout(5, 2));
                ticketIdField = new JTextField(10);
                typeField = new JTextField(10);
                detailsField = new JTextField(10);
                statusField = new JTextField(10);
                deptNumberField = new JTextField(10);

                inputPanel.add(new JLabel("Ticket ID:"));
                inputPanel.add(ticketIdField);
                inputPanel.add(new JLabel("Type:"));
                inputPanel.add(typeField);
                inputPanel.add(new JLabel("Details:"));
                inputPanel.add(detailsField);
                inputPanel.add(new JLabel("Status:"));
                inputPanel.add(statusField);
                inputPanel.add(new JLabel("Department Number:"));
                inputPanel.add(deptNumberField);

                JPanel buttonPanel = new JPanel();
                JButton addButton = new JButton("Add");
                addButton.addActionListener(e -> addTicket());
                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(e -> deleteTicket());
                JButton saveButton = new JButton("Save");
                saveButton.addActionListener(e -> saveTicket());
                JButton backButton = new JButton("Back");
                backButton.addActionListener(e -> dispose());

                buttonPanel.add(addButton);
                buttonPanel.add(deleteButton);
                buttonPanel.add(saveButton);
                buttonPanel.add(backButton);

                add(inputPanel, BorderLayout.NORTH);
                add(buttonPanel, BorderLayout.SOUTH);

                model.addRow(new Object[] { "001", "Network Issue", "Cannot connect to VPN", "Unsolved", "IT" });
                model.addRow(new Object[] { "002", "Hardware", "Mouse not working", "Solved", "Tech Support" });
            }

            private void addTicket() {
                String ticketId = ticketIdField.getText();
                String type = typeField.getText();
                String details = detailsField.getText();
                String status = statusField.getText();
                String deptNumber = deptNumberField.getText();
                if (!ticketId.isEmpty() && !type.isEmpty() && !details.isEmpty() && !status.isEmpty()
                        && !deptNumber.isEmpty()) {
                    model.addRow(new Object[] { ticketId, type, details, status, deptNumber });
                    ticketIdField.setText("");
                    typeField.setText("");
                    detailsField.setText("");
                    statusField.setText("");
                    deptNumberField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void deleteTicket() {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(this, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void saveTicket() {
                JOptionPane.showMessageDialog(this, "Save functionality not implemented", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class hrDS extends JFrame {
        public hrDS() {
            setTitle("HR System Dashboard");
            setSize(300, 200);
            setLayout(new GridLayout(4, 1));
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton viewInfoButton = new JButton("View Information");
            viewInfoButton.addActionListener(e -> new EmployeeInfoGUI().setVisible(true));
            add(viewInfoButton);

            JButton taskButton = new JButton("Tasks");
            taskButton.addActionListener(e -> new TaskGUI().setVisible(true));
            add(taskButton);

            JButton addTicketButton = new JButton("Add Ticket");
            addTicketButton.addActionListener(e -> new TicketGUI().setVisible(true));
            add(addTicketButton);

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(e -> dispose());
            add(closeButton);
        }

        class EmployeeInfoGUI extends JFrame {
            public EmployeeInfoGUI() {
                setTitle("Personal Information");
                setSize(500, 350);
                setLayout(new BorderLayout());
                setLocationRelativeTo(null);

                String[] columnNames = { "ID", "Name", "Dept Number", "Task" };
                Object[][] data = { { "5504", "Remas", "HR", "Attendence tracker" } };

                JTable table = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);

                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        dispose();
                    }
                });
            }
        }

        class TaskGUI extends JFrame {
            private DefaultTableModel model;
            private JTable table;
            private JTextField empIdField, empNameField, deptNumberField, daysOffField, absentDaysField;
            private JButton addButton, deleteButton, searchButton, updateButton, backButton;

            public TaskGUI() {
                setTitle("Tasks Management");
                setSize(900, 400);
                setLayout(new BorderLayout());
                setLocationRelativeTo(null);

                String[] columnNames = { "Emp ID", "Emp Name", "Dept Number", "Days Off", "Absent Days", "Salary" };
                model = new DefaultTableModel(columnNames, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 5;
                    }
                };

                table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                model.addRow(new Object[] { "006", "Ali", "200", 2, 1, 6800 });
                model.addRow(new Object[] { "007", "Mazen", "201", 0, 3, 2000 });
                model.addRow(new Object[] { "008", "Abeer", "202", 5, 0, 20000 });
                model.addRow(new Object[] { "009", "Moneera", "203", 1, 2, 5600 });
                model.addRow(new Object[] { "010", "Ahmed", "204", 3, 1, 10000 });

                add(scrollPane, BorderLayout.CENTER);

                JPanel inputPanel = new JPanel();
                empIdField = new JTextField(5);
                empNameField = new JTextField(10);
                deptNumberField = new JTextField(5);
                daysOffField = new JTextField(5);
                absentDaysField = new JTextField(5);

                inputPanel.add(new JLabel("Emp ID:"));
                inputPanel.add(empIdField);
                inputPanel.add(new JLabel("Emp Name:"));
                inputPanel.add(empNameField);
                inputPanel.add(new JLabel("Dept Number:"));
                inputPanel.add(deptNumberField);
                inputPanel.add(new JLabel("Days Off:"));
                inputPanel.add(daysOffField);
                inputPanel.add(new JLabel("Absent Days:"));
                inputPanel.add(absentDaysField);

                JPanel buttonPanel = new JPanel();

                addButton = new JButton("Add");
                searchButton = new JButton("Search by ID");
                searchButton.addActionListener(e -> searchEmployeeById());
                addButton.addActionListener(e -> addEmployee());
                deleteButton = new JButton("Delete");
                deleteButton.addActionListener(e -> deleteEmployeeById());
                updateButton = new JButton("Update");
                updateButton.addActionListener(e -> updateEmployeeById());
                backButton = new JButton("Back");
                backButton.addActionListener(e -> dispose());

                buttonPanel.add(addButton);
                buttonPanel.add(searchButton);
                buttonPanel.add(deleteButton);
                buttonPanel.add(updateButton);
                buttonPanel.add(backButton);

                add(inputPanel, BorderLayout.NORTH);
                add(buttonPanel, BorderLayout.SOUTH);
            }

            private void addEmployee() {
                try {
                    int daysOff = Integer.parseInt(daysOffField.getText());
                    int absentDays = Integer.parseInt(absentDaysField.getText());
                    int salary = (daysOff * 4000) - (absentDays * 120);

                    model.addRow(new Object[] {
                            empIdField.getText(),
                            empNameField.getText(),
                            deptNumberField.getText(),
                            daysOff,
                            absentDays,
                            salary
                    });

                    empIdField.setText("");
                    empNameField.setText("");
                    deptNumberField.setText("");
                    daysOffField.setText("");
                    absentDaysField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid numbers for Days Off and Absent Days",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void deleteEmployeeById() {
                String idToDelete = empIdField.getText();
                for (int i = model.getRowCount() - 1; i >= 0; i--) {
                    if (model.getValueAt(i, 0).equals(idToDelete)) {
                        model.removeRow(i);
                    }
                }
            }

            private void updateEmployeeById() {
                String idToUpdate = empIdField.getText();
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(idToUpdate)) {
                        try {
                            int daysOff = Integer.parseInt(daysOffField.getText());
                            int absentDays = Integer.parseInt(absentDaysField.getText());
                            int salary = (daysOff * 4000) - (absentDays * 120);

                            model.setValueAt(empNameField.getText(), i, 1);
                            model.setValueAt(deptNumberField.getText(), i, 2);
                            model.setValueAt(daysOff, i, 3);
                            model.setValueAt(absentDays, i, 4);
                            model.setValueAt(salary, i, 5);
                            return; // Ensure to exit after update
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this,
                                    "Please enter valid numbers for Days Off and Absent Days",
                                    "Input Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Employee ID not found for update", "Update Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            private void searchEmployeeById() {
                String searchId = empIdField.getText();
                boolean found = false;
                for (int i = 0; i < model.getRowCount(); i++) {
                    if (model.getValueAt(i, 0).equals(searchId)) {
                        table.setRowSelectionInterval(i, i);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "Employee ID not found.", "Search Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    class TicketGUI extends JFrame {
        private DefaultTableModel model;
        private JTable table;
        private JTextField ticketIdField, typeField, detailsField;

        public TicketGUI() {
            setTitle("Tickets");
            setSize(600, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "Ticket ID", "Type", "Details" };
            model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

            JPanel inputPanel = new JPanel();
            ticketIdField = new JTextField(10);
            typeField = new JTextField(10);
            detailsField = new JTextField(10);
            inputPanel.add(new JLabel("Ticket ID:"));
            inputPanel.add(ticketIdField);
            inputPanel.add(new JLabel("Type:"));
            inputPanel.add(typeField);
            inputPanel.add(new JLabel("Details:"));
            inputPanel.add(detailsField);

            JPanel buttonPanel = new JPanel();
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> addTicket());
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteTicket());
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveTicket());
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> dispose());

            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);

            add(inputPanel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        private void addTicket() {
            String ticketId = ticketIdField.getText();
            String type = typeField.getText();
            String details = detailsField.getText();
            if (!ticketId.isEmpty() && !type.isEmpty() && !details.isEmpty()) {
                model.addRow(new Object[] { ticketId, type, details });
                ticketIdField.setText("");
                typeField.setText("");
                detailsField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteTicket() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void saveTicket() {
            JOptionPane.showMessageDialog(this, "Save functionality not implemented",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

class userDS extends JFrame {
    public userDS() {
        setTitle("User System Dashboard");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton viewInfoButton = new JButton("View Information");
        viewInfoButton.addActionListener(e -> createEmployeeInfoGUI());
        add(viewInfoButton);

        JButton projectTableButton = new JButton("Project Table");
        projectTableButton.addActionListener(e -> new ProjectManagementGUI().setVisible(true));
        add(projectTableButton);

        JButton addTicketButton = new JButton("Add Ticket");
        addTicketButton.addActionListener(e -> createTicketGUI());
        add(addTicketButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton);
    }

    private void createTicketGUI() {
        new TicketGUI().setVisible(true);
    }

    private void createEmployeeInfoGUI() {
        new EmployeeInfoGUI().setVisible(true);
    }

    class EmployeeInfoGUI extends JFrame {
        public EmployeeInfoGUI() {
            setTitle("Employee Information");
            setSize(500, 350);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "ID", "Name", "User ID", "Dept Number", "Department Name" };
            Object[][] data = {
                    { "8875", "Asayel", "C321", "Dept01", " IT " }
            };

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
        }
    }

    class TicketGUI extends JFrame {
        private DefaultTableModel model;
        private JTable table;
        private JTextField ticketIdField, typeField, detailsField;

        public TicketGUI() {
            setTitle("Tickets");
            setSize(600, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "Ticket ID", "Type", "Details" };
            model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
            JPanel inputPanel = new JPanel();
            ticketIdField = new JTextField(10);
            typeField = new JTextField(10);
            detailsField = new JTextField(10);
            inputPanel.add(new JLabel("Ticket ID:"));
            inputPanel.add(ticketIdField);
            inputPanel.add(new JLabel("Type:"));
            inputPanel.add(typeField);
            inputPanel.add(new JLabel("Details:"));
            inputPanel.add(detailsField);
            JPanel buttonPanel = new JPanel();
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> addTicket());
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteTicket());
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveTicket());
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> dispose());

            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);

            add(inputPanel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        private void addTicket() {
            String ticketId = ticketIdField.getText();
            String type = typeField.getText();
            String details = detailsField.getText();
            if (!ticketId.isEmpty() && !type.isEmpty() && !details.isEmpty()) {
                model.addRow(new Object[] { ticketId, type, details });
                ticketIdField.setText("");
                typeField.setText("");
                detailsField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteTicket() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void saveTicket() {
            JOptionPane.showMessageDialog(this, "Save functionality not implemented", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class ProjectManagementGUI extends JFrame {
        private DefaultTableModel model;
        private JTable table;
        private JTextField idField, nameField, projectNameField, deptNumberField;

        public ProjectManagementGUI() {
            setTitle("Project Management");
            setSize(800, 600);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "Employee ID", "Employee Name", "Project Name", "Department Number" };
            model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
            Object[][] data = {
                    { "001", "Raghed", "Website Revamp", "1001" },
                    { "002", "Yara", "New System", "1002" },
                    { "003", "Lama", "Neom", "1003" }
            };
            for (Object[] row : data) {
                model.addRow(row);
            }

            JPanel inputPanel = new JPanel(new GridLayout(5, 2));
            idField = new JTextField();
            nameField = new JTextField();
            projectNameField = new JTextField();
            deptNumberField = new JTextField();

            inputPanel.add(new JLabel("Employee ID"));
            inputPanel.add(idField);
            inputPanel.add(new JLabel("Employee Name"));
            inputPanel.add(nameField);
            inputPanel.add(new JLabel("Project Name"));
            inputPanel.add(projectNameField);
            inputPanel.add(new JLabel("Department Number"));
            inputPanel.add(deptNumberField);

            JPanel buttonPanel = new JPanel(new GridLayout(1, 6));
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> addProject());
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteProject());
            JButton editButton = new JButton("Edit");
            editButton.addActionListener(e -> editProject());
            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(e -> searchProject());
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveProject());
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> dispose());

            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(editButton);
            buttonPanel.add(searchButton);
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);

            add(inputPanel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        private void addProject() {
            model.addRow(new Object[] { idField.getText(), nameField.getText(), projectNameField.getText(),
                    deptNumberField.getText() });
            idField.setText("");
            nameField.setText("");
            projectNameField.setText("");
            deptNumberField.setText("");
        }

        private void deleteProject() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void editProject() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.setValueAt(idField.getText(), selectedRow, 0);
                model.setValueAt(nameField.getText(), selectedRow, 1);
                model.setValueAt(projectNameField.getText(), selectedRow, 2);
                model.setValueAt(deptNumberField.getText(), selectedRow, 3);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void searchProject() {
            String searchId = idField.getText();
            for (int i = 0; i < table.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(searchId)) {
                    table.setRowSelectionInterval(i, i);
                    break;
                }
            }
        }

        private void saveProject() {
            JOptionPane.showMessageDialog(this, "Save functionality not implemented", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

class finalDS extends JFrame {
    public finalDS() {
        setTitle("Employee System Dashboard");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton viewInfoButton = new JButton("View Information");
        viewInfoButton.addActionListener(e -> createEmployeeInfoGUI());
        add(viewInfoButton);

        JButton addLeaveRequestButton = new JButton("Add Leave Request");
        addLeaveRequestButton.addActionListener(e -> createLeaveRequestGUI());
        add(addLeaveRequestButton);

        JButton addTicketButton = new JButton("Add Ticket");
        addTicketButton.addActionListener(e -> createTicketGUI());
        add(addTicketButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton);
    }

    private void createEmployeeInfoGUI() {
        new EmployeeInfoGUI().setVisible(true);
    }

    private void createLeaveRequestGUI() {
        new LeaveRequestGUI().setVisible(true);
    }

    private void createTicketGUI() {
        new TicketGUI().setVisible(true);
    }

    class EmployeeInfoGUI extends JFrame {
        public EmployeeInfoGUI() {
            setTitle("Employee Information");
            setSize(500, 350);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "ID", "Name", "User ID", "Dept Number", "Project Name" };
            Object[][] data = {
                    { "001", "Reghad", "B03", "Dept01", "Neom" }
            };

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });
        }
    }

    class LeaveRequestGUI extends JFrame {
        private DefaultTableModel model;
        private JTable table;
        private JTextField startDateField, endDateField, typeField;
        private JButton saveButton;

        public LeaveRequestGUI() {
            setTitle("Leave Requests");
            setSize(600, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "Start Date", "End Date", "Type of Request" };
            model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            model.addRow(new Object[] { "2024-05-01", "2024-05-10", "Annual" });
            model.addRow(new Object[] { "2024-06-15", "2024-06-20", "Medical" });
            model.addRow(new Object[] { "2024-07-01", "2024-07-03", "Emergency" });
            model.addRow(new Object[] { "2024-08-10", "2024-08-15", "Annual" });
            model.addRow(new Object[] { "2024-09-05", "2024-09-10", "Maternity" });

            add(scrollPane, BorderLayout.CENTER);

            JPanel inputPanel = new JPanel();
            startDateField = new JTextField(10);
            endDateField = new JTextField(10);
            typeField = new JTextField(10);
            inputPanel.add(new JLabel("Start Date:"));
            inputPanel.add(startDateField);
            inputPanel.add(new JLabel("End Date:"));
            inputPanel.add(endDateField);
            inputPanel.add(new JLabel("Type:"));
            inputPanel.add(typeField);

            JPanel buttonPanel = new JPanel();
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> addLeaveRequest());
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteLeaveRequest());
            saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveLeaveRequest());
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> dispose());

            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);

            add(inputPanel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        private void addLeaveRequest() {
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();
            String type = typeField.getText();
            if (!startDate.isEmpty() && !endDate.isEmpty() && !type.isEmpty()) {
                model.addRow(new Object[] { startDate, endDate, type });
                startDateField.setText("");
                endDateField.setText("");
                typeField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteLeaveRequest() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void saveLeaveRequest() {
            JOptionPane.showMessageDialog(this, "Save functionality not implemented", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    class TicketGUI extends JFrame {
        private DefaultTableModel model;
        private JTable table;
        private JTextField ticketIdField, typeField, detailsField;

        public TicketGUI() {
            setTitle("Tickets");
            setSize(600, 400);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            String[] columnNames = { "Ticket ID", "Type", "Details" };
            model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
            JPanel inputPanel = new JPanel();
            ticketIdField = new JTextField(10);
            typeField = new JTextField(10);
            detailsField = new JTextField(10);
            inputPanel.add(new JLabel("Ticket ID:"));
            inputPanel.add(ticketIdField);
            inputPanel.add(new JLabel("Type:"));
            inputPanel.add(typeField);
            inputPanel.add(new JLabel("Details:"));
            inputPanel.add(detailsField);
            JPanel buttonPanel = new JPanel();
            JButton addButton = new JButton("Add");
            addButton.addActionListener(e -> addTicket());
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(e -> deleteTicket());
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveTicket());
            JButton backButton = new JButton("Back");
            backButton.addActionListener(e -> dispose());

            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(saveButton);
            buttonPanel.add(backButton);

            add(inputPanel, BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
        }

        private void addTicket() {
            String ticketId = ticketIdField.getText();
            String type = typeField.getText();
            String details = detailsField.getText();
            if (!ticketId.isEmpty() && !type.isEmpty() && !details.isEmpty()) {
                model.addRow(new Object[] { ticketId, type, details });
                ticketIdField.setText("");
                typeField.setText("");
                detailsField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void deleteTicket() {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void saveTicket() {
            JOptionPane.showMessageDialog(this, "Save functionality not implemented", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
