package com.example.videocamerasdisplayapp.ui.classes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.videocamerasdisplayapp.R
import com.example.videocamerasdisplayapp.ui.common.DTFormatter
import com.example.videocamerasdisplayapp.ui.classes.Color as MyColor

class ClassesAdapter(private val context: Context, private var classes: List<Class>) :
    RecyclerView.Adapter<ClassesAdapter.ViewHolder>() {

        private val TAG = "classes_adapter"

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorDisplay: LinearLayout = itemView.findViewById<LinearLayout>(R.id.color_display)
        val label: TextView = itemView.findViewById<TextView>(R.id.tv_label)
        val id: TextView = itemView.findViewById<TextView>(R.id.tv_id)
        val name: TextView = itemView.findViewById<TextView>(R.id.tv_name)
        val title: TextView = itemView.findViewById<TextView>(R.id.tv_title)
        val createdAt: TextView = itemView.findViewById<TextView>(R.id.tv_created_at)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_class, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = classes[position]

        holder.colorDisplay.background = getColorDisplayDrawable(itemData.color)
        holder.label.text = context.resources.getString(R.string.item_class_label_value)
            .format(itemData.label)
        holder.id.text = context.resources.getString(R.string.item_class_id_value)
            .format(itemData.id)
        holder.name.text = context.resources.getString(R.string.item_class_name_value)
            .format(itemData.name)
        holder.title.text = context.resources.getString(R.string.item_class_title_value)
            .format(itemData.title)
        holder.createdAt.text = context.resources.getString(R.string.item_class_created_at_value)
            .format(itemData.createdAt.format(DTFormatter.formatter))
    }

    override fun getItemCount(): Int {
        return classes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<Class>) {
        classes = newList
        notifyDataSetChanged()
    }

    fun getColorDisplayDrawable(color: MyColor): GradientDrawable {
        val clr = Color.rgb(color.r, color.g, color.b)
        val colors = intArrayOf(clr, clr)
        val drawable = GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, colors)
        drawable.cornerRadius = 10f

        val typedValue = TypedValue()
        val theme = context.theme

        theme.resolveAttribute(android.R.attr.colorAccent, typedValue, true)

        val color = when {
            typedValue.resourceId != 0 -> ContextCompat.getColor(context, typedValue.resourceId)
            else -> typedValue.data
        }
        drawable.setStroke(3, color)

        return drawable
    }
}