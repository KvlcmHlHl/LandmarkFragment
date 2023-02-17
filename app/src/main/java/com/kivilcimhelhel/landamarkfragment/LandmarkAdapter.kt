package com.kivilcimhelhel.landamarkfragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kivilcimhelhel.landamarkfragment.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {
    class LandmarkHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        holder.binding.recyclerRowTextView.text= landmarkList.get(position).name
        holder.itemView.setOnClickListener{
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(landmarkList.get(position))
            Navigation.findNavController(holder.binding.recyclerRowTextView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return landmarkList.size
    }
}
