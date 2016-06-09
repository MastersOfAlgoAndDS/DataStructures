
public class ExceptionTest1 extends ExceptionTest0{
	public static void main(String[] args) {
		try{
			throw new ExceptionTest1();
		}catch(ExceptionTest0 e0){
			System.out.println("E0 occurred");
		} catch (Exception e) {
			System.out.println("Exception occurred");
		}
	}
}
