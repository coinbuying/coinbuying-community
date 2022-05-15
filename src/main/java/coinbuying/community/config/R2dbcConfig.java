package coinbuying.community.config;

import coinbuying.community.model.PostFactory;
import coinbuying.community.repository.PostRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class R2dbcConfig {

    private final PostFactory postFactory;

    public R2dbcConfig(PostFactory postFactory) {
        this.postFactory = postFactory;
    }

    @Bean
    public ConnectionFactoryInitializer dbInit(ConnectionFactory connectionFactory) { // 데이터베이스 초기화를 할수 있음 ConnectionFactoryInitializer
        ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
        init.setConnectionFactory(connectionFactory);
        init.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql"))); // 커넥션꺼
        return init; // r2dbc 쓸 때 이 코드만 복붙해서 쓰면됨

    }

    @Bean
    public CommandLineRunner dataInit(PostRepository postRepository) { // ioc에서 해당하는 customerRepository 주입이 된다.
        return (args) -> { // run 함수
            // 데이터 초기화
            postRepository.saveAll(
                    postFactory.setupListBuilder()
            ).blockLast(); // 끝인걸 알려줘야함
        };
    }


}
