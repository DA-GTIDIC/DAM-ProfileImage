package cat.udl.tidic.amd.dam_images.services;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AccountService {


    @Multipart
    @POST("/account/profile/update_profile_image")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part image, @Header("Authorization") String token);

}
