package com.example.footapp.viewmodel

import com.example.footapp.models.Joueur
import com.example.footapp.models.ListJoueur
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footapp.data.JoueurEntity
import com.example.footapp.data.api.ApiService
import com.example.footapp.data.api.ServiceGenerator
import com.example.footapp.data.persistance.PlayerDatabase
import com.example.footapp.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoueurViewModel : ViewModel() {
    private val _joueurData = MutableLiveData<Joueur>()

    val serviceGenerator = ServiceGenerator.builsService(ApiService::class.java)
     val joueurData: MutableLiveData<Joueur>
        get() = _joueurData


    private val _joueursData = MutableLiveData<MutableList<Joueur>>()
    val joueursData: LiveData<MutableList<Joueur>>
        get() = _joueursData

    fun loadJoueurData(playerId: Long) {
        val call = serviceGenerator.getJoueurById(player_id = playerId)

        call.enqueue(object : Callback<MutableList<Joueur>> {
            override fun onResponse(
                call: Call<MutableList<Joueur>>,
                response: Response<MutableList<Joueur>>
            ) {
                if (response.isSuccessful) {
                    val joueur = response.body()?.last()

                    _joueurData.value = joueur!!


                }
            }

            override fun onFailure(call: Call<MutableList<Joueur>>, t: Throwable) {
                // Gérez les erreurs ici
            }
        })
    }


    fun loadAllJoueurs() {
        val call = serviceGenerator.getJoueurs()
        call.enqueue(object : Callback<MutableList<ListJoueur>> {
            override fun onResponse(
                call: Call<MutableList<ListJoueur>>,
                response: Response<MutableList<ListJoueur>>
            ) {
                if (response.isSuccessful) {
                    val joueurs = response.body()
                    _joueursData.value = joueurs!![0].players

                    //+Log.e("ghvfdv",response.body().toString())
                 }
            }

            override fun onFailure(call: Call<MutableList<ListJoueur>>, t: Throwable) {

               Log.e("ERREUR DE CONNECTION",t.stackTraceToString())
            }
        })
    }



    fun tryData(){
        viewModelScope.launch(Dispatchers.IO) {

            val database = PlayerDatabase.getInstance()
            val rep = PlayerRepository(database.joueurDao())
            val joueur1 = JoueurEntity(0, 814076188,"Navas")
            rep.insertUser(joueur1)
        }
    }

}
