import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Part (d): Borrow Book window.
// Pick a student and a book from the combo boxes, then click "Borrow".
public class BorrowBook extends JFrame implements ActionListener {
    private JComboBox<Student> cmbStudent = new JComboBox<Student>();
    private JComboBox<Book> cmbBook = new JComboBox<Book>();
    private JButton btnBorrow = new JButton("Borrow");
    private JLabel lblInfo = new JLabel("Borrow Information :");

    public BorrowBook() {
        setTitle("Borrow Book");
        setSize(520, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // fill the drop-downs with the saved objects
        for (Student s : Data.students) cmbStudent.addItem(s);
        for (Book b : Data.books) cmbBook.addItem(b);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.add(new JLabel("Student Name & Matric:"));
        form.add(cmbStudent);
        form.add(new JLabel("Book Title & Author:"));
        form.add(cmbBook);
        form.add(new JLabel(""));            // empty cell for spacing
        JPanel p = new JPanel();
        p.add(btnBorrow);
        form.add(p);

        pane.add(form, BorderLayout.NORTH);
        pane.add(lblInfo, BorderLayout.SOUTH);

        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Student s = (Student) cmbStudent.getSelectedItem();
        Book b = (Book) cmbBook.getSelectedItem();
        if (s == null || b == null) {
            JOptionPane.showMessageDialog(this, "Please add students and books first!");
            return;
        }
        String msg = b.borrowBy(s);          // the Book does the work
        lblInfo.setText("<html>Borrow Information :<br>" + msg + "</html>");
    }
}
