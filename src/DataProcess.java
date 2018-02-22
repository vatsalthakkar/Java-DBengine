import java.util.ArrayList;
import java.util.Arrays;


public class DataProcess {
	static String qry="select id,win_by_runs,season,winner from ipl.csv where id<10"
			+"";
	
	public  void setQry(String query) {
		qry=query;
	}
	public String getQry() {
		return qry;
	}
	ArrayList<String> selectedFields=null;
	public  void start(){
		
	
		String []  words=getWords();
		ArrayList<String> fileName=getFileName(words);
		System.out.println("Files in the query: " +fileName);
		
		String base=getBase(words);
		System.out.println("Base is: "+base);
		
		String filter=getFilter(words);
		System.out.println("Filter is: "+filter);
		
		ArrayList<String> logOp=new ArrayList<String>();
		ArrayList<String> conditions = getConditions(filter,logOp);
		System.out.println("Conditions are: "+ conditions);
		System.out.println("Logical Ops are: "+logOp);
		
		selectedFields=getSelectedFields(base);
		System.out.println("The selected fields are: "+selectedFields);
		//System.out.println(selectedFields.get(1));
		
		
		String groupBy = getGroupby(filter);
		System.out.println("Group By: "+groupBy);
		
		String orderBy = getOrderby(filter);
		System.out.println("Order By:"+orderBy);
		
		ArrayList<String> agg = getAgg(base);
		System.out.println("Aggregates functions in query are: "+agg);
	}
	public  String[] getWords() {
		
		String [] words=qry.split(" ");
		return words;
	}
	public  void printArray(String [] array) {
		int n = array.length;
		for(int i=0;i<n;i++) 
			System.out.println(array[i]);
		System.out.println();
	}
	public  ArrayList<String> getFileName(String [] words) {
		ArrayList<String> fileName=new ArrayList<String>();
		int n=words.length;
		for(int i=0;i<n;i++) {
			if(words[i].contains(".")){
				fileName.add(words[i]);
			}
		}
		return fileName;
	}
	
	public  String getBase(String [] words) {
		int n=words.length;
		String base="";
		int whrIndex=-1;
		for(int i=0;i<n;i++) {
			if(words[i].equalsIgnoreCase("where")) {
				whrIndex=i;
				for(int j=0;j<i;j++) {
					base+=words[j];
					base+=" ";
				}
			}
		}
		return base;
	}
	
	public  String getFilter(String [] words) {
		String filter="";
		int n=words.length;
		int whrIndex=-1;
		for(int i=0;i<n;i++) {
			if(words[i].equalsIgnoreCase("where")) {
				whrIndex=i;
				for(int j=i+1;j<n;j++) {
					filter+=words[j];
					filter+=" ";
				}
			}
		}
		return filter;
	}
	
	public  ArrayList<String> getConditions(String filter, ArrayList<String> logOp) {
		String [] conds=filter.split(" ");
		ArrayList<String> conditions = new ArrayList<String>();
		int n=conds.length;
		String temp="";
		for(int i=0;i<n;i++) {
			
			if(conds[i].equalsIgnoreCase("group") || conds[i].equalsIgnoreCase("order")){
				break;
			}
			
			if(!(conds[i].equalsIgnoreCase("and")) && !(conds[i].equalsIgnoreCase("or"))
					&& (!conds[i].equalsIgnoreCase("not"))) {
				temp+=conds[i];
			}
			else {
				logOp.add(conds[i]);
				conditions.add(temp);
				temp="";
			}
		}
		if(!temp.equals(" "))
			conditions.add(temp);
		return conditions;
	}
	public  ArrayList<String> getSelectedFields(String base){
		String [] temp=base.split(" ");
		if(temp.length>=0 && temp[0].equalsIgnoreCase("select")){
			String [] temp1=temp[1].split(",");
			ArrayList<String> fields= new ArrayList<String>();
			if(temp1[0].equals("*"))
				fields.add("all");
			else{
				fields.addAll(Arrays.asList(temp1));
			}
			return fields;
		}
		return null;
	}
	public  String getGroupby(String filter){
		String [] temp1 = filter.split(("(?i)group by"));
		String [] temp = null;
		if(temp1.length>1) temp = temp1[1].split((" "));
		if(temp!= null && temp.length>1)
			return temp[1];
		return "";
	}
	public  String getOrderby(String filter){
		String [] temp1 = filter.split(("(?i)order by"));
		String [] temp=null;
		if(temp1.length>1) temp = temp1[1].split((" "));
		if( temp!= null && temp.length>1)
			return temp[1];
		return "";
	}
	public ArrayList<String> getAgg(String base){
		ArrayList<String> agg = new ArrayList<String>();
		String [] temp=base.split(" ");
		if(temp.length>=0 && temp[0].equalsIgnoreCase("select")){
			String [] temp1=temp[1].split(",");
			int n =temp1.length;
			for(int i=0;i<n;i++){
				if(temp1[i].toLowerCase().contains("avg") ||
				   temp1[i].toLowerCase().contains("min") ||
				   temp1[i].toLowerCase().contains("max") ||
				   temp1[i].toLowerCase().contains("sum") ||
				   temp1[i].toLowerCase().contains("count")){
					agg.add(temp1[i]);
				}
			}
			return agg;
		}
		
		return agg;
	}
}