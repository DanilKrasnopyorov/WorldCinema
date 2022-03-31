package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.newproject.adapters.ChatAdapter;
import com.example.newproject.adapters.MoviesAdapter;
import com.example.newproject.network.ApiHandler;
import com.example.newproject.network.ErrorUtils;
import com.example.newproject.network.models.ChatResponse;
import com.example.newproject.network.models.MoviesResponse;
import com.example.newproject.network.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView messagesContainer;
    private List<ChatResponse> messagesList = new ArrayList<>();
    private ChatAdapter chatAdapter;
    private int chatId;
    private ApiService service = ApiHandler.getInstance().getService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messagesContainer = findViewById(R.id.recycler_messages);
        getMessages();
    }
    private void getMessages(){
        AsyncTask.execute(() -> {
            service.getChatMessages(1).enqueue(new Callback<List<ChatResponse>>() {
                @Override
                public void onResponse(Call<List<ChatResponse>> call, Response<List<ChatResponse>> response) {
                    if(response.isSuccessful()){
                        messagesList = response.body();
                        chatAdapter = new ChatAdapter(messagesList, getApplicationContext());
                        SnapHelper snapHelper = new PagerSnapHelper();
                        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        messagesContainer.setLayoutManager(manager);
                        messagesContainer.setAdapter(chatAdapter);
                        snapHelper.attachToRecyclerView(messagesContainer);
                    } else if(response.code() == 400)
                        Toast.makeText(getApplicationContext(), "Вы не авторизированы! Попробуйте зайти позже!", Toast.LENGTH_SHORT).show();
                    else{
//                        String serverErrorMessage = ErrorUtils.parseError(response).message();
//                        Toast.makeText(getApplicationContext(), serverErrorMessage, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<ChatResponse>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}