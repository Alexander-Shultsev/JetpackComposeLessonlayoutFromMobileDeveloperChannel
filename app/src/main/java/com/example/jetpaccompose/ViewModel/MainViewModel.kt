package com.example.jetpaccompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpaccompose.view.components.CharacteristicsModel

class MainViewModel: ViewModel() {

    private val _pictureLink: MutableLiveData<String> = MutableLiveData(
        "https://avatars.mds.yandex.net/get-mpic/5209485/img_id5426762543151137084.jpeg/9hq"
    )
    val pictureLink: LiveData<String> = _pictureLink

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

    private val _inWishList: MutableLiveData<Boolean> = MutableLiveData(false)
    val inWishList: LiveData<Boolean> = _inWishList

    fun inWishListChange() {
        _inWishList.value?.let {
            _inWishList.postValue(!it)
        }
    }

    private val _inCompareList: MutableLiveData<Boolean> = MutableLiveData(false)
    val inCompareList: LiveData<Boolean> = _inCompareList

    fun inCompareListChange() {
        _inCompareList.value?.let {
            _inCompareList.postValue(!it)
        }
    }
}