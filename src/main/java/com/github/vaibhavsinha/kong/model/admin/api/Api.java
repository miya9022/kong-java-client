package com.github.vaibhavsinha.kong.model.admin.api;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class Api {

  @Json(name = "created_at")
  private Long createdAt;

  @Json(name = "hosts")
  private Object hosts; //sometimes array, sometimes map
//	private List<String> hosts = null;

  @Json(name = "uris")
  private List<String> uris;

  @Json(name = "methods")
  private List<String> methods;

  @Json(name = "http_if_terminated")
  private Boolean httpIfTerminated;

  @Json(name = "https_only")
  private Boolean httpsOnly;

  @Json(name = "id")
  private String id;

  @Json(name = "name")
  private String name;

  @Json(name = "preserve_host")
  private Boolean preserveHost;

  @Json(name = "retries")
  private Integer retries;

  @Json(name = "strip_uri")
  private Boolean stripUri;

  @Json(name = "upstream_connect_timeout")
  private Integer upstreamConnectTimeout;

  @Json(name = "upstream_read_timeout")
  private Integer upstreamReadTimeout;

  @Json(name = "upstream_send_timeout")
  private Integer upstreamSendTimeout;

  @Json(name = "upstream_url")
  private String upstreamUrl;
}
