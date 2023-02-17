package com.kivilcimhelhel.landamarkfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.kivilcimhelhel.landamarkfragment.databinding.FragmentFirstBinding
import com.kivilcimhelhel.landamarkfragment.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var landMark:Landmark? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var bund = SecondFragmentArgs.fromBundle(it)
            landMark = bund.landmark
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameText.text = landMark?.name.toString()
        binding.countryText.text = landMark?.country.toString()
        landMark?.let { binding.imageView.setImageResource(it.image) }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}