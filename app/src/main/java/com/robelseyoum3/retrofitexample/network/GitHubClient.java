package com.robelseyoum3.retrofitexample.network;

import com.robelseyoum3.retrofitexample.model.GithubRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    //https://api.github.com/users/EMHankombo/repos

    @GET ("/users/{user}/repos") //{user} is a placeholder
    Call<List<GithubRepoModel>> getRepos(@Path("user") String user); //here used to dynamically assign the user name


    //@GET("/movie/top_rated/{api_key}")

}





