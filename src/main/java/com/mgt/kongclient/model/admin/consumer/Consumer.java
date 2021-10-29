package com.mgt.kongclient.model.admin.consumer;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by vaibhav on 12/06/17.
 */
public record Consumer(
  String id,
  @Json(name = "custom_id") String customId,
  @Json(name = "created_at") Long createdAt,
  String username,
  List<String> tags
) {

  public Consumer(String id) {
    this(id, null, null, null, null);
  }

  public Consumer(String id, String customId) {
    this(id, customId, null, null, null);
  }

  public Consumer(String id, String customId, Long createdAt) {
    this(id, customId, createdAt, null, null);
  }
}
