package cn.riest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkTestOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkTestOneApplication.class,args);
    }
}
