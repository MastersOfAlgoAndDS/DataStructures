using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodingChallengeCS
{
    public class SortingSolution
    {

        internal object SortNumericList(List<int> nums)
        {
            
            throw new NotImplementedException();
        }

        internal void SortNumericListInPlace(List<int> nums)
        {
            for (int i = 0; i < nums.Count; i++)
            {
                for (int j = i + 1; j < nums.Count; j++)
                {
                    if (nums[i] > nums[j])
                    {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        internal object GetProductOfAllValues(List<int> nums)
        {
            int result = 1;
            foreach (var item in nums)
            {
                if (item == 0)
                {
                    return 0;
                }
                result = result * item;
            }
            return result;
        }
    }
}
