package cat.udl.tidic.amd.dam_images.services;

import cat.udl.tidic.amd.dam_images.network.RetrofitClientInstance;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Header;

public class AccountServiceImpl implements AccountService{

    private final Retrofit refrotit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<ResponseBody> uploadImage(MultipartBody.Part image,
                                          @Header("Authorization") String token) {
        return refrotit.create(AccountService.class).uploadImage(image, token);
    }
}
