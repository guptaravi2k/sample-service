
package io.swagger.samples.inflector.springboot.controllers;

import java.util.stream.Collectors;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.inflector.models.RequestContext;
import io.swagger.inflector.models.ResponseContext;
import io.swagger.samples.inflector.springboot.models.RootResource;
import io.swagger.samples.inflector.springboot.models.UserResource;
import net.minidev.json.JSONObject;

@Component
public class Default {

  @Autowired
  RootResource root;

  @Autowired
  UserResource ur;

  public ResponseContext getApiRoot(RequestContext requestContext) {
    ResponseContext rval = new ResponseContext().status(Status.OK).entity(new JSONObject());
    MultivaluedMap<String, String> headers = rval.getHeaders();
    headers.add(HttpHeaders.LINK,
        root.getLinks().stream().map(Object::toString).collect(Collectors.joining(",")));
    return rval;
  }

  public ResponseContext getUserDetails(RequestContext request) {

    return new ResponseContext().status(Status.OK).entity(ur);
  }
}
