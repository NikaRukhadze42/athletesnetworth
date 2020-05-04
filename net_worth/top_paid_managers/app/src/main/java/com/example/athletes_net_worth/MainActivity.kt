package com.example.athletes_net_worth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.high_recyclerview_layout.*

class MainActivity : AppCompatActivity() {

    private val items = ArrayList<ItemModel>()
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Init()
    }
    //მაქვს მასივი რომელსაც ვავსებ ფუნქციით
    //მასივის ყველა ელემენტს აქვს საბოლოო ელემენტად "Type" რომელიც არის ინტეჯერი და ვიყენებ იმისათვის რომ გავსფლითო ელემენტები
    //რომლებსაც აქვს 500 მილიონ დოლარზე ნაკლები ისინი ჩხნდებიან სქრინზე ვერცხლისფერ ჩარჩოში ხოლო ვისაც 500-ზე მეტი აქვს ისინი
    //ოქროსფერ ჩარჩოში
    private fun Init() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = RecyclerViewAdapter(items)
        recyclerView.adapter = adapter
        fillArray()

        swipeRefreshLayout.setOnRefreshListener({
            swipeRefreshLayout.isRefreshing = true
            refresh()

            Handler().postDelayed({
                swipeRefreshLayout.isRefreshing = false
                fillArray()
                adapter.notifyDataSetChanged()
            }, 500)
        })
    }

    private fun refresh() {
        items.clear()
        adapter.notifyDataSetChanged()
    }


    private fun fillArray() {
        items.add(ItemModel(R.mipmap.ic_kobe, "Kobe Bryant","$600 Million", 1))
        items.add(ItemModel(R.mipmap.ic_marquez,"Marc Marquez" ,"$35 Million",0))
        items.add(ItemModel(R.mipmap.ic_lewis,"Lewis Hamilton" ,"$500 Million",1 ))
        items.add(ItemModel(R.mipmap.ic_usain,"Usain Bolt", "$90 million",0))
        items.add(ItemModel(R.mipmap.ic_ronaldo,"Cristiano Ronaldo" ,"$460 million",0))
        items.add(ItemModel(R.mipmap.ic_brady, "Tom Brady","$180 million" , 0))
        items.add(ItemModel(R.mipmap.ic_lebron, "LeBron James","$480 Million",0))
        items.add(ItemModel(R.mipmap.ic_messi, "Lionel Messi","$400 million",0))
        items.add(ItemModel(R.mipmap.ic_rossi, "Valentino Rossi","$140 million",0))
        items.add(ItemModel(R.mipmap.ic_tiger,"Tiger Woods","$800 million",1))
        adapter.notifyDataSetChanged()
    }
}
