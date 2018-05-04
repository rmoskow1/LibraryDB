package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;


public class BookClient {
    public TextField txtTitle;
    public TextField txtAuthor;
    public TextField txtID;
    public Button btnNext;
    public Button btnPrev;

    View view = new View();
    Controller controller = new Controller();
    int bookID = 1;


    public void initialize() {
        controller.loadBook(bookID);
    }

    public void nextBook(ActionEvent actionEvent) {
        bookID++;
        controller.loadBook(bookID);
    }

    public void previousBook(ActionEvent actionEvent) {
        bookID--;
        if (bookID < 1)
          bookID = 1;
        controller.loadBook(bookID);
    }

    class View {
        void populateScreen(Book book) {
            txtAuthor.setText(book.getAuthor());
            txtTitle.setText(book.getTitle());
            txtID.setText("" + book.getID());
        }

        Book getBookFromScreen() {
            Book b = new Book();
            b.setTitle(txtTitle.getText());
            b.setAuthor(txtAuthor.getText());
            b.setID(Integer.parseInt(txtID.getText()));
            return b;
        }
    }

    class Controller {
        void loadBook(int ID) {
            Book b = new Book();
            b.loadBook(ID);
            view.populateScreen(b);
        }

    }
}
