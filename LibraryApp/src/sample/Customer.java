package sample;

import java.sql.*;

class Customer {
    String first, last;
    int SSN, ID;

    public Customer() {}
    /*public Customer(int ID, String first, String last, int SSN) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/LibraryDB/LibraryApp/CustomerDatabase");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT first, last, SSN From Customers Where ID =" + id);

            if (rs.next()) { // there was a result
                first = rs.getString("Title");
                last  = rs.getString("Author");
                ID = id;
                SSN = rs.getInt(SSN);

            }
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }*/

    public void loadCustomer(int id) {
        try {
            String folder = System.getProperty("user.dir") + "\\LibraryApp\\";
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + folder + "CustomerDatabase");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT first, last, SSN From Customers Where ID =" + id);

            if (rs.next()) { // there was a result
                first = rs.getString("first");
                last  = rs.getString("last");
                ID = id;
                SSN = rs.getInt("SSN");

            }
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }

    public int getID() {
        return ID;
    }
    public int getSSN(){
        return SSN;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }
}

