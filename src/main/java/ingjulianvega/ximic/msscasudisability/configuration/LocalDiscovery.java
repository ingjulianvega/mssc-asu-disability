package ingjulianvega.ximic.msscasudisability.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@EnableDiscoveryClient
public class LocalDiscovery {
}
