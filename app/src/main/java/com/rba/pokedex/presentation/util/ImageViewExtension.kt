package com.rba.pokedex.presentation.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.google.android.material.card.MaterialCardView

@BindingAdapter("paletteImage", "paletteCard")
fun AppCompatImageView.paletteCard(url: String, paletteCard: MaterialCardView) {
    Glide.with(context)
        .load(url)
        .listener(
            GlidePalette.with(url)
                .use(BitmapPalette.Profile.MUTED_LIGHT)
                .intoCallBack { palette ->
                    val rgb = palette?.dominantSwatch?.rgb
                    rgb?.let {
                        paletteCard.setCardBackgroundColor(it)
                    }
                }.crossfade(true)
        ).into(this)
}
