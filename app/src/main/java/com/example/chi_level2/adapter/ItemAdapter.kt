package com.example.chi_level2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.chi_level2.APP_PREFERENCES
import com.example.chi_level2.DetailsFragment
import com.example.chi_level2.R
import com.example.chi_level2.model.Students


class ItemAdapter(
    private val context: Context,
    private val dataset: List<Students>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.list_tv_name)
        val age: TextView = view.findViewById(R.id.list_tv_age)

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val bool: Switch = view.findViewById(R.id.list_switch_bool)

        val preferences: SharedPreferences =
            view.context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }


    @SuppressLint("ResourceType")
    override fun onBindViewHolder(
        holder: ItemViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val item = dataset[position]

        holder.itemView.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            val fragment = DetailsFragment()
            fragment.arguments = bundleOf("token" to position)
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, fragment).addToBackStack(null).commit()
        }

        holder.name.text = context.resources.getString(item.nameResourceId)
        holder.age.text = context.resources.getString(item.ageResourceId)
        holder.bool.isChecked = holder.preferences.getBoolean(position.toString(), false)

        holder.bool.setOnClickListener {
            val editor = holder.preferences.edit()
            editor.putBoolean(position.toString(), holder.bool.isChecked)
            editor.apply()
        }
    }


    override fun getItemCount() = dataset.size
}