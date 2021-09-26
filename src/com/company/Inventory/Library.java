package com.company.Inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library  implements Serializable {

    private List<Books> booksList ;

    public Library()
    {
        booksList = new ArrayList<Books>();
    }

    public void addBooks(Books books)
    {
        booksList.add(books);
    }

    @Override
    public String toString()
    {
        String result ="\n";

        Iterator<Books> itr = booksList.iterator();

        while(itr.hasNext())
        {
            Books books = (Books) itr.next();
            result += books.toString();
        }

        return result;
    }


}
