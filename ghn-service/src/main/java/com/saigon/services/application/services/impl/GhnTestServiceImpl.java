package com.saigon.services.application.services.impl;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.saigon.services.application.apis.models.reponses.GhnModelRes;
import com.saigon.services.application.common.dtos.GhnModelDto;
import com.saigon.services.application.io.entities.GhnModelEntity;
import com.saigon.services.application.services.GhnTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GhnTestServiceImpl implements GhnTestService {

  ModelMapper mapper = new ModelMapper();

  @Override
  public GhnModelRes ghnTest(GhnModelDto ghnModelDto) {

    if (ghnModelDto.getPosition() <= 0) {
      ghnModelDto.setPosition(1);
    }

    List<Integer> listArr;
    listArr = ghnModelDto.getArrInt();
    Collections.sort(listArr, Collections.reverseOrder());
    ghnModelDto.setArrInt(listArr);
    ghnModelDto.setPosition(listArr.get(ghnModelDto.getPosition()) + 1);

    GhnModelEntity ghnModelEntity = mapper.map(ghnModelDto, GhnModelEntity.class);
    log.info("GhnModelEntity {}", ghnModelEntity);

    GhnModelRes ghnModelRes = new GhnModelRes();
    ghnModelRes.setListInteger(ghnModelEntity.getArrInt());
    ghnModelRes.setMessage("Số ở vị trí thứ n: là: " + ghnModelEntity.getPosition());

    return ghnModelRes;
  }

}
