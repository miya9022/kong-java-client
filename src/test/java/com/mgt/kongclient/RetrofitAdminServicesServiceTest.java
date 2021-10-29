package com.mgt.kongclient;

import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.services.Service;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitAdminServicesServiceTest extends BaseTest {

  private final String API_NAME_V1 = "Test_V1_Api";
  private final String API_ID_V1 = "3a9fa5b9-5f99-4ab8-a949-d676becd30b3";
  private final String API_HOST = "example.com";
  private final String API_ROUTE_V1 = "route_v1";

  private final String API_NAME_V2 = "Test_V2_Api";
  private final String API_NAME_V2_NEW = "Test.V2.Api";
  private final String API_ID_V2 = "f813a66b-bac6-4952-831b-f04d53ae0bf0";

  private final String API_UPSTREAM_URL = "http://httpbin.org";
  private final String[] API_URIS = new String[]{"/v1/example", "/v2/example"};

  @Test
  public void test1_createService() {
    var request = new Service(
      API_ID_V1, API_NAME_V1, API_HOST,
      "http", 80, "/api", 5,
      60_000L, 60_000L, 60_000L,
      List.of("test", "api"), null, new Date().getTime(), new Date().getTime()
    );

    var response = kongClient.getAdminServicesService().createService(request);
    Assert.assertEquals(request.name(), response.name());
  }

  @Test
  public void test2_getService() {
    var response = kongClient.getAdminServicesService().getService(API_ID_V1);
    Assert.assertEquals(API_NAME_V1, response.name());
    Assert.assertEquals(API_HOST, response.host());
  }

  @Test(expected = KongClientException.class)
  public void test03_exceptionTest() throws IOException {
    kongClient.getAdminServicesService().getService("some.random.id");
  }

  @Test
  public void test04_testDeleteApi() throws IOException {
    kongClient.getAdminServicesService().deleteService(API_ID_V1);
  }

  @Test
  public void test5_ListServices() throws IOException {
    var serviceList = kongClient.getAdminServicesService().listServices(null);
    var services = new ArrayList<>(serviceList.data());
    Assert.assertNotEquals(services.size(), 0);
  }

  @Test
  public void test6_createRouteByService() {
    var routeId = UUID.randomUUID().toString();
    var route = new Route(
      routeId,
      API_ROUTE_V1,
      List.of(API_URIS)
    );
    kongClient.getAdminServicesRouteService().createRoute(API_ID_V1, route);
  }
}
