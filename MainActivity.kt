package com.yourname.vfitjourney


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)


val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
bottomNav.setOnItemSelectedListener { item ->
val fragment: Fragment = when (item.itemId) {
R.id.nav_home -> HomeFragment()
R.id.nav_log -> LogFragment()
R.id.nav_progress -> ProgressFragment()
R.id.nav_profile -> ProfileFragment()
else -> HomeFragment()
}
supportFragmentManager.beginTransaction()
.replace(R.id.container, fragment)
.commit()
true
}


// default
if (savedInstanceState == null) {
supportFragmentManager.beginTransaction()
.replace(R.id.container, HomeFragment())
.commit()
}


findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab_log)
.setOnClickListener {
// open quick log dialog or LogFragment
supportFragmentManager.beginTransaction()
.replace(R.id.container, LogFragment())
.addToBackStack(null)
.commit()
}
}
}
