import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Part (a): Main menu.
// NOTE: The lecturer provides the real main menu code in UKMFolio.
// This is my own version so the project runs by itself. If you use the
// lecturer's version, just make sure the window class names match.
public class MainMenu extends JFrame implements ActionListener {
    private JButton btnStudent = new JButton("Add Student Info");
    private JButton btnBook = new JButton("Add Book Info");
    private JButton btnBorrow = new JButton("Borrow Book");

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));

        pane.add(new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER));
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);

        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // A NEW window is created on every click, so the combo boxes
        // in BorrowBook always load the latest students and books.
        if (e.getSource() == btnStudent)
            new AddStudentInfo().setVisible(true);
        else if (e.getSource() == btnBook)
            new AddBookInfo().setVisible(true);
        else if (e.getSource() == btnBorrow)
            new BorrowBook().setVisible(true);
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
