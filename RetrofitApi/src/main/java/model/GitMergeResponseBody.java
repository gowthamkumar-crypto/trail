package model;

import com.google.gson.annotations.SerializedName;

/**
 * "sha": "6dcb09b5b57875f334f61aebed695e2e4193db5e",
 *   "merged": true,
 *   "message": "Pull Request successfully merged"
 */
public class GitMergeResponseBody {


    @SerializedName("sha")
    private String sha;

    @SerializedName("merged")
    private Boolean merged;

    @SerializedName("message")
    private String message;

    public GitMergeResponseBody(String sha, Boolean merged, String message) {
        this.sha = sha;
        this.merged = merged;
        this.message = message;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Boolean getMerged() {
        return merged;
    }

    public void setMerged(Boolean merged) {
        this.merged = merged;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
