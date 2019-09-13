package com.example.submission2.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.submission2.Main.MainAdapter
import com.example.submission2.Main.MainPresenter
import com.example.submission2.Main.MainView
import com.example.submission2.R
import com.example.submission2.api.ApiRepository
import com.example.submission2.model.Match
import com.example.submission2.ui.NextMatchFragUI
import com.example.submission2.utils.invisible
import com.example.submission2.utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import java.lang.reflect.Array


class NextMatchFrag : Fragment(), MainView {

    private var matches : MutableList<Match> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var spinner: Spinner
    private lateinit var leagueName: String
    private lateinit var item : Match
    private lateinit var judul : ArrayList<Array>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return NextMatchFragUI().createView(AnkoContext.create(requireContext(),this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val league = resources.getStringArray(R.array.league)
        val idLeague = resources.getStringArray(R.array.league_id)

        val position = arrayOfNulls<String>( idLeague.size)
        val spinnerMap = SparseArray<String>()
        for (i in 0 until  idLeague.size){
            spinnerMap.put(i, idLeague[i].toString())
            position[i] = league[i]
        }

        val spinnerItems = idLeague
        val spinnerAdapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item, spinnerItems) as SpinnerAdapter
        spinner = find<Spinner>(R.id.spinner)
        spinner.adapter = spinnerAdapter

        progressBar = find(R.id.progressbar)
        swipeRefresh = find(R.id.swiperefresh)


        val rvMatch = find<RecyclerView>(R.id.rv_match_league)

        rvMatch.layoutManager = LinearLayoutManager(activity)
        adapter = MainAdapter(matches){
            val toast = Toast.makeText(activity,it.eventVS, Toast.LENGTH_SHORT)
            toast.show()
        }
        rvMatch.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request, gson)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                leagueName = spinner.selectedItem.toString()
                presenter.getNextMatch(leagueName)
                presenter.getDetailLeague(leagueName)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        swipeRefresh.onRefresh {
            presenter.getNextMatch(leagueName)
            presenter.getDetailLeague(leagueName)
        }
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showMatchList(data: List<Match>) {
        swipeRefresh.isRefreshing = false
        matches.clear()
        matches.addAll(data)
        adapter.notifyDataSetChanged()

        item = Match(
            data[0].nameLeague
        )

        val tvLeague = find<TextView>(R.id.tv_league_name)
        tvLeague.text = data[0].nameLeague


    }




}
