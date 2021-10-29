package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitConsumerPluginService {

  @POST("consumers/{consumerId}/plugins/")
  Call<Plugin> addPlugin(@Path("consumerId") String consumerId, @Body Plugin request);

  @GET("consumers/{consumerId}/plugins/{id}")
  Call<Plugin> getPlugin(@Path("consumerId") String consumerId, @Path("id") String nameOrId);

  @PATCH("consumers/{consumerId}/plugins/{id}")
  Call<Plugin> updatePlugin(@Path("consumerId") String consumerId, @Path("id") String nameOrId, @Body Plugin request);

  @PUT("consumers/{consumerId}/plugins/{id}")
  Call<Plugin> upsertPlugin(@Path("consumerId") String consumerId, @Path("id") String nameOrId, @Body Plugin request);

  @DELETE("consumers/{consumerId}/plugins/{id}")
  Call<Void> deletePlugin(@Path("consumerId") String consumerId, @Path("id") String nameOrId);

  @GET("consumers/{consumerId}/plugins/")
  Call<PluginList> listPlugins(@Path("consumerId") String consumerId);
}
