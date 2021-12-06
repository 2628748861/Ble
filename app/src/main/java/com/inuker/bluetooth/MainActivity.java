package com.inuker.bluetooth;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.response.SearchResponse;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClientManager.getClient().search(new SearchRequest.Builder()
                .searchBluetoothLeDevice(10 * 1000)
                .build(), new SearchResponse() {
            @Override
            public void onSearchStarted() {
                Log.e("TAG","onSearchStarted");
            }

            @Override
            public void onDeviceFounded(SearchResult device) {
                Log.e("TAG","onDeviceFounded:"+device.getName());
            }

            @Override
            public void onSearchStopped() {
                Log.e("TAG","onSearchStopped");
            }

            @Override
            public void onSearchCanceled() {
                Log.e("TAG","onSearchCanceled");
            }
        });
    }
}
