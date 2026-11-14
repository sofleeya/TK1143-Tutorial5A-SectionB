import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Part (c): Add Book Info window. Same pattern as AddStudentInfo.
public class AddBookInfo extends JFrame implements ActionListener {
    private JTextField txtTitle = new JTextField(15);
    private JTextField txtAuthor = new JTextField(15);
    private JButton btnAdd = new JButton("Add");
    private JButton btnList = new JButton("List");
    private JTextArea area = new JTextArea(5, 30);

    public AddBookInfo() {
        setTitle("Add Book Info");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
        form.add(new JLabel("Book Title:"));
        form.add(txtTitle);
        form.add(new JLabel("Author:"));
        form.add(txtAuthor);

        JPanel buttons = new JPanel();
        buttons.add(btnAdd);
        buttons.add(btnList);

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(buttons, BorderLayout.SOUTH);

        area.setEditable(false);
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Books:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(area), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (title.equals("") || author.equals("")) {
                JOptionPane.showMessageDialog(this, "Please fill in book title and author!");
                return;
            }
            Data.books.add(new Book(title, author));
            txtTitle.setText("");
            txtAuthor.setText("");
        } else if (e.getSource() == btnList) {
            String text = "";
            for (Book b : Data.books)
                text += "Book title : " + b.getTitle()
                      + " (Author : " + b.getAuthor() + ")\n";
            area.setText(text);
        }
    }
}
