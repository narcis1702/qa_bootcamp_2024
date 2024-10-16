public class Book {
     private String name;
     private int year;
     private Author author;
     private double price;


     public Book(String name, int year, Author author, double price) {
         this.name = name;
         this.year = year;
         this.author = author;
         this.price = price;
    }
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }


}
