package model;

import com.google.gson.annotations.SerializedName;

/**
 *  {
 * "owner":"gowthamkumar-crypto",
 *   "repo": "trail",
 *   "pull_number": 15,
 *   "commit_title": "commit_title"
 *   }
 */
public class GitMergeRequestBody {

    @SerializedName("owner")
    private String owner;

    @SerializedName("repo")
    private String repo;

    @SerializedName("pull_number")
    private int pullNumber;

    @SerializedName("commit_title")
    private String commitTitle;

    public GitMergeRequestBody(String owner, String repo, int pullNumber, String commitTitle) {
        this.owner = owner;
        this.repo = repo;
        this.pullNumber = pullNumber;
        this.commitTitle = commitTitle;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public int getPullNumber() {
        return pullNumber;
    }

    public void setPullNumber(int pullNumber) {
        this.pullNumber = pullNumber;
    }

    public String getCommitTitle() {
        return commitTitle;
    }

    public void setCommitTitle(String commitTitle) {
        this.commitTitle = commitTitle;
    }
}
