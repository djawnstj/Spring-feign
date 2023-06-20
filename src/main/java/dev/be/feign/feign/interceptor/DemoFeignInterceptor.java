package dev.be.feign.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        // GET 요청일 경우
        if (template.method() == Request.HttpMethod.GET.name()) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries());
            return;
        }

        // POST 요청일 경
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedRequestBody);

        String convertRequestBody = encodedRequestBody;

        template.body(convertRequestBody);

    }
}
