package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

@Getter
@Setter
@Embeddable
public class AddonInstance {
    @Column(name = "addon_instance_id")
    private String addonInstanceId;
}
