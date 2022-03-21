import service.GitApiService;



public class Main {

    public static void main(String[] args)  {
        GitApiService controller = new GitApiService();

        /**
         * Below are the parameters that needed to change while testing
         * @param headBranch :- The branch on which you have made changes
         * @param baseBranch :- The branch in which you want to merge your changes
         * @param token      :- Bearer token
         * @param baseUrl    :- Git Base URL(https://api.github.com/)
         */

        int pullNumber = controller.gitPull("gowthamkumar-crypto-patch-31","main","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","https://api.github.com/");


        /**
         *  Below are the parameters that needed to change while testing
         *      * @param pullNumber   :- The pull request number that was generated during pull request
         *      * @param gitUserName  :- Username of the Git Account
         *      * @param gitRepoName  :- Name of the repository we are working on
         *      * @param token        :- Bearer token
         *      * @param baseURL      :- Git Base URL(https://api.github.com/)
         */

        controller.gitMerge(pullNumber,"gowthamkumar-crypto","trail","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","https://api.github.com/");

    }
}
