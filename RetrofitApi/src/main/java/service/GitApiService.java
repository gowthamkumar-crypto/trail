package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import model.GitMergeRequestBody;
import model.GitMergeResponseBody;
import model.GitPullRequestBody;
import model.GitPullResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class GitApiService {

    static int gitPullNumber;


    /**
     * This method uses Retrofit to call git api to create a pull request
     * @param headBranch :- The branch on which you have made changes
     * @param baseBranch :- The branch in which you want to merge your changes
     * @param token      :- Bearer token
     * @param baseUrl    :- Git Base URL(https://api.github.com/)
     * @return           :- Returns pull request number
     */

    public int gitPull(String headBranch, String baseBranch, String token, String baseUrl)  {

        URL gitBaseURL = null;

        {
            try {
                gitBaseURL = new URL(baseUrl);
            } catch (MalformedURLException e) {
                log.error("unable to parse Base URL");
            }
        }

        //Request Body Creation
        GitPullRequestBody body = new GitPullRequestBody("Amazing new feature","Please pull this in!",headBranch,baseBranch);

        //Retrofit Object Creation
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(gitBaseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        GitApiInterface api = retrofit.create(GitApiInterface.class);

        //Interface Call
        Call<GitPullResponse> call = api.gitPostRequest(body,"Bearer " +token,"gowthamkumar-crypto","trail");

        //API Call
        try {
            Response<GitPullResponse> response = call.execute();
            if(response.isSuccessful()) {
                GitPullResponse gpr = response.body();
                gitPullNumber = gpr.getPullNumber();
                log.info("Git Pull successful with pull number:"+Integer.toString(gpr.getPullNumber()));
                } else {
                    log.error("An error has been raised with response code" + Integer.toString(response.code()));
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gitPullNumber;
    }


    /**
     * This method uses Retrofit to create a merge request based in pull request number
     * @param pullNumber   :- The pull request number that was generated during pull request
     * @param gitUserName  :- Username of the Git Account
     * @param gitRepoName  :- Name of the repository we are working on
     * @param token        :- Bearer token
     * @param baseURL      :- Git Base URL(https://api.github.com/)
     */
    public void gitMerge(int pullNumber,String gitUserName, String gitRepoName, String token, String baseURL)  {

        URL gitBaseURL = null;

        {
            try {
                gitBaseURL = new URL(baseURL);
            } catch (MalformedURLException e) {
                log.error("unable to parse Base URL");
            }
        }

        //Request Body Creation
        GitMergeRequestBody body = new GitMergeRequestBody(gitUserName,gitRepoName,pullNumber,"Testing Merge");

        //Retrofit Object Creation
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(gitBaseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //Interface Call
        GitApiInterface api = retrofit.create(GitApiInterface.class);

        //API Call
        Call<GitMergeResponseBody> call = api.gitMergeRequest(body,"Bearer " +token,pullNumber);

        call.enqueue(new Callback<GitMergeResponseBody>() {
            @Override
            public void onResponse(Call<GitMergeResponseBody> call, Response<GitMergeResponseBody> response) {
                if(response.isSuccessful()) {
                    GitMergeResponseBody mrb = response.body();
                    log.info(mrb.getMessage());

                } else {
                    log.error("An error has been raised with response code" + Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(Call<GitMergeResponseBody> call, Throwable throwable) {
                log.error("Failed to initiate the Merge request");
            }
        });
    }

}
