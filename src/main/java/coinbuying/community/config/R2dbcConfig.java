package coinbuying.community.config;

import coinbuying.community.model.BoardFactory;
import coinbuying.community.repository.BoardRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
public class R2dbcConfig {

    private final BoardFactory boardFactory;

    public R2dbcConfig(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    @Bean
    public ConnectionFactoryInitializer dbInit(ConnectionFactory connectionFactory) { // 데이터베이스 초기화를 할수 있음 ConnectionFactoryInitializer
        ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
        init.setConnectionFactory(connectionFactory);
        init.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql"))); // 커넥션꺼
        return init; // r2dbc 쓸 때 이 코드만 복붙해서 쓰면됨

    }

    @Bean
    public CommandLineRunner dataInit(BoardRepository boardRepository) { // ioc에서 해당하는 customerRepository 주입이 된다.
        return (args) -> { // run 함수
            // 데이터 초기화
            boardRepository.saveAll(
                    boardFactory.setupListBuilder()
            ).blockLast(); // 끝인걸 알려줘야함
        };
    }


}
