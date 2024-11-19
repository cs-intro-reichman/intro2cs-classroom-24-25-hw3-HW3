import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class TestAlgebra {
    public static void main(String[] args) {
        int totalTests = 0;
        int passedTests = 0;
        
        totalTests += 6; // plus tests
        passedTests += testPlus();
        
        totalTests += 6; // minus tests
        passedTests += testMinus();
        
        totalTests += 6; // times tests
        passedTests += testTimes();
        
        totalTests += 6; // pow tests
        passedTests += testPow();
        
        totalTests += 6; // div tests
        passedTests += testDiv();
        
        totalTests += 6; // mod tests
        passedTests += testMod();
        
        totalTests += 6; // sqrt tests
        passedTests += testSqrt();
        
        totalTests += 1; // forbidden operator tests
        passedTests += testForbiddenOperators();
        
        System.out.println("Passed " + passedTests + " out of " + totalTests + " tests");
    }

    private static int testPlus() {
        if (Algebra.plus(2, 3) != 5) return 0;
        if (Algebra.plus(0, 0) != 0) return 0;
        if (Algebra.plus(-1, 1) != 0) return 0;
        if (Algebra.plus(100, 200) != 300) return 0;
        if (Algebra.plus(-5, -3) != -8) return 0;
        if (Algebra.plus(Integer.MAX_VALUE - 1, 1) != Integer.MAX_VALUE) return 0;
        return 1;
    }

    private static int testMinus() {
        if (Algebra.minus(7, 2) != 5) return 0;
        if (Algebra.minus(2, 7) != -5) return 0;
        if (Algebra.minus(0, 0) != 0) return 0;
        if (Algebra.minus(100, 50) != 50) return 0;
        if (Algebra.minus(-5, -3) != -2) return 0;
        if (Algebra.minus(Integer.MIN_VALUE + 1, 1) != Integer.MIN_VALUE) return 0;
        return 1;
    }

    private static int testTimes() {
        if (Algebra.times(3, 4) != 12) return 0;
        if (Algebra.times(0, 5) != 0) return 0;
        if (Algebra.times(-2, 3) != -6) return 0;
        if (Algebra.times(-2, -3) != 6) return 0;
        if (Algebra.times(100, 0) != 0) return 0;
        if (Algebra.times(1, 1) != 1) return 0;
        return 1;
    }

    private static int testPow() {
        if (Algebra.pow(5, 3) != 125) return 0;
        if (Algebra.pow(2, 0) != 1) return 0;
        if (Algebra.pow(0, 5) != 0) return 0;
        if (Algebra.pow(1, 10) != 1) return 0;
        if (Algebra.pow(2, 4) != 16) return 0;
        if (Algebra.pow(-2, 3) != -8) return 0;
        return 1;
    }

    private static int testDiv() {
        if (Algebra.div(12, 3) != 4) return 0;
        if (Algebra.div(25, 7) != 3) return 0;
        if (Algebra.div(0, 5) != 0) return 0;
        if (Algebra.div(100, 10) != 10) return 0;
        if (Algebra.div(-15, 3) != -5) return 0;
        if (Algebra.div(-15, -3) != 5) return 0;
        return 1;
    }

    private static int testMod() {
        if (Algebra.mod(25, 7) != 4) return 0;
        if (Algebra.mod(120, 6) != 0) return 0;
        if (Algebra.mod(0, 5) != 0) return 0;
        if (Algebra.mod(7, 3) != 1) return 0;
        if (Algebra.mod(17, 5) != 2) return 0;
        if (Algebra.mod(100, 10) != 0) return 0;
        return 1;
    }

    private static int testSqrt() {
        if (Algebra.sqrt(36) != 6) return 0;
        if (Algebra.sqrt(0) != 0) return 0;
        if (Algebra.sqrt(1) != 1) return 0;
        if (Algebra.sqrt(263169) != 513) return 0;
        if (Algebra.sqrt(76123) != 275) return 0;
        if (Algebra.sqrt(10000) != 100) return 0;
        return 1;
    }

    private static int testForbiddenOperators() {
        try {
            String algebraCode = new String(Files.readAllBytes(Paths.get("Algebra.java")));
            // Remove strings and comments to avoid false positives
            algebraCode = algebraCode.replaceAll("\".*\"", "")
                                   .replaceAll("/\\*.*?\\*/", "")
                                   .replaceAll("//.*", "");
            
            String[] forbidden = {
                "\\+[^+]", // + but not ++
                "-[^-]",   // - but not --
                "\\*",     // *
                "/",       // /
                "%",       // %
                "Math\\.pow",
                "Math\\.sqrt"
            };

            for (String operator : forbidden) {
                if (algebraCode.matches(".*" + operator + ".*")) {
                    System.out.println("Found forbidden operator matching: " + operator);
                    return 0;
                }
            }
            return 1;
        } catch (IOException e) {
            System.out.println("Could not read Algebra.java");
            return 0;
        }
    }
} 