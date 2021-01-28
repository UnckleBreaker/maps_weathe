package com.example.maps_weather
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fManager: FragmentManager) : FragmentPagerAdapter(fManager) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0->return CurFragment()
            1->return History_fragment()
            else-> return  CurFragment()
        }
    }


    override fun getCount() =2
    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "Now"
            1->return "History"
            else-> return  null
        }
    }
}

