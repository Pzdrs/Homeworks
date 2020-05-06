package sample;

import java.util.List;
import java.util.Random;

public class Interval {
    enum ParenthesisType {
        OPENED,
        CLOSED
    }

    public double low, high, lowUsable, highUsable;
    public ParenthesisType start, end;

    public Interval(ParenthesisType start, double low, double high, ParenthesisType end) {
        this.low = low;
        this.lowUsable = low;
        this.start = start;
        this.high = high;
        this.highUsable = high;
        this.end = end;

        if (low == Double.NEGATIVE_INFINITY)
            this.lowUsable = -Integer.MAX_VALUE;
        if (high == Double.POSITIVE_INFINITY)
            this.highUsable = Integer.MAX_VALUE;
    }

    public double getRandom() {
        return lowUsable + (highUsable - lowUsable) * new Random().nextDouble();
    }

    @Override
    public String toString() {
        return (start.equals(ParenthesisType.OPENED) ? "(" : "<") + low + "; " + high + (end.equals(ParenthesisType.OPENED) ? ")" : ">");
    }
}
