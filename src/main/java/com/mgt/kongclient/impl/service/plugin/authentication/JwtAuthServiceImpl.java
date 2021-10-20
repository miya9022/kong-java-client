package com.mgt.kongclient.impl.service.plugin.authentication;

import com.mgt.kongclient.api.plugin.authentication.JwtService;
import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.internal.plugin.authentication.RetrofitJwtService;
import com.mgt.kongclient.model.plugin.authentication.jwt.JwtCredential;
import com.mgt.kongclient.model.plugin.authentication.jwt.JwtCredentialList;

import java.io.IOException;

/**
 * Created by dvilela on 10/16/17.
 */
public class JwtAuthServiceImpl implements JwtService {

  private final RetrofitJwtService retrofitJwtService;

  public JwtAuthServiceImpl(RetrofitJwtService retrofitJwtService) {
    this.retrofitJwtService = retrofitJwtService;
  }

  @Override
  public JwtCredential addCredentials(String consumerIdOrUsername, JwtCredential request) {
    try {
      return retrofitJwtService.addCredentials(consumerIdOrUsername, request).execute().body();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }

  @Override
  public void deleteCredentials(String consumerIdOrUsername, String id) {
    try {
      retrofitJwtService.deleteCredentials(consumerIdOrUsername, id).execute();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }

  @Override
  public JwtCredentialList listCredentials(String consumerIdOrUsername, Long size, String offset) {
    try {
      return retrofitJwtService.listCredentials(consumerIdOrUsername, size, offset).execute().body();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }
}
