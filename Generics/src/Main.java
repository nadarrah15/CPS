
public class Main {
	
	public static void main(String args[]){
		structure.Vector strings = new structure.Vector();
		
		//non generic lets multiple items when they should be strings
		strings.add("Bubba");
		strings.add(5);
		//we could create a new vector for strings only but that would be extensive. Especially if we wanted that for every data type
		
		try{
			//throws a runtime error because the objects cannot be converted
			String str = (String) strings.get(1);
			stringMethod(str);
		} catch (Exception e){
			System.out.println(e);
		}
		
		structure5.Vector<String> genString = new structure5.Vector<String>();
		genString.add("Bubba");
		
		try{
			genString.add("Bubba");
			genString.add(5); //throws a compilation error because add(int) is not defined with generics
		} catch(Exception e){
			System.out.println(e);
		}
		
		
		stringMethod(genString.get(0));
	}
	
	static void stringMethod(String str){
		System.out.println(str);
	}
}
