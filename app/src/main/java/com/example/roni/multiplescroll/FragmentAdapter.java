package com.example.roni.multiplescroll;

/**
 * Created by roni on 26/02/18.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

;
/**
 * Created by Roni on 29/08/17.
 */

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private static final int PRODUCT_TAB = 0;
    private static final int ABOUT_TAB = 1;

    public FragmentAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {
            case PRODUCT_TAB:
                return ProductFragment.newInstance();
            case ABOUT_TAB:
                return StoreNameFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 2 pages.
        return 2;
    }

    /**
     * Title shown on the tabs
     *
     * @param position tab index
     * @return the title of the tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case PRODUCT_TAB:
                return "Products";
            case ABOUT_TAB:
                return "Stores";
        }
        return null;
    }
}
