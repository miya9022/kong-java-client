package com.mgt.kongclient.model.admin.sni;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class Sni {

  @Json(name = "ssl_certificate_id")
  private String sslCertificateId;

  @Json(name = "name")
  private String name;

  @Json(name = "created_at")
  private Long createdAt;
}
