package com.example.mybaseapp.data;

public class GetImageEntity {
    String user_id;
    String offset;
    String type;

    public GetImageEntity(String user_id, String offset, String type) {
        this.user_id = user_id;
        this.offset = offset;
        this.type = type;
    }
}
