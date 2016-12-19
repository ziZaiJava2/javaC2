
package test;

public class FibonacciImpl implements Fibonacci {

	@Override
	public int getFibonacci(int n) {
		if(n == 1 || n == 2){
			return 1;
		}
		return getFibonacci( n - 1) + getFibonacci(n - 2);
	}

}
