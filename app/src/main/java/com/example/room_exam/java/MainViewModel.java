package com.example.room_exam.java;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Room;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private AppDataBase db;

    public MainViewModel(@NonNull Application application, AppDataBase db) {
        super(application);
        db = Room.databaseBuilder(application, AppDataBase.class, "toto-db").build();
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }

    public void insert(Todo todo){
        new InsertAsyncTask(db.todoDao()).execute(todo);
    }

    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void> {
        private TodoDao mTodoDao;
        public InsertAsyncTask(TodoDao todoDao) {this.mTodoDao = todoDao;}

        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }
    }
}
