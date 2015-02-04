/*
 Power Digit Counts was a problem from the Hackerrank contest: 
https://www.hackerrank.com/contests
under euler's problems without any timelimit.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PowerfulDigitCounts
{
    class Program
    {
        public static List<long> powerfulDigitCounts(int inp)
        {
            List<long> myList = new List<long>();
            for (int i = 1; i < 10; i++)
            {
                long num = (long)Math.Pow(i, inp);
                if (num.ToString().Length == inp)
                    myList.Add(num);
            }
            return myList;
        }

        static void Main(string[] args)
        {
            int t = Convert.ToInt32(Console.ReadLine());
            int val1;
            List<long> res;
            for (int i = 0; i < t; i++)
            {
                String elements = Console.ReadLine();
                val1 = Convert.ToInt32(elements);
                res = powerfulDigitCounts(val1);
                if (res.Count > 0)
                {
                    for (int j = 0; j < res.Count; j++)
                        Console.WriteLine(res[j]);
                }
                else Console.WriteLine("No Output");
            } Console.ReadKey();
        }
    }
}