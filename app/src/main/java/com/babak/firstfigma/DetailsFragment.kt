package com.babak.firstfigma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.babak.firstfigma.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding?=null
    private val binding get() =_binding!!
    private val args:DetailsFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item=args.card
        binding.detailsImage.setImageResource(item.image)
        binding.priceDetails.text=item.newPrice.toString()
        binding.nameDetails.text=item.name
        when(item.rate){
            1->binding.starDetails.setImageResource(R.drawable.one_star)
            2->binding.starDetails.setImageResource(R.drawable.two_stars)
            3->binding.starDetails.setImageResource(R.drawable.three_stars)
            4->binding.starDetails.setImageResource(R.drawable.four_stars)
            5->binding.starDetails.setImageResource(R.drawable.five_stars)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}