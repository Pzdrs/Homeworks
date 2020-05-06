package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {
    private Controller controller;
    private int a, b, c;
    private InequalitySymbol inequality;
    private double discriminant;
    private List<Double> roots;
    private List<Interval> intervals;
    public List<String> solution;

    public Solver(Controller controller, int a, int b, int c, String symbol) {
        this.controller = controller;
        this.a = a;
        this.b = b;
        this.c = c;
        this.inequality = InequalitySymbol.getInequalitySymbol(symbol);
        this.intervals = new ArrayList<>();
        this.roots = new ArrayList<>();
        this.solution = new ArrayList<>();
    }


    public void solve() {
        discriminant = Math.pow(b, 2) - 4 * a * c;
        calculateRoots();
        calculateIntervals();
        printResults();
    }

    private void calculateRoots() {
        if (getSolutionsCount() == 1) {
            roots.add(new Double((-b - Math.sqrt(discriminant)) / (2 * a)));
        } else if (getSolutionsCount() == 2) {
            roots.add(new Double((-b - Math.sqrt(discriminant)) / (2 * a)));
            roots.add(new Double((-b + Math.sqrt(discriminant)) / (2 * a)));
        }
        Collections.sort(roots);
    }

    private void calculateIntervals() {
        if (getSolutionsCount() == 1) {
            intervals.add(new Interval(Interval.ParenthesisType.OPENED, Double.NEGATIVE_INFINITY, roots.get(0), InequalitySymbol.getParenthasisType(inequality)));
            intervals.add(new Interval(InequalitySymbol.getParenthasisType(inequality), roots.get(0), Double.POSITIVE_INFINITY, Interval.ParenthesisType.OPENED));
        } else if (getSolutionsCount() == 2) {
            intervals.add(new Interval(Interval.ParenthesisType.OPENED, Double.NEGATIVE_INFINITY, roots.get(0), InequalitySymbol.getParenthasisType(inequality)));
            intervals.add(new Interval(InequalitySymbol.getParenthasisType(inequality), roots.get(0), roots.get(1), InequalitySymbol.getParenthasisType(inequality)));
            intervals.add(new Interval(InequalitySymbol.getParenthasisType(inequality), roots.get(1), Double.POSITIVE_INFINITY, Interval.ParenthesisType.OPENED));
        }
    }

    private int getSolutionsCount() {
        if (discriminant < 0) {
            return 0;
        } else if (discriminant > 0) {
            return 2;
        } else {
            return 1;
        }
    }

    private void printResults() {
        controller.printResults(null);
        if (getSolutionsCount() == 0) {
            solution.add("Rovnice nemá řešení v množině reálných čísel.");
            controller.printResults(solution);
            return;
        }
        solution.add("Kvadr. člen: " + a + " | " + "Lin. člen: " + b + " | " + "Abs. člen: " + c);
        solution.add("Diskriminant: " + discriminant);
        solution.add("Počet kořenů(řešení): " + getSolutionsCount());
        roots.forEach(root -> {
            solution.add("Kořen #" + (roots.indexOf(root) + 1) + ": " + root.toString());
        });
        solution.add("Intervaly pro které nerovnice platí:");
        intervals.forEach(interval -> {
            double random = interval.getRandom();
            switch (inequality) {
                case LESS_THAN:
                    if (a * random * random + b * random + c < 0) {
                        solution.add(interval.toString());
                    }
                    break;
                case GREATER_THAN:
                    if (a * random * random + b * random + c > 0) {
                        solution.add(interval.toString());
                    }
                    break;
                case LESS_THAN_OR_EQUAL_TO:
                    if (a * random * random + b * random + c <= 0) {
                        solution.add(interval.toString());
                    }
                    break;
                case GREATER_THAN_OR_EQUAL_TO:
                    if (a * random * random + b * random + c >= 0) {
                        solution.add(interval.toString());
                    }
                    break;
            }
        });

        controller.printResults(solution);
    }
}
