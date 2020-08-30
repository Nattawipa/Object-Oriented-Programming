//Name : Nattawipa Saetae
//ID : 6188089
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Arena {

	public enum Row {Front, Back};	//enum for specifying the front or back row
	public enum Team {A, B};		//enum for specifying team A or B
	
	private Player[][] teamA = null;	//two dimensional array representing the players of Team A
	private Player[][] teamB = null;	//two dimensional array representing the players of Team B
	private int numRowPlayers = 0;		//number of players in each row
	
	public static final int MAXROUNDS = 100;	//Max number of turn
	public static final int MAXEACHTYPE = 3;	//Max number of players of each type, in each team.
	private final Path logFile = Paths.get("battle_log.txt");
	private int numRow = 2;
	private int numRounds = 0;	//keep track of the number of rounds so far 
	private static double allSumHp;
	
	/**
	 * Constructor. 
	 * @param _numRowPlayers is the number of players in each row.
	 */
	public Arena(int _numRowPlayers)
	{	
		//INSERT YOUR CODE HERE
		this.teamA = new Player[numRow][_numRowPlayers];
		this.teamB = new Player[numRow][_numRowPlayers];
		this.numRowPlayers = _numRowPlayers;
		////Keep this block of code. You need it for initialize the log file. 
		////(You will learn how to deal with files later)
		try {
			Files.deleteIfExists(logFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////
		
	}
	
	/**
	 * Returns true if "player" is a member of "team", false otherwise.
	 * Assumption: team can be either Team.A or Team.B
	 * @param player
	 * @param team
	 * @return
	 */
	public boolean isMemberOf(Player player, Team team)     //check that it team A or team B in true or false
	{
		//INSERT YOUR CODE HERE
		if(team == Team.A) 
		{
			for(int i = 0;i<this.numRow;i++) 
			{
				for(int j =0;j<teamA[i].length;j++) 
				{
					if(teamA[i][j] == player) 
					{
						return true;
					}
				}
			}
		}
		else 
		{
			for(int i = 0;i<this.numRow;i++) 
			{
				for(int j =0;j<teamB[i].length;j++) 
				{
					if(teamB[i][j] == player) 
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	/**
	 * This methods receives a player configuration (i.e., team, type, row, and position), 
	 * creates a new player instance, and places him at the specified position.
	 * @param team is either Team.A or Team.B
	 * @param pType is one of the Player.Type  {Healer, Tank, Samurai, BlackMage, Phoenix}
	 * @param row	either Row.Front or Row.Back
	 * @param position is the position of the player in the row. Note that position starts from 1, 2, 3....
	 */
	public void addPlayer(Team team, Player.PlayerType pType, Row row, int position)      //set team , type , row and send to Player class 
	{	
		//INSERT YOUR CODE HERE
		if(team == Arena.Team.A) 
		{
			if(row == Arena.Row.Front) 
			{
				teamA[0][position-1] = new Player(pType);
				teamA[0][position-1].setPosition(position,"A","Front");
			}
			else 
			{
				teamA[1][position-1] = new Player(pType);
				teamA[1][position-1].setPosition(position, "A", "Back");
			}
		}
		else if(team == Arena.Team.B) 
		{
			if(row == Arena.Row.Front) 
			{
				teamB[0][position-1] = new Player(pType);
				teamB[0][position-1].setPosition(position, "B", "Front");
			}
			else 
			{
				teamB[1][position-1] = new Player(pType);
				teamB[1][position-1].setPosition(position, "B", "Back");
			}
		}
	}
	
	
	/**
	 * Validate the players in both Team A and B. Returns true if all of the following conditions hold:
	 * 
	 * 1. All the positions are filled. That is, there each team must have exactly numRow*numRowPlayers players.
	 * 2. There can be at most MAXEACHTYPE players of each type in each team. For example, if MAXEACHTYPE = 3
	 * then each team can have at most 3 Healers, 3 Tanks, 3 Samurais, 3 BlackMages, and 3 Phoenixes.
	 * 
	 * Returns true if all the conditions above are satisfied, false otherwise.
	 * @return
	 */
	public boolean validatePlayers()      //check each type of player that have more than 3 or not  
	{
		//INSERT YOUR CODE HERE
		int[][] count = {{0,0,0,0,0,0},
						  {0,0,0,0,0,0}};
		
		for(int i = 0; i<this.numRow;i++)
		{
			for(int j = 0; j < numRowPlayers; j++)
			{
				if(Player.PlayerType.Phoenix == teamA[i][j].getType()) 
				{
					count[0][0]++;
				}
				else if(Player.PlayerType.Cherry == teamA[i][j].getType()) 
				{
					count[0][1]++;
				}
				else if(Player.PlayerType.BlackMage == teamA[i][j].getType()) 
				{
					count[0][2]++;
				}
				else if(Player.PlayerType.Healer == teamA[i][j].getType()) 
				{
					count[0][3]++;
				}
				else if(Player.PlayerType.Tank == teamA[i][j].getType()) 
				{
					count[0][4]++;
				}
				else if(Player.PlayerType.Samurai == teamA[i][j].getType()) 
				{
					count[0][5]++;
				}
				else if(Player.PlayerType.Phoenix == teamB[i][j].getType()) 
				{
					count[1][0]++;
				}
				else if(Player.PlayerType.Cherry == teamB[i][j].getType()) 
				{
					count[1][1]++;
				}
				else if(Player.PlayerType.BlackMage == teamB[i][j].getType()) 
				{
					count[1][2]++;
				}
				else if(Player.PlayerType.Healer == teamB[i][j].getType()) 
				{
					count[1][3]++;
				}
				else if(Player.PlayerType.Tank == teamB[i][j].getType()) 
				{
					count[1][4]++;
				}
				else if(Player.PlayerType.Samurai == teamB[i][j].getType()) 
				{
					count[1][5]++;
				}
			}
		}
		for(int i=0 ; i < numRow ; i++)       
		{
			for(int j=0;j<6;j++)
			if(count[i][j] > 3)          //check and return in true or false
			{
				return false;
			}

		}
		return true;
	}
	
	
	/**
	 * Returns the sum of HP of all the players in the given "team"
	 * @param team
	 * @return
	 */
	public static double getSumHP(Player[][] team)
	{
		//INSERT YOUR CODE HERE
		allSumHp = 0;             //set value of allSumHp
		for(int i=0;i<2;i++) 
		{
			for(int j =0;j<team[i].length;j++) 
			{
				if(team[i][j].getCurrentHP()>0) 
				{
					allSumHp = allSumHp + team[i][j].getCurrentHP();      //calculate allSumHp in each team
				}
			}
		}
		return allSumHp;
	}
	
	/**
	 * Return the team (either teamA or teamB) whose number of alive players is higher than the other. 
	 * 
	 * If the two teams have an equal number of alive players, then the team whose sum of HP of all the
	 * players is higher is returned.
	 * 
	 * If the sums of HP of all the players of both teams are equal, return teamA.
	 * @return
	 */
	public Player[][] getWinningTeam()       //use in the case that which team have allHP=0 first
	{
		//INSERT YOUR CODE HERE	
		if(getSumHP(teamB)>=getSumHP(teamA))      //find the winner team
		{
			return teamB;
		}
			return teamA;
	}
	
	/**
	 * This method simulates the battle between teamA and teamB. The method should have a loop that signifies
	 * a round of the battle. In each round, each player in teamA invokes the method takeAction(). The players'
	 * turns are ordered by its position in the team. Once all the players in teamA have invoked takeAction(),
	 * not it is teamB's turn to do the same. 
	 * 
	 * The battle terminates if one of the following two conditions is met:
	 * 
	 * 1. All the players in a team has been eliminated.
	 * 2. The number of rounds exceeds MAXROUNDS
	 * 
	 * After the battle terminates, report the winning team, which is determined by getWinningTeam().
	 */
	public void startBattle() 
	{
		//INSERT YOUR CODE HERE
		while(getSumHP(teamA)>0 && getSumHP(teamB)>0 && this.numRounds<= MAXROUNDS) //if it have correct condition then do the process below
		{
			this.numRounds++;
			System.out.println("@ Round "+numRounds);
			for (int i = 0; i < numRow; i++) {
				for (int j = 0; j < numRowPlayers; j++) 
				{
					Player playerA = teamA[i][j];
					if(playerA.getCurrentHP() > 0) 
					{
						playerA.takeAction(this);     //begin battle
					}
				}
			}
			//TeamB
			for (int i = 0; i < numRow; i++) 
			{
				for (int j = 0; j < numRowPlayers; j++) 
				{
					Player playerB = teamB[i][j];
					if(playerB.getCurrentHP() > 0) 
					{
						playerB.takeAction(this);
					}
				}
			}
			displayArea(this, true);
			logAfterEachRound();
		}
		if(getWinningTeam() == teamA)          //if teamA win print out @@@ Team A won.
		{
			System.out.println("@@@ Team A won.");
		}else if(getWinningTeam() == teamB)    //if teamB win print out @@@ Team B won.
		{
			System.out.println("@@@ Team B won.");
		}
	}
	
	
	
	/**
	 * This method displays the current area state, and is already implemented for you.
	 * In startBattle(), you should call this method once before the battle starts, and 
	 * after each round ends. 
	 * 
	 * @param arena
	 * @param verbose
	 */
	public static void displayArea(Arena arena, boolean verbose)
	{
		StringBuilder str = new StringBuilder();
		if(verbose)
		{
			str.append(String.format("%43s   %40s","Team A","")+"\t\t"+String.format("%-38s%-40s","","Team B")+"\n");
			str.append(String.format("%43s","BACK ROW")+String.format("%43s","FRONT ROW")+"  |  "+String.format("%-43s","FRONT ROW")+"\t"+String.format("%-43s","BACK ROW")+"\n");
			for(int i = 0; i < arena.numRowPlayers; i++)
			{
				str.append(String.format("%43s",arena.teamA[1][i])+String.format("%43s",arena.teamA[0][i])+"  |  "+String.format("%-43s",arena.teamB[0][i])+String.format("%-43s",arena.teamB[1][i])+"\n");
			}
		}
	
		str.append("@ Total HP of Team A = "+getSumHP(arena.teamA)+". @ Total HP of Team B = "+getSumHP(arena.teamB)+"\n\n");
		System.out.print(str.toString());
		
		
	}
	
	/**
	 * This method writes a log (as round number, sum of HP of teamA, and sum of HP of teamB) into the log file.
	 * You are not to modify this method, however, this method must be call by startBattle() after each round.
	 * 
	 * The output file will be tested against the auto-grader, so make sure the output look something like:
	 * 
	 * 1	47415.0	49923.0
	 * 2	44977.0	46990.0
	 * 3	42092.0	43525.0
	 * 4	44408.0	43210.0
	 * 
	 * Where the numbers of the first, second, and third columns specify round numbers, sum of HP of teamA, and sum of HP of teamB respectively. 
	 */
	private void logAfterEachRound()    
	{
		try 
		{
			Files.write(logFile, Arrays.asList(new String[]{numRounds+"\t"+getSumHP(teamA)+"\t"+getSumHP(teamB)}), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	public Player[][] getTeamA()    
	{
		return teamA;            //return teamA
	}
	public Player[][] getTeamB()
	{
		return teamB;            //return teamB
	}
	//Add method
	public Player findTarget(Player player)      
	{
		Player [][] myteam = null;
		Player target = null;
		boolean findtargettoattack = false;
		double mininum = 9999;
		
		if(isMemberOf(player, Team.A)) //find target to attack
		{
			myteam = teamB;
		}else if(isMemberOf(player, Team.B)) 
		{
			myteam = teamA;
		}
		for (int i = 0; i < 2; i++) 
		{
			if(i == 0) 
			{
				for (int j = 0; j < myteam[i].length; j++) 
				{
					target = myteam[i][j];
					if(target.isTaunting() && target.getCurrentHP() > 0) 
					{
						findtargettoattack = true;
						break;
					}
				}
			}
			else 
			{
				for (int j = 0; j < myteam[i].length; j++) 
				{
					target = myteam[i][j];
					if(target.isTaunting() && target.getCurrentHP() > 0) 
					{
						findtargettoattack = true;
						break;
					}
				}
			}
			if(findtargettoattack) 
			{
				break;
			}
		}
		if(!findtargettoattack) 
		{
			for (int i = 0; i < 2; i++) 
			{
				if(i==0) 
				{
					for (int j = 0; j < myteam[i].length; j++) 
					{
						if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() < mininum) 
						{
							mininum = myteam[i][j].getCurrentHP();
							target = myteam[i][j];
							findtargettoattack = true;
						}
					}
				}else 
				{
					for (int j = 0; j < myteam[i].length; j++) 
					{
						if(myteam[i][j].getCurrentHP() > 0 && myteam[i][j].getCurrentHP() < mininum) 
						{
							mininum = myteam[i][j].getCurrentHP();
							target = myteam[i][j];
							findtargettoattack = true;
						}
					}
				}
				if(findtargettoattack) 
				{
					break;
				}else 
				{
					target = null;
				}
			}	
		}
		return target;
	}
	public Player[][] myTeam(Player player)
	{
		if(isMemberOf(player, Team.A)) 
		{
			return getTeamA();
		}
		return getTeamB();
	}
}