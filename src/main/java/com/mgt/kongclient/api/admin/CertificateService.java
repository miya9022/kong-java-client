package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.certificate.Certificate;
import com.mgt.kongclient.model.admin.certificate.CertificateList;

/**
 * Created by vaibhav on 13/06/17.
 */
@Deprecated
public interface CertificateService {
  Certificate createCertificate(Certificate request);

  Certificate getCertificate(String sniOrId);

  Certificate updateCertificate(String sniOrId, Certificate request);

  Certificate createOrUpdateCertificate(Certificate request);

  Certificate deleteCertificate(String sniOrId);

  CertificateList listCertificates();
}