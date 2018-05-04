package sample;

import java.sql.*;

class Customer {
    public Customer() {}

    public void loadCustomer(int id) {
        try {

            Connection conn = DriverManager.getConnection("/Users/morischick/Downloads/MVCDemo/CustomerDatabase");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Title, Author, bookID, SSN From Customers Where ID =" + id);

            if (rs.next()) { // there was a result
                title = rs.getString("Title");
                author = rs.getString("Author");
                ID = id;

            }
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String first) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String last) {
        this.author = author;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    int ID;
    String title, author;
}
