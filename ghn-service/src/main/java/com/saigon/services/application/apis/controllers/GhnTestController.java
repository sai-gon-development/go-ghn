package com.saigon.services.application.apis.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saigon.services.application.apis.models.reponses.GhnModelRes;
import com.saigon.services.application.apis.models.requests.GhnModelReq;
import com.saigon.services.application.common.dtos.GhnModelDto;
import com.saigon.services.application.services.GhnTestService;

@RestController
@RequestMapping("/ghn")
public class GhnTestController {

  ModelMapper modelMapper = new ModelMapper();

  @Autowired
  GhnTestService ghnTestService;

  @PostMapping("/ghn-test")
  public ResponseEntity<GhnModelRes> ghnTest(@RequestBody @Validated GhnModelReq ghnModelReq, @RequestParam int position) {
    GhnModelDto ghnModelDto = modelMapper.map(ghnModelReq, GhnModelDto.class);
    ghnModelDto.setPosition(position);
    return new ResponseEntity<>(ghnTestService.ghnTest(ghnModelDto), HttpStatus.OK);
  }

}
