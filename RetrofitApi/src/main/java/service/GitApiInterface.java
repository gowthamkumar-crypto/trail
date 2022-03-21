package service;

import model.GitMergeRequestBody;
import model.GitMergeResponseBody;
import model.GitPullRequestBody;
import model.GitPullResponse;
import retrofit2.Call;
import retrofit2.http.*;



public interface GitApiInterface {

    /**
     *This is a Post api call to create a pull request for a specific branch mentioned in the request body
     * @param token : Bearer token [String Type & @Header]
     * @param body  : Request Body [GitPullRequestBody class type & @Body]
     * @param UserName : Username of the Git Account which will be passed as a path in URL [String Type & @Path]
     * @param repo   : Name of the repository you are working on
     * @return : It returns GitPullResponse class object
     */

    @POST("repos/{username}/{repo}/pulls")
    Call<GitPullResponse> gitPostRequest(@Body GitPullRequestBody body, @Header("Authorization") String token, @Path("username") String UserName, @Path("repo") String repo);

    /**
     *This is a Put api call to merge the pull request by use the- unique pull number
     * @param token : Bearer token [String Type & @Header]
     * @param body  : Request Body [GitMergeRequestBody class type & @Body]
     * @param pullNumber : This is generated during the git pull request which will be passed as a path in URL [String Type & @Path]
     * @return : It returns GitMergeResponseBody class object
     */

    @PUT("repos/gowthamkumar-crypto/trail/pulls/{pullNumber}/merge")
    Call<GitMergeResponseBody> gitMergeRequest(@Body GitMergeRequestBody body, @Header("Authorization") String token, @Path("pullNumber") int pullNumber);


}
