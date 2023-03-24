package com.example.appenglish.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appenglish.R;
import com.example.appenglish.models.Book;
import com.example.appenglish.models.Exam;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Book book = new Book();
        book.title = "book1";
        book.content = "content 1";
        book.save();

        Book bookService = new Book();

        Book book1 = (Book) bookService.find(book.id);
        book.where("title","=","book1").get();
        //1234
    }
}