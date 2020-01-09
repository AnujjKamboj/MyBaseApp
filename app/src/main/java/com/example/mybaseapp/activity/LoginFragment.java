package com.example.mybaseapp.activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mybaseapp.R;
import com.example.mybaseapp.adapter.ImageAdapter;
import com.example.mybaseapp.data.GetImageEntity;
import com.example.mybaseapp.data.GetImageWrapper;
import com.example.mybaseapp.retrofir_repo.ApiInterface;
import com.example.mybaseapp.retrofir_repo.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private RecyclerView imageRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        imageRV = view.findViewById(R.id.imageRV);
        imageRV.setLayoutManager(new GridLayoutManager(getActivity(), 2, RecyclerView.VERTICAL, false));
        hitLoginApi();
    }

    private void hitLoginApi() {

        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class, "", "");
        Call<GetImageWrapper> call = apiInterface.getdata(new GetImageEntity("108", "0", "popular"));
        call.enqueue(new Callback<GetImageWrapper>() {
            @Override
            public void onResponse(Call<GetImageWrapper> call, Response<GetImageWrapper> response) {

                GetImageWrapper getImageWrapper = response.body();
                if (getImageWrapper.status.equals("success")) {
                    imageRV.setAdapter(new ImageAdapter(getActivity(), getImageWrapper.images));
                } else {

                    Toast.makeText(getActivity(), getImageWrapper.status, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetImageWrapper> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
//    HostnameVerifier hostnameVerifier = new HostnameVerifier() {
//        @Override
//        public boolean verify(String hostname, SSLSession session) {
//            HostnameVerifier hv =
//                    HttpsURLConnection.getDefaultHostnameVerifier();
//            return hv.verify("example.com", session);
//        }
//    };

//    // Tell the URLConnection to use our HostnameVerifier
//    URL url = null;
//        try {
//        url = new URL("https://dev1.xicom.us/xttest/");
//    } catch (MalformedURLException e) {
//        e.printStackTrace();
//    }
//    HttpsURLConnection urlConnection =
//            null;
//        try {
//        urlConnection = (HttpsURLConnection)url.openConnection();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//        urlConnection.setHostnameVerifier(hostnameVerifier);
//        try {
//        InputStream in = urlConnection.getInputStream();
//        Toast.makeText(getActivity(), in.toString(), Toast.LENGTH_SHORT).show();
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//        copyInputStreamToOutputStream(in, System.out);
}
