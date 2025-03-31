package com.cruise.service;

import org.springframework.stereotype.Service;

@Service
public class ProxyServerService {
    public String processHTTPRequest(String httpRequest) {
        return "Message received:";
    }
}
