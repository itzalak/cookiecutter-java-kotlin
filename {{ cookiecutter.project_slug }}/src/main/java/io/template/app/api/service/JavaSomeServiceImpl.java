package io.template.app.api.service;

import org.springframework.stereotype.Service;

@Service
public class JavaSomeServiceImpl implements JavaSomeService {
    @Override
    public String someMethodReturningString() {
        return "Successful";
    }
}
