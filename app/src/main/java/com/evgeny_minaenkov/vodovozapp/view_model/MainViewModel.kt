package com.evgeny_minaenkov.vodovozapp.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evgeny_minaenkov.vodovozapp.data.Repository
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = Repository()

    private val _tovary = MutableLiveData<Map<String , List<Data>>>()
    val tovary : LiveData<Map<String , List<Data>>> = _tovary

    private val _favorites = MutableLiveData<List<Data>>()
    val favorites: LiveData<List<Data>> = _favorites

    private val _cart = MutableLiveData<List<Data>>()
    val cart: LiveData<List<Data>> = _cart

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch(Dispatchers.IO) {
            _tovary.postValue(repository.getData())
        }
    }

    fun addToFavorites(product: Data){
        val list = mutableListOf<Data>()
        if (_favorites.value?.contains(product) == true){
            _favorites.value?.let {
                list.addAll(it)
            }
            list.removeAll(listOf(product))
            _favorites.postValue(list)

        } else {
            _favorites.value?.let {
                list.addAll(it)
            }
            list.add(product)
            _favorites.postValue(list)
        }
    }

    fun addToCart(product: Data){
        val list = mutableListOf<Data>()
        _cart.value?.let {
            list.addAll(it)
        }
        list.add(product)
        _cart.postValue(list)
    }
}