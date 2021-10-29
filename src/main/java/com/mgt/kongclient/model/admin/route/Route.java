package com.mgt.kongclient.model.admin.route;

import com.squareup.moshi.Json;

import java.util.List;

public record Route(
  String id,
  String name,
  List<String> paths,
  List<String> destinations,
  List<String> protocols,
  List<String> methods,
  String snis,
  List<String> hosts,
  List<String> tags,
  @Json(name = "path_handling") String pathHandling,
  @Json(name = "service") Service service,
  @Json(name = "strip_path") Boolean stripPath,
  @Json(name = "preserve_host") Boolean preserveHost,
  @Json(name = "regex_priority") Integer regexPrior,
  @Json(name = "created_at") Long createdAt,
  @Json(name = "updated_at") Long updatedAt
) {

  public Route(String id, String name) {
    this(id, name, null, null, null, null, null, null, null,
      null, null, null, null, null, null, null);
  }

  public Route(String id, String name, List<String> paths) {
    this(id, name, paths, null, null, null, null, null, null,
      null, null, null, null, null, null, null);
  }

  public Route(String id, String name, List<String> paths, List<String> protocols) {
    this(id, name, paths, null, protocols, null, null, null, null, null, null, null, null, null, null, null);
  }
}
