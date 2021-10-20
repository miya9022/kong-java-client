package com.mgt.kongclient.model.plugin.authentication.key;

import com.squareup.moshi.Json;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
@NoArgsConstructor
public class KeyAuthCredential {

  @Json(name = "id")
  private String id;

  @Json(name = "key")
  private String key;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "created_at")
  private Long createdAt;

  public KeyAuthCredential(String key) {
    this.key = key;
  }
}
