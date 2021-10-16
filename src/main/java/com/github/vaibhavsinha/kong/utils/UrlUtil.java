package com.github.vaibhavsinha.kong.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by fanhua on 2017-07-28.
 */
public class UrlUtil {

  public static Map<String, String> splitQueryString(String urlString) {
    try {
      URL url = new URL(urlString);
      Map<String, String> query_pairs = new LinkedHashMap<>();
      String queryString = url.getQuery();
      if (queryString != null) {
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
          int idx = pair.indexOf("=");
          query_pairs.put(URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8), URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8));
        }
      }
      return query_pairs;
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Could not parse URL: " + urlString, e);
    }
  }


  public static Map<String, String> splitFragmentString(String urlString) {
    try {
      URL url = new URL(urlString);
      Map<String, String> query_pairs = new LinkedHashMap<>();
      String fragmentString = url.getRef();
      if (fragmentString != null) {
        String[] pairs = fragmentString.split("&");
        for (String pair : pairs) {
          int idx = pair.indexOf("=");
          query_pairs.put(URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8), URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8));
        }
      }
      return query_pairs;
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException("Could not parse URL: " + urlString, e);
    }
  }


  public static void main(String[] args) throws Exception {

    String url1 = "http://kong.test.com/simulate/getCode?access_token=4ddb06a7c9c44ea1a1f3043ee8de9938&expires_in=7200";

    String url2 = "http://kong.test.com/simulate/getCode#access_token=4ddb06a7c9c44ea1a1f3043ee8de9938&expires_in=7200";

    var moshi = new Moshi.Builder().build();
    var type = Types.newParameterizedType(Map.class, String.class, String.class);
    JsonAdapter<Map<String, String>> adapter = moshi.adapter(type);

    System.out.println(adapter.toJson(splitFragmentString(url1)));
    System.out.println(adapter.toJson(splitFragmentString(url2)));
  }
}
