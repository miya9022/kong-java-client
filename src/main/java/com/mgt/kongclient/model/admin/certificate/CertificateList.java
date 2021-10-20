package com.mgt.kongclient.model.admin.certificate;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class CertificateList extends AbstractEntityList {
  Long total;
  List<Certificate> data;
}
