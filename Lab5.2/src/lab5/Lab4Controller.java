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
import lab5.Labs.Lab4.src.FourthLab;

public class Lab4Controller
{
    @FXML
    private ResourceBundle resources;

    private StringBuilder outputString;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private TextArea textArea;

    @FXML
    private Button startButton;

    @FXML
    private TextArea textAreaInput2;

    @FXML
    private TextArea textAreaInput1;

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
    void start4(ActionEvent event)
    {
        String workers = textAreaInput1.getText();
        String baskets = textAreaInput2.getText();
        outputString = new StringBuilder();
        FourthLab.main(workers, baskets);
        textArea.setText(outputString.toString());


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
                    outputString.append(new String(b, offset, length));
            }
        });
        System.setOut(consoleStream); //select consoleStream as current
        System.setErr(consoleStream);
    }
}
