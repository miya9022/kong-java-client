package com.mgt.kongclient;

import com.mgt.kongclient.model.admin.consumer.Consumer;
import com.mgt.kongclient.model.plugin.authentication.jwt.JwtCredential;
import com.mgt.kongclient.model.plugin.authentication.jwt.JwtCredentialList;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by dvilela on 10/22/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitJwtServiceTest extends BaseTest {

    private static Consumer consumer;

    @Before
    public void createConsumerAndAddCredential() throws Exception {
        Consumer c = new Consumer();
        c.setCustomId(UUID.randomUUID().toString());
        consumer = kongClient.getConsumerService().createConsumer(c);

        JwtCredential credential = kongClient.getJwtService().addCredentials(consumer.getId(), new JwtCredential());
        assertEquals(consumer.getId(), credential.getConsumerId());
    }

    @After
    public void deleteConsumer() throws Exception {
        kongClient.getConsumerService().deleteConsumer(consumer.getId());
    }

    @Test
    public void test01_listCredentialsTest() throws Exception {
        JwtCredentialList list = kongClient.getJwtService().listCredentials(consumer.getId(), null, null);
        JwtCredential c = list.getData().get(0);
        assertEquals(consumer.getId(), c.getConsumerId());
    }

    @Test
    public void test02_deleteCredentialTest() throws Exception {
        JwtCredentialList list = kongClient.getJwtService().listCredentials(consumer.getId(), null, null);
        JwtCredential credential = list.getData().get(0);
        kongClient.getJwtService().deleteCredentials(consumer.getId(), credential.getId());
        JwtCredentialList list2 = kongClient.getJwtService().listCredentials(consumer.getId(), null, null);
        assertEquals(0L, (long) list2.getTotal());
    }

}
