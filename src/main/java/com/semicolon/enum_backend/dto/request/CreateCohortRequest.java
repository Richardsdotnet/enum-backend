package com.semicolon.enum_backend.dto.request;

import com.semicolon.enum_backend.models.Program;
import lombok.*;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class CreateCohortRequest {
    private String name;
    private String Description;
    private String program;
    private String startDate;
    private String endDate;
}
