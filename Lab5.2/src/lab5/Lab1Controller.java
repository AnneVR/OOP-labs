package lab5;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.util.StringConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lab5.Labs.Lab1.src.FirstLab;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lab1Controller
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker Date;

    private StringBuilder tempString;
    @FXML
    private TextArea textArea;

    @FXML
    private Button startButton;

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
    void start1(ActionEvent event)
    {
        LocalDate value = Date.getValue();
        DateTimeFormatter dateFormatDay = DateTimeFormatter.ofPattern("dd", Locale.ENGLISH);
        DateTimeFormatter dateFormatMonth = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        DateTimeFormatter dateFormatYear = DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH);

        String formattedDay = value.format(dateFormatDay);
        String formattedMonth = value.format(dateFormatMonth);
        String formattedYear = value.format(dateFormatYear);

        int day = Integer.parseInt(formattedDay);
        int year = Integer.parseInt(formattedYear);

        tempString = new StringBuilder();
        FirstLab.main(day, formattedMonth, year);
        textArea.setText(tempString.toString());

    }

    @FXML
    void initialize()
    {
        textArea.setEditable(false);
        Date.setValue(LocalDate.now());
        Date.setShowWeekNumbers(false);

        StringConverter<LocalDate> converter = new StringConverter<LocalDate>()
        {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", Locale.ENGLISH);

            public String toString(LocalDate date) { return dateFormatter.format(date);}
            public LocalDate fromString(String string) { return LocalDate.parse(string, dateFormatter);}

        };
        Date.setConverter(converter);
        Date.setPromptText("dd-MMMM-yyyy");

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
