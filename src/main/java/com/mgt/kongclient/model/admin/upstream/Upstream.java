package com.mgt.kongclient.model.admin.upstream;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
public record Upstream(
  String id,
  String name,
  String algorithm,
  Long slots,
  @Json(name = "host_header") String hostHeader,
  @Json(name = "hash_on") String hashOn,
  @Json(name = "hash_on_header") String hashOnHeader,
  @Json(name = "hash_fallback") String hashFallback,
  @Json(name = "hash_fallback_header") String hashFallbackHeader,
  @Json(name = "hash_on_cookie") String hashOnCookie,
  @Json(name = "hash_on_cookie_path") String hashOnCookiePath,
  @Json(name = "created_at") Long createdAt
) {

  public Upstream(String id, String name, Long createdAt) {
    this(id, name, null, null, null, null, null,
      null, null, null, null, createdAt);
  }

  public Upstream(String name) {
    this(null, name, null, null, null, null, null,
      null, null, null, null, null);
  }
}
