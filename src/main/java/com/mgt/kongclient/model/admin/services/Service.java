package com.mgt.kongclient.model.admin.services;

import com.squareup.moshi.Json;

import java.util.List;

public record Service(
  String id,
  String name,
  String host,
  String protocol,
  Integer port,
  String path,
  Integer retries,
  @Json(name = "connect_timeout") Long connectTimeout,
  @Json(name = "read_timeout") Long readTimeout,
  @Json(name = "write_timeout") Long writeTimeout,
  List<String> tags,
  @Json(name = "client_certificate") String clientCertificate,
  @Json(name = "created_at") Long createdAt,
  @Json(name = "updated_at") Long updatedAt
) {
}
