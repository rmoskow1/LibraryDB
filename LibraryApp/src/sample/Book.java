package sample;

import java.sql.*;

public class Book {
    int ID;
    String title, author;
    /*
    public Book(int ID, String title, String author){
        this.ID = ID;
        this.title = title;
        this.author = author;
    }*/

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void loadBook(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/LibraryDB/LibraryApp/CustomerDatabase");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT title, author, id From Customers Where ID =" + id);

            if (rs.next()) { // there was a result
                title = rs.getString("Title");
                author  = rs.getString("Author");
                ID = id;
            }
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
}
