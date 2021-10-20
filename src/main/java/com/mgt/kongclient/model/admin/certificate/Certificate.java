package com.mgt.kongclient.model.admin.certificate;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 14/06/17.
 */
@Data
public class Certificate {

  @Json(name = "id")
  private String id;

  @Json(name = "cert")
  private String cert;

  @Json(name = "key")
  private String key;

  @Json(name = "snis")
  private List<String> snis;

  @Json(name = "created_at")
  private Long createdAt;
}
