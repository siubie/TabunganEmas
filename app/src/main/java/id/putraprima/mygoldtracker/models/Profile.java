package id.putraprima.mygoldtracker.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {
    private String username;
    private String email;
    private String image;

    public Profile() {
    }

    public Profile(String username, String email, String image) {
        this.username = username;
        this.email = email;
        this.image = image;
    }

    protected Profile(Parcel in) {
        username = in.readString();
        email = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
