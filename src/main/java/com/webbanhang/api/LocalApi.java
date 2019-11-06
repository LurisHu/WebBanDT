package com.webbanhang.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.service.LocalService;

@RestController
public class LocalApi {
	@Autowired
	LocalService jsonService;
	
	@GetMapping(path = "api/city",produces = "application/json")
	public Object getCity() throws ClientProtocolException, IOException {
		return jsonService.getJSONObject("https://thongtindoanhnghiep.co/api/city");
	}
	
	@GetMapping(path = "/api/city/{id}/district",produces = "application/json")
	public Object getDistrict(@PathVariable("id") Integer id) throws ClientProtocolException, IOException {
		return jsonService.getJSONArray("https://thongtindoanhnghiep.co/api/city/"+id+"/district");
	}
	
	@GetMapping(path = "/api/district/{id}/ward",produces = "application/json")
	public Object getWard(@PathVariable("id") Integer id) throws ClientProtocolException, IOException {
		return jsonService.getJSONArray("https://thongtindoanhnghiep.co/api/district/"+id+"/ward");
	}
}
