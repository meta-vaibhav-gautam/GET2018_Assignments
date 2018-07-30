import static org.junit.Assert.*;

import org.junit.Test;
/*
 * class containing jUnit test methods for IntSet class methods
 * created on july 25,2018
 */
public class IntSetTest {

	//positive test for isMember() method
	@Test
	public void testIsMemberPass() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		boolean result=obj.isMember(4);
		
		assertEquals(result,true);
	}
	
	//negative test for isMember() method	@Test
	public void testIsMemberFail() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		boolean result=obj.isMember(7);
		
		assertNotEquals(result,true);
	}
	
	//positive test for size() method
	@Test
	public void testSizePass() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		int result=obj.size();
		
		assertEquals(result,6);
	}
	
	//negative test for size() method
	@Test
	public void testSizeFail() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		int result=obj.size();
		
		assertNotEquals(result,9);
	}
	
	//positive test for isSubset() method
	@Test
	public void testisSubsetPass() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		IntSet subSetObj=new IntSet();
		subSetObj.initialiseSet(new int[]{3,4,5});
		boolean result=obj.isSubset(subSetObj);
		
		assertEquals(result,true);
	}
	
	//negative test for isSubset() method
	@Test
	public void testisSubsetFail() {
		IntSet obj=new IntSet();
		obj.initialiseSet(new int[]{1,2,3,4,5,6});
		IntSet subSetObj=new IntSet();
		subSetObj.initialiseSet(new int[]{5,7});
		boolean result=obj.isSubset(subSetObj);
		
		assertNotEquals(result,true);
	}
	
	//positive test for union
	@Test
	public void testunionPass() {
		IntSet objSet1=new IntSet();
		objSet1.initialiseSet(new int[]{1,2,3,4,5,6});
		IntSet objSet2=new IntSet();
		objSet2.initialiseSet(new int[]{3,4,5,7,9});
		int result[]=objSet1.union(objSet1, objSet2);
		int expecteds[]={1,2,3,4,5,6,7,9};
		
		assertArrayEquals(expecteds, result);
	}
	

}
