package com.example.mybaseapp.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.example.mybaseapp.BuildConfig;
import com.example.mybaseapp.R;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by anuj.kamboj on 04-04-2019.
 */

public class BaseActivity extends AppCompatActivity {

    private boolean exit;
//    public PrefStore store;
    private File file;
    private Uri outputfileUri;
    private Dialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        store = new PrefStore(this);
//        Fresco.initialize(getApplicationContext());

        getKeyHash();
//        Mint.initAndStartSession(this.getApplication(), "422b6b0e");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (SharedPrefsHelper.getInstance().hasQbUser() && !QBChatService.getInstance().isLoggedIn()) {
//            ChatHelper.getInstance().loginToChat(SharedPrefsHelper.getInstance().getQbUser(), new QBEntityCallback<Void>() {
//                @Override
//                public void onSuccess(Void aVoid, Bundle bundle) {
//                    onResumeFinished();
//                }
//
//                @Override
//                public void onError(QBResponseException e) {
//                    onResumeFinished();
//                }
//            });
//        } else {
//            onResumeFinished();
//        }
    }
    public void onResumeFinished() {
        // Need to Override onResumeFinished() method in nested classes if we need to handle returning from background in Activity
    }
//    private void getFireBaseToken() {
//        FirebaseInstanceId.getInstance().getInstanceId()
//                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                        if (!task.isSuccessful()) {
//                            Log.e(getLocalClassName(), "getInstanceId failed", task.getException());
//                            return;
//                        }
//
//                        // Get new Instance ID token
//                        String token = task.getResult().getToken();
////                        store.saveString(AppConstants.TOKEN, token);
//                        // Log and toast
//                        Log.e(getLocalClassName(), token);
////                        Toast.makeText(BaseActivity.this, token, Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }



    public void initFCM() {
        String refreshToken = getDeviceUniqueID();
        if (refreshToken != null && !refreshToken.isEmpty()) {
//            checkApi(refreshToken);
        }
    }


    public void getDataItem(Object... objects) {

    }

//    private void checkApi(String refreshToken) {
//        gotoGetStartActivity();
//    }

//    public void showSnackBar(String message, String retry, ActionClickListener actionClickListener) {
//        SnackBarManager.showSnackBar(message, this);
//    }

    public void hideSoftKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showLoading() {
//        showProgressDialog(this);
//            CommonUtils.showProgressDialog(this);
    }

    public void hideLoading() {
        hideProgressDialog();
//        CommonUtils.hideProgressDialog();
    }

    public String getDeviceUniqueID() {
        @SuppressLint("HardwareIds") String androidId = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return androidId;
    }

    public void callFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .commit();
    }

    public void callFragment(Fragment fragment, int id, Bundle bundle) {
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .commit();
    }

    public void gotoFragment(Fragment fragment, int id) {
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void gotoFragment(Fragment fragment, int id, Bundle bundle) {
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .addToBackStack(null)
                .commit();
    }

//    public void gotoMainActivity() {
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
//    }
//
//    public void gotoLoginSignupActivity() {
//        startActivity(new Intent(this, LoginSignUpActivity.class));
//        finish();
//    }
//
//    public void gotoGetStartActivity() {
//        startActivity(new Intent(this, GetStartedActivty.class));
//        finish();
//    }

    public void backAction() {
        if (exit) {
            finishAffinity();
        } else {
            Toast.makeText(this, "Press one more time to exit", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(() -> exit = false, 2 * 1000);
        }
    }

    public boolean isEmptyCheck(EditText editText) {
        if (editText != null) {
            return editText.getText().toString().trim().isEmpty();
        } else return true;
    }

    public String getTextValue(EditText editText) {
        if (editText != null) {
            return editText.getText().toString().trim();
        } else {
            return "";
        }
    }

//    public boolean isNetworkConnected() {
//        return NetworkUtils.isNetworkConnected(getApplicationContext());
//    }
//
//    public void showMessage(String message) {
//        CommonUtils.showToast(this, message);
//    }
//
//    public void showMessage(@StringRes int resId) {
//        showMessage(getString(resId));
//    }
//
//
//    public SignUpData saveProfileData(SignUpData authData) {
//        store.save(AppConstants.PROFILE_DATA, authData);
//        return authData;
//    }
//
//    public SignUpData getProfileData() {
//        return store.getObject(AppConstants.PROFILE_DATA, SignUpData.class);
//    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

//    public void selectOptionDialog() {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.choose_option_dialog);
//        dialog.setTitle(getResources().getString(R.string.app_name));
//        TextView camera = dialog.findViewById(R.id.camera);
//        TextView gallery = dialog.findViewById(R.id.gallery);
//        TextView textViewCancel = dialog.findViewById(R.id.cancel);
//
//        camera.setOnClickListener(v -> {
//            requestCameraPermission();
//            dialog.dismiss();
//        });
//        gallery.setOnClickListener(v -> {
//            requestGalleryPermission();
//            dialog.dismiss();
//        });
//        textViewCancel.setOnClickListener(v -> dialog.dismiss());
//        dialog.show();
//    }

    private void requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA}, 120);
        } else {
            startCameraIntent();
        }
    }

    public void requestGalleryPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE}, 110);
        } else {
            startGalleryIntent();
        }
    }

    public void startCameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory(), "attachment.jpg");
        outputfileUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputfileUri);
        startActivityForResult(intent, 120);
    }

    public void startGalleryIntent() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), 110);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        OnImageSelectionListner.getInstance(this).onImageUpdate(requestCode, resultCode, data, outputfileUri);
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case AppConstants.PERMISSIONS_REQUEST_ACCESS_CAMERA:
//                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
//                        android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
//                        android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//                    startCameraIntent();
//                }
//                break;
//            case AppConstants.PERMISSIONS_REQUEST_ACCESS_GALLERY:
//                if (ContextCompat.checkSelfPermission(this,
//                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
//                        ContextCompat.checkSelfPermission(this,
//                                android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                    startGalleryIntent();
//                }
//                break;
//        }
//    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public int getCameraPhotoOrientation(Context context, Uri imageUri, File imagePath) {
        int rotate = 0;
        try {
            context.getContentResolver().notifyChange(imageUri, null);
            ExifInterface exif = new ExifInterface(imagePath.getAbsolutePath());
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rotate;
    }

//    public void showProgressDialog(Context context) {
//        hideProgressDialog();
//        if (progressDialog != null) {
//            progressDialog.show();
//            return;
//        }
//        progressDialog = new Dialog(context, R.style.transparent_dialog_borderless);
//        ProgressDialogBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.progress_dialog, null, false);
////        View view = View.inflate(context, R.layout.progress_dialog, null);
//        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        progressDialog.setContentView(binding.getRoot());
//        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        // txtMsgTV = (TextView) view.findViewById(R.id.txtMsgTV);
//        progressDialog.setCancelable(false);
//        progressDialog.show();
//    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public void log(String message) {
//        CommonUtils.log(this, message);
//    }

    private void getKeyHash() {
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.fashloco.app", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }

//    public void showErrorSnackbar(@StringRes int resId, Exception e, View.OnClickListener clickListener) {
//        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
//        if (rootView != null) {
//            ErrorUtils.showSnackbar(rootView, resId, e,
//                    R.string.dialog_retry, clickListener).show();
//        }
//    }
}
