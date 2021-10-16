package com.github.vaibhavsinha.kong.model.admin.upstream;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class Upstream {

  @Json(name = "id")
  private String id;

  @Json(name = "slots")
  private Integer slots;

  @Json(name = "name")
  private String name;

  @Json(name = "orderlist")
  private List<Integer> orderList;

  @Json(name = "created_at")
  private Long createdAt;
}
