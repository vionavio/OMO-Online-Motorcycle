package com.viona.core.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.viona.core.R
import com.viona.core.extensions.findIdByLazy
import com.viona.core.view.component.TransportCardView

class ComponentPlaygroundActivity : AppCompatActivity() {

    companion object {
        fun launch(context: Context) {
            context.startActivity(
                Intent(context, ComponentPlaygroundActivity::class.java)
            )
        }
    }

    private val transportBike: TransportCardView by findIdByLazy(R.id.transport_bike)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_playground)

    }
}