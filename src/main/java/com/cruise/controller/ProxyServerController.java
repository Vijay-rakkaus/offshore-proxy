package com.cruise.controller;

import com.cruise.service.ProxyServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ProxyServerController {

    @Autowired
    private ProxyServerService proxyServerService;

    @PostMapping
    public ResponseEntity<String> processRequest(@RequestBody String httpRequest) {
        return ResponseEntity.ok(proxyServerService.processHTTPRequest(httpRequest));
    }
}

