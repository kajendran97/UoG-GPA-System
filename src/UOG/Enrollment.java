/**
 * @RagulRavindiran
 */
package UOG;

import java.util.ArrayList;

public class Enrollment {

    private CoreModDetails coreModule;
    private OptModDetails optModule;
    private StudentDetails student;
    private double StudentFinalGPA = 0;
    private String studentDegree;
    private String studentName;
    private String studentId;
    private Date enrolmentDate;

    //getting core module details
    public CoreModDetails getCoreModule() {
        return coreModule;
    }

    //getting optional module details
    public OptModDetails getOptModule() {
        return optModule;
    }

    //getting student details
    public StudentDetails getStudent() {
        return student;
    }

    //getting GPA details
    public double getStudentFinalGPA() {
        return StudentFinalGPA;
    }

    //getting Degree Title details
    public String getStudentDegree() {
        return studentDegree;
    }

    //getting student name
    public String getStudentName() {
        return studentName;
    }

    //getting student ID
    public String getStudentId() {
        return studentId;
    }

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    /**
     * This Functions assigns Core module, Optional Module and All Student Details
     * @param core || all core module details
     * @param optional || all optional module details
     * @param student || all student details
     */
    public Enrollment(CoreModDetails core, OptModDetails optional, StudentDetails student) {
        this.coreModule = core;
        this.optModule = optional;
        this.student = student;
        this.StudentFinalGPA = this.calculateGPA();
        this.studentDegree = this.SettingTitle();
        this.studentName = student.getName();
        this.studentId = student.getStudent_id();
    }

    //method to calculate GPA
    public double calculateGPA() {

        ArrayList optmodules = optModule.getAllopt();
        ArrayList compmodules = coreModule.getAllcom();


        int totalcreditUnits = 0;
        int creditUnitOpt = 0;

        double gpa = 0;
        double gp = 0;
        double gptotalcom = 0;


        for (int x = 0; x < optmodules.size(); x++) {

            String moduleecode = ((ArrayList) optmodules.get(x)).get(0).toString();
            int mark = Integer.parseInt(((ArrayList) optmodules.get(x)).get(1).toString());


            if (mark >= 85) {

                gp = 4;

            } else if (mark >= 70) {

                gp = 3.67;


            } else if (mark >= 65) {

                gp = 3.33;

            } else if (mark >= 60) {

                gp = 3;

            } else if (mark >= 55) {

                gp = 2.67;

            } else if (mark >= 45) {

                gp = 2.33;

            } else if (mark >= 40) {

                gp = 2;

            } else if (mark >= 35) {

                gp = 1.67;

            } else if (mark >= 30) {

                gp = 1;

            } else if (mark >= 0) {

                gp = 0;

            }

            if (moduleecode.equals("SC598")) {

                totalcreditUnits += 15;
                creditUnitOpt = 15;
            } else if (moduleecode.equals("SC599")) {

                totalcreditUnits += 30;
                creditUnitOpt = 30;

            } else {
                totalcreditUnits += 2;
                creditUnitOpt = 2;
            }

            gptotalcom += (gp * creditUnitOpt);


        }


        int creditUnitsCom = 0;
        double gptotalopt = 0;
        for (int x = 0; x < compmodules.size(); x++) {


            String moduleecode = ((ArrayList) compmodules.get(x)).get(0).toString();
            double mark = Integer.parseInt(((ArrayList) compmodules.get(x)).get(1).toString());


            if (moduleecode.equals("SC597")) {

                totalcreditUnits += 1;
                creditUnitsCom = 1;

            } else {

                totalcreditUnits += 2;
                creditUnitsCom = 2;
            }


            if (mark >= 85) {

                gp = 4;

            } else if (mark >= 70) {

                gp = 3.67;


            } else if (mark >= 65) {

                gp = 3.33;

            } else if (mark >= 60) {

                gp = 3;

            } else if (mark >= 55) {

                gp = 2.67;

            } else if (mark >= 45) {

                gp = 2.33;

            } else if (mark >= 40) {

                gp = 2;

            } else if (mark >= 35) {

                gp = 1.67;

            } else if (mark >= 30) {

                gp = 1;

            } else if (mark >= 0) {

                gp = 0;

            }

            gptotalopt += (gp * creditUnitsCom);


        }

        double gptotal = gptotalcom + gptotalopt;
        System.out.println(gptotal);
        gpa = gptotal / totalcreditUnits;
        return gpa;
    }


    //method for assigning respective degree titles
    public String SettingTitle() {

        String title;

        double gpa = StudentFinalGPA;
        String header = "";

        for (int x = 0; x < optModule.getAllopt().size(); x++) {

            String moduleecode = ((ArrayList) optModule.getAllopt().get(x)).get(0).toString();


            if (moduleecode.equals("SC598")) {


                header = "Coursework and Research";

            } else if (moduleecode.equals("SC599")) {

                header = "Research";

            } else if (moduleecode.length() != 0) {
                header = "Coursework";
            }


        }

        if (gpa <= 2.99) {
            title = "Postgraduate Diploma in Computer Science";
        } else if (gpa <= 3.49) {
            title = "MSc by " + header + " with Pass";
        } else if (gpa <= 3.69) {
            title = "MSc by " + header + " with Merit";
        } else if (gpa <= 4.00) {
            title = "MSc by " + header + " with Distinction";
        } else {
            title = "Not Defined";
        }


        return title;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Enrollment{" +
                "coreModule=" + coreModule +
                ", optModule=" + optModule +
                ", student=" + student +
                ", StudentFinalGPA=" + StudentFinalGPA +
                ", studentDegree='" + studentDegree + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", enrolmentDate=" + enrolmentDate +
                '}';
    }
}
