package com.example.maps_weather.ui

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.maps_weather.R
import com.example.maps_weather.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val PERMISSION_REQUEST= 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            if(check(permissions)){
                enableView()
            }
            else{
                requestPermissions(permissions,PERMISSION_REQUEST)
            }
        }
        else
            enableView()
        view_pager.adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        tab_layout.setupWithViewPager(view_pager)
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.position?.let { view_pager.currentItem = it }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
        })
    }


    fun enableView()= Toast.makeText(this,"Permisson is done",Toast.LENGTH_SHORT).show()

    fun check(permissionArray:Array<String>) : Boolean{
        var success = true
        for (i in permissionArray.indices){
            if(checkCallingOrSelfPermission(permissionArray[i]) == PackageManager.PERMISSION_DENIED)
                success = false
        }
        return success
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST) {
            var allSuccess = true
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    allSuccess = false
                    val requestAgain =
                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(
                            permissions[i]
                        )
                    if (requestAgain) {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            this,
                            "Go to settings and enable the permission",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}