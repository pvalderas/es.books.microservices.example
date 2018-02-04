package application.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonConfigurator {
	
	@Bean
	public IRule ribbonRule(){
		//return new RetryRule(new WeightedResponseTimeRule(), 500);
		return new RoundRobinRule();
	}

}
