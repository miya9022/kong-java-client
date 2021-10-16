package com.github.vaibhavsinha.kong.api.plugin.authentication;

import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.AuthorizationRequest;
import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.GrantTokenRequest;
import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.Token;

import java.util.Map;

public interface OAuth2ProcessService {


  // OAuth2 Process ---------------------------------------------------------------------------------------------------


  Map<String, Object> authorize(String apiUri, AuthorizationRequest request);

  Token grantToken(String apiUri, GrantTokenRequest request);
}
