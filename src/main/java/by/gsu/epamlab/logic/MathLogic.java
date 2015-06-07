package by.gsu.epamlab.logic;

public class MathLogic {
    public static double executeOperation(double[] arr, MathOperations op) {
        op.init();
        for (double d : arr) {
            op.setNext(d);
        }
        return op.result();
    }
}
