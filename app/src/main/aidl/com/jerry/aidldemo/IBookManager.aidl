// IBookManager.aidl
package com.jerry.aidldemo;

// Declare any non-default types here with import statements
import com.jerry.aidldemo.Book;

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void addBook(in Book book);
    List<Book> getBooks();
}
