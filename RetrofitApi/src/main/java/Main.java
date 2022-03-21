import org.json.JSONException;
import service.GitApiService;

import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        GitApiService controller = new GitApiService("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");
//        controller.gitPull();
        controller.gitMerge(23);

    }
}
