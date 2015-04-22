using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CornerStoneTest
{
    class User
    {
        protected string sampleName;
        protected int basicId;

        public string GetName()
        {
            return sampleName;
        }

        public int GetId()
        {
            return basicId;
        }

    }

    class Staff : User
    {
        private int hoursWorkedWeekly;

        public Staff(string sampleName, int basicId, int hoursWorkedWeekly)
        {
            this.sampleName = sampleName;
            this.basicId = basicId;
            this.hoursWorkedWeekly = hoursWorkedWeekly;
        }

        public int GetHoursWorkedWeekly()
        {
            return hoursWorkedWeekly;
        }
    }

    class Student : User
    {
        private int studentId;

        public Student(string sampleName, int basicId, int studentId)
        {
            this.sampleName = sampleName;
            this.basicId = basicId;
            this.studentId = studentId;
        }

        new public int GetId()
        {
            return studentId;
        }
    }

    class Professor : User
    {
        private bool hasPhd;

        public Professor(string sampleName, int basicId, bool hasPhd)
        {
            this.sampleName = sampleName;
            this.basicId = basicId;
            this.hasPhd = hasPhd;
        }

        new public string GetName()
        {
            if(hasPhd)
            return "Dr. " + sampleName;
            return sampleName;
        }
    }
}
