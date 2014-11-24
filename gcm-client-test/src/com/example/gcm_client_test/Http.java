package com.example.gcm_client_test;

import android.util.Log;

import com.loopj.android.http.*;

/**
 * This class uses library that comes from http://loopj.com/android-async-http/
 * 
 * @author Jun
 * 
 */
public class Http {
	private String url;
	private AsyncHttpClient client = new AsyncHttpClient();

	private final static String tag = "Http";

	public Http(String url) {
		this.url = url;
	}

	public void get(JsonHttpResponseHandler handler) {
		client.get(url, handler);
	}

	public void register(String regId, JsonHttpResponseHandler handler) {
		// Setup request url
		String reqUrl = url + "/reg";
		// Setup post body
		RequestParams params = new RequestParams();
		params.put("regId", regId);
		// Request
		client.post(reqUrl, params, handler);

		Log.i(tag, "POST " + reqUrl);
	}
}
