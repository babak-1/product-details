package com.babak.firstfigma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.babak.firstfigma.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get() =_binding!!

    val product1 =Card("Nike Air Max 270 React ENG",5,100.5,200.0,true,R.drawable.cros1)
    val product2 = Card("Nike Gamma Force",3,200.5,400.0,true,R.drawable.cros2)
    val product3 = Card("Nike Dunk Low",2,300.4,0.0,false,R.drawable.cros3)
    val product4 = Card("Adidas Gazelle Bold Shoes",5,120.0,0.0,false,R.drawable.cros4)
    val product5 = Card("Adidas SambaMN Shoes",2,100.0,200.0,true,R.drawable.cros1)
    val product6 = Card("Adidas Forum Low Shoes",4,180.0,200.0,true,R.drawable.cros3)


    var array= arrayListOf<Card>(product1,product5,product2,product4,product3,product6)
    val cardAdapter=CardAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardAdapter.onclickNavigate={
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it))
        }
        binding.allCard.adapter=cardAdapter
        cardAdapter.updateList(array)
        binding.countProduct.text="${array.size} Result"
        binding.searchBtn.setOnClickListener {
            var searchWord =  binding.searchInput.text.toString().trim()
            if(searchWord==""){
                cardAdapter.updateList(array)
                binding.countProduct.text="${array.size} Result"
            }else{
              var filteredArr =  array.filter { it.name.lowercase().contains(searchWord.lowercase()) }
                cardAdapter.updateList(filteredArr)
                binding.countProduct.text="${filteredArr.size} Result"

            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }



}