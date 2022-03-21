package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.GitMergeRequestBody;
import model.GitMergeResponseBody;
import model.GitPullRequestBody;
import model.GitPullResponse;
import org.json.JSONException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.GitApiInterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GitApiService {

    URL gitBaseURL;

    {
        try {
            gitBaseURL = new URL("https://api.github.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //Need to add logging
        }
    }

    String token ;

    public GitApiService(String token) {
        this.token = token;
    }

    public void gitPull()  {

        //Request Body Creation
        GitPullRequestBody body = new GitPullRequestBody("Amazing new feature","Please pull this in!",
                "gowthamkumar-crypto-patch-24","main");



        //Retrofit Object Creation
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(gitBaseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        GitApiInterface api = retrofit.create(GitApiInterface.class);

        //Interface Call
        Call<GitPullResponse> call = api.gitPostRequest(body,"Bearer " +token,"gowthamkumar-crypto","trail");


        //API Call
        call.enqueue(new Callback<GitPullResponse>() {
            @Override
            public void onResponse(Call<GitPullResponse> call, Response<GitPullResponse> response) {
                if(response.isSuccessful()) {
                    GitPullResponse gpr = response.body();
                    System.out.println(gpr.getPullNumber());



                } else {
                    System.out.println("error:");
                    System.out.println(response.errorBody());
                    System.out.println("response code:");
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<GitPullResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }

    public void gitMerge(int PullNumber)  {

        //Request Body Creation
        GitMergeRequestBody body = new GitMergeRequestBody("gowthamkumar-crypto","trail",PullNumber,"Testing Merge");

        //Retrofit Object Creation
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(gitBaseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Interface Call
        GitApiInterface api = retrofit.create(GitApiInterface.class);

        //API Call
        Call<GitMergeResponseBody> call = api.gitMergeRequest(body,"Bearer " +token,PullNumber);

        call.enqueue(new Callback<GitMergeResponseBody>() {
            @Override
            public void onResponse(Call<GitMergeResponseBody> call, Response<GitMergeResponseBody> response) {
                if(response.isSuccessful()) {
                    GitMergeResponseBody mrb = response.body();
                    System.out.println(mrb.getMerged());

                } else {
                    System.out.println("error:");
                    System.out.println(response.errorBody());
                    System.out.println("response code:");
                    System.out.println(response.code());
                }
            }

            @Override
            public void onFailure(Call<GitMergeResponseBody> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });


    }
}
