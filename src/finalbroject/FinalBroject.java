package finalbroject;

import java.util.Scanner;

public class FinalBroject {

    public static void main(String[] args) {
        //---------------------------------before Start------------------------------------
        //Create Books for test
        Book CSS = new Book("001", "CSS", "available", null);
        storage.Books.add(CSS);
        Book HTML = new Book("002", "HTML", "available", null);
        storage.Books.add(HTML);
        Book JS = new Book("003", "JS", "available", null);
        storage.Books.add(JS);
        Book Java = new Book("004", "Java", "available", null);
        storage.Books.add(Java);
        //Create Students for test
        Student abd = new Student(90.0, "abd", "abd", "123", "active");
        storage.Users.add(abd);
        Student ahmed = new Student(70.0, "ahmed", "ahmed", "1234", "active");
        storage.Users.add(ahmed);
        Student ali = new Student(75.7, "ali", "ali", "12345", "inactive");
        storage.Users.add(ali);
        //Create Employee for test
        Employee said = new Employee("said", "said", "123", "active");
        storage.Users.add(said);
        Employee sami = new Employee("sami", "sami", "1234", "inactive");
        storage.Users.add(sami);
        //Create Librarian for test
        Librarian taj = new Librarian("taj", "taj", "123");
        storage.Librarians.add(taj);
        Librarian samir = new Librarian("samir", "samir", "1234");
        storage.Librarians.add(samir);

        //---------------------------------Start------------------------------------
        Scanner input = new Scanner(System.in);
        while (true) {

            System.out.println("Welcome to Library System,");
            System.out.print("Enter your ID name : ");
            String ID = input.nextLine();
            //---------------------------------Student------------------------------------
            if (storage.checkUserId(ID) != null) {
                if (storage.checkUserId(ID).equals("Student")) {
                    String name = storage.findUser(ID).getName();
                    System.out.print("Hi Student " + name + ", now enter your password: ");
                    String password = input.nextLine();
                    if (storage.checkUserPassword(password, ID)) {
                        User tempUser = storage.findUser(ID);
                        System.out.println("Welcome " + name + ",");
                        /*System.out.println("1- Show available books\n"
                                + "2- Borrow a book (by ISBN)\n"
                                + "3- Search for books by name\n"
                                + "4- to change user\n"
                                + "5- to Exit the program");*/
                        boolean loop = true;
                        while (loop) {
                            System.out.println("1- Show available books\n"
                                + "2- Borrow a book (by ISBN)\n"
                                + "3- Search for books by name\n"
                                + "4- to change user\n"
                                + "5- to Exit the program");
                            System.out.print("\nEnter Your choice : ");
                            int choice = input.nextInt();
                            input.nextLine();
                            switch (choice) {
                                case 1:
                                    storage.showAvailableBooks();
                                    System.out.println("-----------------------------------------");
                                    System.out.print("Want to borrow a book? Enter its ISBN: ");
                                    String ISBN = input.nextLine();
                                    tempUser.borrow(ISBN);
                                    break;
                                case 2:
                                    System.out.print("Enter the books’ ISBN: ");
                                    ISBN = input.nextLine();
                                    tempUser.borrow(ISBN);
                                    break;
                                case 3:
                                    System.out.print("Enter the name you want to look for, or the ISBN number: ");
                                    String ISBNOrName = input.nextLine();
                                    Book tempBook = tempUser.findBookByName(ISBNOrName);
                                    if (tempBook != null) {
                                        tempBook.printRebort();
                                    } else {
                                        System.out.println("the book that you look for is not in the library");
                                    }
                                    break;
                                case 4:
                                    loop = false;
                                    break;
                                case 5:
                                    System.exit(0);
                                    break;
                                default:
                                    break;
                            }
                            System.out.println("\n----------------------------------------------------------------------------------");
                        }

                    }
                    //-------------------------------------Employee------------------------------------
                } else if (storage.checkUserId(ID).equals("Employee")) {
                    String name = storage.findUser(ID).getName();
                    System.out.print("Hi Employee " + name + ", now enter your password: ");
                    String password = input.nextLine();
                    if (storage.checkUserPassword(password, ID)) {
                        User tempUser = storage.findUser(ID);
                        System.out.println("Welcome " + name + ",");
                        /*System.out.println("1- Show available books\n"
                                + "2- Borrow a book (by ISBN)\n"
                                + "3- Search for books by name\n"
                                + "4- to change user\n"
                                + "5- to Exit the program");*/
                        boolean loop = true;
                        while (loop) {
                             System.out.println("1- Show available books\n"
                                + "2- Borrow a book (by ISBN)\n"
                                + "3- Search for books by name\n"
                                + "4- to change user\n"
                                + "5- to Exit the program");
                            System.out.print("\nEnter Your choice : ");
                            int choice = input.nextInt();
                            input.nextLine();
                            switch (choice) {
                                case 1:
                                    storage.showAvailableBooks();
                                    System.out.println("-----------------------------------------");
                                    System.out.print("Want to borrow a book? Enter its ISBN: ");
                                    String ISBN = input.nextLine();
                                    tempUser.borrow(ISBN);
                                    break;
                                case 2:
                                    System.out.print("Enter the books’ ISBN: ");
                                    ISBN = input.nextLine();
                                    tempUser.borrow(ISBN);
                                    break;
                                case 3:
                                    System.out.print("Enter the name you want to look for, or the ISBN number: ");
                                    String ISBNOrName = input.nextLine();
                                    Book tempBook = tempUser.findBookByName(ISBNOrName);
                                    if (tempBook != null) {
                                        tempBook.printRebort();
                                    } else {
                                        System.out.println("the book that you look for is not in the library");
                                    }
                                    break;
                                case 4:
                                    loop = false;
                                    break;
                                case 5:
                                    System.exit(0);
                                    break;
                                default:
                                    break;
                            }
                            System.out.println("\n----------------------------------------------------------------------------------");
                        }

                        //-------------------------------------Librarian------------------------------------
                    }
                } else if (storage.checkUserId(ID).equalsIgnoreCase("Librarian")) {
                    Librarian tempLibrarian = storage.findLibrarian(ID);
                    String name = tempLibrarian.getName();
                    System.out.print("Hi Librarian " + name + ", now enter your password: ");
                    String password = input.nextLine();
                    if (storage.checkLibrarianPassword(password, ID)) {
                        System.out.println("Welcome " + name + ",");
                       /* System.out.println("1- Approve Borrowing Request Queue\n"
                                + "2- View All Books\n"
                                + "3- Check the borrowing history for a book\n"
                                + "4- Check the borrowing history for a user\n"
                                + "5- Manage Library users\n"
                                + "6- Explore books\n"
                                + "7- Add Book\n"
                                + "8- to change user\n"
                                + "9- to Exit the program");*/
                        boolean loop = true;
                        while (loop) {
                            System.out.println("1- Approve Borrowing Request Queue\n"
                                + "2- View All Books\n"
                                + "3- Check the borrowing history for a book\n"
                                + "4- Check the borrowing history for a user\n"
                                + "5- Manage Library users\n"
                                + "6- Explore books\n"
                                + "7- Add Book\n"
                                + "8- to change user\n"
                                + "9- to Exit the program");
                            System.out.print("\nEnter Your choice : ");
                            int choice = input.nextInt();
                            input.nextLine();
                            switch (choice) {
                                case 1:
                                    break;
                                case 2:
                                    storage.showAllBook();
                                    break;
                                case 3:
                                    storage.showAvailableBooks();
                                    System.out.print("Enter book ISBN : ");
                                    String ISBN = input.nextLine();
                                    if (storage.findBook(ISBN) != null) {
                                        storage.findBook(ISBN).showBorrowHistory();
                                    }
                                    break;
                                case 4:
                                    storage.showAllUser();
                                    System.out.print("Which users’ history you want to check ? ");
                                    String UserId = input.nextLine();
                                    if (storage.findUser(UserId) != null) {
                                        storage.findUser(UserId).showBorrowHistory();
                                    }
                                    break;
                                case 5:
                                    storage.showAllUser();
                                    System.out.print("Which users’ status you want to toggle ?");
                                    UserId = input.nextLine();
                                    if (storage.findUser(UserId) != null) {
                                        storage.findUser(UserId).toggle();
                                    }

                                    break;
                                case 6:
                                    System.out.print("First book is : ");
                                    int theIindex = 0;
                                    System.out.println(storage.Books.get(theIindex).getISBN() + " , " + storage.Books.get(theIindex).getName());

                                    System.out.println("Press n for next, p for previous, f for first, l for last.");
                                    String ExploreChoice = input.nextLine();
                                    if (ExploreChoice.equalsIgnoreCase("n")) {
                                        if (theIindex == storage.Books.size() - 1) {
                                            System.out.println("Index out of bounds");
                                        } else {
                                            theIindex++;
                                            System.out.print("The next : ");
                                            System.out.println(storage.Books.get(theIindex).getISBN() + " , " + storage.Books.get(theIindex).getName());
                                        }
                                    } else if (ExploreChoice.equalsIgnoreCase("p")) {
                                        if (theIindex == 0) {
                                            System.out.println("Index out of bounds");
                                        } else {
                                            theIindex--;
                                            System.out.print("The previous : ");
                                            System.out.println(storage.Books.get(theIindex).getISBN() + " , " + storage.Books.get(theIindex).getName());
                                        }
                                    } else if (ExploreChoice.equalsIgnoreCase("f")) {
                                        theIindex = 0;
                                        System.out.print("The first : ");
                                        System.out.println(storage.Books.get(theIindex).getISBN() + " , " + storage.Books.get(theIindex).getName());
                                    } else if (ExploreChoice.equalsIgnoreCase("l")) {
                                        theIindex = storage.Books.size() - 1;
                                        System.out.print("The last : ");
                                        System.out.println(storage.Books.get(theIindex).getISBN() + " , " + storage.Books.get(theIindex).getName());
                                    }
                                    break;

                                case 7:
                                    ISBN = "00" + (storage.Books.size() + 1);
                                    System.out.println("Book ISBN is " + ISBN);
                                    System.out.print("Book name : ");
                                    String bookName = input.nextLine();
                                    Book temp = new Book(ISBN , bookName , "available", null);
                                    storage.Books.add(temp);
                                    break;
                                case 8:
                                    loop = false;
                                    break;
                                case 9:
                                    System.exit(0);
                                    break;
                                default:System.out.println("Wrong choice");
                            }
                            System.out.println("\n----------------------------------------------------------------------------------");
                        }
                    }

                }

            }
        }
    }
}
