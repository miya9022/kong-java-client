package com.github.vaibhavsinha.kong.model.plugin.security.acl;

import com.squareup.moshi.Json;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaibhav on 18/06/17.
 */
@Data
@NoArgsConstructor
public class Acl {
  @Json(name = "id")
  private String id;

  @Json(name = "group")
  private String group;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "created_at")
  private Long createdAt;

  public Acl(String group) {
    this.group = group;
  }
}
