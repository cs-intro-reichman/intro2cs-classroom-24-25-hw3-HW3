public class TestAnagram {
    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        testIsAnagram();
        testPreProcess();
        testRandomAnagram();
        
        System.out.println("\nTotal tests: " + totalTests);
        System.out.println("Passed tests: " + passedTests);
        System.out.println("Success rate: " + (passedTests * 100.0 / totalTests) + "%");
    }

    public static int testIsAnagram() {
        System.out.println("\nTesting isAnagram method:");
        totalTests += 6;

        // Test case 1: Basic anagram
        boolean test1 = Anagram.isAnagram("silent", "listen");
        System.out.println("Test 1 (basic anagram): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Different lengths
        boolean test2 = !Anagram.isAnagram("hello", "world!");
        System.out.println("Test 2 (different lengths): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 3: Same letters, different counts
        boolean test3 = !Anagram.isAnagram("hello", "hello!");
        System.out.println("Test 3 (different letter counts): " + (test3 ? "PASS" : "FAIL"));
        
        // Test case 4: Empty strings
        boolean test4 = Anagram.isAnagram("", "");
        System.out.println("Test 4 (empty strings): " + (test4 ? "PASS" : "FAIL"));
        
        // Test case 5: Complex anagram with spaces
        boolean test5 = Anagram.isAnagram("William Shakespeare", "I am a weakish speller");
        System.out.println("Test 5 (complex anagram): " + (test5 ? "PASS" : "FAIL"));
        
        // Test case 6: Case sensitivity
        boolean test6 = Anagram.isAnagram("Silent", "ListeN");
        System.out.println("Test 6 (case sensitivity): " + (test6 ? "PASS" : "FAIL"));

        int passed = (test1 && test2 && test3 && test4 && test5 && test6) ? 1 : 0;
        passedTests += passed;
        return passed;
    }

    public static int testPreProcess() {
        System.out.println("\nTesting preProcess method:");
        totalTests += 4;

        // Test case 1: Remove special characters
        boolean test1 = Anagram.preProcess("What? No way!!!").equals("whatnoway");
        System.out.println("Test 1 (special chars): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Preserve spaces
        boolean test2 = Anagram.preProcess("Hello World!").equals("hello world");
        System.out.println("Test 2 (preserve spaces): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 3: Convert to lowercase
        boolean test3 = Anagram.preProcess("HeLLo").equals("hello");
        System.out.println("Test 3 (case conversion): " + (test3 ? "PASS" : "FAIL"));
        
        // Test case 4: Empty string
        boolean test4 = Anagram.preProcess("").equals("");
        System.out.println("Test 4 (empty string): " + (test4 ? "PASS" : "FAIL"));

        int passed = (test1 && test2 && test3 && test4) ? 1 : 0;
        passedTests += passed;
        return passed;
    }

    public static int testRandomAnagram() {
        System.out.println("\nTesting randomAnagram method:");
        totalTests += 3;
        
        // Test case 1: Check if result is an anagram
        String original = "hello";
        String randomized = Anagram.randomAnagram(original);
        boolean test1 = Anagram.isAnagram(original, randomized);
        System.out.println("Test 1 (is anagram): " + (test1 ? "PASS" : "FAIL"));
        
        // Test case 2: Check if same length
        boolean test2 = original.length() == randomized.length();
        System.out.println("Test 2 (same length): " + (test2 ? "PASS" : "FAIL"));
        
        // Test case 3: Check randomness (run multiple times)
        boolean foundDifferent = false;
        String first = Anagram.randomAnagram("testing");
        for (int i = 0; i < 10; i++) {
            String next = Anagram.randomAnagram("testing");
            if (!first.equals(next)) {
                foundDifferent = true;
                break;
            }
        }
        System.out.println("Test 3 (randomness): " + (foundDifferent ? "PASS" : "FAIL"));

        int passed = (test1 && test2 && foundDifferent) ? 1 : 0;
        passedTests += passed;
        return passed;
    }
} 