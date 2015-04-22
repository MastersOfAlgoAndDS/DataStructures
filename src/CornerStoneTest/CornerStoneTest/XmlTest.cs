using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using CornerStoneTest;

namespace CodingChallengeCS
{
    [TestClass]
    public class XmlTest
    {
        public const string pathToXml = "SampleBookData.xml";
       //This question requires you to load an XML file from a given path, parse it, and return basic information about its contents.
        //Note that sample XML data can be found in "SampleBookData.xml".
        //For all of the following functions, elements must be returned in the order in which they first appear in the XML document.
        [TestMethod]
        public void ListOfBookTitlesCanBeRetrieved()
        {
            var xmlSolution = new XmlSolution(pathToXml);
            var expected = new List<String>() { "The Gorgias", "The Autobiography of Benjamin Franklin", "The Confidence Man", "Oryx and Crake", "The Republic" };
            CollectionAssert.AreEqual(xmlSolution.GetAllBookTitles(), expected);
        }

        [TestMethod]
        public void MostExpensiveBooksCanBeRetrieved()
        {
            var xmlSolution = new XmlSolution(pathToXml);
            var expected = new List<string>() { "The Confidence Man", "Oryx and Crake" };
            CollectionAssert.AreEqual(xmlSolution.GetMostExpensiveTitles(), expected);
        }

        [TestMethod]
        public void ListOfAllAuthorsCanBeRetrieved()
        {

            var xmlSolution = new XmlSolution(pathToXml);
            var expected = new List<string>() { "Plato", "Benjamin Franklin", "Herman Melville", "Margaret Atwood"};
            CollectionAssert.AreEqual(xmlSolution.GetAllAuthorsInStock(), expected);
        }
    }
}
