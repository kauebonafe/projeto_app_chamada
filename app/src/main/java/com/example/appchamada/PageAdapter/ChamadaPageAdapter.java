package com.example.appchamada.PageAdapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appchamada.chamada.FragmentChamadaCode;

public class ChamadaPageAdapter extends FragmentPagerAdapter {


    int mNumOfTabs;


    public ChamadaPageAdapter(FragmentManager fm, int NumOfTabs) {

        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
               FragmentChamadaCode tab1 = new FragmentChamadaCode();
                return tab1;
            case 1:


                FragmentChamadaCode tab2 = new FragmentChamadaCode();

                return tab2;

            case 2:


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;

    }


}
