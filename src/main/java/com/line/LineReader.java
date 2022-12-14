package com.line;

import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
    Parser<T> parser;

    boolean isRemoveColumnName = true; //행제목 날릴지 안 날릴지

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public LineReader(Parser<T> parser, boolean isRemoveColumnName) {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    public LineReader() {
        this.parser = parser;
        this.isRemoveColumnName = isRemoveColumnName;
    }

    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;

        if (isRemoveColumnName) {
            br.readLine();
        }

        while ((str = br.readLine()) != null) {
            result.add(parser.parse(str));
        }
        return result;
    }

//    public static void main(String[] args) throws IOException {
//        LineReader lr = new LineReader();
//
//        String filename = "/Users/jeonghyeonkim/Downloads/서울시 병의원 위치 정보.csv";
//        List<String> lines = lr.readLines(filename);
//        System.out.println(lines.size());
//    }
}
