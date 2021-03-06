package com.learning.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by amits on 14/09/16.
 */
@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
@ToString

@Getter
@Setter
@Entity
@Table(name = "app_event_notice")
public class Notice extends BaseEntity {

    private NoticeType type;
    private String message;
}
