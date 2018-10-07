package com.example.w.emptabel.ui.passingActivity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.w.emptabel.R;
import com.example.w.emptabel.Model.Employee;
import com.example.w.emptabel.databinding.ActivityPassingBinding;

public class PassingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Employee employee = new Employee("John Smith", 2);

        ActivityPassingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_passing);
        binding.setEmployee(employee);
    }
}
