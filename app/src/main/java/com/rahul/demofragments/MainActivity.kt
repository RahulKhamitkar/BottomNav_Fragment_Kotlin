package com.rahul.demofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rahul.demofragments.view.CreditFragment
import com.rahul.demofragments.view.HomeFragment
import com.rahul.demofragments.view.ListFragment
import com.rahul.demofragments.view.ShopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.home_frag -> {
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.shop_frag -> {
                replaceFragment(ShopFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.credit_frag -> {
                replaceFragment(CreditFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.list_frag -> {
                replaceFragment(ListFragment())
                return@OnNavigationItemSelectedListener true
            }




        }
        false
    }

    lateinit var controller: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        bottomTab.let { NavigationUI.setupWithNavController(bottomTab, controller.navController) }


        bottomTab.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())


    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTranscation = supportFragmentManager.beginTransaction()
        fragmentTranscation.replace(R.id.fragment,fragment)
        fragmentTranscation.commit()
    }


    override fun onSupportNavigateUp(): Boolean {
        return  findNavController(R.id.fragment).navigateUp()
    }


}
