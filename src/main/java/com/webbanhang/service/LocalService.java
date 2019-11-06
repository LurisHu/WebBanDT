package com.webbanhang.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class LocalService {
	public Object getJSONObject(String apiUrl) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(apiUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network
		// socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager.
		JSONObject resultForResturn = null;
		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			// do something useful with the response body
			if (entity1 != null) {
				String retSrc = EntityUtils.toString(entity1);
				// parsing JSON
				JSONObject result = new JSONObject(retSrc); // Convert String to JSON Object
				resultForResturn = result;
//				System.out.println("Result is: "+result);
//				JSONArray tokenList = result.getJSONArray("LtsItem");
//				System.out.println("List item is: "+tokenList);
//				JSONObject oj = tokenList.getJSONObject(0);
//				System.out.println("The item is: "+oj);
//				String token = oj.getString("Title");
//				System.out.println("The city is: "+token);
			}
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);
		} finally {
			response1.close();
		}
		return new ResponseEntity<String>(resultForResturn.toString(), HttpStatus.OK);
	}
	public Object getJSONArray(String apiUrl) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(apiUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network
		// socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager.
		JSONObject resultForResturn = null;
		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			// do something useful with the response body
			if (entity1 != null) {
				String retSrc = EntityUtils.toString(entity1);
				retSrc="{\"LtsItem\":"+retSrc+"}";
				// parsing JSON
				JSONObject result = new JSONObject(retSrc);
				resultForResturn = result;
//				System.out.println("Result is: "+result);
//				JSONArray tokenList = result.getJSONArray("LtsItem");
//				System.out.println("List item is: "+tokenList);
//				JSONObject oj = tokenList.getJSONObject(0);
//				System.out.println("The item is: "+oj);
//				String token = oj.getString("Title");
//				System.out.println("The city is: "+token);
			}
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);
		} finally {
			response1.close();
		}
		
		return resultForResturn.toString();
	}
}
