import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Part (b): Add Student Info window.
// "Add" makes a Student object and saves it. "List" shows all saved students.
public class AddStudentInfo extends JFrame implements ActionListener {
    private JTextField txtName = new JTextField(15);
    private JTextField txtMatric = new JTextField(15);
    private JButton btnAdd = new JButton("Add");
    private JButton btnList = new JButton("List");
    private JTextArea area = new JTextArea(5, 30);

    public AddStudentInfo() {
        setTitle("Add Student Info");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // closes THIS window only

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
        form.add(new JLabel("Name:"));
        form.add(txtName);
        form.add(new JLabel("Matric:"));
        form.add(txtMatric);

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        area.setEditable(false);
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Students:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(area), BorderLayout.CENTER);   // scrollbars

        pane.add(top, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);    // register the listener
        btnList.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (name.equals("") || matric.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in name and matric!");
                return;
            }
            Data.students.add(new Student(name, matric));
            txtName.setText("");
            txtMatric.setText("");
        } else if (e.getSource() == btnList) {
            String text = "";
            for (Student s : Data.students)
                text += "Name : " + s.getName() + " (" + s.getMatric() + ")\n";
            area.setText(text);
        }
    }
}
