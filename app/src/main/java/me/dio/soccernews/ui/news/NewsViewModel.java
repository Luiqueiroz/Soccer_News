package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> News;

    public NewsViewModel() {
        this.News = new MutableLiveData<>();


        // TODO REMOVER MOCK DE NOTÍCIAS
        List<News> News = new ArrayList<>();
        News.add(new News("Ferroviário tem desfalque importante", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters"));
        News.add(new News("Ferrinha joga no sábado", "\"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\""));
        News.add(new News("Copa do mundo feminina está terminando", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"));

        this.News.setValue(News);

    }

    public LiveData<List<News>> getNews() {
        return this.News;
    }
}