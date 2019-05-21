/*
Title: BookStore
@author: Seow Hui Yin
Date: 06/04/2018
File Name: BookClient.java

Purpose: This is the Client class for the Book class. This class contains main method
         is to start execution and run the program. User will be asked to choose
         the option to perform some action for maintain the bookstore.
 */

package asgmt2_bookstore;
import java.util.Scanner; //To let user input from the Scanner class
import java.text.DecimalFormat; //Import the format class to format values into currency format

public class BookClient 
{
  static Book[] bookCollection = new Book[6]; //array that to store all of the created Book objects
  static Scanner scan = new Scanner(System.in);
  static int choice ;
  static DecimalFormat df = new DecimalFormat( "#.00" );
  static Book tempbookCollection = new Book();  

    public static void main(String[] argv)
    {
        studentInfo();
        /**boolean that allows the main part of the program to run while it is true**/
        boolean quit = false;
        Scanner scan = new Scanner(System.in);
	System.out.println("Hello and welcome to the Book Store!");
	
 
       //main menu,output options
       do {
	System.out.println("\nChoose one of the options below : ");
	System.out.println(" =====================================================================");
        System.out.println("\t1)\tQuit");
	System.out.println("\t2)\tCreate an array for 6 books.");
	System.out.println("\t3)\tDetails of books currently in stock.");
	System.out.println("\t4)\tSearch book by given ISBN.");
	System.out.println("\t5)\tSearch book by given Author.");
        System.out.println("\t6)\tUpdate stock of book by enter ISBN.");
        System.out.println("\t7)\tUpdate price of book by enter book title.");
        System.out.println("\t8)\tMost expensive book.");
        System.out.println("\t9)\tQuantity of total stock.");
        System.out.println("\t10)\tMonetary value of total stock.");
        System.out.println("\t11)\tAdd new book.");
        System.out.println("\t12)\tDelete/Remove book.");
        System.out.println("\t13)\tSorting.");
	System.out.println(" =====================================================================");
	System.out.println(" Enter your option here [1-13]: ");
        choice = scan.nextInt();//User inputs a choice (integer)
      
        switch (choice) {
            case 1: System.out.println("Quit!Goodbye!"); 
                    System.exit(0); //ends the program entirely 
                    break;
                    
            case 2 : enterDetails();
                     break;
                          
            case 3 : bookDetails();
                     break;
                       
            case 4 : getBookByISBN();
                     break;
               
            case 5 : getBookByAuthor();
                     break;
           
            case 6 : updateInStock(); 
                     break;
   
            case 7 : updatePrice(); 
                     break; 
          
            case 8 : getMax(); 
                     break;

            case 9 : totalStock();  
                     break;
                   
            case 10 : getMonetaryValue();
                      break;
                   
            case 11 : addBook();
                      break;                                
            
            case 12 : removeBook();
                      break;
                
            case 13 : Sorting();
                      break;
        }     
   
            //if the user's choice does not correspond to any of the options, keep asking again and again
                while(choice == 0 || choice < 0 || choice > 13)
                    {
                        System.out.println("Invalid choice! Please choose a valid option");
                        System.out.println("Press Enter ");
                        System.out.println("Please input a number between 1 to 13");
                        choice = scan.nextInt();
                        quit = false;

                    }
        
   
}
       while (!quit);
       }
    
/*when option 2 selected, user ask to enter book's detail*/
    public static void enterDetails()
{
     //create books by enter details
     String Title = null;
     String Author = null; 
     String Publisher = null; 
     int Year = 0; 
     long ISBN = 0; 
     double Price = 0; 
     int InStock = 0;
     Scanner scan = new Scanner(System.in);
     int N = 6;
     
		//Create a string array to store the book detail
                String arrayOfBooks[] = new String[N];
		for (int i = 0; i < arrayOfBooks.length; i++) {                   
			System.out.println("Enter the detail of book " + (i+1) + " : ");
                        System.out.print("Enter the title of book : ");
                        Title = scan.nextLine();
                        System.out.print("Enter the author of book : ");
                        Author = scan.nextLine();
                        System.out.print("Enter the publisher of book : ");
                        Publisher = scan.nextLine();
                        System.out.print("Enter the year publish of book : ");
                        Year = scan.nextInt();
                        System.out.print("Enter the ISBN of book : ");
                        ISBN = scan.nextLong();
                        System.out.print("Enter the price of book : $");
                        Price = scan.nextDouble();
                        System.out.print("Enter the quantity in stock : ");
                        InStock = scan.nextInt();
		        arrayOfBooks[i] = scan.nextLine();
                        System.out.println(" ");
                        
                        Book oneBook = new Book(Title, Author, Publisher, Year, ISBN, Price, InStock);
                        bookCollection[i] = oneBook; //new book created
        }
}
    
/*when option 3 selected, display all book's detail*/
 public static void bookDetails()
 {      
    //show books' detail one by one
    for (int i = 0; i < bookCollection.length; i++) //loop over array
        { 
          //display all books information 
	  System.out.print(bookCollection[i] + "\n"); 
        }

} 
 
/*when option 4 selected, search the book with given ISBN*/
public static void getBookByISBN()
{
    System.out.println("Please enter an ISBN: ");
    long input = scan.nextLong();
    boolean found = false;
        for (int i = 0; i< bookCollection.length; i++) //loop over array
        {
            if (input == bookCollection[i].getISBN()) //to get ISBN
            {
              tempbookCollection = bookCollection[i];
              found = true;
            }  
        } 
                if(found)
                 {
                    tempbookCollection.getbookCollection();
                 } 
                    else
                    System.out.print("No book found! ");                    
}


/*when option 5 selected,search the book with given author name*/
public static void getBookByAuthor()
{ 
    //number of books that exist under the author's name
    int existingBooks=0;
    System.out.println("Please Enter the name of the author");
    String authorName= scan.nextLine();
    boolean found = false;
    for (int i=0; i<bookCollection.length;i++) //loop over array
        {
          if (bookCollection[i]!=null)
          if (bookCollection[i].getAuthor().equals(authorName)) //get author name and compare to input	
          existingBooks++;
        }
           //how many books exist under the name of the author
            System.out.println("There exists " + existingBooks + " books under this author : ");
            System.out.println();
					
            for (int i=0; i<bookCollection.length; i++) //loop over array
              {
                //if a book does exist at a particular location in an array
                if (bookCollection[i]!=null)
                  {
                    //check if the author names match to the input
                    if (bookCollection[i].getAuthor().equals(authorName))	
                        bookCollection[i].getbookCollection();
                      else
                       System.out.print("No book found! ");   
                  }
              }
}


/*when option 6 selected,search the book with given ISBN, and update stock*/
public static void updateInStock()
{
    System.out.println("Please enter an ISBN: ");
    long update= scan.nextLong();
    boolean found = false;
        for (int i = 0; i< bookCollection.length; i++) //loop over array
        {
            if (update == bookCollection[i].getISBN()) //get ISBN and compare to input
           {
              found = true;

              System.out.println("What is the new quantity of stock?");
              int quantity = scan.nextInt();
              bookCollection[i].setInStock(quantity); //set new quantity to stock
              System.out.println("Qty of books in stock is updated:  " + quantity + "books"); //new update quantity
              break;
           }
        }
        
                 if (found == false)
                 System.out.print("No book found! ");                      
}

/*when option 7 selected,search the book with given book title, and update price*/ 
public static void updatePrice()
{  
    Scanner kb = new Scanner(System.in);
    System.out.println("Please enter the title of book");               
    String bookName= kb.nextLine();
    boolean found = false;
    for (int i=0; i<bookCollection.length;i++) //loop over array
    {
        if (bookCollection[i].getTitle().equals(bookName)) //get book title and compare to input
        {
            found = true;
            System.out.println("\nWhat is the new price?");
            double upPrice = kb.nextDouble();
            bookCollection[i].setPrice(upPrice);
            System.out.println("Price of the book (" + bookName + ") is updated"); //new updated price
            System.out.println("-----------------------------------------------");
            System.out.println("New Price :  $" + df.format(upPrice));
            break;
        }
    }
    
    if (found == false) 
        System.out.print("No book found! ");
}


/*when option 8 selected,find most expensive book*/
public static void getMax()
{
    Book mostExBook = null;
    double max = bookCollection[0].getPrice();
        for(int i=0; i<bookCollection.length; i++) //loop over array
            {
                if (bookCollection[i].getPrice()>max) 
                {
                    max = bookCollection[i].getPrice(); //get largest in array
                    mostExBook = bookCollection[i];
                }
            } 
        
                    System.out.println( "\n========< Most expensive book in bookstore >=========");
                    System.out.println(" "+ mostExBook.toString());
                    System.out.println( "--------------------------------------------------------");
                    System.out.println("The price is : $" + df.format(max));  
}


/*when option 9 selected,get total stock*/
public static void totalStock()
{
    Book[] newbookCollection = new Book[bookCollection.length];
       for (int i =0; i < newbookCollection.length; i++)
        {
          newbookCollection[i] = bookCollection [i];
        }
                int total = bookCollection[0].getInStock();
                int sum = 0;
                  for(int i=0; i<bookCollection.length; i++) //loop over array
                    {
                      {sum = sum + bookCollection[i].getInStock();} //get total stock
                    } 
                  
                 System.out.println( "\n========< Quantity of total stock in bookstore >=========");
                 System.out.println(">>Total stock is " + sum);   
}


/*when option 10 selected, get monetary value of total stock*/
public static void getMonetaryValue()
{
         double totalValue = bookCollection[0].getBookValue();
         double value = 0;
         for(int i=0; i<bookCollection.length; i++) //loop over array
           {
              {value = value + bookCollection[i].getBookValue();}
           } 
         
         System.out.println( "\n========< Monetary Value of total stock in bookstore >=========");
         System.out.println(">>Total value is $" + df.format(value));   
}

/*when option 11 selected,add new book to array*/
   public static void addBook()
{
     String Title = null;
     String Author = null; 
     String Publisher = null; 
     int Year = 0; 
     long ISBN = 0; 
     double Price = 0; 
     int InStock = 0;
     
               Book[] newbookCollection = new Book[bookCollection.length+1]; //array size increase by 1
               for (int i = 0; i < bookCollection.length; i++)
               {
                   newbookCollection[i] = bookCollection[i];
               }
			System.out.println("Enter the detail of book  : ");
                        System.out.print("Enter the title of book : ");
                        Title = scan.nextLine();
                        System.out.print("Enter the author of book : ");
                        Author = scan.nextLine();
                        System.out.print("Enter the publisher of book : ");
                        Publisher = scan.nextLine();
                        System.out.print("Enter the year publish of book : ");
                        Year = scan.nextInt();
                        System.out.print("Enter the ISBN of book : ");
                        ISBN = scan.nextLong();
                        System.out.print("Enter the price of book : $");
                        Price = scan.nextDouble();
                        System.out.print("Enter the quantity in stock : ");
                        InStock = scan.nextInt();
                        System.out.println(" ");
                        System.out.println("Book added successfully!");

                        Book oneNewBook = new Book(Title, Author, Publisher, Year, ISBN, Price, InStock);
                        int lastIndex = newbookCollection.length - 1;
                        newbookCollection[lastIndex] = oneNewBook; //new book created
                        bookCollection = newbookCollection; //copy new array to old array
   }
       

/*when option 12 selected,
search the book with given ISBN and remove the book*/
public static void removeBook()
{

    System.out.println("Please enter an ISBN: ");
    long update= scan.nextLong();
    boolean found = false;
    
          // before delete 
          System.out.println("All books in bookstore :\n");
          for (int k = 0; k < bookCollection.length; k++) 
        {
          System.out.println(bookCollection[k]);
        }
          
            for (int i = 0; i < bookCollection.length; i++) 
            {
                // delete function
                if (update == bookCollection[i].getISBN()) 
                {
                    for (int j = i + 1; i < bookCollection.length - 1; j++) //array size decrease by 1
                  {
                    bookCollection[i] = bookCollection[j];
                    i++;
                  }
                }
            }
            
            // after delete 
            System.out.println("The book with the ISBN input has been removed!");
            System.out.println("All books in bookstore after removing that particular book");
            for (int i = 0; i < bookCollection.length - 1; i++) 
            {
              System.out.println(bookCollection[i]);
            }
}


/*when option 13 select
sort all books into ascending order of author name*/
public static void Sorting() 
{
    Book[] sortedBooks = bookCollection;
    //Sort the array using bubble sort
    for (int i = 0; i< sortedBooks.length - 1; i++) 
        {
              for (int j = 0; j < sortedBooks.length - 1; j++) 
            {
		 if (sortedBooks[j].getAuthor().compareTo(sortedBooks[j+1].getAuthor())>0)
                    {
			Book temp = sortedBooks[j];
			sortedBooks[j] = sortedBooks[j + 1];
			sortedBooks[j + 1] = temp;
                    }
            }
        }
                    for (int i = 0; i< sortedBooks.length ; i++) 
                    {
                      System.out.println (sortedBooks[i].toString());
                    }
                      System.out.println();
}

//Display student information
public static void studentInfo() 
    {
        System.out.println("Name:Seow Hui Yin");
        System.out.println("Student number:33255186");
        System.out.println("Mode of enrolment:External");
        System.out.println("Tutor name:Mr.Chong");
        System.out.println("Tutorial attendance day:Tuesday");
        System.out.println("Time:8.30pm to 10.30pm");
        System.out.println(" ");
    }

}
