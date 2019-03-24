package lab5;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import lab5.Labs.Lab3.src.ThirdLab;

public class Lab3Controller
{

    @FXML
    private ResourceBundle resources;

    private StringBuilder tempString;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TextArea textArea;

    @FXML
    private Button startButton;

    @FXML
    private TextArea textAreaInput;

    @FXML
    void back(ActionEvent event)throws Exception
    {
        Stage stage = (Stage)backButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setOpacity(1);

        stage1.setTitle("Lab5");
        stage1.setScene(new Scene(root, 788, 589));
        stage1.setResizable(false);
        stage1.show();
    }

    @FXML
    void start2(ActionEvent event)
    {
        String value = textAreaInput.getText();

        tempString = new StringBuilder();
        ThirdLab.main(value);
        textArea.setText(tempString.toString());

    }

    @FXML
    void initialize()
    {
        textArea.setEditable(false);
        PrintStream consoleStream = new PrintStream(new OutputStream()
        {
            public void write(int b) {}

            public synchronized void write(byte[] b, int offset, int length)
            {
                tempString.append(new String(b, offset, length));
            }

        });
        System.setOut(consoleStream); //select consoleStream as current
        System.setErr(consoleStream);

    }
}
