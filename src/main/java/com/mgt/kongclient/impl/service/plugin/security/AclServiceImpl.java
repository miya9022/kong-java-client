package com.mgt.kongclient.impl.service.plugin.security;

import com.mgt.kongclient.api.plugin.security.AclService;
import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.internal.plugin.security.RetrofitAclService;
import com.mgt.kongclient.model.plugin.security.acl.Acl;
import com.mgt.kongclient.model.plugin.security.acl.AclList;

import java.io.IOException;

/**
 * Created by vaibhav on 18/06/17.
 * <p>
 * Updated by fanhua on 2017-08-07.
 * <p>
 * Upated by dvilela on 22/10/17.
 */
public class AclServiceImpl implements AclService {

  private final RetrofitAclService retrofitAclService;

  public AclServiceImpl(RetrofitAclService retrofitAclService) {
    this.retrofitAclService = retrofitAclService;
  }

  @Override
  public void associateConsumer(String usernameOrId, String group) {
    try {
      retrofitAclService.associateConsumer(usernameOrId, new Acl(group)).execute();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }

  @Override
  public AclList listAcls(String usernameOrId, Long size, String offset) {
    try {
      return retrofitAclService.listAcls(usernameOrId, size, offset).execute().body();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }
}
