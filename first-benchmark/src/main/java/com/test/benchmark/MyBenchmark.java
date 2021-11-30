package com.test.benchmark;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1)
public class MyBenchmark {
    @Param({"", "somePathNoDoT", "some.Path.With.Dot"})
    String value;

    @Benchmark
    public String stringReplace() {
        return value.replace(".", "/");
    }

    @Benchmark
    public String replaceApache() {
        return StringUtils.replace(value, ".", "/");
    }
}