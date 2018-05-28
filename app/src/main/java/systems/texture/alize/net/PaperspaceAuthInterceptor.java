package systems.texture.alize.net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import systems.texture.alize.util.SharedPrefUtil;

public class PaperspaceAuthInterceptor implements Interceptor {
    private Context context;

    public PaperspaceAuthInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String apiKey = SharedPrefUtil.getPaperspaceAPIKey(context);
        Request request = chain.request();

        Request.Builder builder = request.newBuilder()
                .header("x-api-key", apiKey);

        Request authenticatedRequest = builder.build();
        return chain.proceed(authenticatedRequest);
    }
}
