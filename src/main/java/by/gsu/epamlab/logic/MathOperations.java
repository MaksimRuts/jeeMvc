package by.gsu.epamlab.logic;

public enum MathOperations {
    SUM {
        @Override
        void init() {
            value = 0;
        }

        @Override
        void setNext(double arg) {
            value += arg;
        }
    },

    MIN {
        @Override
        void init() {
            value = Double.MAX_VALUE;
        }

        @Override
        void setNext(double arg) {
            if (value > arg) {
                value = arg;
            }
        }
    },

    MAX {
        @Override
        void init() {
            value = Double.MIN_VALUE;
        }

        @Override
        void setNext(double arg) {
            if (value < arg) {
                value = arg;
            }
        }
    },

    AVG {
        private int count;

        @Override
        void init() {
            value = 0;
            count = 0;
        }

        @Override
        void setNext(double arg) {
            value += arg;
            count++;
        }

        @Override
        double result() {
            return value / count;
        }
    };

    protected double value;

    abstract void init();
    abstract void setNext(double arg);
    double result() {
        return value;
    }
}
