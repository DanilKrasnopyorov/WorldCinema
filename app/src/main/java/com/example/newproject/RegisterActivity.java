package com.example.newproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText nameField;
    private EditText surnameField;
    private EditText emailField;
    private EditText passwordField;
    private EditText repeatPasswordField;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog alertDialog;
//    usescleartexttraffic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameField = findViewById(R.id.nameInput);
        surnameField = findViewById(R.id.surnameInput);
        emailField = findViewById(R.id.emailInput);
        passwordField = findViewById(R.id.passwordInput);
        repeatPasswordField = findViewById(R.id.repeatPasswordInput);
    }

    public void moveToLoginScreen(View view) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void registerUser(View view) {
        name = nameField.getText().toString();
        surname = surnameField.getText().toString();
        email = emailField.getText().toString();
        password = passwordField.getText().toString();
        repeatPassword = repeatPasswordField.getText().toString();
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setCancelable(true)
                .setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
        if(name.length() == 0) {
            alertDialogBuilder
                    .setMessage("Поле Имя не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(surname.length() == 0){
            alertDialogBuilder
                    .setMessage("Поле Фамилия не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(email.length() == 0){
            alertDialogBuilder
                    .setMessage("Поле Email не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(email.length() == 0){
            alertDialogBuilder
                    .setMessage("Поле Email не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            alertDialogBuilder
                    .setMessage("Поле Email заполнено неверно!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(password.length() == 0){
            alertDialogBuilder
                    .setMessage("Поле Пароль не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        if(repeatPassword.length() == 0){
            alertDialogBuilder
                    .setMessage("Поле Повторите пароль не должно быть пустым!");
            alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return;
        }
        alertDialogBuilder
                .setMessage("Тест на дурака пройден успешно");
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return;
    }
}