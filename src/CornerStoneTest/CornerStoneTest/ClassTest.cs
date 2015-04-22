using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CornerStoneTest;

namespace CodingChallengeCS
{
    /// <summary>
    /// This question requires you to model basic classes for and class relations between "User", "Student", "Staff", and "Professor" entities, along with GetId() and GetName() methods. 
    /// </summary>
    [TestClass]
    public class ClassTest
    {
        public const int basicId = 12345;
        public const int studentId = 99999;
        public const int hoursWorkedWeekly = 34;
        public const string sampleName = "Ada Lovelace";

        [TestMethod]
        public void StaffIsInitializedCorrectly()
        {
            var staff = new Staff(sampleName, basicId, hoursWorkedWeekly);

            Assert.AreEqual(sampleName, staff.GetName());
            Assert.AreEqual(basicId, staff.GetId());
            Assert.AreEqual(hoursWorkedWeekly, staff.GetHoursWorkedWeekly());

        }
        [TestMethod]
        public void StudentIsInitializedCorrectly()
        {
            User student = new Student(sampleName, basicId, studentId);
            Assert.AreEqual(sampleName, student.GetName());
            Assert.AreEqual(basicId, student.GetId());
           Assert.AreEqual(studentId, ((Student)student).GetId());
        }
        [TestMethod]
        public void ProfessorIsInitializedCorrectly()
        {
            bool hasPhd = true;
            var professor = new Professor(sampleName, basicId, hasPhd);
            Assert.AreEqual("Dr. " + sampleName, professor.GetName());
            Assert.AreEqual(basicId, professor.GetId());

            var lessSuccessfulProfessor = new Professor(sampleName, basicId, !hasPhd);
            Assert.AreEqual(sampleName, lessSuccessfulProfessor.GetName());
            Assert.AreEqual(basicId, lessSuccessfulProfessor.GetId());

        }
        
    }
}
