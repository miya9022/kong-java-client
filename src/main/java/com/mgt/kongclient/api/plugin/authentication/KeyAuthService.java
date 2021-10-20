package com.mgt.kongclient.api.plugin.authentication;

import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredential;
import com.mgt.kongclient.model.plugin.authentication.key.KeyAuthCredentialList;

/**
 * Created by vaibhav on 15/06/17.
 * <p>
 * Updated by dvilela on 17/10/17.
 */
public interface KeyAuthService {
  KeyAuthCredential addCredentials(String consumerIdOrUsername, String key);

  KeyAuthCredentialList listCredentials(String consumerIdOrUsername, Long size, String offset);

  void deleteCredential(String consumerIdOrUsername, String id);
}
