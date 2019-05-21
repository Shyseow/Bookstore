/*
Title: BookStore
@author: Seow Hui Yin
Date: 06/04/2018
File Name: Book.java

Purpose: The purpose of this program is where all the books will be created 
         for the BookClient in order to contain. Everything related to creating 
         the books are in this class, from the title, author, publisher, year,
         ISBN, price and InStock. It contains all the methods asked for including 
         the accessor methods, mutator methods, toString method and equals method.
 */


package asgmt2_bookstore;

import java.text.DecimalFormat;
import java.util.Scanner;

/* Class for basic bookstore: title,author,publisher,year,ISBN,price,InStock */
public final class Book {   
//private variable,attributes of the books:  
  private String Title;
  private String Author; 
  private String Publisher; 
  private int Year; 
  private long ISBN; 
  private double Price; 
  private int InStock; 
  
  Scanner scan = new Scanner(System.in);
  DecimalFormat df = new DecimalFormat( "#.00" ); //format values into currency format
  
//default constructor
public Book()       
    {
        Title = "No name yet.";
        Author = "No name yet.";
        Publisher = "No name yet.";
        Year = 0;
        ISBN = 0;
        Price = 0;
        InStock = 0;
    }
  
// Constructor with parameters
public Book (String newTitle, String newAuthor,String newPublisher,int newYear,long newISBN, double newPrice,int newInStock)
    {
        this.Title = newTitle;
        this.Author = newAuthor;
        this.Publisher = newPublisher;
        this.Year = newYear;
        this.ISBN = newISBN;
        this.Price = newPrice;
        this.InStock = newInStock;       
    } 
        
/*accessors (getter methods)*/
//returns Title of book
public String getTitle() 
    {
        return Title;
    }

//returns Author of book
public String getAuthor() 
    {
        return Author;
    }

//returns Publisher of book
public String getPublisher() 
    {
        return Publisher;
    }

//returns Year of book
public int getYear() 
    {
        return Year;
    }

//returns ISBN of book
public long getISBN() 
    {
        return ISBN;
    }

//returns Price of book
public double getPrice() 
    {
        return Price;
    }

//returns Stocks of book
public int getInStock() 
    {
        return InStock;
    }

// Calculate and returns the value of stock on this particular item
public double getBookValue() 
    {
        return (Price * ((double)InStock));
    }

//Output the details of a book
public void getbookCollection()
{
    System.out.println("\nBook's detail ");
                        System.out.println("Title                 :  " + Title);
                        System.out.println("Author                :  " + Author);
                        System.out.println("Publisher             :  " + Publisher);
                        System.out.println("Publish year          :  " + Year);
                        System.out.println("ISBN                  :  " + ISBN);
                        System.out.println("Price                 :  $" + df.format(Price));
                        System.out.println("Qty of books in stock :  " + InStock);
}


/*mutator(setter methods)*/
//Initializes the Title of book
public void setTitle(String newTitle) 
{
    this.Title = newTitle;
}

//Initializes the Author of book
public void setAuthor(String newAuthor) 
{
    this.Author = newAuthor;
}

//Initializes the Publisher of book
public void setPublisher(String newPublisher) 
{
    this.Publisher = newPublisher;
}

//Initializes the Year of book
public void setYear(int newYear) 
{
    this.Year = newYear;
}

//Initializes the ISBN of book
public void setISBN(long newISBN) 
{
    this.ISBN = newISBN;
}

//Initializes the Price of book
public void setPrice(double newPrice) 
{
    this.Price = newPrice;
    
}

//Initializes the Stocks of book
public void setInStock(int newInStock) 
{
    this.InStock = newInStock;
}

//Read input of the details of a book
public void setbookCollection()
{
    System.out.println("Enter the detail of book " );
                        System.out.print("Enter the title of book : ");
                        this.Title = scan.nextLine();
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
}

/*Method that compares the equality of two books and return 
true if they have the same title,same author and same ISBN*/
  public boolean equals(Object b) {

		if (this == b) {
			return true;
		}
		//check if both objects should be compared or not
		if (b instanceof Book) {
                        // cast to your class to access its fields
			Book other = (Book)b;
                    //check both fields are equal, means objects are equal
			return this.Title.equals(other.Title) && this.ISBN == other.ISBN && this.Author.equals(other.Author);
		}
		return false;
  }
             
/*toString method that represent the book as a string*/
public String toString()
{
    return ("\nTitle\t :  " + this.Title + "\nAuthor\t : " + this.Author + "\nPublisher: " + this.Publisher + "\nYear\t : " + this.Year +
            "\nISBN\t : " + this.ISBN + "\nPrice\t : $ " + df.format(this.Price) + "\nInStock\t : " + this.InStock ); 
}
                
}

 