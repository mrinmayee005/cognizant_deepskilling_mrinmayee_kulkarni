package com.example.ems.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeEmailView {

    Long getId();

    String getName();

    String getEmail();

    @Value("#{target.name + ' <' + target.email + '>'}")
    String getDisplayLabel();
}
