package id.putraprima.mygoldtracker.bindingAdapter;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
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

    @androidx.databinding.BindingAdapter("txtDate")
    public static void setTxtDate(TextView view, Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String strDate= formatter.format(date);
        view.setText(strDate);
    }
}
