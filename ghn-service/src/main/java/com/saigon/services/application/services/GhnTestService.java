package com.saigon.services.application.services;

import com.saigon.services.application.apis.models.reponses.GhnModelRes;
import com.saigon.services.application.common.dtos.GhnModelDto;

public interface GhnTestService {

  GhnModelRes ghnTest(GhnModelDto ghnModelDto);
  
}
