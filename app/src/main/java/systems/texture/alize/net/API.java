package systems.texture.alize.net;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import systems.texture.alize.model.paperspace.Login;
import systems.texture.alize.model.paperspace.Machine;

public final class API {
    public static final class PaperSpace {
        private static String API_BASE = "https://api.paperspace.io/";
        private static Retrofit retrofit;

        public static Retrofit getClient(Context context) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(new PaperspaceAuthInterceptor(context));
            OkHttpClient client = builder.build();

            if (retrofit == null) {
                Gson gsonConfig = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd")
                        .create();
                retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE)
                        .addConverterFactory(GsonConverterFactory.create(gsonConfig))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build();
            }
            return retrofit;
        }

        public interface LoginService {
            @FormUrlEncoded
            @POST("users/login")
            Observable<Login> loginUser(
                @Field("email") String email,
                @Field("password") String password,
                @Query("QRCodeMFALoginToken") String mfaToken);
        }

        public interface MachineService {
            @GET("machines/getMachines")
            Observable<List<Machine>> getMachineList();
        }
    }

}
