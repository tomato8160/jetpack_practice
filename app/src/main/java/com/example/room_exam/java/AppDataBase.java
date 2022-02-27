package com.example.room_exam.java;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room_exam.java.Todo;
import com.example.room_exam.java.TodoDao;

//@Database(entities = Todo.class, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TodoDao todoDao();
}
