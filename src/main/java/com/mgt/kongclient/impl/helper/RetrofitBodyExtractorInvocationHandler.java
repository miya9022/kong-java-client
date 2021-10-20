package com.mgt.kongclient.impl.helper;

import com.mgt.kongclient.exception.KongClientException;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by vaibhav on 13/06/17.
 */
@Slf4j
public class RetrofitBodyExtractorInvocationHandler implements InvocationHandler {

  private final Object proxied;

  public RetrofitBodyExtractorInvocationHandler(Object proxied) {
    this.proxied = proxied;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    var methodName = method.getName();
    var parameterTypes = method.getParameterTypes();
    var method1 = proxied.getClass().getMethod(methodName, parameterTypes);
    var call = (Call) method1.invoke(proxied, args);
    var response = call.execute();
    log.debug("Http Request:  " + response.raw().request());
    log.debug("Http Response: " + response.raw());
    if (!response.isSuccessful()) {
      throw new KongClientException(response.errorBody() != null ? response.errorBody().string() : String.valueOf(response.code()));
    }
    return response.body();
  }
}
