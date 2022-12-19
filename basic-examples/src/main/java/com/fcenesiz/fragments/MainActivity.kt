package com.fcenesiz.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fcenesiz.fragments.databinding.ActivityMainBinding
import com.fcenesiz.fragments.fragment.FragmentA
import com.fcenesiz.fragments.fragment.FragmentB

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //goneAllLayouts()
        binding.apply {
            buttonExample01.setOnClickListener {
                layoutExample01.root.visibility = View.VISIBLE
                layoutExample0203.root.visibility = View.GONE
                layoutExample04.root.visibility = View.GONE
                addNewFragment()
            }
            buttonExample0203.setOnClickListener {
                layoutExample01.root.visibility = View.GONE
                layoutExample0203.root.visibility = View.VISIBLE
                layoutExample04.root.visibility = View.GONE
            }
            buttonExample04.setOnClickListener {
                layoutExample01.root.visibility = View.GONE
                layoutExample0203.root.visibility = View.GONE
                layoutExample04.root.visibility = View.VISIBLE
            }

            layoutExample0203.buttonAddFragmentA.setOnClickListener { addFragmentA() }
            layoutExample0203.buttonRemoveFragmentA.setOnClickListener { removeFragmentA() }
            layoutExample0203.buttonAddFragmentB.setOnClickListener { addFragmentB() }
            layoutExample0203.buttonRemoveFragmentB.setOnClickListener { removeFragmentB() }
            layoutExample0203.buttonReplaceWithA.setOnClickListener { replaceWithA() }
            layoutExample0203.buttonReplaceWithB.setOnClickListener { replaceWithB() }

            layoutExample04.buttonAddFragmentA.setOnClickListener { addFragmentA04() }
            layoutExample04.buttonAttachFragmentA.setOnClickListener { attachFragmentA() }
            layoutExample04.buttonDetachFragmentA.setOnClickListener { detachFragmentA() }
            layoutExample04.buttonShowFragmentA.setOnClickListener { showFragmentA() }
            layoutExample04.buttonHideA.setOnClickListener { hideFragmentA() }
        }
    }

    // example01 ----------------------------------------------------------------------------------
    private fun addNewFragment() {
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.layoutExample01.frame.id, fragmentA, "FRAGMENT_1")
        transaction.commit()
    }

    // example01 ----------------------------------------------------------------------------------
    // example02 ----------------------------------------------------------------------------------
    private fun addFragmentA() {
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.layoutExample0203.frame2.id, fragmentA, "FRAGMENT_A")
        transaction.commit()
    }

    private fun removeFragmentA() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_A")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(it)
            transaction.commit()
        }
    }

    private fun addFragmentB() {
        val fragmentB = FragmentB()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.layoutExample0203.frame2.id, fragmentB, "FRAGMENT_B")
        transaction.commit()
    }

    private fun removeFragmentB() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_B")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.remove(it)
            transaction.commit()
        }
    }

    // example02 ----------------------------------------------------------------------------------
    // example03 ----------------------------------------------------------------------------------
    private fun replaceWithA() {
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.layoutExample0203.frame2.id, fragmentA, "FRAGMENT_A")
        transaction.commit()
    }

    private fun replaceWithB() {
        val fragmentB = FragmentB()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.layoutExample0203.frame2.id, fragmentB, "FRAGMENT_B")
        transaction.commit()
    }

    // example03 ----------------------------------------------------------------------------------
    // example04 ----------------------------------------------------------------------------------
    private fun addFragmentA04() {
        val fragmentA = FragmentA()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.layoutExample04.frame4.id, fragmentA, "FRAGMENT_A")
        transaction.commit()
    }

    private fun attachFragmentA() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_A")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.attach(it)
            transaction.commit()
        }
    }

    private fun detachFragmentA() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_A")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.detach(it)
            transaction.commit()
        }
    }

    private fun showFragmentA() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_A")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.show(it)
            transaction.commit()
        }
    }

    private fun hideFragmentA() {
        supportFragmentManager.findFragmentByTag("FRAGMENT_A")?.let {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.hide(it)
            transaction.commit()
        }
    }
    // example04 ----------------------------------------------------------------------------------

}