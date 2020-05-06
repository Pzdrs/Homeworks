package sample;

public enum InequalitySymbol {
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_OR_EQUAL_TO,
    LESS_THAN_OR_EQUAL_TO;

    public static InequalitySymbol getInequalitySymbol(String string) {
        switch (string) {
            case ">":
                return GREATER_THAN;
            case "<":
                return LESS_THAN;
            case ">=":
                return GREATER_THAN_OR_EQUAL_TO;
            case "<=":
                return LESS_THAN_OR_EQUAL_TO;
        }
        return null;
    }

    public static Interval.ParenthesisType getParenthasisType(InequalitySymbol inequalitySymbol) {
        return inequalitySymbol == InequalitySymbol.GREATER_THAN_OR_EQUAL_TO || inequalitySymbol == InequalitySymbol.LESS_THAN_OR_EQUAL_TO ? Interval.ParenthesisType.CLOSED : Interval.ParenthesisType.OPENED;
    }
}
