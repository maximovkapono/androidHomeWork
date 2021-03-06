package com.example.anmaksimov.homework

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    private val mCallbacks = MyActivityLifecycleCallbacks()

    override fun onCreate(savedInstanceState: Bundle?) {
        application.registerActivityLifecycleCallbacks(mCallbacks)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
        application.unregisterActivityLifecycleCallbacks(mCallbacks)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        val orientation = newConfig?.orientation
        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                setContentView(R.layout.activity_main)
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                setContentView(R.layout.activity_main)
            }
        }
    }

    fun handleClick(arg0: View) {
        val intent = Intent(baseContext, SecondActivity::class.java)
        startActivity(intent)
    }

    class MyActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {
            Log.i(activity?.javaClass?.simpleName, "onCreate")
        }

        override fun onActivityResumed(activity: Activity?) {
            Log.i(activity?.javaClass?.simpleName, "onActivityResumed")
        }

        override fun onActivityStarted(activity: Activity?) {
            Log.i(activity?.javaClass?.simpleName, "onActivityStarted")
        }

        override fun onActivityDestroyed(activity: Activity?) {
            Log.i(activity?.javaClass?.simpleName, "onActivityDestroyed")
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            Log.i(activity?.javaClass?.simpleName, "onActivitySaveInstanceState Bundle")
        }

        override fun onActivityStopped(activity: Activity?) {
            Log.i(activity?.javaClass?.simpleName, "onActivityStopped")
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            Log.i(activity?.javaClass?.simpleName, "onActivityCreated Bundle")
        }
    }
}
