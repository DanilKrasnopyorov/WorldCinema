package com.example.newproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.newproject.network.ApiHandler;
import com.example.newproject.network.models.UserResponse;
import com.example.newproject.network.service.ApiService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {
    private ApiService service = ApiHandler.getInstance().getService();
    private TextView userFullName;
    private TextView userEmail;
    private TextView userId;
    private ImageView userAvatar;
    public ProfileFragment(){

    }
    public static ProfileFragment newInstance(String param1, String param2){
        return new ProfileFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initUI(view);
        getUserData();
        return view;
    }
    private void initUI(View view){
        userFullName = view.findViewById(R.id.userFullName);
        userEmail = view.findViewById(R.id.userEmail);
        userId = view.findViewById(R.id.userId);
        userAvatar = view.findViewById(R.id.userAvatar);
    }
    private void getUserData(){
        AsyncTask.execute(() -> {
            service.getUserInfo().enqueue(new Callback<List<UserResponse>>() {
                @Override
                public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                    if(response.isSuccessful()){
                        Picasso.with(getContext())
                                .load("http://cinema.areas.su/up/images" + response.body().get(0).getAvatar())
                                .into(userAvatar);
                        userFullName.setText(response.body().get(0).getFirstName() + " " + response.body().get(0).getLastName());
                        userEmail.setText(response.body().get(0).getEmail());
                        userId.setText(response.body().get(0).getUserId());
                    } else if(response.code() == 401)
                        Toast.makeText(getActivity().getApplicationContext(), "Произошла ошибка! Попробуйте позже!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity().getApplicationContext(), "Произошла ошибка! Попробуйте позже!", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                    Log.d(TAG, t.getLocalizedMessage());
                    Toast.makeText(getActivity().getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
