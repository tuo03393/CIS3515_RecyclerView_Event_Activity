package edu.temple.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView display responsibility
        val numbers = Array(100) {it + 1}
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        recyclerView.layoutManager = GridLayoutManager(this, 4)
/*
        // TODO (Step 2: Define lambda to modify displayTextView size)
        val callback = {
            //Generic lambdas use "it".
            textSizeR : Int ->
            displayTextView.textSize = textSizeR.toFloat()
        }


        // Todo (Step 3: Pass lambda to adapter)
        recyclerView.adapter = NumberDisplayAdapter(numbers, callback)
*/
       // /* You can also do, instead of step 2 & 3, do:
        recyclerView.adapter = NumberDisplayAdapter(numbers) {
        displayTextView.textSize = it.toFloat()
        }
       //  */

    }

}