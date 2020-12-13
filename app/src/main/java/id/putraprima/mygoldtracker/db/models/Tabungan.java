package id.putraprima.mygoldtracker.db.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tabungan")
public class Tabungan implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tabunganId")
    private int id;

    private float berat;
    private float harga;
    private Date tanggalBeli;

    public Tabungan() {
    }

    public Tabungan(float berat, float harga, Date tanggalBeli) {
        this.berat = berat;
        this.harga = harga;
        this.tanggalBeli = tanggalBeli;
    }

    public Tabungan(int id, float berat, float harga, Date tanggalBeli) {
        this.id = id;
        this.berat = berat;
        this.harga = harga;
        this.tanggalBeli = tanggalBeli;
    }

    protected Tabungan(Parcel in) {
        id = in.readInt();
        berat = in.readFloat();
        harga = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeFloat(berat);
        dest.writeFloat(harga);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tabungan> CREATOR = new Creator<Tabungan>() {
        @Override
        public Tabungan createFromParcel(Parcel in) {
            return new Tabungan(in);
        }

        @Override
        public Tabungan[] newArray(int size) {
            return new Tabungan[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBerat() {
        return berat;
    }

    public void setBerat(float berat) {
        this.berat = berat;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public Date getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(Date tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }
}
