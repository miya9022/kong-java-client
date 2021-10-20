package com.mgt.kongclient.model.admin.route;

import com.squareup.moshi.Json;

import java.util.List;

public record Route(
  String id,
  String name,
  @Json(name = "path_handling") String pathHandling,
  List<String> paths,
  List<String> destinations,
  List<String> protocols,
  List<String> methods,
  String snis,
  @Json(name = "service") Service service,
  @Json(name = "strip_path") Boolean stripPath,
  @Json(name = "preserve_host") Boolean preserveHost,
  @Json(name = "regex_priority") Integer regexPrior,
  List<String> hosts,
  List<String> tags,
  @Json(name = "created_at") Long createdAt,
  @Json(name = "updated_at") Long updatedAt
) {
}
