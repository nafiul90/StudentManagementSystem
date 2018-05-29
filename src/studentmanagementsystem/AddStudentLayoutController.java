/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nafiul
 */
public class AddStudentLayoutController implements Initializable {

    @FXML
    private TextField studentName;
    @FXML
    private TextField studentEmail;
    @FXML
    private TextField department;
    @FXML
    private TextArea address;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    static ObservableList<Student> stdList=FXCollections.observableArrayList();
    
    @FXML
    private void saveButtonAction(ActionEvent event) {
        
        String name=studentName.getText();
        String email=studentEmail.getText();
        String dept=department.getText();
        String adr=address.getText();
        
        
        if(name.equals("") && email.equals("") && dept.equals("") & adr.equals("")) return;
        Student std=new Student(name,email,dept,adr);
        
        stdList.add(std);
        
        studentName.clear();
        studentEmail.clear();
        department.clear();
        address.clear();
        
        
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
    }
    
}
