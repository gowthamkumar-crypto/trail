package service;

import model.GitMergeRequestBody;
import model.GitMergeResponseBody;
import model.GitPullRequestBody;
import model.GitPullResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GitApiInterface {

    /**
     *
     * @param token
     * @return
     */

    @POST("repos/{username}/{repo}/pulls")
    Call<GitPullResponse> gitPostRequest(@Body GitPullRequestBody body, @Header("Authorization") String token, @Path("username") String UserName, @Path("repo") String Repo);

    @PUT("repos/gowthamkumar-crypto/trail/pulls/{pullNumber}/merge")
    Call<GitMergeResponseBody> gitMergeRequest(@Body GitMergeRequestBody body, @Header("Authorization") String token, @Path("pullNumber") int pullNumber);


}
