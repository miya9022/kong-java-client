package com.mgt.kongclient.impl.service.plugin.authentication;

import com.mgt.kongclient.api.plugin.authentication.HmacAuthService;
import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.internal.plugin.authentication.RetrofitHmacAuthService;
import com.mgt.kongclient.model.plugin.authentication.hmac.HmacAuthCredential;

import java.io.IOException;

/**
 * Created by vaibhav on 15/06/17.
 * <p>
 * Updated by fanhua on 2017-08-07.
 */
public class HmacAuthServiceImpl implements HmacAuthService {

  private final RetrofitHmacAuthService retrofitHmacAuthService;

  public HmacAuthServiceImpl(RetrofitHmacAuthService retrofitHmacAuthService) {
    this.retrofitHmacAuthService = retrofitHmacAuthService;
  }

  @Override
  public void addCredentials(String consumerIdOrUsername, String username, String secret) {
    try {
      retrofitHmacAuthService.addCredentials(consumerIdOrUsername, new HmacAuthCredential(username, secret)).execute();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }
}
