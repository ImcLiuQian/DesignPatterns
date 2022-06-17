package com.liutian.designPatterns.iterator;

public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    private int last = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public Boolean hasNext() {
        if (last >= bookShelf.length) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Book bookAt = bookShelf.getBookAt(last);
        last++;
        return bookAt;
    }
}
