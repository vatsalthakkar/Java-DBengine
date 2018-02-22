
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.*;
/**
 * 
 */

/**
 * @author Vatsal
 *
 */
class Testcase {

	String qry="select id,win_by_runs,season,winner from ipl.csv where id<10";
	DataProcess testDP=null;
	@BeforeEach
	void befEach() {
		testDP=new DataProcess();
		testDP.setQry("select id,win_by_runs,season,winner from ipl.csv where id<10");
	}
	@Test
	void testGetWords(){
		
		String qry=testDP.getQry();
		String [] exp = qry.split(" ");
		
		Assert.assertArrayEquals( exp, testDP.getWords() );
	}
	@Test
	void testGetFileName() {
		ArrayList<String> actual=testDP.getFileName(qry.split(" "));
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("ipl.csv");
		Assert.assertEquals(exp, actual);
	}
	@Test
	void testGetBase() {
		String actual=testDP.getBase(qry.split(" "));
		String exp="select id,win_by_runs,season,winner from ipl.csv ";
		Assert.assertEquals(exp, actual);
	}
	@Test
	void testGetFilter() {
		String actual=testDP.getFilter(qry.split(" "));
		String exp="id<10 ";
		Assert.assertEquals(exp, actual);
	}
	ArrayList<String> logOp = new ArrayList<String>();
	@Test 
	void testGetConditions(){
		ArrayList<String> actual=testDP.getConditions(testDP.getFilter(qry.split(" ")),logOp);
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("id<10");
		Assert.assertEquals(exp, actual);
	}
	@Test
	void testLogOps() {
		ArrayList<String> exp=new ArrayList<String>();
		Assert.assertEquals(exp,logOp);
	}
	@Test
	void testGetSelectedFields() {
		ArrayList<String> actual=testDP.getSelectedFields(testDP.getBase(qry.split(" ")));
		ArrayList<String> exp=new ArrayList<String>();
		exp.add("id");
		exp.add("win_by_runs");
		exp.add("season");
		exp.add("winner");
		Assert.assertEquals(exp, actual);
	}
	@Test
	void testGetGroupBy() {
		String actual=testDP.getGroupby(testDP.getBase(qry.split(" ")));
		String exp="";
		Assert.assertEquals(exp, actual);
	}
	
	@Test
	void testGetOrderby() {
		String actual=testDP.getOrderby(testDP.getFilter(qry.split(" ")));
		String exp="";
		Assert.assertEquals(exp, actual);
	}
	@Test
	void testGetagg() {
		ArrayList<String> actual = testDP.getAgg(testDP.getBase(qry.split(" ")));
		ArrayList<String> exp = new ArrayList<String>();
		Assert.assertEquals(exp, actual);
	}

}
