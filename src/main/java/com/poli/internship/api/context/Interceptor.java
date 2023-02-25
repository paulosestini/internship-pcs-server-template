package com.poli.internship.api.context;

import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Interceptor implements WebGraphQlInterceptor {

    @Override
    public Mono<WebGraphQlResponse> intercept (WebGraphQlRequest request, Chain chain) {
        request.configureExecutionInput(((executionInput, builder) -> {
            Map<String, Object> map = new HashMap<>();
            String auth = Objects.requireNonNull(request.getHeaders().get("Authorization")).get(0);
            // Here you can extract info from the token
            //
            // 1) If the token is decryptable:
            // String userId = SomeCryptoService.verify(auth).get("id");
            //
            // 2) If the token can be used to retrieve data from elsewhere (like google):
            // String userId = SomeGoogleService.getData(auth).get("id");
            //
            // Then it can be added to the context
            // map.put("userId", userId);
            //
            // Now you will be able to retrieve it in the queries and mutations
            // Just add "GraphQLContext ctx" as an argument to the query,
            // then retrieve the data:
            // String userId = ctx.get("userId");
            return builder.graphQLContext(map).build();
        }));

        return chain.next(request);
    }
}
