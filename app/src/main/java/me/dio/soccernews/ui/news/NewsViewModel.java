package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.data.remote.SoccerNewsApi;
import me.dio.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> News = new MutableLiveData<>();
    private final   SoccerNewsApi api;


    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://luiqueiroz.github.io/Soccer-news--api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         api = retrofit.create(SoccerNewsApi.class);
        this.findNews();

    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
           if (response.isSuccessful()) {
               News.setValue(response.body());
           } else {
               //TODO pensar numa estratégia de tratamento de erro.

                 }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO pensar numa estratégia de tratamento de erro.

            }
        });
    }

    public LiveData<List<News>> getNews() {
        return this.News;
    }
}