package com.mgt.kongclient;

import com.mgt.kongclient.model.admin.sni.Sni;
import com.mgt.kongclient.model.admin.sni.SniList;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by vaibhav on 12/06/17.
 */
public class RetrofitSniServiceTest  extends BaseTest {



//    @Test
    public void testCreateSni() throws IOException {
        Sni request = new Sni();
        request.setName("jwt");
        request.setSslCertificateId(UUID.randomUUID().toString());

        Sni response = kongClient.getSniService().createSni(request);
        System.out.print(response);
        Assert.assertEquals(request.getName(), response.getName());
    }

//    @Test
    public void testGetSni() throws IOException {
        Sni response = kongClient.getSniService().getSni("2e9c5805-ea4e-4d38-ba7c-5e878d38489c");
        System.out.print(response);
        Assert.assertEquals("jwt", response.getName());
    }

//    @Test
    public void testListSnis() throws IOException {
        List<Sni> snis = new ArrayList<>();
        SniList sniList = kongClient.getSniService().listSnis();
        snis.addAll(sniList.getData());
        while (sniList.getOffset() != null) {
            sniList = kongClient.getSniService().listSnis();
            snis.addAll(sniList.getData());
        }
        System.out.println(snis);
        Assert.assertNotEquals(snis.size(), 0);
    }

//    @Test(expected = KongClientException.class)
    public void exceptionTest() throws IOException {
        kongClient.getSniService().getSni("some-random-id");
    }

//    @Test
    public void testUpdateSni() throws IOException {
        Sni request = new Sni();
        request.setName("jwt");
        request.setSslCertificateId(UUID.randomUUID().toString());

        Sni response = kongClient.getSniService().updateSni("2e9c5805-ea4e-4d38-ba7c-5e878d38489c", request);
        System.out.print(response);
        Assert.assertEquals(request.getSslCertificateId(), response.getSslCertificateId());
    }

//    @Test
    public void testCreateOrUpdateSni() throws IOException {
        Sni request = new Sni();
        request.setName("jwt");
        request.setSslCertificateId(UUID.randomUUID().toString());
        request.setCreatedAt(new Date().getTime());

        Sni response = kongClient.getSniService().createOrUpdateSni(request);
        System.out.print(response);
        Assert.assertEquals(request.getSslCertificateId(), response.getSslCertificateId());
    }

//    @Test
    public void testDeleteSni() throws IOException {
        kongClient.getSniService().deleteSni("2e9c5805-ea4e-4d38-ba7c-5e878d38489c");
    }

}
