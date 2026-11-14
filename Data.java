import java.util.ArrayList;

// One shared place that keeps all students and books,
// so every window reads and writes the same lists.
public class Data {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Book> books = new ArrayList<Book>();
}
