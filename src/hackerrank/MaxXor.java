public class MaxXor{
static int maxXor(int l, int r)
	        {
		            int res=0;
			                for (int i = l; i <= r; i++)
					            {
						                    for (int j = l; j <= r; j++)
								                    {
										                        if ((i ^ j) > res)
													                        res = i ^ j;
																                }
																		            }
																			                return res;
																					        }

																						        static void Main(String[] args)
																							        {
																								            int res;
																									                int _l;
																											            _l = Convert.ToInt32(Console.ReadLine());

																												                int _r;
																														            _r = Convert.ToInt32(Console.ReadLine());

																															                res = maxXor(_l, _r);
																																	            Console.WriteLine(res);
																																		                Console.ReadKey();
																																				        }
																																					}
