public class Student {
    private String name;
    private String matric;
    private boolean hasBorrowed = false;   // each student can borrow only ONE book

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }

    public String getName()   { return name; }
    public String getMatric() { return matric; }
    public boolean hasBorrowed() { return hasBorrowed; }
    public void setBorrowed(boolean b) { hasBorrowed = b; }

    // The combo box shows this text
    public String toString() {
        return name + " (" + matric + ")";
    }
}
