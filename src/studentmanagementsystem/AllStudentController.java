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
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author nafiul
 */
public class AllStudentController implements Initializable {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> nameColl;
    @FXML
    private TableColumn<Student, String> emailColl;
    
    @FXML
    private TableColumn<Student, String> addressColl;
    @FXML
    private TableColumn<Student, Integer> idColl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        studentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        AddStudentLayoutController.stdList.clear();
        
        //database action..
        
        DatabaseAction dbAction=new DatabaseAction();
        try {
            AddStudentLayoutController.stdList= dbAction.getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(AllStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     
            
        idColl.setCellValueFactory(new PropertyValueFactory<Student,Integer>("Id"));
        nameColl.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        emailColl.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
            
        addressColl.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
            
        studentTable.setItems(AddStudentLayoutController.stdList);
        
    }    

    @FXML
    private void deleteButtonAction(ActionEvent event) throws IOException {
        
        
        
    }

    
    
}
