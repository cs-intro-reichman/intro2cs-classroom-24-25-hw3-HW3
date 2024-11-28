// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		// System.out.println(plus(6, -5)); // 2 + 3
		// System.out.println(minus(7, 2)); // 7 - 2
		// System.out.println(minus(2, 7)); // 2 - 7
		// System.out.println(times(-3, -4)); // 3 * 4
		// System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		// System.out.println(pow(-2, 2)); // 5^3
		// System.out.println(pow(3, 5)); // 3^5
		// System.out.println(div(0, 3)); // 12 / 3
		// System.out.println(div(12, 3)); // 5 / 5
		// System.out.println(div(25, 7)); // 25 / 7
		// System.out.println(mod(25, 7)); // 25 % 7
		// System.out.println(mod(120, 6)); // 120 % 6
		// System.out.println(sqrt(36));
		// System.out.println(sqrt(263169));
		// System.out.println(sqrt(76123));
	}

	public static int plus(int x1, int x2) {
		// Replace the following statement with your code

		if (x2 < 0) {
			int Z = Math.abs(x2);
			for (int i = 0; i < Z; i++) {
				x1--;
			}
			return x1;
		}

		else {
			for (int i = 0; i < x2; i++) {
				x1++;
			}
			return x1;
		}

	}

	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				x1--;
			}
			return x1;
		}

		else {
			int z = Math.abs(x2);
			for (int i = 0; i < z; i++) {
				x1++;
			}
			return x1;
		}
	}

	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int times = 0;
		while (x1 != 0 && x2 != 0) {

			if (x1 > 0 && x2 < 0) {
				for (int i = 0; i < x1; i++) {
					times += x2;
				}
				return times;
			}
			if (x1 < 0 && x2 > 0) {
				for (int i = 0; i < x2; i++) {
					times += x1;
				}
				return times;
			}
			if (x1 < 0 && x2 < 0) {
				x1 = -(x1);
				x2 = -(x2);
				for (int i = 0; i < x2; i++) {
					for (int j = 0; j < x1; j++) {
						times++;
					}

				}
				return times;
			} else {
				for (int i = 0; i < x2; i++) {
					for (int j = 0; j < x1; j++) {
						times++;
					}

				}
				return times;
			}
		}
		return times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for (int i = 0; i < n; i++) {
			pow = times(pow, x);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int counter = 0;
		int mark;
		mark = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0) ? -1 : 1;
		if (x1 < 0) {
			x1 = times(x1, -1);
		}
		if (x2 < 0) {
			x2 = times(x2, -1);
		}
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			counter = plus(counter, 1);
		}

		return times(counter, mark);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int mark = 1;
		if (x1 < 0) {
			mark = -1;
			x1 = times(x1, -1);
		}
		if (x2 < 0) {
			x2 = times(x2, -1);
		}

		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}

		return times(x1, mark);
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int L = 1;
		int H = x;
		int sum = 0;

		if (x == 0 || x == 1) {
			return x;
		}

		while (L <= H) {
			int mid = L + (H - L) / 2;

			if (mid * mid == x) {
				return mid;
			} else if (mid * mid < x) {
				L = mid + 1;
				sum = mid;
			} else {
				H = mid - 1;
			}

		}
		return sum;
	}
}
