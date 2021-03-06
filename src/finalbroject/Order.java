package finalbroject;

public class Order {

    private String ISBN;
    private String UserID;

    public Order(String ISBN, String UserID) {
        this.ISBN = ISBN;
        this.UserID = UserID;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

}
