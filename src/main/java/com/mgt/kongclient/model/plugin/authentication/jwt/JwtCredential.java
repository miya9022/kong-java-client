package com.mgt.kongclient.model.plugin.authentication.jwt;

import com.squareup.moshi.Json;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaibhav on 16/06/17.
 * <p>
 * Updated by dvilela on 17/10/17.
 */
@Data
@NoArgsConstructor
public class JwtCredential {

  @Json(name = "rsa_public_key")
  private String rsaPublicKey;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "id")
  private String id;

  @Json(name = "created_at")
  private Long createdAt;

  @Json(name = "key")
  private String key;

  @Json(name = "algorithm")
  private String algorithm;

  @Json(name = "secret")
  private String secret;
}
