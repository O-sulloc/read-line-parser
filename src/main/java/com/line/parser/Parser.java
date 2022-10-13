package com.line.parser;

import com.line.domain.Hospital;

public interface Parser<T> {
    T parse(String str);

    Hospital parse(String str, String address);
}
