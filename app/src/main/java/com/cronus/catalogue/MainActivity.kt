package com.cronus.catalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.cronus.catalogue.home.ListRepo
import com.dropbox.android.external.store4.StoreBuilder
import com.dropbox.android.external.store4.StoreRequest
import com.dropbox.android.external.store4.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val listRepo = ListRepo()
    private val listStore = StoreBuilder.fromNonFlow<Unit, List<String>> { _ ->
        listRepo.getLists()
    }
        .disableCache()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            val data = listStore.get(Unit)
            list.adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, data)
        }
    }
}
