package com.icloud.refactoring._13_loop._01_replace_loop_with_pipeline;

import java.util.List;
import java.util.Objects;

public class Author {

    private final String company;

    private final String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> twitterHandles(List<Author> authors, String company) {
        return authors.stream()
                .filter(author -> author.company.equals(company))
                .map(a -> a.twitterHandle)
                .filter(Objects::nonNull)
                .toList();

    }

}
