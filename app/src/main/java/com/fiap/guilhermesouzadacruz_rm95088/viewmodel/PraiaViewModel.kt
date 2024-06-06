package com.fiap.guilhermesouzadacruz_rm95088.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.fiap.guilhermesouzadacruz_rm95088.model.Praia

class ItemsViewModel : ViewModel() {
    private val _items = mutableStateListOf<Praia>()
    val items: SnapshotStateList<Praia> = _items

    fun addItem(item: Praia) {
        _items.add(item)
    }
}