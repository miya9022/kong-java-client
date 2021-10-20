package com.mgt.kongclient.model.plugin.authentication.oauth2;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
public class ApplicationList extends AbstractEntityList {

  Long total;

  List<Application> data;
}
