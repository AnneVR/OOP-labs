package lab5;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startButton;

    @FXML
    private ComboBox comboBox;

    @FXML
    void initialize()
    {
        ObservableList<String> comboBoxItems = FXCollections.observableArrayList("Lab1", "Lab3", "Lab4");
        comboBox.setItems(comboBoxItems);
        comboBox.setValue("Lab1");
    }

    @FXML
    void start(ActionEvent event) throws Exception
    {
        if (comboBox.getValue() == "Lab1")
        {
            Stage stage = (Stage)startButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader1 = new
                FXMLLoader(getClass().getResource("lab1.fxml"));
            Parent root5 = fxmlLoader1.load();
            Stage stage5 = new Stage();
            stage5.setOpacity(1);

            stage5.setTitle("Lab5");
            stage5.setScene(new Scene(root5, 788, 589));
            stage5.setResizable(false);
            stage5.show();
        }

        if (comboBox.getValue() == "Lab3")
        {
            Stage stage = (Stage)startButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader3 = new
                    FXMLLoader(getClass().getResource("lab3.fxml"));
            Parent root3 = fxmlLoader3.load();
            Stage stage3 = new Stage();
            stage3.setOpacity(1);

            stage3.setTitle("Lab5");
            stage3.setScene(new Scene(root3, 788, 589));
            stage3.setResizable(false);
            stage3.show();
        }

        if (comboBox.getValue() == "Lab4")
        {
            Stage stage = (Stage)startButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader4 = new
                    FXMLLoader(getClass().getResource("lab4.fxml"));
            Parent root4 = fxmlLoader4.load();
            Stage stage4 = new Stage();
            stage4.setOpacity(1);

            stage4.setTitle("Lab5");
            stage4.setScene(new Scene(root4, 788, 589));
            stage4.setResizable(false);
            stage4.show();
        }
    }
}

