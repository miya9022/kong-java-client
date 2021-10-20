package com.mgt.kongclient.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mgt.kongclient.model.plugin.authentication.oauth2.ApplicationList;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mgt.kongclient.BaseTest;
import com.mgt.kongclient.model.plugin.authentication.oauth2.Application;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RetrofitOAuth2ManageServiceTest extends BaseTest {

    private static String CONSUMER_ID = "53fe86c9-59d8-48c1-94ef-2e6142fadf85";


    // ------------------------------------------------------------------------------------

    private static String appName = "testApp-20170807113035732";
    private static String appClientId = "dc80e4ebf33445faafad96c1b4701d48";
    private static String appClientSecret = "22435791881e40dc97fd05f28eb86488";
    private static List<String> appRedirectUrl = new ArrayList<>();
    static {
        appRedirectUrl.add("http://10.5.227.17:3000/callback");
    }


    private Application cachedApp;


    // App Management ---------------------------------------------------------------------------------------------------

    @Test
    public void test01_CreateOAuth2App() throws IOException {

        Application appRequest = new Application(appName, appRedirectUrl, appClientId, appClientSecret);

        Application appResponse = kongClient.getOAuth2ManageService().createConsumerApplication(CONSUMER_ID, appRequest);

        printJson(appResponse);

        Assert.assertEquals(appName, appResponse.getName());

        cachedApp = appResponse;
    }

    @Test
    public void test02_GetOAuth2App() throws IOException {

        Application appResponse = kongClient.getOAuth2ManageService().getConsumerApplication(CONSUMER_ID, appClientId);

        printJson(appResponse);

        Assert.assertEquals(appName, appResponse.getName());

        cachedApp = appResponse;
    }


    @Test
    public void test03_UpdateOAuth2App() throws IOException {

        Application appRequest = new Application(appName + "-2", appRedirectUrl);
        appRequest.setId(appClientId); //important

        Application appResponse = kongClient.getOAuth2ManageService().updateConsumerApplication(CONSUMER_ID, appClientId, appRequest);

        printJson(appResponse);

        Assert.assertEquals(appName + "-2", appResponse.getName());

        cachedApp = appResponse;
    }

    @Test
    public void test04_DeleteOAuth2App() throws IOException {

        kongClient.getOAuth2ManageService().deleteConsumerApplication(CONSUMER_ID, appClientId);

    }


    @Test
    public void test05_ListOAuth2Apps() throws IOException {

        ApplicationList appList = kongClient.getOAuth2ManageService().listConsumerApplications(CONSUMER_ID);

        printJson(appList);
    }


    @Test
    public void test06_ListOAuth2Apps() throws IOException {

        ApplicationList appList = kongClient.getOAuth2ManageService().listClientApplications(
                null, appName, null, null, CONSUMER_ID);

        printJson(appList);
    }

}
