package lab01.tdd;

public interface SelectStrategyFactory {

    /**
     * Determines if element is even
     * @return true if the element is even
     */
    SelectStrategy createEvenStrategy();

    /**
     * Determines if element is a multiple of the given number
     * @param number the number to be checked if it's a multiple of element
     * @return true if number is a multiple of element
     */
    SelectStrategy createMultipleOfStrategy(int number);

    /**
     * Determines if element is equal to the given number
     * @param number the number to be checked if it's equal to element
     * @return true if number is equal to element
     */
    SelectStrategy createEqualsStrategy(int number);

}
