import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String [] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"ipl.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		DataProcess dp=new DataProcess();
		//list for storing the data of each match
		List<Data> matchData = new ArrayList<Data>();
		String header = reader.readLine();
		String head[]=header.split(",");
		String [] intHead1=new String[] {"id","season","dl_applied","win_by_runs","win_by_wickets",};
		List<String> intHead = Arrays.asList(intHead1);
		
		String [] stringHead1= new String[]{"city","date","team1","team2","toss_winner",
						"toss_decision","result","winner","player_of_match",
						"venue","umpire1","umpire2","umpire3"};
		List<String> stringHead = Arrays.asList(stringHead1);
		//dp.printArray(head);
		//System.out.println(line);
		while ((line = reader.readLine()) != null) {
			Data match = new Data();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					match.setId(Integer.parseInt(data));
				else if (index == 1)
					match.setSeason(Integer.parseInt(data));
				else if (index == 2)
					match.setCity(data);
				else if (index == 3)
					match.setDate(data);
				else if (index == 4)
					match.setTeam1(data);
				else if (index == 5)
					match.setTeam2(data);
				else if (index == 6)
					match.setToss_winner(data);
				else if (index == 7)
					match.setToss_decision(data);
				else if (index == 8)
					match.setResult(data);
				else if (index == 9)
					match.setDl_applied(Integer.parseInt(data));
				else if (index == 10)
					match.setWinner(data);
				else if (index == 11)
					match.setWin_by_runs(Integer.parseInt(data));
				else if (index == 12)
					match.setWin_by_wickets(Integer.parseInt(data));
				else if (index == 13)
					match.setPlayer_of_match(data);
				else if (index == 14) {
					match.setVenue(data);
					index--;
				}
				else if (index ==15 )
					match.setUmpire1(data);
				else if (index == 16)
					match.setUmpire2(data);
				else if (index == 17)
					match.setUmpire3(data);
				else
					System.out.println("invalid data::" + data);
				index++;
			}
			//System.out.println(data);
			index = 0;
			matchData.add(match);
		}
		
		//close reader
		reader.close();
		dp.start();
		//System.out.println(matchData.get(0).toString());
		//List for storing logical operators
		ArrayList<String> logOp = new ArrayList<String>();
		//dp.start();
		//System.out.println(dp.getConditions(dp.getFilter(dp.getWords(dp.qry)), logOp).size());
		ArrayList<String> conds=dp.getConditions(dp.getFilter(dp.getWords()), logOp);
		int n=conds.size();
		int m=matchData.size();
		
		//System.out.println("size"+n);
		
		for(int i=0;i<n;i++){
			String [] temp = null;
			String op="";
			if(conds.get(i).contains(">")) {
				op="g";
				temp=conds.get(i).split(">");
			}
			if(conds.get(i).contains(">=")) {
				op="ge";
				temp=conds.get(i).split(">=");
			}
			if(conds.get(i).contains("<")) {
				op="l";
				temp=conds.get(i).split("<");
			}
			if(conds.get(i).contains("<=")) {
				op="le";
				temp=conds.get(i).split("<=");
			}
			int k=dp.selectedFields.size();
			for(int j=0;j<m;j++){
				if(op.equals("g")) {
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase())));
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>Integer.parseInt(temp[1]));
					if(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>Integer.parseInt(temp[1]))
					{
						
						for(int z=0;z<k;z++) {
							
							if(intHead.contains(dp.selectedFields.get(z))) {
								
								System.out.print(matchData.get(j).hmap1.get(dp.selectedFields.get(z))+" ");
							}
							if(stringHead.contains(dp.selectedFields.get(z))) {
								System.out.print(matchData.get(j).hmap2.get(dp.selectedFields.get(z))+" ");
							}
							
						}
						System.out.println();
					}
					
				}
				if(op.equals("ge")) {
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase())));
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>Integer.parseInt(temp[1]));
					if(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>=Integer.parseInt(temp[1])){
						for(int z=0;z<k;z++) {
							
							if(intHead.contains(dp.selectedFields.get(z))) {
								
								System.out.print(matchData.get(j).hmap1.get(dp.selectedFields.get(z))+" ");
							}
							if(stringHead.contains(dp.selectedFields.get(z))) {
								System.out.print(matchData.get(j).hmap2.get(dp.selectedFields.get(z))+" ");
							}
							
						}
						System.out.println();
					}
				}
				if(op.equals("l")) {
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase())));
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>Integer.parseInt(temp[1]));
					if(matchData.get(j).hmap1.get((temp[0].toLowerCase()))<Integer.parseInt(temp[1])){
						for(int z=0;z<k;z++) {
							
							if(intHead.contains(dp.selectedFields.get(z))) {
								
								System.out.print(matchData.get(j).hmap1.get(dp.selectedFields.get(z))+" ");
							}
							if(stringHead.contains(dp.selectedFields.get(z))) {
								System.out.print(matchData.get(j).hmap2.get(dp.selectedFields.get(z))+" ");
							}
							
						}
						System.out.println();
					}
				}
				if(op.equals("le")) {
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase())));
					//System.out.println(matchData.get(j).hmap1.get((temp[0].toLowerCase()))>Integer.parseInt(temp[1]));
					if(matchData.get(j).hmap1.get((temp[0].toLowerCase()))<=Integer.parseInt(temp[1])){
						for(int z=0;z<k;z++) {
							
							if(intHead.contains(dp.selectedFields.get(z))) {
								
								System.out.print(matchData.get(j).hmap1.get(dp.selectedFields.get(z))+" ");
							}
							if(stringHead.contains(dp.selectedFields.get(z))) {
								System.out.print(matchData.get(j).hmap2.get(dp.selectedFields.get(z))+" ");
							}
							
						}
						System.out.println();
					}
				}
			}
			
		}
		System.out.println(matchData.get(34).getUmpire1());
	}
}