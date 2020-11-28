package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView

var albumSongs = ArrayList<String>()
var albumURI = String


class albums : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        //Map the Grid View
        val GridView = findViewById<GridView>(R.id.albumView) as GridView
        //Attach the adapter to the Grid View
        GridView.adapter = albumAdapter(applicationContext)
        //Item click listener for the Grid View
        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, albumsDetail::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/album1"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Free))
            } else if (position == 1) {
                uri = "@drawable/album2"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Ready))
            } else {
                uri = "@drawable/album3"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Bright))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }



    }




}









