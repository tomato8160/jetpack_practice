package com.example.room_exam.java;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.room_exam.java.Todo;

import java.util.List;

//@Dao
public interface TodoDao {
    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAll();

    @Insert
    void insert(Todo todo);

    @Update
    void update(com.example.room_exam.java.Todo todo);

    @Delete
    void delete(com.example.room_exam.java.Todo todo);
}
