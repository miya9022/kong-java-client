package com.mgt.kongclient;

import com.mgt.kongclient.exception.KongClientException;
import com.mgt.kongclient.model.admin.upstream.Upstream;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by vaibhav on 12/06/17.
 */
public class RetrofitUpstreamServiceTest extends BaseTest {

  @Test
  public void testCreateUpstream() throws IOException {
    var request = new Upstream("local.com");

    var response = kongClient.getUpstreamService().createUpstream(request);
    System.out.print(response);
    Assert.assertEquals(request.name(), response.name());
  }

  @Test
  public void testGetUpstream() throws IOException {
    var response = kongClient.getUpstreamService().getUpstream("0ba0f245-0fda-43a1-a96f-ac33e1b4cf41");
    System.out.print(response);
    Assert.assertEquals("local.com", response.name());
  }

  @Test
  public void testListUpstreams() throws IOException {
    var upstreams = new ArrayList<Upstream>();
    var upstreamList = kongClient.getUpstreamService().listAllUpstreams();
    upstreams.addAll(upstreamList.getData());
    while (upstreamList.getOffset() != null) {
      upstreamList = kongClient.getUpstreamService().listAllUpstreams();
      upstreams.addAll(upstreamList.getData());
    }
    System.out.println(upstreams);
    Assert.assertNotEquals(upstreams.size(), 0);
  }

  @Test(expected = KongClientException.class)
  public void exceptionTest() throws IOException {
    kongClient.getUpstreamService().getUpstream("some-random-id");
  }

  @Test
  public void testUpdateUpstream() throws IOException {
    Upstream request = new Upstream("local.com");

    Upstream response = kongClient.getUpstreamService().updateUpstream("0ba0f245-0fda-43a1-a96f-ac33e1b4cf41", request);
    System.out.print(response);
    Assert.assertEquals(request.name(), response.name());
  }

  @Test
  public void testCreateOrUpdateUpstream() throws IOException {
    var request = new Upstream("0ba0f245-0fda-43a1-a96f-ac33e1b4cf41", "local.com", new Date().getTime());

    var response = kongClient.getUpstreamService().createOrUpdateUpstream("0ba0f245-0fda-43a1-a96f-ac33e1b4cf41", request);
    System.out.print(response);
    Assert.assertEquals(request.name(), response.name());
  }

  @Test
  public void testDeleteUpstream() throws IOException {
    kongClient.getUpstreamService().deleteUpstream("0ba0f245-0fda-43a1-a96f-ac33e1b4cf41");
  }

}
