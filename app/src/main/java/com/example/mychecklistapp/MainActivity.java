package com.example.mychecklistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mychecklistapp.models.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Item> itemList;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        itemList = new ArrayList<>();


        itemList.add(new Item("Java", "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.", R.drawable.java));
        itemList.add(new Item("Python", "Python is an interpreted, high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation.", R.drawable.python));
        itemList.add(new Item("JavaScript", "JavaScript is a high-level, often just-in-time compiled language that conforms to the ECMAScript specification.", R.drawable.javascript));
        itemList.add(new Item("C#", "C# is a modern, object-oriented programming language developed by Microsoft as part of its .NET initiative.", R.drawable.csharp));
        itemList.add(new Item("Ruby", "Ruby is a dynamic, open source programming language with a focus on simplicity and productivity.", R.drawable.ruby));
        itemList.add(new Item("C++", "C++ is a general-purpose programming language created as an extension of the C programming language, or 'C with Classes'.", R.drawable.cplusplus));
        itemList.add(new Item("Go", "Go is an open-source programming language that makes it easy to build simple, reliable, and efficient software.", R.drawable.go));
        itemList.add(new Item("Swift", "Swift is a powerful and intuitive programming language for macOS, iOS, watchOS, and tvOS.", R.drawable.swift));
        itemList.add(new Item("PHP", "PHP is a popular general-purpose scripting language that is especially suited to web development.", R.drawable.php));
        itemList.add(new Item("Kotlin", "Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference.", R.drawable.kotlin));
        itemList.add(new Item("Rust", "Rust is a multi-paradigm programming language focused on performance and safety, especially safe concurrency.", R.drawable.rust));
        itemList.add(new Item("TypeScript", "TypeScript is a strict syntactical superset of JavaScript that adds optional static typing to the language.", R.drawable.typescript));

        ItemAdapter adapter = new ItemAdapter(this, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("itemTitle", itemList.get(position).getName()); // Pass the title
                intent.putExtra("itemDetail", itemList.get(position).getDetail()); // Pass the description
                intent.putExtra("imageResId", itemList.get(position).getPath()); // Pass the image resource ID
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}