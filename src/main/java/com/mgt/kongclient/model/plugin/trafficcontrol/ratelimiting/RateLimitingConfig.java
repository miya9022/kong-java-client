package com.mgt.kongclient.model.plugin.trafficcontrol.ratelimiting;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class RateLimitingConfig {

  @Json(name = "second")
  Integer second;

  @Json(name = "minute")
  Integer minute;

  @Json(name = "hour")
  Integer hour;

  @Json(name = "day")
  Integer day;

  @Json(name = "month")
  Integer month;

  @Json(name = "year")
  Integer year;

  @Json(name = "limit_by")
  LimitBy limitBy;

  @Json(name = "policy")
  Policy policy;

  @Json(name = "fault_tolerant")
  Boolean faultTolerant;

  @Json(name = "redis_host")
  String redisHost;

  @Json(name = "redis_port")
  Integer redisPort;

  @Json(name = "redis_password")
  String redisPassword;

  @Json(name = "redis_timeout")
  Integer redisTimeout;

  @Json(name = "redis_database")
  Integer redisDatabase;

  public enum Policy {
    local, cluster, redis
  }

  public enum LimitBy {
    consumer, credential, ip
  }
}
