using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace CodingChallengeCS
{
    //This question focuses on list comprehension and the implementation of two simple sorting algorithms.
    //You must write and implement the class SortingSolution based on the following unit tests.

    [TestClass]
    public class SortingTest
    {
        public static List<int> nums = new List<int>() { 1, 5, 4, 2, 3 };
        public static List<int> sortedNums = new List<int>(){ 1, 2, 3, 4, 5 };
        public SortingSolution sortingSolution;

        [TestInitialize]
        public void Init()
        {
            this.sortingSolution = new SortingSolution();
        }
        [TestMethod]
        public void NumericListCanBeSorted(){
            var sorted = sortingSolution.SortNumericList(nums);
            CollectionAssert.AreEqual(sortedNums, nums);
        }

        [TestMethod]
        public void NumericListCanBeSortedInPlace()
        {
            sortingSolution.SortNumericListInPlace(nums);
            CollectionAssert.AreEqual(sortedNums, nums);
        }
        [TestMethod]
        public void NumericListProductCanBeCalculated()
        {
            var product = sortingSolution.GetProductOfAllValues(nums);
            Assert.AreEqual(120, product);
        }
    }
}
