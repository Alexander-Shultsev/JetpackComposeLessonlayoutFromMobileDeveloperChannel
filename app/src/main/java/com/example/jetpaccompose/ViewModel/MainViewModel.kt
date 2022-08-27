package com.example.jetpaccompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CharacteristicsModel(
    val title: String,
    val value: String
)

class MainViewModel: ViewModel() {

    private val _article: MutableLiveData<String> = MutableLiveData("Артикул: 7598833")
    val article: LiveData<String> = _article

    private val _title: MutableLiveData<String> = MutableLiveData("Дрель аккумуляторная")
    val title: LiveData<String> = _title

    private val _countProductsInCard: MutableLiveData<Int> = MutableLiveData(0)
    val countProductsInCard: LiveData<Int> = _countProductsInCard

    fun addProductInCart() {
        _countProductsInCard.postValue(1)
    }

    private val _countProduct: MutableLiveData<Int> = MutableLiveData(0)
    val countProduct: LiveData<Int> = _countProduct

    fun setCountProduct(newCountProduct: Int) {
        _countProduct.postValue(newCountProduct)
    }

    private val _pickupStoresCount: MutableLiveData<Int> = MutableLiveData(1)
    val pickupStoresCount: LiveData<Int> = _pickupStoresCount

    private val _characterList: MutableLiveData<List<CharacteristicsModel>> = MutableLiveData(
        listOf(
            CharacteristicsModel("Толщина", "12,5"),
            CharacteristicsModel("Вес", "10"),
            CharacteristicsModel("Марка", "Sony")
        )
    )
    val characterList: LiveData<List<CharacteristicsModel>> = _characterList
}