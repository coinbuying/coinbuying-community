package coinbuying.community.config;

import coinbuying.community.handler.PostHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
@EnableWebFlux // WebFlux 설정 활성화
public class WebFluxRouterConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> boardsRouterBuilder(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/boards", builder -> builder
                        .GET("/{boardType}", postHandler::getPostsByBoardType)
                        .GET("/{boardType}/{postType}", postHandler::getPostsByBoardTypeAndPostType)
                ).build();
    }

    @Bean
    public RouterFunction<ServerResponse> postsRouterBuilder(PostHandler postHandler) {
        return RouterFunctions.route()
                .path("/posts", builder -> builder
                        .POST("/write", accept(MediaType.APPLICATION_JSON), postHandler::postsRegistration)
                        .PUT("/write", accept(MediaType.APPLICATION_JSON), postHandler::postsModify)
                        .POST("/showYn", accept(MediaType.APPLICATION_JSON), postHandler::modifyPostsShowYn)
                        .GET("/content/{postId}", postHandler::findContent)
                        .GET("/favorites", postHandler::getFavorites)
                        //.GET("/file", postHandler::downloadFile)

                ).build();
    }

}
