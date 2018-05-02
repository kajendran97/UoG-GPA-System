/**
 * @RagulRavindiran
 */
package UOG;

//Creating a new class to add all basic details of students
public class StudentDetails {

    private String name;
    private int age;
    private String student_id;
    private String email;
    private int contact_no;
    private String address;

    //getting student name
    public String getName() {
        return name;
    }

    //getting student age
    public int getAge() {
        return age;
    }

    //getting student ID
    public String getStudent_id() {
        return student_id;
    }

    //getting student Email
    public String getEmail() {
        return email;
    }

    //getting student ContactNo
    public int getContact_no() {
        return contact_no;
    }

    //getting student Address
    public String getAddress() {
        return address;
    }


    /**
     *This is a function which assigns details of students to the ArrayList
     * @param name || name of the student
     * @param age || age of the student
     * @param student_id || student ID of the student
     * @param email || email of the student
     * @param contact_no || Contact no of the student
     * @param address || address of the student
     */
    public StudentDetails(String name, int age, String student_id, String email, int contact_no, String address) {
        this.name = name;
        this.age = age;
        this.student_id = student_id;
        this.email = email;
        this.contact_no = contact_no;
        this.address = address;
    }
}
