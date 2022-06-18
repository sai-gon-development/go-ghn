package com.saigon.services.application.apis.controllers;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saigon.services.application.apis.models.reponses.Notification;

@RestController
@RequestMapping("/common")
public class CommonController {
  
  @GetMapping("/helth")
  public ResponseEntity<Notification> helthCheck() {
    return new ResponseEntity<>(new Notification(ZonedDateTime.now(), "UP"), HttpStatus.OK);
  }

}
