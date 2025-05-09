package com.vividhdarote.journalismApp.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import com.vividhdarote.journalismApp.entity.User;

import java.util.stream.Stream;

import static org.springframework.security.core.userdetails.User.*;

public class UserArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(User.builder().userName("Vishnu").password("123").build()),
                Arguments.of(User.builder().userName("Vividh").password("123").build())
        );
    }
}
