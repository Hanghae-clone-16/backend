package backend.velog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration//설정파일이라는 것을 알려줌
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//cors를 적용할 URL패턴 정의
//                .allowedOrigins("http://localhost:8888")
                .allowedOrigins("http://localhost:9090","http://jeongjoolee.shop.s3-website.ap-northeast-2.amazonaws.com")//자원 공유 허락할 Origin 허락
                .allowedMethods("*")//허락할 HTTP method 지정
                .allowCredentials(true)
                .allowedHeaders("*");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) { // 여기서 view url을 mapping 해줄수 있음
        registry.addViewController("/home").setViewName("home"); // 앞 url : 요청, 뒤 text :url이름
        registry.addViewController("/").setViewName("home");
    }
}
