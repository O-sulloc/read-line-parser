package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");

        return new Hospital(splitted[0],splitted[1],splitted[2],Integer.parseInt(splitted[6]),splitted[4],splitted[5]);
    }

    @Override
    public Hospital parse(String str, String address) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");

        return new Hospital(splitted[0], splitted[1]);
    }

}
