package ru.hh.demo_app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.hh.blank.presentation.BlankFragment
import ru.hh.demo_app.R
import ru.hh.gallery.presentation.GalleryFragment
import toothpick.ktp.KTP

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            KTP.openRootScope().inject(this)

            supportFragmentManager.beginTransaction()
                .add(R.id.container, GalleryFragment())
                .commit()
        }
    }
}
