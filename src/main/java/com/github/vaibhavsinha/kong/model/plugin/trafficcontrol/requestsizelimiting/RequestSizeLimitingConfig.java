package com.github.vaibhavsinha.kong.model.plugin.trafficcontrol.requestsizelimiting;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 18/06/17.
 */
@Data
public class RequestSizeLimitingConfig {
  @Json(name = "allowed_payload_size")
  Integer allowedPayloadSize;
}
