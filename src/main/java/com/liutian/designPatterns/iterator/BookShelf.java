package com.liutian.designPatterns.iterator;

import java.util.ArrayList;

public class BookShelf implements Aggregate{

    private ArrayList<Book> books;
    int length = 0;

    public BookShelf(int n) {
        books = new ArrayList<>(n);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        length++;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
