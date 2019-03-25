package com.yakow.weber.cocktailsard.ui.cocktail.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseViewHolder
import com.yakow.weber.domain.entity.Cocktail
import kotlinx.android.synthetic.main.item_cocktails_adapter.view.*

/**
 * Created on 26.03.19
 * @author YWeber */

class CocktailsAdapter(override var dataSet: MutableList<Cocktail>) : BaseRecyclerAdapter<Cocktail, CocktailsAdapter.BaseCocktailsViewHolder>() {
    override fun createViewHolder(view: View, viewType: Int): BaseCocktailsViewHolder = CocktailsViewHolder(view)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_cocktails_adapter



    abstract class BaseCocktailsViewHolder(itemView: View) : BaseViewHolder<Cocktail>(itemView)

    inner class CocktailsViewHolder(itemView: View) : BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            Glide.with(itemView)
                    .load("https://cdn.liquor.com/wp-content/uploads/2017/11/14145228/bacardi-cocktail-720x720-recipe.jpg")
                    .into(itemView.pictureCocktailView)
            itemView.pictureCocktailView // TODO Image url
            itemView.nameCocktailView.text = item.nameCocktail
            itemView.descriptionConsistView.text = item.consist
            itemView.timePreparing.text = item.timePreparing
        }
    }
    inner class FirsCocktailsViewHolder(itemView: View) : BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}