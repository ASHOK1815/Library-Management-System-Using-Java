package com.company;

import com.company.Inventory.Books;
import com.company.Inventory.Library;

import java.io.*;
import java.util.Scanner;

public class Main {

    static boolean running = true;
    static String fileName = null;
    static Library lib = new Library();
    static Books books;
    static Scanner scanner = new Scanner(System.in);
    static void loadScript(String fileName)
    {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        File file = new File(fileName+".ser");
        if(file.exists())
        {
            try {
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library)in.readObject();
                fis.close();
                in.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
        else
        {
            System.out.println("\n File doesnot exist");
        }
    }

    static void SavaAndQuit()
    {
        System.out.println("Enter the file name");
        fileName = scanner.next()+".ser";
        running = false;
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(lib);
            fos.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addBooks()
    {
        int isbn;
        String title,author;
        double price;
        System.out.println("\nEnter the books title");
        title = scanner.next();
        System.out.println("Enter the books author");
        author = scanner.next();
        System.out.println("Enter the ISBN number");
        isbn = scanner.nextInt();
        System.out.println("Enter the price of the book");
        price = scanner.nextInt();
        books = new Books(isbn,title,author, price);
        lib.addBooks(books);
    }

    public static void main(String[] args) {

        do {
            int choice;
            System.out.println("Enter 1 for listing all the books present in the library");
            System.out.println("Enter 2 for adding books in the library");
            System.out.println("Enter 3 for save and quite");
            System.out.println("Enter 4 for load a library");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println(lib.toString());
                    break;
                case 2:
                    addBooks();
                    break;
                case 3:
                    SavaAndQuit();
                    break;
                case 4:
                    System.out.println("Enter the file name that you want to load");
                    fileName = scanner.next();
                    loadScript(fileName);
                    break;


                default:

            }



        }while (running);

    }
}
