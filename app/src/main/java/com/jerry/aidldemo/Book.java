package com.jerry.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public int price;
    public String name;

    public Book(String name, int price){
        this.price = price;
        this.name = name;
    }

    protected Book(Parcel in) {
        price = in.readInt();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(price);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
