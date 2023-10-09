package listDriver;

public class Student {

    String name;
    int iD;

    Student(String name, int iD) {
        this.name = name;
        this.iD = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public boolean equals(Student Stu){
        if (Stu == null) {
            return false;
        } else if (Stu.getiD() == getiD()) {
            return true;
        } return false;
    }

    public String toString() {
        return name + iD;
    }
}
