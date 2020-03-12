package com.mrmaximka.mersedestest.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mrmaximka.mersedestest.model.CryptoAnalyserRestModel;
import com.mrmaximka.mersedestest.rest.CryptoAnalyserRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    MutableLiveData<Boolean> isLoad;
    private List<CryptoAnalyserRestModel> model = new ArrayList<>();

    public HomeViewModel() {
        isLoad = new MutableLiveData<>();
        isLoad.setValue(false);
    }

    public LiveData<Boolean> getText() {
        return isLoad;
    }

    public List<CryptoAnalyserRestModel> getModel() {
        return model;
    }

    void getData(){

        Runnable loadData = this::requestRetrofit;

        Completable.fromRunnable(loadData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> isLoad.setValue(true))
                .doOnError(Throwable::getMessage)
                .subscribe();

    }

    private void requestRetrofit(){
        Call<List<CryptoAnalyserRestModel>> weatherRepo;
        weatherRepo = CryptoAnalyserRepo.getSingleton().getAPI().loadData();

        weatherRepo.enqueue(new Callback<List<CryptoAnalyserRestModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CryptoAnalyserRestModel>> call, @NonNull Response<List<CryptoAnalyserRestModel>> response) {
                if (response.body() != null && response.isSuccessful()){    // Если выполнен и не пууст
                    model = response.body(); // Получение модели данных
                    isLoad.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<List<CryptoAnalyserRestModel>> call, Throwable t) {
                Log.d("MMV", Objects.requireNonNull(t.getLocalizedMessage()));
            }
        });
    }

    public void clearFlag() {
        isLoad.setValue(false);
    }
}