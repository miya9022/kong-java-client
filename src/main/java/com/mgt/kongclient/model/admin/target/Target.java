package com.mgt.kongclient.model.admin.target;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 14/06/17.
 */
@Data
public class Target {

  @Json(name = "id")
  private String id;

  @Json(name = "target")
  private String target;

  @Json(name = "weight")
  private Long weight;

  @Json(name = "upstream_id")
  private String upstreamId;

  @Json(name = "created_at")
  private Long createdAt;
}
