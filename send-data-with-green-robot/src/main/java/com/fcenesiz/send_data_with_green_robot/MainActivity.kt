package com.fcenesiz.send_data_with_green_robot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fcenesiz.send_data_with_green_robot.databinding.ActivityMainBinding
import com.fcenesiz.send_data_with_green_robot.event.DataEvent
import com.fcenesiz.send_data_with_green_robot.event.ResultEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragments()
    }

    private fun addFragments(){
        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.frame1.id, fragmentA, "FRAGMENT_A")
        transaction.add(binding.frame2.id, fragmentB, "FRAGMENT_B")
        transaction.commit()

    }

    // we need to use this to get data from fragment
    @Subscribe
    fun triggerOnDataEvent(dataEvent: DataEvent){
        val n1 = dataEvent.n1
        val n2 = dataEvent.n2
        val result = n1 + n2
        EventBus.getDefault().post(ResultEvent(result))
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

}