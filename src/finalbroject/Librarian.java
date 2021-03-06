package finalbroject;

import java.util.Scanner;

public class Librarian {

    public Librarian() {
    }

    public Librarian(String ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    private String ID;
    private String name;
    private String password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void borrowingRequests() {
        while (!storage.Orders.isEmpty()) {
            Order temp = storage.Orders.remove();
            User tempUser = storage.findUser(temp.getUserID());
            Book tempBook = storage.findBook(temp.getISBN());

            String Username = tempUser.getName();
            String bookName = tempBook.getName();
            System.out.println(Username + " wants to borrow( " + temp.getISBN() + " , " + bookName+" )");
            System.out.println("Approve it? (1:yes, 0:no)");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            input.nextLine();
            if (x == 1) {
                if (tempBook.getStatus().equals("available")) {
                    tempBook.setCurrentOwner(tempUser);
                    tempBook.setStatus("borrowed");
                    tempBook.borrowingHistory.push(tempUser);
                    tempUser.borrowingHistory.push(tempBook);
                    System.out.println("The book has been registered as borrowed");
                } else {
                    System.out.println("this book is borrowed");
                }
            }
        }
    }

    public void acceptReturnedBooks(String ID) {
        if (storage.findBook(ID) != null) {
            storage.findBook(ID).setStatus("available");
        } else {

        }
    }

    public void BorrowHistory(String ID, char bookOrUser) {
        if (bookOrUser == 'U' || bookOrUser == 'u') {
            if (storage.findUser(ID) != null) {
                User tempUser = storage.findUser(ID);
                tempUser.showBorrowHistory();
            }
        } else if (bookOrUser == 'B' || bookOrUser == 'b') {
            if (storage.findBook(ID) != null) {
                Book tempBook = storage.findBook(ID);
                tempBook.showBorrowHistory();
            }
        }
    }

}
