package com.example.java.lambda.streamtests;

import java.util.concurrent.ThreadPoolExecutor;

public class PoolWorkload {

    ThreadPoolExecutor threadPoolExecutor;

    public PoolWorkload() {
        //threadPoolExecutor = new ThreadPoolExecutor();
    }

    public static void main(String[] args) {
        new PoolWorkload();
    }

}
