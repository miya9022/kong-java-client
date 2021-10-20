package com.mgt.kongclient.impl.service.plugin.authentication;

import com.mgt.kongclient.api.plugin.authentication.KeyAuthService;
import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.internal.plugin.authentication.RetrofitKeyAuthService;
import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredential;
import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredentialList;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by vaibhav on 15/06/17.
 * <p>
 * Updated by fanhua on 2017-08-07.
 * <p>
 * Updated by dvilela on 17/10/17.
 */
public class KeyAuthServiceImpl implements KeyAuthService {

  private final RetrofitKeyAuthService retrofitKeyAuthService;

  public KeyAuthServiceImpl(RetrofitKeyAuthService retrofitKeyAuthService) {
    this.retrofitKeyAuthService = retrofitKeyAuthService;
  }

  @Override
  public KeyAuthCredential addCredentials(String consumerIdOrUsername, String key) {
    try {
      Response<KeyAuthCredential> res = retrofitKeyAuthService.addCredentials(consumerIdOrUsername,
        new KeyAuthCredential(key)).execute();
      if (res.code() == 201) {
        return res.body();
      }
      throw new KongClientException("Could not create credentials", res.code(), res.message());
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }

  @Override
  public KeyAuthCredentialList listCredentials(String consumerIdOrUsername, Long size, String offset) {
    try {
      return retrofitKeyAuthService.listCredentials(consumerIdOrUsername, size, offset).execute().body();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }

  @Override
  public void deleteCredential(String consumerIdOrUsername, String id) {
    try {
      retrofitKeyAuthService.deleteCredential(consumerIdOrUsername, id).execute();
    } catch (IOException e) {
      throw new KongClientException(e.getMessage());
    }
  }
}
