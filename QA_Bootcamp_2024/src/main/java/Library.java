public class Library {

    public static void main(String[] args) {
        Author author = new Author("Narcis Negru", "contact@narcisnegru.ro");

        Book book = new Book("The QA roadtrip", 2024, author, 39.99);

        System.out.println("Book " + book.getName() + " (" + book.getPrice() + " RON), by "
                + book.getAuthor().getName() + ", published in " + book.getYear());
    }
}
