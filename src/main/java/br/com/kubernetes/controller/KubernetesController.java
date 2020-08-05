package br.com.kubernetes.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@AllArgsConstructor
public class KubernetesController {

    private final Environment environment;

    @GetMapping("/")
    public String helloKubernetes(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            String port = environment.getProperty("local.server.port");

            return "Hello Kubernetes from address:" + inetAddress.getHostAddress() + ":"+ port +
                    " hostname: " + inetAddress.getHostName() +" :)";
        } catch (UnknownHostException e) {
            return "Cannot get HostAddress :(";
        }
    }
}
