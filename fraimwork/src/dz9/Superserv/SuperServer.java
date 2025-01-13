package dz9.Superserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableSuperServer
@SpringBootApplication
public class SuperServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(SuperServer.class);
    }
}
