package tool;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Book;
import model.BookList;
import ui.MainClass;

public class IO {
    public void load()
    {
        try {
            String filename = "E:\\library\\learn\\txb.txt";
            File file = new File(filename);
            //文件对象
            FileReader fileReader = new FileReader(file);
            //文件读取对象，通过文件对象构建
            BufferedReader reader = new BufferedReader(fileReader);
            //文件阅读器，通过文件读取对象构建
            /*  reader.readLine()
                reader.close()

             */
            String temp;
            while((temp = reader.readLine()) != null)
            {
                String bookname = temp.split(",")[0];
                String author = temp.split(",")[1];
                String pricestr = temp.split(",")[2];
                float price = Float.parseFloat(pricestr);
                Book book = new Book(bookname,author,price);
                BookList.booklist.add(book);
            }
            reader.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void save()
    {
        String fileName = "E:\\library\\learn\\txb.txt";
        String allbook="";
        for(int i = 0; i < BookList.booklist.size(); i++)
        {
            Book book = (Book)BookList.booklist.get(i);
            String temp = book.getBookname() + "," + book.getAuthor() + "," + book.getPrice() + "\r\n";
            allbook += temp;
        }
        try {
            File file1 = new File(fileName);
            //创建文件对象
            FileWriter fileWriter = new FileWriter(file1);
            //创建文件写入对象

            fileWriter.write(allbook);
            // 写入字符串
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
