using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Xml;
using System.Xml.Linq;

namespace CornerStoneTest
{
    class XmlSolution
    {
        private string pathToXml;

        public XmlSolution(string pathToXml)
        {
            // TODO: Complete member initialization
            this.pathToXml = pathToXml;
        }

        public List<String> GetMostExpensiveTitles()
        {
            XElement xmldoc = XElement.Load(pathToXml);
            decimal maxPrice = decimal.MinValue;
            IEnumerable<XElement> books =
                from el in xmldoc.Descendants("book")
                select el;
            List<String> MostExpensiveTitles = new List<string>();
            foreach (XElement book in books)
            {
                decimal price = Decimal.Parse(book.Element("price").Value);
                if (price > maxPrice)
                {
                    MostExpensiveTitles = new List<string>();
                    MostExpensiveTitles.Add(book.Element("title").Value);
                    maxPrice = price;
                }
                else if (price == maxPrice)
                {
                    MostExpensiveTitles.Add(book.Element("title").Value);
                }
            }
            return MostExpensiveTitles;
        }

        public List<String> GetAllAuthorsInStock()
        {
            XElement xmldoc = XElement.Load(pathToXml);
            IEnumerable<XElement> authors =
                from el in xmldoc.Descendants("author")
                select el;
            Dictionary<String,int> Authors = new Dictionary<string,int>();
            foreach (XElement author in authors)
            {
                XElement name = author.Element("name");
                if (name == null)
                {
                    XElement firstName = author.Element("firstName");
                    XElement lastName = author.Element("lastName");
                    if (!Authors.ContainsKey(firstName.Value + " " + lastName.Value))
                        Authors.Add(firstName.Value + " " + lastName.Value, 1);
                }
                else
                {
                    if (!Authors.ContainsKey(name.Value))
                        Authors.Add(name.Value,1);
                }
            }
            return Authors.Keys.ToList();
        }

        public List<String> GetAllBookTitles()
        {
            XElement xmldoc = XElement.Load(pathToXml);
            IEnumerable<XElement> titles =
                from el in xmldoc.Descendants("title")
                select el;
            List<String> BookTitles = new List<string>();
            foreach (XElement title in titles)
            {
                BookTitles.Add(title.Value);
            }
            return BookTitles;
        }
    }
}
