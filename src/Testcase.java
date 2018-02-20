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

	DataProcess testDP=null;
	@BeforeEach
	void befEach() {
		testDP=new DataProcess();
		testDP.setQry("select id,win_by_runs,season,winner from ipl.csv where id<10");
	}
	@Test
	void test1(){
		
		String qry=testDP.getQry();
		String [] exp = qry.split(" ");
		
		Assert.assertArrayEquals( exp, testDP.getWords() );
	}

}
