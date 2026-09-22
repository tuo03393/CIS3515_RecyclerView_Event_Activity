package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TODO(Step 1: Implement click behavior)
// TODO (Step 1a: Accept lambda in constructor)
//Define an argument to accept a certain type. For a lambda, it will be the signature of the lambda. What does it take & what does it return.
//In this case, it is listed in step 1b.
//Added private val callback : (Int) -> Unit.
class NumberDisplayAdapter (private val numbers: Array<Int>, private val callback: (Int) -> Unit) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    // TODO (Step 1b: Invoke lambda via onClickListener)
    inner class NumberViewHolder (layout: View) : RecyclerView.ViewHolder (layout) {
        // enumerate views inside layout
        val textView = layout.findViewById<TextView>(R.id.textView).apply { //Added .apply & the setOnClickListener function.
            setOnClickListener{
                callback(numbers[bindingAdapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }
    //Inflate is the term for turning any resources into an object in memory.
    //Inflate wants three arguments: layout, root, and attach to root, which is usually false.

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }

}