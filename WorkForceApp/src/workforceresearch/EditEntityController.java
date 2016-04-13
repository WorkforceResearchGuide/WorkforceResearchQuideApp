package workforceresearch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditEntityController implements Initializable 
{
    @FXML
    private Button deleteEntityButton,addFileRelationButton,removeRelationButton,addRelationButton,saveEditsButton,cancelEditsButton;
    
    @FXML
    private RadioButton beliefRadioButton;
    
    @FXML
    private ListView associationsListView;
    
    private AppHandler appHandler;
    
    @FXML
    private void handleBeliefRadioButton(ActionEvent event)
    {
        
    }
    
    @FXML
    private void handleAddFileRelationButton(ActionEvent event)
    {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
    }
    
    @FXML
    private void handleRemoveRelationButton(ActionEvent event)
    {
       //gets the selected item
        associationsListView.getSelectionModel().getSelectedItem();
        
        Stage stage;
        Parent root = null;
        boolean fxmlFound = false;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteAssociationVerify.fxml")); 
        DeleteAssociationVerifyController control = null;
        
        stage = new Stage();
        try 
        {
            root = loader.load();
            control = loader.<DeleteAssociationVerifyController>getController();
            fxmlFound = true;
        }  
        catch (IOException ex) 
        {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(fxmlFound)
        {
            stage.setScene(new Scene(root));
            stage.setTitle("WARNING");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(removeRelationButton.getScene().getWindow());
            control.setAppHandler(appHandler);
            stage.showAndWait();
        }
    }
    
    @FXML
    private void handleAddRelationButton(ActionEvent event)
    {
        Stage stage;
        Parent root = null;
        boolean fxmlFound = false;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("associateEntity.fxml")); 
        AssociateEntityController associateControl = null;
        
        stage = new Stage();
        try 
        {
            root = loader.load();
            associateControl = loader.<AssociateEntityController>getController();
            fxmlFound = true;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(fxmlFound)
        {
            stage.setScene(new Scene(root));
            stage.setTitle("Associate a Fact/Belief");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(addRelationButton.getScene().getWindow());
            associateControl.setAppHandler(appHandler);
            stage.showAndWait();
        }
    }
    
    @FXML
    private void handleSaveNewFBButton(ActionEvent event)
    {
        //TODO: edit the fact/belief
        Stage stage = (Stage) saveEditsButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleCancelNewButton(ActionEvent event)
    {
        Stage stage = (Stage) cancelEditsButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handleDeleteEntityButton(ActionEvent event)
    {
        Stage stage;
        Parent root = null;
        boolean fxmlFound = false;
        
        stage = new Stage();
        try 
        {
            root = FXMLLoader.load(getClass().getResource("deleteEntityVerify.fxml"));
            fxmlFound = true;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(MainScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(fxmlFound)
        {
            stage.setScene(new Scene(root));
            stage.setTitle("WARNING");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(deleteEntityButton.getScene().getWindow());
            stage.showAndWait();
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setAppHandler(AppHandler ah)
    {
        appHandler = ah;
    }
    
}