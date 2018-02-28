package io.swagger.samples.inflector.springboot.models;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Link;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UserResource implements Resource {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Link> getLinks() {
    return Collections.emptyList();
  }

  public String getSurname() {

    List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from UserDetails");

    if (rows.size() != 0) {
      String fullName = (String) rows.get(0).get("Name");

      String[] names = fullName.split(",");
      if (names.length > 1) {
        String surName = names[0];
        return !StringUtils.isEmpty(surName) ? surName.trim() : "";
      }
      return "";
      //throw new NotImplementedException("TODO");
    } else {
      return "";
    }
  }

  public String getGivenname() {

    List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from UserDetails");

    if (rows.size() != 0) {
      String fullName = (String) rows.get(0).get("Name");

      String[] names = fullName.split(",");
      if (names.length > 1) {
        String givenName = names[1];
        return !StringUtils.isEmpty(givenName) ? givenName.trim() : "";
      }
      return "";
      //throw new NotImplementedException("TODO");
    } else {
      return "";
    }
  }
  public String getDob() throws Exception {

    List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from UserDetails");

    if (rows.size() != 0) {
      String dob = (String) rows.get(0).get("DoB");

      SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat format2 = new SimpleDateFormat("dd/MMM/yyyy");
      Date date = format2.parse(dob);
      String result = format1.format(date);
      return result;
    } else {
      return "";
    }
  }

}
