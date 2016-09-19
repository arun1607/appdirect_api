package com.learning.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class RestResponse {

    private String accountIdentifier;
    private ResponseErrorCode errorCode;
    private String message;
    private boolean success;

}
