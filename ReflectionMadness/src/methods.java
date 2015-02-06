import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class methods {

	public static void main(String[] args) {
		
		Class<? super ArrayList> superclass = ArrayList.class.getSuperclass();
		
		List<Method> asList = Arrays.asList(superclass.getDeclaredMethods());
		
		int cpt = -1;
		for (Method i : asList)
		{
			System.out.println("\t\t " + ++cpt +" "  +  i);
		}
		
	     Method outOfBoundMeg = asList.get(13);
	     outOfBoundMeg.setAccessible(true);
	     try {
			Object message = outOfBoundMeg.invoke(superclass, 2);
			System.out.println(message);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
}
