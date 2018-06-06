package systems.texture.alize.net;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
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
import systems.texture.alize.model.paperspace.User;
import systems.texture.alize.util.SharedPrefUtil;

public final class API {
    public static final class PaperSpace {
        private static String API_BASE = "https://api.paperspace.io/";
        private static Retrofit retrofit;

        public static Retrofit getAuthClient(Context context) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(new PaperspaceAuthInterceptor(context, SharedPrefUtil.getPaperspaceAPIKey(context)));
            OkHttpClient client = builder.build();

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE)
                        .addConverterFactory(GsonConverterFactory.create(new Gson()))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build();
            }
            return retrofit;
        }

        public static Retrofit getCustomClient(Context context, @NonNull String apiKey) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(new PaperspaceAuthInterceptor(context, apiKey));
            OkHttpClient client = builder.build();

            return new Retrofit.Builder()
                .baseUrl(API_BASE)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        }

        public interface UserService {
            @FormUrlEncoded
            @POST("users/login")
            Observable<Login> loginUser(
                @Field("email") String email,
                @Field("password") String password,
                @Query("QRCodeMFALoginToken") String mfaToken);

            @GET("users/getUsers")
            Observable<List<User>> getUsers();
        }

        public interface MachineService {
            @GET("machines/getMachines")
            Observable<List<Machine>> getMachineList();
        }
    }

}
