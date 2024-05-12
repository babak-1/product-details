package com.babak.firstfigma

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.babak.firstfigma.databinding.CardItemBinding

class CardAdapter():
    RecyclerView.Adapter<CardAdapter.ProductViewHolder>() {
        val listCard = arrayListOf<Card>()
        lateinit var onclickNavigate: (item:Card)->Unit
        inner class ProductViewHolder(val cardItemBinding: CardItemBinding) :
            RecyclerView.ViewHolder(cardItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCard.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = listCard[position]
        val holderCard = holder.cardItemBinding
        holderCard.cardName.text=item.name
        holderCard.imageView.setImageResource(item.image)
        if(item.sale){
            holderCard.oldPrice.text="$${item.oldPrice}"
            holderCard.saleText.text="24% Off"
        }
        holderCard.newPriceText.text="$${item.newPrice}"

        when(item.rate){
            1->holderCard.cardStars.setImageResource(R.drawable.one_star)
            2->holderCard.cardStars.setImageResource(R.drawable.two_stars)
            3->holderCard.cardStars.setImageResource(R.drawable.three_stars)
            4->holderCard.cardStars.setImageResource(R.drawable.four_stars)
            5->holderCard.cardStars.setImageResource(R.drawable.five_stars)
        }
        holder.cardItemBinding.oneCard.setOnClickListener{
//            Navigation.findNavController(it)
//                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item))
            onclickNavigate(item)
        }

    }

    fun updateList(newList: List<Card>){
        listCard.clear()
        listCard.addAll(newList)
        notifyDataSetChanged()
    }

}
