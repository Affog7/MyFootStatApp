package com.example.footapp.viewmodel

import com.example.footapp.models.Joueur
import com.example.footapp.models.ListJoueur
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footapp.data.JoueurComments
import com.example.footapp.data.JoueurEntity
import com.example.footapp.data.api.ApiService
import com.example.footapp.data.api.ServiceGenerator
import com.example.footapp.data.persistance.JoueurDatabase
import com.example.footapp.repository.CommentsRepository
import com.example.footapp.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class JoueurViewModel : ViewModel() {
    private val _joueurData = MutableLiveData<Joueur>()
    private val _joueurComments = MutableLiveData<MutableList<JoueurComments>>()



    val commentsDao = JoueurDatabase.getInstance().commentsDAO()

    private val commentsRepository = CommentsRepository(commentsDao)
    val serviceGenerator = ServiceGenerator.builsService(ApiService::class.java)
     val joueurData: MutableLiveData<Joueur>
        get() = _joueurData

val  joueursComments : MutableLiveData<MutableList<JoueurComments>>
    get() = _joueurComments

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


    fun loadCommentsFromDBById(id: Long) : LiveData<MutableList<JoueurComments>>{

        _joueurComments.value = this.commentsRepository.getCommentById(id)
        return this._joueurComments
    }

    fun insertNewComment(id: Long, name:String){

        commentsRepository.insertComment(JoueurComments(0,id,"${name}", Calendar.getInstance().time.toString()))

    }


    fun deleteComment(id: Long){

        commentsRepository.deleteComment(id)

    }

    fun tryData(){
        viewModelScope.launch(Dispatchers.IO) {

            val database = JoueurDatabase.getInstance()
            val rep = PlayerRepository(database.joueurDAO())
            val joueur1 = JoueurEntity(0, 814076188,"Navas")
            rep.insertUser(joueur1)
        }
    }





}
