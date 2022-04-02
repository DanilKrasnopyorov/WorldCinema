package com.example.newproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.R;
import com.example.newproject.network.models.ChatResponse;
import com.example.newproject.network.models.MoviesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {
    private List<ChatResponse> messagesList;
    private Context mContext;
    private int VIEW_TYPE_MESSAGE_ME = 1;
    private int VIEW_TYPE_MESSAGE_OTHER = 2;

    public ChatAdapter(List<ChatResponse> chatList, Context context) {
        this.messagesList = chatList;
        this.mContext = context;
    }

    public class ChatHolder extends RecyclerView.ViewHolder{
        private TextView messageText;
        private TextView messageDate;
        private TextView messageUsername;
        private ImageView messageAvatar;
        public ChatHolder (View itemView){
            super(itemView);
            messageText = itemView.findViewById(R.id.messageText);
            messageDate = itemView.findViewById(R.id.messageDate);
            messageUsername = itemView.findViewById(R.id.messageUsername);
            messageAvatar = itemView.findViewById(R.id.messageAvatar);
        }
        public void setMessageAvatar(String imageUrl) {
            Picasso.with(mContext)
                    .load(imageUrl)
                    .error(R.drawable.empty_img)
                    .into(messageAvatar);
        }

        public void setMessageDate(String date) {
            messageDate.setText(date);
        }

        public void setMessageText(String content) {
            messageText.setText(content);
        }

        public void setMessageUsername( String username ) {
            messageUsername.setText(username);
        }
    }
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == VIEW_TYPE_MESSAGE_ME) {
            view = layoutInflater.inflate(R.layout.my_message_item, parent, false);
        }
        else if (viewType == VIEW_TYPE_MESSAGE_OTHER) {
            view = layoutInflater.inflate(R.layout.another_message_item, parent, false);
        }
        else{
            view = layoutInflater.inflate(R.layout.another_message_item, parent, false);
        }
        return new ChatHolder(view);
    }
    @Override
    public int getItemViewType(int position){
        ChatResponse message = messagesList.get(position);
        if(message.getFirstName().equals("Ivan"))
            return VIEW_TYPE_MESSAGE_ME;
        else
            return VIEW_TYPE_MESSAGE_OTHER;
    }
    @Override
    public int getItemCount(){
        return messagesList == null ? 0: messagesList.size();
    }
    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, final int position){
        final ChatResponse message = messagesList.get(position);
        if(message.getFirstName() != null)
            holder.setMessageUsername(message.getFirstName() + " " + message.getLastName());
        else
            holder.setMessageUsername(message.getAuthorName());
        holder.setMessageAvatar("http://cinema.areas.su/up/images/" + message.getAvatar());
        holder.setMessageDate(message.getDate());
        holder.setMessageText(message.getText());
    }
}
