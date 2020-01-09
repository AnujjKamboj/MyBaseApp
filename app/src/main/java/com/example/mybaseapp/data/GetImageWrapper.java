package com.example.mybaseapp.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetImageWrapper implements Parcelable {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("images")
    @Expose
    public ArrayList<Image> images = new ArrayList<>();
    public final static Parcelable.Creator<GetImageWrapper> CREATOR = new Creator<GetImageWrapper>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetImageWrapper createFromParcel(Parcel in) {
            return new GetImageWrapper(in);
        }

        public GetImageWrapper[] newArray(int size) {
            return (new GetImageWrapper[size]);
        }

    };

    protected GetImageWrapper(Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.images, (com.example.mybaseapp.data.Image.class.getClassLoader()));
    }

    public GetImageWrapper() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(images);
    }

    public int describeContents() {
        return 0;
    }

}
