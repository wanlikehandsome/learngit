package model;

public class Book {

    private String bookname;
    private String author;
    private float price;

    public Book(String bookname, String author, float price)
    {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }
    public Book(){

    }

    public String getBookname() {
        return bookname;
    }
    public String getAuthor() {
        return author;
    }
    public float getPrice() {
        return price;
    }
    //返回对象的属性


    public boolean  setBook(String bookname, String author, float price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        return true;
    }
    //修改对象的值，并返回真值

}