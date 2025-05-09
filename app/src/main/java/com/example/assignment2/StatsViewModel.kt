package com.example.assignment2

import androidx.lifecycle.ViewModel

class StatsViewModel(var statsRepository: BookRepository): ViewModel(){

    fun obtainAvgPrice(): Double{
        return statsRepository.getAveragePrice()
    }

    fun obtainBioAvgPrice(): Double{
        return statsRepository.getGenreAveragePrice("Biography")
    }

    fun obtainSciFiAvgPrice(): Double{
        return statsRepository.getGenreAveragePrice("Science Fiction")
    }

    fun obtainHelpAvgPrice(): Double{
        return statsRepository.getGenreAveragePrice("Self-help")
    }
}