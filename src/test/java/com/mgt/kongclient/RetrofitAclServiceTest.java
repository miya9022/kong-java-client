package com.mgt.kongclient;

import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.plugin.security.acl.Acl;
import com.mgt.kongclient.model.plugin.security.acl.AclList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by dvilela on 10/22/17.
 */
public class RetrofitAclServiceTest extends BaseTest {

  private Consumer consumer;

  @Before
  public void createConsumer() throws Exception {
    consumer = new Consumer(UUID.randomUUID().toString());
    consumer = kongClient.getConsumerService().createConsumer(consumer);
  }

  @After
  public void deleteConsumer() throws Exception {
    kongClient.getConsumerService().deleteConsumer(consumer.id());
  }

  @Test
  public void testAssociateAndListAcls() throws Exception {
    kongClient.getAclService().associateConsumer(consumer.id(), "default");

    AclList list = kongClient.getAclService().listAcls(consumer.id(), 1L, null);

    Acl acl = list.getData().get(0);
    assertEquals(consumer.id(), acl.getConsumerId());
    assertEquals("default", acl.getGroup());
  }

}
