package validation;



public interface Validatable {
    void checkValues(Double xValue, Double yValue, Double rValue) throws UnvalidExeption;
}
