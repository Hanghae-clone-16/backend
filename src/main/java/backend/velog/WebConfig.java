package backend.velog;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:8888")
                .allowedOrigins("http://jeongjoolee.shop.s3-website.ap-northeast-2.amazonaws.com/")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}
