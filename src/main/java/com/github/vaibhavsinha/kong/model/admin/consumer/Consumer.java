package com.github.vaibhavsinha.kong.model.admin.consumer;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 12/06/17.
 */
@Data
public class Consumer {

  String id;

  @Json(name = "custom_id")
  String customId;

  @Json(name = "created_at")
  Long createdAt;

  String username;
}
