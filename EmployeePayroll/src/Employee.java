import java.util.*;
public class Employee{
    public String getName() {
        return name;
    }

    private String name;
    private Long id;
    private Designation designation;
    private int attendanceCounter;

    Employee(String n, Long id, Designation d){
        this.name = n;
        this.id = id;
        this.designation = d;
    }

    public void setAttendanceCounter(int c){
        this.attendanceCounter += c;
    }

    public int getAttendanceCounter(){
        return this.attendanceCounter;
    }

    public Designation getDesignation(){
        return this.designation;
    }

}

