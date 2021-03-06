package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CustomerForm {
    public TextField txtFirst; //txtFirst
    public TextField txtLast; //txtLast
    public Button btnNext; //btnNext
    public Button btnPrev; //btnPrev
    public TextField txtID; //txtID
    public TextField txtSSN;

    View view = new View();
    Controller controller = new Controller();
    int bookID = 1;


    public void initialize() {
        controller.loadCustomer(bookID);
    }

    public void nextBook(ActionEvent actionEvent) {
        bookID++;
        controller.loadCustomer(bookID);
    }

    public void previousBook(ActionEvent actionEvent) {
        bookID--;
        if (bookID < 1)
            bookID = 1;
        controller.loadCustomer(bookID);
    }

    class View {
        void populateScreen(Customer customer) {
            txtFirst.setText(customer.getFirst());
            txtLast.setText(customer.getLast());

            txtID.setText("" + customer.getID());
        }

        Customer getCustomerFromScreen() {
            Customer c = new Customer();
            c.setFirst(txtFirst.getText());
            c.setLast(txtLast.getText());
            c.setSSN(Integer.parseInt(txtID.getText()));
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

