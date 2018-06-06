package systems.texture.alize.net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import systems.texture.alize.util.SharedPrefUtil;

public class PaperspaceAuthInterceptor implements Interceptor {
    private Context context;
    private String apiKey;

    public PaperspaceAuthInterceptor(Context context, String apiKey) {
        this.context = context;
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder builder = request.newBuilder()
                .header("x-api-key", apiKey);

        Request authenticatedRequest = builder.build();
        return chain.proceed(authenticatedRequest);
    }
}
