package InterviewBit.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        new MergeOverlappingIntervals().merge(intervals).forEach(i -> {
            System.out.println(i.start + " " + i.end);
        });
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        intervals.sort(Comparator.comparingInt(i -> i.start));

        Stack<Interval> stack = new Stack<>();
        Stack<Interval> newStack = new Stack<>();
        ArrayList<Interval> result = new ArrayList<>();


        stack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            boolean overlap = checkIfOverlap(stack.peek(), intervals.get(i));
            if (overlap) {
                Interval temp = mergeIntervals(stack.peek(), intervals.get(i));
                stack.pop();
                stack.push(temp);
            } else {
                stack.push(intervals.get(i));
            }
        }

        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }

        while (!newStack.isEmpty()) {
            result.add(newStack.pop());
        }

        return result;
    }

    private Interval mergeIntervals(Interval peek, Interval newInterval) {

        int smallest = peek.start < newInterval.start ? peek.start : newInterval.start;
        int largest = peek.end > newInterval.end ? peek.end : newInterval.end;

        Interval temp = new Interval(smallest, largest);
        return temp;
    }

    private boolean checkIfOverlap(Interval peek, Interval newInterval) {

        if (newInterval.start >= peek.start && newInterval.start <= peek.end)
            return true;
        if (peek.start >= newInterval.start && peek.start <= newInterval.end)
            return true;
        return false;
    }

}
