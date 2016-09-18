package com.learning.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by amits on 15/09/16.
 */
@ToString
@NoArgsConstructor
@Getter
@Setter
public class RestResponse {

    private String accountIdentifier;
    private ResponseErrorCode errorCode;
    private String message;
    private boolean success;

}
