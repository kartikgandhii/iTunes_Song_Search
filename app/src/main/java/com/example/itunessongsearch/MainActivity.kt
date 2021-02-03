package com.example.itunessongsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itunessongsearch.model.DataModel
import com.example.itunessongsearch.service.RetrofitInterface
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.shape.ShapeAppearanceModel.builder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.stream.DoubleStream.builder
import java.util.stream.IntStream.builder
import java.util.stream.LongStream.builder
import java.util.stream.Stream.builder

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
    lateinit var rv: RecyclerView
    lateinit var sv: EditText
    lateinit var Sbtn: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        sv = findViewById(R.id.serachView)
        Sbtn = findViewById(R.id.searchBtn)

        Sbtn.setOnClickListener {
                var name = sv.text.toString()
                name = name.replace("\\s".toRegex(), "+").toLowerCase()
                var naam = name

                val retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service = retrofit.create(RetrofitInterface::class.java)
                val call = service.getSongs(naam)

                call.enqueue(object : Callback<ItunesResponse> {
                    override fun onResponse(
                        call: Call<ItunesResponse>,
                        response: Response<ItunesResponse>
                    ) {
                        Toast.makeText(this@MainActivity, response.code().toString(), Toast.LENGTH_LONG).show()
                        val itunes = response.body()

                        if (itunes != null) {

                            adapter = RecyclerViewAdapter(itunes.getResults())
                            rv.adapter = adapter
                            rv.layoutManager = GridLayoutManager(this@MainActivity, 2)
                        }
                    }

                    override fun onFailure(call: Call<ItunesResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()


                    }


                })

        }
    }




    companion object {
        private const val URL = "https://itunes.apple.com/"
    }
}

