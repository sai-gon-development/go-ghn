package com.saigon.services.application.apis.models.reponses;

import java.io.Serializable;
import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification implements Serializable {

  private static final long serialVersionUID = -5828101164006114538L;
  
  @Schema(description = "Notification time")
  private ZonedDateTime time;

  @Schema(description = "Notification message")
  private String message;

}
