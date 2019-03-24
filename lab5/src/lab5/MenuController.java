package lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lab5.Labs.Lab1.src.FirstLab;
import lab5.Labs.Lab3.src.ThirdLab;
import lab5.Labs.Lab4.src.FourthLab;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.event.ActionEvent;


public class MenuController
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextArea textArea;

    @FXML
    private URL location;

    @FXML
    private Button startButton;

    @FXML
    private ComboBox comboBox;

    @FXML
    private TextField arg1;

    @FXML
    private TextField arg2;

    @FXML
    private TextField arg3;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    private StringBuilder outputString;

    @FXML
    void initialize() {

        ObservableList<String> comboBoxItems = FXCollections.observableArrayList("Lab1", "Lab3", "Lab4");
        comboBox.setItems(comboBoxItems);

        textArea.setEditable(false);
        textArea.setPromptText("Please, select a task number");

        PrintStream consoleStream = new PrintStream(new OutputStream()
        {
            public void write(int b) {}

            public synchronized void write(byte[] b, int offset, int length) {
                if (b != null && outputString != null) {
                    outputString.append(new String(b, offset, length));
                }
            }
        });

        System.setOut(consoleStream); //select consoleStream as current
        System.setErr(consoleStream);
    }

    @FXML
    void start(ActionEvent event) throws Exception
    {
        outputString = new StringBuilder();
        textArea.clear();
        if (comboBox.getValue() == "Lab1")
        {
            FirstLab.main(arg1.getText(), arg2.getText(), arg3.getText());
        } else if (comboBox.getValue() == "Lab3")
        {
            ThirdLab.main(arg2.getText());
        } else if (comboBox.getValue() == "Lab4")
        {
            FourthLab.main(arg1.getText(), arg2.getText());
        } else if (comboBox.getValue() == null)
        {
            textArea.clear();
            textArea.setText("Error! Please, select a task number");
        }
        textArea.setText(outputString.toString());

    }


    @FXML
    public void itemChanged(ActionEvent actionEvent)
    {
        textArea.clear();

        if (comboBox.getValue() == "Lab1")
        {
            label1.setText("Day of birth");
            label2.setText("Month of birth");
            label3.setText("Year of birth");

            arg1.clear();
            arg2.clear();
            arg3.clear();

            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);

            arg1.setVisible(true);
            arg2.setVisible(true);
            arg3.setVisible(true);
            textArea.setPromptText("Создать приложение, вычисляющее возраст , c 3 параметрами : день, месяц , год( дата рождения)" +
                         ", где месяц задается в виде строки: май или январь и т. п.\n" +
                        "Результатом работы приложения должен быть возраст , выраженный в количестве лет, месяцев и дней на текущую дату.");

        } else if (comboBox.getValue() == "Lab3")
        {
            label2.setText("Iterations");

            arg1.clear();
            arg2.clear();
            arg3.clear();

            label1.setVisible(false);
            label2.setVisible(true);
            label3.setVisible(false);

            arg1.setVisible(false);
            arg2.setVisible(true);
            arg3.setVisible(false);
            textArea.setPromptText("Напишите приложение с 2 потоками- производителем и потребителем, которые имеют разделяемую статическую переменную- склад. " +
                         "То есть склад не является массивом!\n" +
                        "Склад хранит целые числа от 0 до 100.\n" +
                        "Производитель генерирует число от 0 до 100 и отправляет его на склад, выводя имя производителя и сгенеренное число.\n" +
                        "Потребитель читает значение числа со склада, как только оно там появилось, и выводит  на консоль имя потребителя и полученное число.\n" +
                        "  Выполнить задание   с использованием конструкции synchronized . \n" +
                        "Не использовать в этом задании флаги для синхронизации потоков, а только методы wait и notify. \n" +
                        "Также не использовать любые задержки для потоков после начала их работы в виде методов sleep, yield или wait c параметром.");
        } else if (comboBox.getValue() == "Lab4")
        {
            label1.setText("Workers");
            label2.setText("Baskets");

            arg1.clear();
            arg2.clear();
            arg3.clear();

            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(false);

            arg1.setVisible(true);
            arg2.setVisible(true);
            arg3.setVisible(false);
            textArea.setPromptText("Выполнить многопотоковое приложение с 2 параметрами для нижеследующей задачи.\n" +
                        "Работники(количество работников задано параметром) собирают яблоки в ящики(количество ящиков задано параметром). Дополнительный работник- мастер координирует работу, \n" +
                        "каждый работник сообщает ему о том, что собрал очередной ящик.\n" +
                        " Когда каждый работник соберет ящик ,\n" +
                        " то он ждет пока остальные работники тоже соберут по одному ящику, по сигналу мастера  он продолжает работу.\n" +
                        " Работа  заканчивается, когда все ящики будут собраны. \n" +
                        "Использовать ограничения из задания 3. Выводить идентификатор работника вместе с номером ящика для каждого потока.");
        }

    }
}



