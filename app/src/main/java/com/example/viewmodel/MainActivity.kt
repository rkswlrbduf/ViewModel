package com.example.viewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var adapter: HeroesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = recyclerview
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        model.getHeroes().observe(this, object: Observer<ArrayList<Hero>> {
            override fun onChanged(t: ArrayList<Hero>?) {
                adapter = HeroesAdapter(this@MainActivity, t)
                recyclerView.adapter = adapter
            }
        })

    }
}
