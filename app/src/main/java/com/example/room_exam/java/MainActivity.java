package com.example.room_exam.java;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.room_exam.R;

public class MainActivity extends AppCompatActivity {

    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);



        MainViewModel mainViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainViewModel.class);

        // ui 갱신
        mainViewModel.getAll().observe(this, data -> {
            mResultTextView.setText(data.toString());

        });


        // 버튼 클릭시 db에 insert
        findViewById(R.id.add_button).setOnClickListener(view -> {
            mainViewModel.insert(new Todo(mTodoEditText.getText().toString()));
        });
    }
}