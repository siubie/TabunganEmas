package id.putraprima.mygoldtracker.bindingAdapter;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class BindingAdapter {
    @androidx.databinding.BindingAdapter("txtGram")
    public static void setTxtGram(TextView view,float gram){
        view.setText(String.valueOf(gram)+" gr");
    }

    @androidx.databinding.BindingAdapter("txtHarga")
    public static void setTxtHarga(TextView view, float harga){
        Locale myIndonesianLocale = new Locale("in", "ID");
        DecimalFormat format = (DecimalFormat) NumberFormat.getCurrencyInstance(myIndonesianLocale);
        format.setMaximumFractionDigits(0);
        format.setPositivePrefix("Rp. ");
        view.setText(format.format(harga));
    }
}
