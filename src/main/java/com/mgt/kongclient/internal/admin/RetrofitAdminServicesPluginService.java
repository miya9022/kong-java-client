package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitAdminServicesPluginService {

  @POST("services/{serviceId}/plugins/")
  Call<Plugin> addPlugin(@Path("serviceId") String serviceNameOrId, @Body Plugin request);

  @GET("services/{serviceId}/plugins/{id}")
  Call<Plugin> getPlugin(@Path("serviceId") String serviceNameOrId, @Path("id") String nameOrId);

  @PATCH("services/{serviceId}/plugins/{id}")
  Call<Plugin> updatePlugin(@Path("serviceId") String serviceNameOrId, @Path("id") String nameOrId, @Body Plugin request);

  @PUT("services/{serviceId}/plugins/{id}")
  Call<Plugin> upsertPlugin(@Path("serviceId") String serviceNameOrId, @Path("id") String nameOrId, @Body Plugin request);

  @DELETE("services/{serviceId}/plugins/{id}")
  Call<Void> deletePlugin(@Path("serviceId") String serviceNameOrId, @Path("id") String nameOrId);

  @GET("services/{serviceId}/plugins/")
  Call<PluginList> listPlugins(@Path("serviceId") String serviceNameOrId);
}
