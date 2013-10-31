package com.codepath.apps.cravengr;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import com.codepath.apps.cravengr.models.Business;
import com.codepath.apps.cravengr.R;
import com.loopj.android.http.JsonHttpResponseHandler;

public class YelpSearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yelpsearch);
		YelpClient client = YelpClientApp.getRestClient();
		client.search("kabab-and-currys", "sunnyvale", new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int code, JSONObject body) {
				try {
					JSONArray businessesJson = body.getJSONArray("businesses");
					ArrayList<Business> businesses = Business.fromJson(businessesJson);
					Log.d("DEBUG", businesses.toString());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				Toast.makeText(YelpSearchActivity.this, "FAIL", Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}

}
