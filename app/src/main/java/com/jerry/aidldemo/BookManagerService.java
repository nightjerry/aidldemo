package com.jerry.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import androidx.annotation.Nullable;

public class BookManagerService extends Service {
    //CopyOnWriteArrayList: 支持并发读/写
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();

    private Binder mBinder = new com.jerry.aidldemo.IBookManager.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                double aDouble, String aString) throws RemoteException {
            //just test
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return mBookList;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book("Android", 11));
        mBookList.add(new Book("iOS", 12));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
