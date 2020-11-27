package com.example.androidbasicsapp2

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast

class DragDropActivity : AppCompatActivity() {
    lateinit var dRagDrop:View
    lateinit var mLayoutTop:LinearLayout
    lateinit var mLayoutButtom:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_drop)

        mLayoutTop=findViewById(R.id.tTop)
        mLayoutButtom=findViewById(R.id.tBottom)

        mLayoutTop.setOnDragListener(dragListener)
        mLayoutButtom.setOnDragListener(dragListener)

        dRagDrop=findViewById(R.id.drag_drop)

        dRagDrop.setOnClickListener {
            //atatch data to a drag

            val clipText="this is our clip item"
            val item=ClipData.Item(clipText)
            val mimeType= arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data=ClipData(clipText,mimeType,item)

            val dragShadowBuilder=View.DragShadowBuilder(it)
            it.startDragAndDrop(data,dragShadowBuilder,it,0)

            it.visibility=View.INVISIBLE
            true
        }
    }

    val dragListener=View.OnDragListener { view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED ->{
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION ->true
            DragEvent.ACTION_DRAG_EXITED ->{
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP ->{
                val item=event.clipData.getItemAt(0)
                val dragData=item.text
                Toast.makeText(this,"passed succesfuly",Toast.LENGTH_LONG).show()

                view.invalidate()

                val v=event.localState as View
                val owner =v.parent as ViewGroup
                owner.removeView(v)

                val destination=view as LinearLayout
                destination.addView(v)
                v.visibility=View.VISIBLE
                true

            }
            DragEvent.ACTION_DRAG_ENDED ->{
                view.invalidate()
                true
            } else->{

            return@OnDragListener false
            }
        }
    }
}