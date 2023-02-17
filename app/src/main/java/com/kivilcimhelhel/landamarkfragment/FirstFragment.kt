package com.kivilcimhelhel.landamarkfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kivilcimhelhel.landamarkfragment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var landmarkList : java.util.ArrayList<Landmark>
    private var adapter :LandmarkAdapter? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        landmarkList = ArrayList()
        //landmark name, country name, landmark image
        val ist = Landmark("İstanbul", "Turkiye", R.drawable.ist)
        val london = Landmark("London", "England", R.drawable.londra)
        val paris = Landmark("Paris", "France", R.drawable.paris)

        landmarkList.add(ist)
        landmarkList.add(london)
        landmarkList.add(paris)
        adapter = LandmarkAdapter(landmarkList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(RecyclerViewItemDecoration(requireContext(),R.drawable.divider))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}