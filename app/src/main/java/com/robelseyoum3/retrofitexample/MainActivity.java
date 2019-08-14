package com.robelseyoum3.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.robelseyoum3.retrofitexample.model.GithubRepoModel;
import com.robelseyoum3.retrofitexample.network.GitHubClient;
import com.robelseyoum3.retrofitexample.network.RetrofitInstances;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView mrecyclerView;
    private RepoAdapter repoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GitHubClient gitHubClient = RetrofitInstances.getRetrofitInstances().create(GitHubClient.class);

        Call<List<GithubRepoModel>> call = gitHubClient.getRepos("EMHankombo");



        call.enqueue(new Callback<List<GithubRepoModel>>() {
            @Override
            public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {

                List<GithubRepoModel> repos = response.body();
                Log.i("MainActivity", "onResponse: number of repositories :-  "+ repos.size());


                if(repos != null){

//                   for(int i=0; i<repos.size(); i++){
//                       Log.i("MainActivity", "onResponse:  "+ repos.get(i).getFullName());
//
//                   }
                    generateRepoList(repos);
               }
            }

            @Override
            public void onFailure(Call<List<GithubRepoModel>> call, Throwable t) {
                Log.i("MainActivity", "onResponse:  " + t.getMessage());

            }
        });

    }

    private void generateRepoList(List<GithubRepoModel> repoList) {

        mrecyclerView = findViewById(R.id.recyler_view_list);

        repoAdapter = new RepoAdapter(repoList);

        //here we create to design the values
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(layoutManager);

        //here we bind the activity_main recyclerView with the objects into personAdapter
        mrecyclerView.setAdapter(repoAdapter);

    }
}

