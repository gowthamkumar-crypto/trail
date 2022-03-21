package model;

import com.google.gson.annotations.SerializedName;

public class GitPullRequestBody {
/**
 * {
 *   "title": "Amazing new feature",
 *   "body": "Please pull this in!",
 *   "head": "gowthamkumar-crypto-patch-9",
 *   "base": "main"
 * }
 */

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("head")
    private String head;

    @SerializedName("base")
    private String base;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public GitPullRequestBody(String title, String body, String head, String base) {
        this.title = title;
        this.body = body;
        this.head = head;
        this.base = base;
    }
}
