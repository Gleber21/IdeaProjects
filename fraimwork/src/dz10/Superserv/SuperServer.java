package dz10.Superserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSuperServer
@SpringBootApplication
public class SuperServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(SuperServer.class);
    }
}
