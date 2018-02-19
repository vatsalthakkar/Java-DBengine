import java.util.HashMap;

public class Data {
	int id=0,season=0,dl_applied=0,win_by_runs=0,win_by_wickets=0;
	String city="",date="",team1="",team2="",toss_winner="",toss_decision="",result="",
	winner="",player_of_match="",venue="",umpire1="",umpire2="",umpire3="";
	
	HashMap<String,Integer> hmap1= new HashMap<String,Integer>();
	HashMap<String,String> hmap2= new HashMap<String,String>();
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id=id;
		hmap1.put("id", id);
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		hmap1.put("season", season);
		this.season = season;
	}
	public int getDl_applied() {
		return dl_applied;
	}
	public void setDl_applied(int dl_applied) {
		hmap1.put("dl", dl_applied);
		this.dl_applied = dl_applied;
	}
	public int getWin_by_runs() {
		return win_by_runs;
	}
	public void setWin_by_runs(int win_by_runs) {
		hmap1.put("win_by_runs", win_by_runs);
		this.win_by_runs = win_by_runs;
	}
	public int getWin_by_wickets() {
		return win_by_wickets;
	}
	public void setWin_by_wickets(int win_by_wickets) {
		hmap1.put("win_by_wickets", win_by_wickets);
		this.win_by_wickets = win_by_wickets;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		hmap2.put("city", city);
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		hmap2.put("date", date);
		this.date = date;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		hmap2.put("team1", team1);
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		hmap2.put("team2", team2);
		this.team2 = team2;
	}
	public String getToss_winner() {
		return toss_winner;
	}
	public void setToss_winner(String toss_winner) {
		hmap2.put("toss_winner", toss_winner);
		this.toss_winner = toss_winner;
	}
	public String getToss_decision() {
		return toss_decision;
	}
	public void setToss_decision(String toss_decision) {
		hmap2.put("toss_decision", toss_decision);
		this.toss_decision = toss_decision;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		hmap2.put("result", result);
		this.result = result;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		hmap2.put("winner", winner);
		this.winner = winner;
	}
	public String getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(String player_of_match) {
		hmap2.put("player_of_match", player_of_match);
		this.player_of_match = player_of_match;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		hmap2.put("venue", venue);
		this.venue = venue;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		hmap2.put("umpire1", umpire1);
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		hmap2.put("umpire2", umpire2);
		this.umpire2 = umpire2;
	}
	public String getUmpire3() {
		return umpire3;
	}
	public void setUmpire3(String umpire3) {
		hmap2.put("umpire3", umpire3);
		this.umpire3 = umpire3;
	}
	@Override
	public String toString(){
		return "\nID="+getId()+"::Season"+getSeason()+"::City="+getCity()+"::Date="+getDate();
	}
}
