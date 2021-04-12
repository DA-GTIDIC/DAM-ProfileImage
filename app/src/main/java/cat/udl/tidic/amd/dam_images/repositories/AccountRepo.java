package cat.udl.tidic.amd.dam_images.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.io.File;

import cat.udl.tidic.amd.dam_images.services.AccountService;
import cat.udl.tidic.amd.dam_images.services.AccountServiceImpl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepo {

    private final String TAG = "AccountRepo";

    private final AccountService accountService;
    private final MutableLiveData<String> mResponse;

    public AccountRepo() {
        this.accountService = new AccountServiceImpl();
        this.mResponse = new MutableLiveData<>();
    }

    public void uploadPhoto(File imageFile){
        RequestBody reqBody = RequestBody.create(imageFile,MediaType.parse("image/*"));
        MultipartBody.Part image = MultipartBody.Part.createFormData("image_file", imageFile.getName(), reqBody);
        String token = "656e50e154865a5dc469b80437ed2f963b8f58c8857b66c9bf";
        accountService.uploadImage(image,token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                int return_code = response.code();  //200, 404, 401,...
                Log.d(TAG,"uploadPhoto() -> ha rebut el codi: " +  return_code);
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                String error_msg = "Error: " + t.getMessage();
                Log.d(TAG,"uploadPhoto() -> ERROR: " +  error_msg);
                mResponse.setValue(error_msg);
            }
        });
    }

}
