package com.example.newproject.network.models;

import com.google.gson.annotations.SerializedName;

public class ChatResponse {
    @SerializedName("chatId")
    private String chatId;
    @SerializedName("messageId")
    private String messageId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("creationDateTime")
    private String date;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("text")
    private String text;

    public String getAvatar() {
        return avatar;
    }

    public String getChatId() {
        return chatId;
    }

    public String getDate() {
        return date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getText() {
        return text;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
