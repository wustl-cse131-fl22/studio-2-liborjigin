package studio2;

public class Ruin {

	public static void main(String[] args) {
		
		int startAmount=2;
		double winChance=0.7;
		double gamble = 0;
		int winLimit=10;
		int ruinPoint = 0;
		int totalSimulations=10000;
		int simDay=0;
		int ruinCount=0;
		double ruinRate = 0;
		
		for(int i=1; i < totalSimulations; i++) {
			double simNum=0;
			String dayResult = null;
			int moneyAmount = startAmount;
			
			
			while(moneyAmount < winLimit && moneyAmount > ruinPoint) {
				gamble=Math.random();
			
				if(gamble>= winChance) {
					moneyAmount=moneyAmount-1;
				}
				else {
					moneyAmount++;
				}
				simNum++;
			}
			if(moneyAmount == winLimit) {
				dayResult = "Success";
			}
			else if(moneyAmount == ruinPoint) {
				dayResult = "lose";
				ruinCount++;
			}
			
			
			simDay = i;
			System.out.println("Simulation day: " + simDay +" |Plays done: "+ simNum + " |day result: "+ dayResult);
		}
		System.out.println("Losses: "+ruinCount+" Simulations:"+ simDay);
		ruinRate = (double)ruinCount/(totalSimulations-1);
		System.out.println("Ruin rate from simulation: "+ ruinRate + " Expected ruin rate: .183503");
	}

}
