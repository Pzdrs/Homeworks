package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox inequalities;
    @FXML
    private TextField a, b, c;
    @FXML
    private TextArea results;

    private Solver solver;

    @FXML
    public void clearInputs() {
        solver = null;
        a.setText("");
        b.setText("");
        c.setText("");
        results.setText("");
        inequalities.getSelectionModel().select(0);
    }

    @FXML
    public void handle() {
        // Validate inputs
        try {
            int aValue = Integer.parseInt(a.getText());
            int bValue = Integer.parseInt(b.getText());
            int cValue = Integer.parseInt(c.getText());
            // Check for 0 in 'a' value
            if (aValue == 0) {
                results.setText("Toto je lineární nerovnice, ne kvadratická.");
                return;
            }
            solver = new Solver(this, aValue, bValue, cValue, inequalities.getSelectionModel().getSelectedItem().toString());
            solver.solve();
        } catch (NumberFormatException exception) {
            results.setText("Vkládejte pouze celá čísla.");
        }
    }

    public void printResults(List<String> solution) {
        if (solution == null) {
            results.setText("");
            return;
        }
        solution.forEach(line -> {
            results.setText(results.getText() + "\n" + line);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inequalities.getItems().addAll("<", ">", "<=", ">=");
        inequalities.getSelectionModel().select(0);
    }
}
