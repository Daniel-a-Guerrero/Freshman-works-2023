
	import java.lang.Math;
   public class IntAlgo {
	/**
	 * Implement algorithm 5.1.8. Check if a number is prime by checking if any integer n (between 2 and the square root of n) is a divisor.   
	 * @param p - prime to check
	 * @return 1 if p is prime. If p not prime, return p's first non trivial divisor. in example isPrime(12) returns 2
	 */
	public static int isPrime (int p) {
		for(int i=2;i<=Math.sqrt(p);i++)
      {
         if(p%i==0)
            return i;
      }
		return 1;
	}
	
	/**
	 * Implement algorithm 5.3.3 - iterative Euclidean algorithm
	 * @param a - first positive integer
	 * @param b - second positive integer
	 * @return gcd(a,b)
	 */
	public static int gcd(int a, int b) {
   if(b>a)
      return gcdr(b,a);
   int r=a%b;
   while(r!=0)
   {
      a=b;
      b=r;
      r=a%b;
   }
   return b;
	}

	/**
	 * Implement algorithm 5.3.9 - recursive Euclidean algorithm
	 * @param a - first positive integer
	 * @param b - second positive integer
	 * @return gcd(a,b)
	 */
	public static int gcdr(int a, int b) {
		//TO DO, r=a%b;if(r!=0), return gcd(b,r)
      if(b>a)
         return gcdr(b,a);
      int r=a%b;
      if(r!=0)
         return gcd(b,r);
      else
         return b;
	}
	
	public static void main(String[] args) {
		// isPrime
		System.out.println(isPrime(12)); // return 2
		System.out.println(isPrime(223)); // return 1
		System.out.println(isPrime(49)); // return 7
		//gcd
		System.out.println(gcd(27,10)); // return 1
		System.out.println(gcd(105,55)); // return 5
		System.out.println(gcd(40,300)); // return 20
		//gcdr
		System.out.println(gcdr(27,10)); // return 1
		System.out.println(gcdr(105,55)); // return 5
		System.out.println(gcdr(40,300)); // return 20

	}

}
