package com.example.newproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newproject.network.ApiHandler;
import com.example.newproject.network.ErrorUtils;
import com.example.newproject.network.models.LoginBody;
import com.example.newproject.network.models.LoginResponse;
import com.example.newproject.network.models.RegisterBody;
import com.example.newproject.network.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    ApiService service = ApiHandler.getInstance().getService();

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
        doRegister();
    }

    private RegisterBody getRegisterData(){
        return new RegisterBody(name, surname, email, password);
    }
    private LoginBody getLoginData(){
        return new LoginBody(email, password);
    }
    private void doRegister(){
        AsyncTask.execute(() -> {
            service.doRegister(getRegisterData()).enqueue(new Callback<RegisterBody>() {
                @Override
                public void onResponse(Call<RegisterBody> call, Response<RegisterBody> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Регистрация прошла успешно. Можете авторизироваться!", Toast.LENGTH_SHORT).show();
                        doLogin();
                    }
                    else if (response.code() == 400){
                        String serverErrorMessage = ErrorUtils.parseError(response).message();
                        Toast.makeText(getApplicationContext(), serverErrorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<RegisterBody> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            });
        });
    }
    private void doLogin() {
        AsyncTask.execute(() -> {
            service.doLogin(getLoginData()).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()){
                        SharedPreferences settings = getSharedPreferences("settings", MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("token", response.body().getToken());
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else if (response.code() == 401) {
                        String serverErrorMessage = ErrorUtils.parseError(response).message();
                        Toast.makeText(getApplicationContext(), serverErrorMessage, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Прошла неизвестная ошибка попробуйте позже!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}