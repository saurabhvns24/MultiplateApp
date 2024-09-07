package com.example.rajnigandhaapp.apputil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.MalformedJsonException;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.example.rajnigandhaapp.R;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/*
public abstract class NetworkAndCacheResource<Cache, ApiResponse> {
    private static final String TAG = NetworkAndCacheResource.class.getSimpleName();
    private static final String TAG1 = "NetworkAndCacheResource";
    private LiveData<Cache> cachedData;
    private final MediatorLiveData<Resource<Cache>> result = new MediatorLiveData<>();

    public NetworkAndCacheResource() {
        init();
    }

    public static String getErrorMessage(Context ctx, Throwable error) {
        if (error instanceof SocketTimeoutException) {
            return ctx.getString(R.string.requestTimeOutError);
        } else if (error instanceof MalformedJsonException) {
            return ctx.getString(R.string.responseMalformedJson);
        } else if (error instanceof IOException) {
            return ctx.getString(R.string.networkError);
        } else if (error instanceof HttpException) {
            return (Objects.requireNonNull(((HttpException) error).response()).message());
        } else {
            return ctx.getString(R.string.unknownError);
        }
    }

    public void init() {
        Log.d(TAG, "in init");
        */
/*
         * Posting empty loading state
         *//*

        result.setValue(new Resource<Cache>().loading());

        cachedData = loadFromDb();


        result.addSource(cachedData, dbData -> {
            result.removeSource(cachedData);
            if (dbData == null) {
                Log.d(TAG, "onChanged: null found");
            } else {
                Log.d(TAG, "onChanged: " + dbData);
            }

            if (shouldFetchFromServer(dbData)) {

                */
/*
                 * Need to fetch new data from server, so posting whatever we have in cache with
                 * loading state.
                 *//*



                result.setValue(new Resource<Cache>().loading(dbData));

                */
/*
                 * Initiate process for fetching data from server.
                 *//*


                fetchFromServer(cachedData);
            } else {

                */
/*
                 * No need to fetch data from server, so posting whatever we have in cache with
                 * success state.
                 *//*

                result.setValue(new Resource<Cache>().success(dbData));
            }
        });

        //fetchFromServer(cachedData);
    }

    private void fetchFromServer(final LiveData<Cache> cachedData) {
        createApiCall().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG1, "response successfull: ");
                        result.removeSource(cachedData);
                        saveAndPostData(response.body());
                    } else {
                        Log.d(TAG1, "response not successfull: ");
                        result.removeSource(cachedData);
                        assert response.errorBody() != null;
                        final String errormsg = response.errorBody().string();

                        result.addSource(cachedData, cache -> result.setValue(new Resource<Cache>().error(errormsg, cache)));
                    }
                } catch (Exception e) {
                    Log.d(TAG1, "Exception" + e.getMessage());
                    result.removeSource(cachedData);
                    result.addSource(cachedData, cache -> result.setValue(new Resource<Cache>().error("Unexpected error occured", cache)));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, final Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                result.removeSource(cachedData);

                result.addSource(cachedData, new Observer<Cache>() {
                    @Override
                    public void onChanged(Cache cache) {
                        result.setValue(new Resource<Cache>().error(Objects.requireNonNull(t.getMessage()), cache));
                    }
                });
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    private void saveAndPostData(final ApiResponse apiResponse) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                saveInDb(apiResponse);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                result.addSource(loadFromDb(), cache -> result.setValue(new Resource<Cache>().success(cache)));
            }
        }.execute();
    }

    public abstract boolean shouldFetchFromServer(Cache dbData);

    public abstract void saveInDb(ApiResponse response);

    public abstract LiveData<Cache> loadFromDb();

    public abstract Call<ApiResponse> createApiCall();


    public LiveData<Resource<Cache>> getAsLiveData() {
        return result;
    }
}
*/
