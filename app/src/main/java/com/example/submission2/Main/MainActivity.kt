package com.example.submission2.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.Menu
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import com.example.submission2.PagerAdapter
import com.example.submission2.R
import com.example.submission2.activity.SearchActivity
import com.example.submission2.api.ApiRepository
import com.example.submission2.model.Match
import com.example.submission2.ui.MainActUI
import com.google.gson.Gson
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), MainView {

    lateinit var keyword: String
    private lateinit var presenter: MainPresenter
    private lateinit var progressBar:ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActUI().setContentView(this)


        val viewpager = findViewById<ViewPager>(R.id.viewpager_main)
        val tabsmain = findViewById<TabLayout>(R.id.tabs_main)

        viewpager.adapter = PagerAdapter(supportFragmentManager)
        tabsmain.setupWithViewPager(viewpager)

        var request = ApiRepository()
        val gson = Gson()
        presenter =MainPresenter(this, request, gson)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setQueryHint("Search by Club Name")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                keyword = query.toString()
                presenter.getSearchTeam(keyword)
                startActivity<SearchActivity>("keyword" to keyword)
                Toast.makeText(applicationContext,keyword,Toast.LENGTH_SHORT).show()
                return false
            }

        })

        return true
    }

    override fun showLoading() {
      //  progressBar.visible()
    }

    override fun hideLoading() {
       // progressBar.invisible()
    }

    override fun showMatchList(matches: List<Match>) {

    }
}
