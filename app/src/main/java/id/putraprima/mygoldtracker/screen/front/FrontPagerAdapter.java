package id.putraprima.mygoldtracker.screen.front;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import id.putraprima.mygoldtracker.screen.harga.HargaFragment;
import id.putraprima.mygoldtracker.screen.portfolio.PortfolioFragment;
import id.putraprima.mygoldtracker.screen.tabungan.TabunganFragment;

public class FrontPagerAdapter extends FragmentStateAdapter {

    public FrontPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new PortfolioFragment();
            case 1:
                return new HargaFragment();
            case 2:
                return new TabunganFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
