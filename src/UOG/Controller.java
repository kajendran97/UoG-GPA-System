/**
 * @RagulRavindiran
 */
package UOG;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    //method for user login
    public void loginUser(ActionEvent evt) throws Exception {

        String userID = username.getText();
        String pass = password.getText();

        //checking for correct username and password
        if (userID.equalsIgnoreCase("Student") && pass.equalsIgnoreCase("Student")) {
            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("option_menu_student.fxml"));
            mainStage.setTitle("Student Menu");
            mainStage.setScene(new Scene(root, 604, 659));
            mainStage.show();
        } else if (userID.equalsIgnoreCase("Lecturer") && pass.equalsIgnoreCase("Lecturer")) {
            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("option_menu.fxml"));
            mainStage.setTitle("Main Menu");
            mainStage.setScene(new Scene(root, 604, 659));
            mainStage.show();

        } else {
            //alerting if wrong username or password entered
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Fail");
            alert.setContentText("");
            alert.setContentText("Incorrect Username or Password");
            alert.showAndWait();
        }
    }

    @FXML
    private TableView<Enrollment> finalDetails;
    @FXML
    private TableColumn<Enrollment, String> sName;
    @FXML
    private TableColumn<Enrollment, String> sID;
    @FXML
    private TableColumn<Enrollment, String> finalGPA;
    @FXML
    private TableColumn<Enrollment, String> degreeTitle;

    public ObservableList<Enrollment> getEnrollmentDetails() {
        ObservableList<Enrollment> studentData = FXCollections.observableArrayList(studentDatabase);
        return studentData;
    }

    public void finalStudentTable() {

        sID.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("studentId"));
        sName.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("studentName"));
        finalGPA.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("studentFinalGPA"));
        degreeTitle.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("studentDegree"));
        finalDetails.setItems(getEnrollmentDetails());
    }

    //method to view final student detail after GPA calculation
    public void toViewDetails(ActionEvent evt) throws Exception {
        if (studentDatabase.size() >= 1) {
            for (Enrollment studentDetail : studentDatabase) {
                System.out.println(studentDetail.getStudent().getName());
                System.out.println(studentDetail.calculateGPA());
            }

            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("viewDetails.fxml"));
            mainStage.setTitle("Details of Student");
            mainStage.setScene(new Scene(root, 800, 659));
            mainStage.show();

            for (Node node : root.getChildrenUnmodifiable()) {

                if (node instanceof Button) {
                    Button SelectedButton = ((Button) node);
                    if (SelectedButton.getId().equals("LoadButton")) {
                        SelectedButton.fire();
                    }

                }

            }


        } else {
            //alerting for not added details
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error Finding Details");
            alert2.setHeaderText("No Student Details Found");
            alert2.setContentText("Please first add Student details to the Database");
            alert2.showAndWait();
            System.out.println("");
        }
    }


    //introducing an ArrayList to store all student details
    static ArrayList<Enrollment> studentDatabase = new ArrayList<Enrollment>();

    @FXML
    private TextField name, age, studentID, email, contactNO, address;

    static StudentDetails student;
    static CoreModDetails coreModule;
    static OptModDetails optModule;

    public void showAddDetails(ActionEvent evt) throws Exception {

        Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("add_details.fxml"));
        mainStage.setTitle("Add Details");
        mainStage.setScene(new Scene(root, 604, 659));
        mainStage.show();
    }

    //method to input all studnet basic details
    public void inputDetails(ActionEvent evt) throws Exception {

        try {
            String stuName = name.getText();
            int stuAge = Integer.parseInt(age.getText());
            String stuId = studentID.getText();
            String stuEmail = email.getText();
            int stuContNo = Integer.parseInt(contactNO.getText());
            String stuAddress = address.getText();

            student = new StudentDetails(stuName, stuAge, stuId, stuEmail, stuContNo, stuAddress);

            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("modules_core.fxml"));
            mainStage.setTitle("Core Modules Details");
            mainStage.setScene(new Scene(root, 650, 750));
            mainStage.show();
        }
        catch (Exception evt1){

            //alerting for wrong input
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setTitle("Error");
            alert3.setHeaderText("Fix the issue");
            alert3.setContentText("Enter all details properly");
            alert3.showAndWait();

        }
    }

    @FXML
    private TextField mod1, mod2, mod3, mod4, mod5, mod6, mod7, mod8, mod9;

    //method to input all compulsory module details
    public void inputCoreModDetails(ActionEvent evt) throws Exception {
        try {
            int stuMarks1 = Integer.parseInt(mod1.getText());
            int stuMarks2 = Integer.parseInt(mod2.getText());
            int stuMarks3 = Integer.parseInt(mod3.getText());
            int stuMarks4 = Integer.parseInt(mod4.getText());
            int stuMarks5 = Integer.parseInt(mod5.getText());
            int stuMarks6 = Integer.parseInt(mod6.getText());
            int stuMarks7 = Integer.parseInt(mod7.getText());
            int stuMarks8 = Integer.parseInt(mod8.getText());
            int stuMarks9 = Integer.parseInt(mod9.getText());

            coreModule = new CoreModDetails();
            coreModule.addCom("SC531", stuMarks1);
            coreModule.addCom("SC535", stuMarks2);
            coreModule.addCom("SC537", stuMarks3);
            coreModule.addCom("SC539", stuMarks4);
            coreModule.addCom("SC538", stuMarks5);
            coreModule.addCom("SC546", stuMarks6);
            coreModule.addCom("SC554", stuMarks7);
            coreModule.addCom("SC555", stuMarks8);
            coreModule.addCom("SC597", stuMarks9);

            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("module_opt.fxml"));
            mainStage.setTitle("Optional Modules Details");
            mainStage.setScene(new Scene(root, 604, 750));
            mainStage.show();
        }
        catch (Exception evt1){

            //alerting for wrong input
            Alert alert4 = new Alert(Alert.AlertType.ERROR);
            alert4.setTitle("Error");
            alert4.setHeaderText("Fix the issue");
            alert4.setContentText("Enter all details properly");
            alert4.showAndWait();
        }
    }

    @FXML
    private TextField mc1, mc2, mc3, mc4, mc5, mc6, mc7, omod1, omod2, omod3, omod4, omod5, omod6, omod7, speModMarks;
    @FXML
    private RadioButton rb1, rb2, rb3;
    @FXML
    private ToggleGroup specialmarks;

    //method to input all optional modules details
    public void inputOptModDetails(ActionEvent evt) throws Exception {
        try {
            String optModCode1 = mc1.getText();

            String optModCode2 = mc2.getText();
            String optModCode3 = mc3.getText();
            String optModCode4 = mc4.getText();
            String optModCode5 = mc5.getText();
            String optModCode6 = mc6.getText();
            String optModCode7 = mc7.getText();
            String projectCode = "";
            int stuMarks10 = Integer.parseInt(omod1.getText());
            int stuMarks11 = Integer.parseInt(omod2.getText());
            int stuMarks12 = Integer.parseInt(omod3.getText());
            int stuMarks13 = Integer.parseInt(omod4.getText());
            int stuMarks14 = Integer.parseInt(omod5.getText());
            int stuMarks15 = Integer.parseInt(omod6.getText());
            int stuMarks16 = Integer.parseInt(omod7.getText());
            int stuMarks17 = 0;

            String radioname = ((RadioButton) specialmarks.getSelectedToggle()).getId();
            if (radioname.equals("rb1")) {
                projectCode = "SC598";
                stuMarks17 = Integer.parseInt(speModMarks.getText());

            } else if (radioname.equals("rb2")) {
                projectCode = "SC599";
                stuMarks17 = Integer.parseInt(speModMarks.getText());
            }

            optModule = new OptModDetails();
            optModule.addOpt(optModCode1, stuMarks10);
            optModule.addOpt(optModCode2, stuMarks11);
            optModule.addOpt(optModCode3, stuMarks12);
            optModule.addOpt(optModCode4, stuMarks13);
            optModule.addOpt(optModCode5, stuMarks14);
            optModule.addOpt(optModCode6, stuMarks15);
            optModule.addOpt(optModCode7, stuMarks16);

            if (projectCode.length() >= 1) {
                optModule.addOpt(projectCode, stuMarks17);
            }

            Enrollment allDetails = new Enrollment(coreModule, optModule, student);
            studentDatabase.add(allDetails);

            System.out.println(allDetails.getStudentFinalGPA());
            System.out.println(allDetails.getStudentDegree());

            Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("option_menu.fxml"));
            mainStage.setTitle("Main Menu");
            mainStage.setScene(new Scene(root, 604, 659));
            mainStage.show();
        }
        catch (Exception evt1){

            //alerting for wrong input
            Alert alert5 = new Alert(Alert.AlertType.ERROR);
            alert5.setTitle("Error");
            alert5.setHeaderText("Fix the issue");
            alert5.setContentText("Enter all details properly");
            alert5.showAndWait();
        }

    }

    @FXML
    private Button terminate;

    //method to terminate the application
    public void terminateApp(ActionEvent evt) throws Exception{
        Platform.exit();
        System.exit(0);
    }



    @FXML
    private Button tologin;

    //method yo return back to login page
    public void toLogin(ActionEvent evt) throws Exception {
        Stage mainStage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        mainStage.setTitle("Gugsi University of Computer Sciences");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.show();
    }

}
