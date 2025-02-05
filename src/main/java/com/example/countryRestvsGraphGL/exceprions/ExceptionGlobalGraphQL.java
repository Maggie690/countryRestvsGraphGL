package com.example.countryRestvsGraphGL.exceprions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class ExceptionGlobalGraphQL extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType errorType = ErrorType.INTERNAL_ERROR;
        if (ex instanceof DataIntegrityViolationException) {
            errorType = ErrorType.BAD_REQUEST;
        } else if (ex instanceof ResourceNotFoundException) {
            errorType = ErrorType.NOT_FOUND;
        }

        return GraphqlErrorBuilder.newError(env)
                .message(ex.getMessage())
                .errorType(errorType)
                .locations(null)
                .build();
    }
}
