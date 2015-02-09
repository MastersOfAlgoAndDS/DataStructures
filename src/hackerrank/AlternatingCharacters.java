public class AlternatingCharacters{
    public static int alternatingCharacters(String inp){
    		    int cnt=0;
		    		    char[] a = inp.ToCharArray();
				    		    char character=a[0];
						                for (int i = 1; i < a.Length; i++)
								            {
									    			    if(character==a[i])
												    				    cnt++;
																    			    character=a[i];
																			    		    }
																					    		    return cnt;
																							            }

																								            static void Main(string[] args)
																									            {
																										                int t = Convert.ToInt32(Console.ReadLine());
																												            String val1;
																													                int res;
																															            for (int i = 0; i < t; i++)
																																                {
																																		                String elements = Console.ReadLine();
																																				                val1 = elements;
																																						                res = alternatingCharacters(val1);
																																								                Console.WriteLine(res);
																																										            } Console.ReadKey();
																																											            }

}

