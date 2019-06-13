package com.yakow.weber.cocktailsard.ui.cocktail.adapter

import android.view.View
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.ReplayRelay
import com.yakow.weber.cocktailsard.R
import com.yakow.weber.cocktailsard.extension.visible
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.cocktailsard.ui.base.adapter.BaseViewHolder
import com.yakow.weber.cocktailsard.utils.ImageLoader
import com.yakow.weber.domain.entity.Cocktail
import io.reactivex.Observable
import kotlinx.android.synthetic.main.include_item_status.view.*
import kotlinx.android.synthetic.main.item_cocktail_the_day.view.*
import kotlinx.android.synthetic.main.item_cocktails_adapter.view.*

/**
 * Created on 26.03.19
 * @author YWeber */

class CocktailsAdapter(listCocktails: List<Cocktail>) :
    BaseRecyclerAdapter<Cocktail, CocktailsAdapter.BaseCocktailsViewHolder>() {
    private val clickAction = BehaviorRelay.create<Cocktail>()

    override fun ActionClicks(): Observable<Cocktail> = clickAction.hide()

    override val dataSet: MutableList<Cocktail> = listCocktails.toMutableList()

    override fun createViewHolder(view: View, viewType: Int): BaseCocktailsViewHolder =
        when (viewType) {
            R.layout.item_cocktails_adapter -> CocktailsViewHolder(view) { cocktail ->
                clickAction.accept(
                    cocktail
                )
            }
            else -> CocktailsTheDayViewHolder(view) { cocktail -> clickAction.accept(cocktail) }
        }

    override fun getLayoutIdForPosition(position: Int): Int = when {
        dataSet[position].dayCocktail -> R.layout.item_cocktail_the_day
        else -> R.layout.item_cocktails_adapter
    }

    abstract class BaseCocktailsViewHolder(itemView: View) : BaseViewHolder<Cocktail>(itemView) {
        abstract val clickItem: (Cocktail) -> Unit
    }

    class CocktailsViewHolder(itemView: View, override val clickItem: (Cocktail) -> Unit) :
        BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            ImageLoader.loadImage(itemView, item.pictureCocktail, itemView.pictureCocktailView)
            itemView.nameCocktailView.text = item.nameCocktail
            itemView.descriptionConsistView.text = item.consist
            itemView.timePreparing.text = item.timePreparing
            itemView.favoriteView.visible = item.favorites
            itemView.drinkCocktailView.visible = item.tested
            itemView.cocktailCardContainer.setOnClickListener { clickItem(item) }
        }
    }

    class CocktailsTheDayViewHolder(itemView: View, override val clickItem: (Cocktail) -> Unit) :
        BaseCocktailsViewHolder(itemView) {
        override fun bind(item: Cocktail) {
            ImageLoader.loadImage(itemView, item.pictureCocktail, itemView.pictureDayCocktailView)
            itemView.nameDayCocktailView.text = item.nameCocktail
            itemView.descriptionDayConsistView.text = item.consist
            itemView.timeDayPreparing.text = item.timePreparing
            itemView.favoriteView.visible = item.favorites
            itemView.drinkCocktailView.visible = item.tested
            itemView.cocktailDayCardContainer.setOnClickListener { clickItem(item) }
        }
    }
}