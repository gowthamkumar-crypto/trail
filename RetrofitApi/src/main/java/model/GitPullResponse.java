package model;

import com.google.gson.annotations.SerializedName;

public class GitPullResponse {

    @SerializedName("url")
    private String url;

    @SerializedName("number")
    private int pullNumber;

    public GitPullResponse(String url, int pullNumber) {
        this.url = url;
        this.pullNumber = pullNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPullNumber() {
        return pullNumber;
    }

    public void setPullNumber(int pullNumber) {
        this.pullNumber = pullNumber;
    }
}
