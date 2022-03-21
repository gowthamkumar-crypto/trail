import org.junit.jupiter.api.Test;
import service.GitApiService;


class ApiTest {
    GitApiService controller = new GitApiService();
    int pullNumber;
    @Test
    public void gitPullTest(){
        pullNumber = controller.gitPull("gowthamkumar-crypto-patch-32","main","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","https://api.github.com/");
    }

    @Test
    public void gitMergeTest(){
        controller.gitMerge(pullNumber,"gowthamkumar-crypto","trail","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","https://api.github.com/");
    }

}