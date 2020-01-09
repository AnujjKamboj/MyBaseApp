package com.example.mybaseapp.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable
{

@SerializedName("xt_image")
@Expose
public String xtImage;
@SerializedName("id")
@Expose
public String id;
public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


@SuppressWarnings({
"unchecked"
})
public Image createFromParcel(Parcel in) {
return new Image(in);
}

public Image[] newArray(int size) {
return (new Image[size]);
}

}
;

protected Image(Parcel in) {
this.xtImage = ((String) in.readValue((String.class.getClassLoader())));
this.id = ((String) in.readValue((String.class.getClassLoader())));
}

public Image() {
}

public void writeToParcel(Parcel dest, int flags) {
dest.writeValue(xtImage);
dest.writeValue(id);
}

public int describeContents() {
return 0;
}

}