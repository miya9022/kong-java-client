package com.mgt.kongclient.impl.service.plugin.authentication;

import com.mgt.kongclient.api.plugin.authentication.BasicAuthService;
import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.internal.plugin.authentication.RetrofitBasicAuthService;
import com.mgt.kongclient.model.plugin.authentication.basic.BasicAuthCredential;

import java.io.IOException;

/**
 * Created by vaibhav on 15/06/17.
 * <p>
 * Updated by fanhua on 2017-08-07.
 */
public class BasicAuthServiceImpl implements BasicAuthService {

  private final RetrofitBasicAuthService retrofitBasicAuthService;

  public BasicAuthServiceImpl(RetrofitBasicAuthService retrofitBasicAuthService) {
    this.retrofitBasicAuthService = retrofitBasicAuthService;
  }

  @Override
  public void addCredentials(String consumerIdOrUsername, String username, String password) {
    try {
      retrofitBasicAuthService.addCredentials(consumerIdOrUsername, new BasicAuthCredential(username, password)).execute();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }
}
