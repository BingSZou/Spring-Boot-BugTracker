package com.mongodb.demo.service;

import com.mongodb.demo.model.Application;

public interface ApplicationService {
    Application addNewApplicationWithTemplate(Application newApplication);
    void updateApplicationWithTemplate(Application application);
}
