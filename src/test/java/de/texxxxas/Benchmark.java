package de.texxxxas;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class Benchmark {
    public static void main(String[] args) throws Exception {
        new Runner(new OptionsBuilder()
            .include(Benchmark.class.getSimpleName())
            .forks(1)
            .warmupTime(TimeValue.milliseconds(100))
            .warmupIterations(3)
            .measurementTime(TimeValue.seconds(1))
            .measurementIterations(5)
            .build()).run();
    }

    private double x = 2.0;

    @org.openjdk.jmh.annotations.Benchmark
    public double standardInvSqrt() {
        return 1.0/Math.sqrt(x);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public double fastInvSqrt() {
        return invSqrt(x);
    }

    static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x = x * (1.5d - xhalf * x * x);
        return x;
    }
}