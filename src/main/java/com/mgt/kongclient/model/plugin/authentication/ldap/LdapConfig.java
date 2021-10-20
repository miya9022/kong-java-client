package com.mgt.kongclient.model.plugin.authentication.ldap;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class LdapConfig {

  @Json(name = "hide_credentials")
  Boolean hideCredentials;

  @Json(name = "anonymous")
  String anonymous;

  @Json(name = "ldap_host")
  String ldapHost;

  @Json(name = "ldap_port")
  Integer ldapPort;

  @Json(name = "start_tls")
  Boolean startTls;

  @Json(name = "base_dn")
  String baseDn;

  @Json(name = "verify_ldap_host")
  Boolean verifyLdapHost;

  @Json(name = "attribute")
  String attribute;

  @Json(name = "cache_ttl")
  Integer cacheTtl;

  @Json(name = "timeout")
  Integer timeout;

  @Json(name = "keepalive")
  Integer keepalive;
}
