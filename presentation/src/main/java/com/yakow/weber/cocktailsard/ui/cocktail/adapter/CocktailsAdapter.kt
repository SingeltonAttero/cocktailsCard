package com.yakow.weber.cocktailsard.ui.cocktail.adapter

import android.view.View
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.extension.rxOnClickListener
import com.yakow.weber.cocktailsard.extension.visible
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseViewHolder
import com.yakow.weber.cocktailsard.utils.ImageLoader
import com.yakow.weber.domain.entity.Cocktail
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.include_item_status.view.*
import kotlinx.android.synthetic.main.item_cocktail_the_day.view.*
import kotlinx.android.synthetic.main.item_cocktails_adapter.view.*

/**
 * Created on 26.03.19
 * @author YWeber */

class CocktailsAdapter(
    override var dataSet: MutableList<Cocktail>,
    override var disposables: CompositeDisposable,
    private val itemClick: (item: Cocktail) -> Unit

) : BaseRecyclerAdapter<Cocktail, CocktailsAdapter.BaseCocktailsViewHolder>() {
    override fun createViewHolder(view: View, viewType: Int): BaseCocktailsViewHolder =
        when (viewType) {
            R.layout.item_cocktails_adapter -> CocktailsViewHolder(view)
            else -> CocktailsTheDayViewHolder(view)
        }

    override fun getLayoutIdForPosition(position: Int): Int = when {
        dataSet[position].dayCocktail -> R.layout.item_cocktail_the_day
        else -> R.layout.item_cocktails_adapter
    }

    abstract class BaseCocktailsViewHolder(itemView: View) : BaseViewHolder<Cocktail>(itemView)
    inner class CocktailsViewHolder(itemView: View) : BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            ImageLoader.loadImage(itemView, item.pictureCocktail, itemView.pictureCocktailView)
            itemView.nameCocktailView.text = item.nameCocktail
            itemView.descriptionConsistView.text = item.consist
            itemView.timePreparing.text = item.timePreparing
            itemView.favoriteView.visible = item.favorites
            itemView.drinkCocktailView.visible = item.tested
            itemView.cocktailCardContainer.rxOnClickListener { itemClick(item) }.bind()
        }
    }

    inner class CocktailsTheDayViewHolder(itemView: View) : BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            ImageLoader.loadImage(itemView, item.pictureCocktail, itemView.pictureDayCocktailView)
            itemView.nameDayCocktailView.text = item.nameCocktail
            itemView.descriptionDayConsistView.text = item.consist
            itemView.timeDayPreparing.text = item.timePreparing
            itemView.favoriteView.visible = item.favorites
            itemView.drinkCocktailView.visible = item.tested
            itemView.cocktailDayCardContainer.rxOnClickListener { itemClick(item) }.bind()
        }
    }
}