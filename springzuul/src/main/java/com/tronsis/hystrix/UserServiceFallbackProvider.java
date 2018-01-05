package com.tronsis.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.MediaType;  
import org.springframework.http.client.ClientHttpResponse;  
import org.springframework.stereotype.Component;  
  
import java.io.ByteArrayInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.nio.charset.Charset;

/**
 * zuul 自带的路断器：
 * 可以看到zuul的熔断器主要目的和意义在于针对某个微服务的异常状态进行控制，并不能具体的针对某个具体的请求方法进行控制
 */
@Component  
public class UserServiceFallbackProvider implements ZuulFallbackProvider {

    /**
     *
     * @return 要监听的挂掉的微服务名字
     */
    @Override  
    public String getRoute() {  
        return "eureka-client";
    }  
  
    @Override  
    public ClientHttpResponse fallbackResponse() {  
        return new ClientHttpResponse() {  
            @Override  
            public HttpStatus getStatusCode() throws IOException {  
                return HttpStatus.OK;  
            }  
  
            @Override  
            public int getRawStatusCode() throws IOException {  
                return this.getStatusCode().value();  
            }  
  
            @Override  
            public String getStatusText() throws IOException {  
                return this.getStatusCode().getReasonPhrase();  
            }  
  
            @Override  
            public void close() {  
  
            }  
  
            @Override  
            public InputStream getBody() throws IOException {  
                return new ByteArrayInputStream("eureka-client is down !".getBytes());
            }  
  
            @Override  
            public HttpHeaders getHeaders() {  
                HttpHeaders headers = new HttpHeaders();  
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));  
                headers.setContentType(mt);  
                return headers;  
            }  
        };  
    }  
} 