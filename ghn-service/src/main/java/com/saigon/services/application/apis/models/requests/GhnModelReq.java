package com.saigon.services.application.apis.models.requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GhnModelReq {

  @Schema(description = "List Integer")
  @JsonProperty("arr_int")
  private List<Integer> arrInt;

}
