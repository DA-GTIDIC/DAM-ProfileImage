package cat.udl.tidic.amd.dam_images;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.io.File;

import cat.udl.tidic.amd.dam_images.repositories.AccountRepo;

public class MainActivityViewModel extends ViewModel {

    AccountRepo accountRepo;

    public MainActivityViewModel() {
        this.accountRepo = new AccountRepo();
    }

    public void uploadAccountImage(File imageFile){
        Log.d("VM", "uploading image... using repo");
        this.accountRepo.uploadPhoto(imageFile);
    }
}
