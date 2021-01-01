package com.demo.hibernate.core.common;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;

   public ErrorResponse(ErrorCode errorCode) {
       this.errorCode = errorCode.getCode();
       this.errorMessage = errorCode.getMessage();
   }
}
