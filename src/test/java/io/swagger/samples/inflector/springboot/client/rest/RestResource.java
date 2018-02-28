package io.swagger.samples.inflector.springboot.client.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Link;

import org.springframework.http.ResponseEntity;

import io.swagger.samples.inflector.springboot.models.Resource;
import net.minidev.json.JSONObject;

public class RestResource implements Resource {

	private ResponseEntity<JSONObject> response;

	public RestResource(ResponseEntity<JSONObject> response) {
		this.response = response;
	}

	@Override
	public List<Link> getLinks() {
		List<String> linkHeaders = response.getHeaders().get(HttpHeaders.LINK);
		List<String> splitHeaders = new ArrayList<>();
		for (String header : linkHeaders) {
			for (String item : header.split(",")) {
				splitHeaders.add(item);
			}
		}
		return splitHeaders.stream().map(linkString -> Link.valueOf(linkString)).collect(Collectors.toList());
	}


	public JSONObject getData() {
		return response.getBody();
	}

}
