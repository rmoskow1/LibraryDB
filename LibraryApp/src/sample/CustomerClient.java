package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;


public class CustomerClient {
    public TextField txtFirst;
    public TextField txtLast;
    public TextField txtSSN;
    public Button btnNext;
    public Button btnPrev;
    public TextField txtID;

    View view = new View();
    Controller controller = new Controller();
    int customerID = 1;


    public void initialize() {
        controller.loadCustomer(customerID);
    }

    public void nextCustomer(ActionEvent actionEvent) {
        customerID++;
        controller.loadCustomer(customerID);
    }

    public void previousCustomer(ActionEvent actionEvent) {
        customerID--;
        if (customerID < 1)
            customerID = 1;
        controller.loadCustomer(customerID);
    }

    class View {
        void populateScreen(Customer customer) {
            txtFirst.setText(customer.getFirst());
            txtLast.setText(customer.getLast());
            txtSSN.setText("" + customer.getSSN());
            txtID.setText("" + customer.getID());
        }

        Customer getCustomerFromScreen() {
            Customer c = new Customer();
            c.setFirst(txtFirst.getText());
            c.setLast(txtLast.getText());
            c.setSSN(Integer.parseInt(txtSSN.getText()));
            c.setID(Integer.parseInt(txtID.getText()));
            return c;
        }
    }

    class Controller {
        void loadCustomer(int ID) {
            Customer c = new Customer();
            c.loadCustomer(ID);
            view.populateScreen(c);
        }

    }
}
