/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextArea addressField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    static ObservableList<Student> stdList=FXCollections.observableArrayList();
    
    @FXML
    private void saveButtonAction(ActionEvent event) throws IOException, SQLException {
        
        if(idField.getText().equals("")) return;
        
        int id=Integer.parseInt(idField.getText());
        String name=nameField.getText();
        String email=emailField.getText();
      
        String adr=addressField.getText();
        
        
        if(name.equals("") && email.equals("") && adr.equals("")) return;
        Student std=new Student(id,name,email,adr);
        
        
        
        //database action
        DatabaseAction dbAction=new DatabaseAction();
        dbAction.insertStudent(std);
        
        
        nameField.clear();
        emailField.clear();
        idField.clear();
        addressField.clear();
        
        
    }

    @FXML
    private void resetButtonAction(ActionEvent event) {
        nameField.clear();
        emailField.clear();
        idField.clear();
        addressField.clear();
        
    }
    
}
